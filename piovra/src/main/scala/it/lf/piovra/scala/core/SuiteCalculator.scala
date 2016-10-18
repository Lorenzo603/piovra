package it.lf.piovra.scala.core

import java.util

import org.apache.logging.log4j.{LogManager, Logger}

import scala.collection.JavaConverters._
import collection.JavaConversions._
import scala.collection.mutable.ListBuffer


class SuiteCalculator {

  val LOG: Logger = LogManager.getLogger(SuiteCalculator.this.getClass)

  def factor:List[String] = List("f1", "f2", "f3")
  def option1:List[String] = List("o00", "o01")
  def option2:List[String] = List("o10", "o11", "o12")
  def option3:List[String] = List("o20")

  var m:Map[String, List[String]] = Map(
    "f1" -> List("o00", "o01"),
    "f2" -> List("o10", "o11", "o12"),
    "f3" -> List("o20")
  )

  def result:List[List[String]] = List(
    List("o00", "o10", "o20"),
    List("o00", "o11", "o20"),
    List("o00", "o12", "o20"),
    List("o01", "o10", "o20"),
    List("o01", "o11", "o20"),
    List("o01", "o12", "o20")
  )


  def calculate(javaMap : java.util.Map[String, java.util.List[String]]) : java.util.List[java.util.List[String]] = {

    def convertToScala(javaMap : java.util.Map[String, java.util.List[String]]) : Map[String, List[String]] = {
      javaMap.mapValues(listValue => listValue.asScala.toList).toMap
    }
    val mapList: List[List[String]] = convertToScala(javaMap).values.toList

    val realValueMapping : Map[String, String] = mapList.map(row => row.map(value => (mapList.indexOf(row).toString + row.indexOf(value).toString) -> value )).flatten.toMap

    val maxLength: Int = mapList.map(l => l.size).max

    val allCombinations: List[List[String]] =
      mapList.flatMap(row => row.indices.toList.map(colIndex => mapList.indexOf(row).toString + colIndex.toString))
        .combinations(maxLength).toList

    def isValidCombination(combination: List[String]) : Boolean = {
      combination.count(s => s(0).toString == combination.indexOf(s).toString) == maxLength
    }

    val validCombinations = allCombinations.filter(isValidCombination(_))
    validCombinations.foreach(println)

    val remappedValidCombinations = validCombinations.map(l => l.map(v => realValueMapping.getOrDefault(v, "") ) )
    remappedValidCombinations.foreach(println)

    def convertToJava(scalaList : List[List[String]]) : java.util.List[java.util.List[String]] = {
      scalaList.map(listValue => listValue.asJava).asJava
    }
    convertToJava(remappedValidCombinations)
  }

}
