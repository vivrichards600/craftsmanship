package org.craftmanship.leap_year

import org.craftmanship.spec.UnitSpec

class YearSpec   extends UnitSpec {
  "Year" should {
    "inform when it's not a leap year" in {
      year(1953).isLeapYear should be (false)
    }

    "be leap year when it's divisible by 4" in {
      year(2004).isLeapYear should be (true)
    }

    "not be a leap year when it's divisible by 100 but not by 400" in {
      year(1800).isLeapYear should be (false)
    }

    "be a leap year when it's divisible by 400" in {
      year(400).isLeapYear should be (true)
    }
  }

  def year(year: Int): Year = new Year(year)
}
