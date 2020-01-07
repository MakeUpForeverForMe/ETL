package com.etl.common.bean

import java.sql.Date

case class StructBase(
                       id: Long,
                       ctime: Date,
                       utime: Date,
                       idType: Int,
                       alias: String,
                       sourceType: String,
                       hosts: String,
                       user: String,
                       passwd: String,
                       sourcePath: String
                     ) extends Serializable {
  override def toString: String = id + "\t" + ctime + "\t" + utime + "\t" + idType + "\t" + alias + "\t" + sourceType + "\t" + hosts + "\t" + user + "\t" + passwd + "\t" + sourcePath
}
