package org.craftmanship.bank

object Application extends App {

  val statement = new Statement(new Printer)
  val account = new Account(statement, new Clock)

  account deposit(100)
  account deposit(500)
  account withdrawal(200)
  account withdrawal(300)

  account printStatement

}
