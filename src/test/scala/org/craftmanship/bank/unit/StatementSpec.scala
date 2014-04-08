package org.craftmanship.bank.unit

import org.craftmanship.spec.UnitSpec
import org.craftmanship.bank._
import org.mockito.Mockito._
import org.mockito.BDDMockito._
import org.craftmanship.bank.Deposit
import java.util.Date
import org.joda.time.DateTime

class StatementSpec extends UnitSpec {

  "statement" should {
    "print an empty statement" in {
      val printer = mock[Printer]
      val statement = new Statement(printer)

      statement.print(List())

      verify(printer).print(List("DATE AMOUNT BALANCE"))
    }

    "print a statement with one deposit" in {
      val clock = mock[Clock]
      val currentDate = new DateTime(2014, 04, 01, 0, 0).toDate()
      given(clock.currentDate) willReturn(currentDate)
      val printer = mock[Printer]
      val statement = new Statement(printer)

      statement.print(List(Deposit(currentDate, 100.00)))

      verify(printer).print(List("DATE AMOUNT BALANCE", "01/04/2014 100.00 100.00"))
    }
  }
}
