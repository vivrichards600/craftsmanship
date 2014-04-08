package org.craftmanship.bank.acceptance

import org.mockito.Mockito._
import org.craftmanship.bank._

class BankStatementAcceptanceTest extends AcceptanceSpec {
  feature("Print bank statement") {
    scenario("statement with no transactions") {

      Given("a bank account with no transactions")
      val statement = mock[Statement]
      val clock = mock[Clock]
      val account = new Account(statement, clock)

      When("when I print a statement")
      account.printStatement

      Then("the statement should have no transactions")
      verify(statement).print(List())

    }

    scenario("statement containing one deposit"){

      Given("a bank account with one deposit")
      val printer = mock[Printer]
      val clock = mock[Clock]
      val statement = new Statement(printer)
      val account = new Account(statement, clock)
      account.deposit(100)

      When("when I print a statement")
      account.printStatement

      Then("the statement should have one deposit")
      verify(printer).print(List(
          "DATE AMOUNT BALANCE",
          "01/04/2014 100.00 100.00"
      ))

    }
  }
}
