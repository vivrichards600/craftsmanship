package org.craftmanship.bank.acceptance

import org.mockito.Mockito._
import org.craftmanship.bank._

class BankStatementAcceptanceTest extends AcceptanceSpec {
  feature("Print bank statement") {
    scenario("statement with no transactions") {

      Given("a bank account with no transactions")
      val printer = mock[Printer]
      val account = new Account(printer)

      When("when I print a statement")
      account.printStatement

      Then("the statement should have no transactions")
      verify(printer).print(List("DATE AMOUNT BALANCE"))

    }

    scenario("statement containing one deposit"){

      Given("a bank account with one deposit")
      val printer = mock[Printer]
      val account = new Account(printer)
      account.deposit(100)

      When("when I print a statement")
      account.printStatement

      Then("the statement should have one deposit")
      verify(printer).print(List("DATE AMOUNT BALANCE", "01/04/2014 100.00 100.00"))

    }
  }
}
