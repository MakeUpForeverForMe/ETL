package com.etl

import com.etl.utils.JDBCUtils
import org.junit.jupiter.api.Test

class ETLTest {

  private val jDBCUtils = new JDBCUtils()

  @Test
  def ConnectTest(): Unit = {
    println(jDBCUtils.getConnection)
  }

//  def closeTest(): Unit = {
//    jDBCUtils.closeConnect()
//  }
}
