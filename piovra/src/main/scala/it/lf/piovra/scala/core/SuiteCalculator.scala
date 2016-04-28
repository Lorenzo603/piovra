package it.lf.piovra.scala.core

import org.apache.logging.log4j.{LogManager, Logger}

/**
  * Created by Lfurrer on 28/04/2016.
  */
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


  def calculate() : String = {
    val mapList: List[List[String]] = m.values.toList
    val maxLength: Int = mapList.map(l => l.size).max

    val allCombinations: List[List[String]] =
      mapList.flatMap(row => row.indices.toList.map(colIndex => mapList.indexOf(row).toString + colIndex.toString))
        .combinations(maxLength).toList

    def isValidCombination(combination: List[String]) : Boolean = {
      combination.count(s => s(0).toString == combination.indexOf(s).toString) == maxLength
    }

    val validCombinations = allCombinations.filter(isValidCombination(_))
    validCombinations.foreach(println)

    LOG.info("Stamapto da SCALA!")
    "Creato da SCALA!"
  }

}
