package com.etl


import scala.collection.JavaConverters._
import scala.collection.mutable

package object common {
  type JuMap = java.util.Map[String, AnyRef]

  type JuList = java.util.List[JuMap]

  type SMMap = mutable.Map[String, Any]
  val SMMap: SMMap = mutable.HashMap[String, Any]()

  type SuMapRef = mutable.Map[String, AnyRef]

  type BufferMapRef = mutable.Buffer[SuMapRef]


  implicit def Map4S2J(sMMap: SMMap): JuMap = sMMap.asInstanceOf[SuMapRef].asJava

  implicit def List4S2J(juList: JuList): BufferMapRef = juList.asScala.map(_.asScala)

  def ss(args: Any*): Seq[Any] = args

  //  implicit def
}
