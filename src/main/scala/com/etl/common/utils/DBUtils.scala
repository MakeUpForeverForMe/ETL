package com.etl.common.utils

import java.sql.{Connection, ResultSet, Statement}
import java.util.Properties

import com.alibaba.druid.pool.DruidDataSourceFactory
import com.alibaba.druid.util.JdbcUtils
import javax.sql.DataSource

import scala.io.Source

object DBUtils extends DBUtils

sealed class DBUtils {
  private var dataSource: DataSource = _
  private val properties = new Properties()
  properties.load(Source.fromFile(this.getClass.getClassLoader.getResource("jdbc.properties").getPath).bufferedReader())
  dataSource = DruidDataSourceFactory.createDataSource(properties)

  def getDataSource: DataSource = dataSource

  def getConnection: Connection = dataSource.getConnection

  def close(connection: Connection, statement: Statement): Unit = close(connection, statement, null)

  def close(statement: Statement, resultSet: ResultSet): Unit = close(null, statement, resultSet)

  def close(connection: Connection, statement: Statement, resultSet: ResultSet): Unit = {
    close(resultSet)
    close(statement)
    close(connection)
  }

  def close(connection: Connection): Unit = JdbcUtils.close(connection)

  def close(statement: Statement): Unit = JdbcUtils.close(statement)

  def close(resultSet: ResultSet): Unit = JdbcUtils.close(resultSet)
}
