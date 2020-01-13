package com.etl.common.bean

import java.sql.{ResultSet, Timestamp}

import com.alibaba.druid.util.ResultSetConsumer


case class StructBase(
                       id: Long,
                       ctime: Timestamp,
                       utime: Timestamp,
                       useType: Int,
                       sourceType: String,
                       hosts: String,
                       user: String,
                       passwd: String,
                       sourcePath: String
                     ) extends ResultSetConsumer[StructBase] with Serializable {
  override def toString: String = "id = ‘" + id + "’\t" +
    "ctime = ‘" + ctime + "’\t" +
    "utime = ‘" + utime + "’\t" +
    "useType = ‘" + useType + "’\t" +
    "sourceType = ‘" + sourceType + "’\t" +
    "hosts = ‘" + hosts + "’\t" +
    "user = ‘" + user + "’\t" +
    "passwd = ‘" + passwd + "’\t" +
    "sourcePath = ‘" + sourcePath + "’"

  override def apply(rs: ResultSet): StructBase = ???

  override def accept(`object`: StructBase): Unit = ???
}

//class StructBase extends ResultSetConsumer[StructBase] with Serializable {
//  private var id: Long = _
//  private var ctime: Timestamp = _
//  private var utime: Timestamp = _
//  private var idType: Int = _
//  private var useType: String = _
//  private var hosts: String = _
//  private var user: String = _
//  private var passwd: String = _
//  private var sourcePath: String = _
//
//  def this(id: Long, ctime: Timestamp, utime: Timestamp, idType: Int, useType: String, hosts: String, user: String, passwd: String, sourcePath: String) {
//    this
//    this.id = id
//    this.ctime = ctime
//    this.utime = utime
//    this.idType = idType
//    this.useType = useType
//    this.hosts = hosts
//    this.user = user
//    this.passwd = passwd
//    this.sourcePath = sourcePath
//  }
//
//  override def toString: String = id + "\t" + ctime + "\t" + utime + "\t" + idType + "\t" + useType + "\t" + hosts + "\t" + user + "\t" + passwd + "\t" + sourcePath
//
//  override def apply(rs: ResultSet): StructBase = ???
//
//  override def accept(structBase: StructBase): Unit = ???
//}