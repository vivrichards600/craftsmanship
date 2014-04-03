package org.craftmanship.roman_numerals

import org.craftmanship.spec.UnitSpec
import org.craftmanship.roman_numeral.RomanNumeralConverter


class RomanNumeralConverterSpec extends UnitSpec {

  "Roman numeral converter" should {
    "convert decimal to roman" in {
      converter.convert(1) should equal("I")
      converter.convert(2) should equal("II")
      converter.convert(3) should equal("III")
      converter.convert(4) should equal("IV")
      converter.convert(5) should equal("V")
      converter.convert(6) should equal("VI")
      converter.convert(8) should equal("VIII")
      converter.convert(9) should equal("IX")
      converter.convert(10) should equal("X")
      converter.convert(13) should equal("XIII")
      converter.convert(14) should equal("XIV")
      converter.convert(38) should equal("XXXVIII")
      converter.convert(39) should equal("XXXIX")
      converter.convert(2499) should equal("MMCDXCIX")
      converter.convert(3949) should equal("MMMCMXLIX")
    }
  }


  val converter = new RomanNumeralConverter
}