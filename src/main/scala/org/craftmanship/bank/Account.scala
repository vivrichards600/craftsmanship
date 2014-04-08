package org.craftmanship.bank

import scala.collection.mutable


class Account(statement: Statement, clock: Clock) {

  val transactions: mutable.MutableList[Deposit] = mutable.MutableList()

  def printStatement {
    statement.print(transactions.toList)
//    printer.print(List("DATE AMOUNT BALANCE", transaction.toString))
  }

  def deposit(amount: Double) {
    transactions += Deposit(amount, clock.currentDate)
//      transactions add (new Deposit(amount, clock.currentDate))
  }


}
