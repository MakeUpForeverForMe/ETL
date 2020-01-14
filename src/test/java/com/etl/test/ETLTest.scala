package com.etl.test

import java.sql.{SQLIntegrityConstraintViolationException, SQLSyntaxErrorException, Timestamp}

import com.etl.common._
import com.alibaba.druid.util.JdbcUtils
import com.etl.common.bean.StructBase
import com.etl.common.dao.BaseDao
import com.etl.common.utils.{AesPlus, DBUtils}
import org.apache.log4j.Logger
import org.junit.{After, Before, Test}

import scala.collection.mutable


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
    logger.info("获取连接 connection：" + connection)
    logger.info("获取连接 成功")
  }

  @After
  def closeConnectionTest(): Unit = {
    logger.debug("末尾测试任务 closeConnectionTest")
    logger.info("关闭连接 connection")
    DBUtils.close(connection)
    logger.info("关闭连接 connection 成功")
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

  @Test
  def insertIntoTableTest(): Unit = {
    logger.info("向表中插入数据 ------------------------------------------ 开始")
    val hashMap: SMMap = SMMap(Seq(("use_type", 0), ("type", "mysql"), ("hosts", "mysql22"), ("user", aes.encrypt("root")), ("passwd", aes.encrypt("000000")), ("source_path", "microb")))
    try {
      JdbcUtils.insertToTable(dataSource, "STRUCT_BASE", hashMap)
    } catch {
      case e: SQLIntegrityConstraintViolationException => logger.info("此条数据已存在，不可重复插入" + e.printStackTrace())
      case e: SQLSyntaxErrorException => logger.info("SQL 语句存在错误，请检查 SQL" + e.printStackTrace())
    }
    logger.info("向表中插入数据 ------------------------------------------ 完成")
  }


  @Test
  def caseClassTest(): Unit = {
    val structBase = StructBase(0, Timestamp.valueOf("2020-01-01 00:00:00"), Timestamp.valueOf("2020-01-01 00:00:00"), 0, "mysql", "mysql22", "root", "000000", "microb")
    println(structBase)
  }
}
