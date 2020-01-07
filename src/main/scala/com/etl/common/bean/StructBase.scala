package com.etl.common.bean

import java.sql.Date

case class StructBase(
                       id: Long,
                       ctime: Date,
                       utime: Date,
                       id_type: Int,
                       alias: String,
                       sourceType: String,
                       hosts: String,
                       user: String,
                       passwd: String,
                       sourcePath: String
                     ) extends Serializable
