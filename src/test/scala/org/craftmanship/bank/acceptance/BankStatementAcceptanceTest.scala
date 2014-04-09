package org.craftmanship.bank.acceptance

class BankStatementAcceptanceTest extends AcceptanceSpec {

  feature("Print bank statement") {

    scenario("bank statement with no transactions") {
      Given("a bank account with no transactions")

      When("when I print a statement")
      account printStatement

      Then("the statement should have no transactions")
      application checkThatPrinterReceives List("DATE AMOUNT BALANCE")
    }

    scenario("bank statement containing multiple deposits and withdrawals"){
      Given("a bank account with multiple deposits and withdrawals")
      application setDateTo(2014, 04, 01)
      account.deposit(100)
      account.withdrawal(50)
      account.deposit(100)
      account.withdrawal(100)

      When("when I print a statement")
      account printStatement

      Then("the statement should have multiple deposits and withdrawals and update the balance")
      application checkThatPrinterReceives List(
        "DATE AMOUNT BALANCE",
        "01/04/2014 100.00 100.00",
        "01/04/2014 -50.00 50.00",
        "01/04/2014 100.00 150.00",
        "01/04/2014 -100.00 50.00"
      )
    }
  }
  val account = application createNewAccount
}
