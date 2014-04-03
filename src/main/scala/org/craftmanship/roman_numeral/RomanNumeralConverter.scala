package org.craftmanship.roman_numeral

class RomanNumeralConverter {

  val conversion_table = List(
    Pair(1000, "M"),
    Pair(900, "CM"),
    Pair(500, "D"),
    Pair(400, "CD"),
    Pair(100, "C"),
    Pair(90, "XC"),
    Pair(50, "L"),
    Pair(40, "XL"),
    Pair(10, "X"),
    Pair(9, "IX"),
    Pair(5, "V"),
    Pair(4, "IV"),
    Pair(1, "I")
  )

  def convert(number: Int): String = {
    var decimal = number
    var roman: String = ""

    conversion_table.foreach(p => if (decimal >= p._1) {
      decimal -= p._1
      roman += p._2
      if (decimal > 0) { roman += convert(decimal); decimal = 0 }
    })
    roman
  }
}