package com.etl.test

import com.etl.common.utils.DBUtils
import org.apache.log4j.Logger
import org.junit.jupiter.api.Test

class ETLTest {
  private val logger: Logger = Logger.getLogger(this.getClass)

  logger.debug("创建JDBCUtils对象")
  private val dbUtils = new DBUtils()

  logger.debug("运行测试任务ConnectTest")

  @Test
  def ConnectTest(): Unit = {
    logger.info("开始获取连接")
    println(dbUtils.getConnection)
    logger.error("获取连接完成")
  }

  //  def closeTest(): Unit = {
  //    dbUtils.closeConnect()
  //  }
}
