package com.etl.common.utils

import java.sql.{Connection, ResultSet, Statement}
import java.util.Properties

import com.alibaba.druid.pool.DruidDataSourceFactory
import javax.sql.DataSource
import org.apache.commons.dbutils.DbUtils

import scala.io.Source

class JDBCUtils {
  private var source: DataSource = _
  private val properties = new Properties()
  try {
    properties.load(Source.fromFile(this.getClass.getClassLoader.getResource("jdbc.properties").getPath).bufferedReader())
    source = DruidDataSourceFactory.createDataSource(properties)
  } catch {
    case e: Exception => e.printStackTrace()
  }

  def getConnection: Connection = source.getConnection

  def closeConnect(connection: Connection, statement: Statement, resultSet: ResultSet): Unit = DbUtils.closeQuietly(connection, statement, resultSet)
}