package org.craftmanship.bank

import scala.collection.mutable


class Account(statement: Statement, clock: Clock) {

  val transactions: mutable.MutableList[Deposit] = mutable.MutableList()

  def printStatement {
    statement.print(transactions.toList)
  }

  def deposit(amount: Double) {
    transactions += Deposit(clock.currentDate, amount)
  }


}
