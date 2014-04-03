package org.craftmanship.leap_year


class Year(year: Int) {
  def isLeapYear: Boolean = {
    if (isNotDivisibleBy4 || isNotDivisibleBy100 && isDivisibleBy400) return false
    true
  }

  private def isNotDivisibleBy4 = year % 4 != 0
  private def isNotDivisibleBy100 = year % 100 == 0
  private def isDivisibleBy400 = year % 400 != 0
}

