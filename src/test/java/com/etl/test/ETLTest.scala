package com.etl.test

import com.etl.common._
import com.alibaba.druid.util.JdbcUtils
import com.etl.common.dao.BaseDao
import com.etl.common.utils.{AesPlus, DBUtils}
import org.apache.log4j.Logger
import org.junit.{After, Before, Test}


class ETLTest {
  private val logger: Logger = Logger.getLogger(this.getClass)

  logger.debug("获取 connection 变量")
  private val connection = DBUtils.getConnection
  logger.debug("获取 dataSource 变量")
  private val dataSource = DBUtils.getDataSource
  logger.debug("创建加密对象")
  private val aes = new AesPlus()

  @Before
  def connectionTest(): Unit = {
    logger.debug("首先测试任务 connectionTest")
    logger.info("connection：" + connection)
  }

  @After
  def closeConnectionTest(): Unit = {
    logger.debug("末尾测试任务 closeConnectionTest")
    logger.info("close connection")
    DBUtils.close(connection)
  }

  @Test
  def insertIntoTableTest(): Unit = {
    logger.info("向表中插入数据 ------------------------------------------ 开始")
    val hashMap = SMMap += (("use_type", 0), ("type", "mysql"), ("hosts", "mysql22"), ("user", aes.encrypt("root")), ("passwd", aes.encrypt("INikGPLun*8v")), ("base_path", "microb"))
    JdbcUtils.insertToTable(dataSource, "STRUCT_BASE", hashMap)
    logger.info("向表中插入数据 ------------------------------------------ 完成")
  }

  @Test
  def showTableTest(): Unit = {
    logger.info("获取数据库中有哪些表 ------------------------------------------ 开始")
    println(JdbcUtils.showTables(connection, "mysql"))
    logger.info("获取数据库中有哪些表 ------------------------------------------ 完成")
  }

  @Test
  def executeTest(): Unit = {
    logger.info("获取表 STRUCT_BASE 的数据 ------------------------------------------ 开始")
    val sql = "select * from STRUCT_BASE"
    new BaseDao().execute(DBUtils.getDataSource, sql).foreach(println)
    logger.info("获取表 STRUCT_BASE 的数据 ------------------------------------------ 完成")
  }
}
