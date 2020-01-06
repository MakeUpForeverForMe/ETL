package com.etl

import com.etl.utils.JDBCUtils
import org.junit.jupiter.api.Test

class ETLTest {

  @Test
  def ConnectTest(): Unit = {
    println(new JDBCUtils().getConnection)
  }
}
