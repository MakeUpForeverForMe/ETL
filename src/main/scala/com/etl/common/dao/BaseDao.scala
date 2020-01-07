package com.etl.common.dao


import java.util

import com.alibaba.druid.util.JdbcUtils
import com.etl.common.utils.DBUtils
import javax.sql.DataSource

class BaseDao {
  def update(dataSource: DataSource, sql: String, args: Any*): Int = JdbcUtils.executeUpdate(dataSource, sql, args)

  def execute(dataSource: DataSource, sql: String, args: Any*): util.List[util.Map[String, AnyRef]] = JdbcUtils.executeQuery(dataSource, sql, args)
}
