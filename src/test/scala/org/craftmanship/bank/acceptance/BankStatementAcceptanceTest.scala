package org.craftmanship.bank.acceptance


class BankStatementAcceptanceTest extends AcceptanceSpec {

  feature("Print bank statement") {
    scenario("statement with no transactions") {

      Given("a bank account with no transactions")
      val account = application createNewAccount

      When("when I print a statement")
      account printStatement

      Then("the statement should have no transactions")
      application checkThatPrinterReceives List("DATE AMOUNT BALANCE")
    }

    scenario("statement containing multiple deposits and withdrawals"){

      Given("a bank account with multiple deposits and withdrawals")
      val account = application createNewAccount()
      application setDateTo(2014, 04, 01)
      account.deposit(100)
      account.withdrawal(50)
      account.deposit(100)
      account.withdrawal(100)

      When("when I print a statement")
      account printStatement

      Then("the statement should have one withdrawal")
      application checkThatPrinterReceives List(
        "DATE AMOUNT BALANCE",
        "01/04/2014 100.00 100.00",
        "01/04/2014 -50.00 50.00",
        "01/04/2014 100.00 150.00",
        "01/04/2014 -100.00 50.00"
      )
    }
  }
}
