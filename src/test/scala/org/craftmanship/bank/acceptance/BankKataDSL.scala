package org.craftmanship.bank.acceptance

import org.scalatest.mock.MockitoSugar
import org.craftmanship.bank.{Statement, Clock, Account, Printer}
import org.mockito.Mockito._
import org.mockito.BDDMockito._
import java.util.Date
import org.joda.time.DateTime

trait BankKataDSL extends MockitoSugar {

  val application = fixture

  def fixture = new {
    var printer = mock[Printer]
    var clock = mock[Clock]

    def createNewAccount(): Account = {
      printer = mock[Printer]
      clock = mock[Clock]
      given(clock.currentDate) willReturn(new Date())
      val statement = new Statement(printer)
      new Account(statement, clock)
    }

    def checkThatPrinterReceives(lines: List[String]) {
      verify(printer).print(lines)
    }

    def setDateTo(year: Int, month: Int, day: Int) {
      val date = new DateTime(year, month, day, 0, 0).toDate
      given(clock.currentDate) willReturn(date)
    }
  }

}
