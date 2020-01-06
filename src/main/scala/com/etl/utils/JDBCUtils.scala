package com.etl.utils

import java.sql.Connection
import java.util.Properties

import com.alibaba.druid.pool.DruidDataSourceFactory
import javax.sql.DataSource

import scala.io.Source

class JDBCUtils {
  private var source: DataSource = _
  private val properties = new Properties()
  properties.load(Source.fromFile(this.getClass.getClassLoader.getResource("jdbc.properties").getPath).bufferedReader())
  source = DruidDataSourceFactory.createDataSource(properties)

  def getConnection: Connection = source.getConnection
}
