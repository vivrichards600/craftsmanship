package org.craftmanship.leap_year

class Year(year: Int) {
  def isLeapYear: Boolean = divisibleBy4 && !(divisibleBy100 && notDivisibleBy400)
  
  private def divisibleBy4 = year % 4 == 0
  private def divisibleBy100 = year % 100 == 0
  private def notDivisibleBy400 = year % 400 != 0
}

