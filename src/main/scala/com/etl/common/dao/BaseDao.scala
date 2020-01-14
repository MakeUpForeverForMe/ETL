package com.etl.common.dao


import java.sql.Connection
import java.util

import com.alibaba.druid.util.JdbcUtils
import com.etl.common._
import javax.sql.DataSource

class BaseDao {
  /**
    * 执行非事务的增、删、改操作
    *
    * @param dataSource 需要传入 DataSource 获取连接
    * @param sql        传入需要执行的SQL
    * @param args       SQL中对应的变量部分
    * @return 返回执行成功的受影响行数
    */
  def update(dataSource: DataSource, sql: String, args: Any*): Int = JdbcUtils.executeUpdate(dataSource, sql, args)

  /**
    * 获取数据库数据
    *
    * @param dataSource 需要传入 DataSource 获取连接
    * @param sql        传入需要执行的SQL
    * @param args       SQL中对应的变量部分
    * @return 以 List<`Map`> 形式返回获取到的数据
    */
  def execute(dataSource: DataSource, sql: String, args: Any*): BufferMapRef = JdbcUtils.executeQuery(dataSource, sql)
}
