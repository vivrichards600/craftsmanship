package org.craftmanship.bank

import scala.collection.mutable


class Account(statement: Statement, clock: Clock) {

  val transactions: mutable.MutableList[Transaction] = mutable.MutableList()

  def printStatement {
    statement.print(transactions.toList)
  }

  def deposit(amount: Double) {
    transactions += Transaction(clock.currentDate, amount)
  }

  def withdrawal(amount: Double) {
    transactions += Transaction(clock.currentDate, -amount)
  }

}
