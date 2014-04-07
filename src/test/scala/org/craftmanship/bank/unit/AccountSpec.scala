package org.craftmanship.bank.unit

import org.craftmanship.spec.UnitSpec
import org.craftmanship.bank.{Printer, Account}
import org.mockito.Mockito._

class AccountSpec extends UnitSpec {

  "Empty Account" should {
    "print an empty statement" in {
      val printer = mock[Printer]
      val account = new Account(printer)

      account.printStatement

      verify(printer).print(List("DATE AMOUNT BALANCE"))
    }
  }

  "An account with one deposit" should {
    "print a statement containing one deposit" in {
      val printer = mock[Printer]
      val account = new Account(printer)
      account.deposit(100)

      account.printStatement

      verify(printer).print(List("DATE AMOUNT BALANCE", "01/04/2014 100.00 100.00"))
    }
  }

}
