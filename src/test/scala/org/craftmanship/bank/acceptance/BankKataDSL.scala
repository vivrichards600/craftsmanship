package org.craftmanship.bank.acceptance

import org.scalatest.mock.MockitoSugar
import org.craftmanship.bank.{Statement, Clock, Account, Printer}
import org.mockito.Mockito._

trait BankKataDSL extends MockitoSugar {

  val application = fixture

  def fixture = new {
    var printer = mock[Printer]

    def createNewAccount(): Account = {
      printer = mock[Printer]
      val clock = mock[Clock]
      val statement = new Statement(printer)
      new Account(statement, clock)
    }

    def checkThatPrinterReceives(lines: List[String]) {
      verify(printer).print(lines)
    }
  }

}
