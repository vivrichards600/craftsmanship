package org.craftmanship.bank

import java.util.Date
import org.joda.time.format.DateTimeFormat._

class Statement(printer: Printer) {

  val STATEMENT_HEADER = "DATE AMOUNT BALANCE"
  var balance = 0d

  def print(transactions: List[Deposit]) {
    val statementLines = transactions map toStatementLine
    printer print(STATEMENT_HEADER +: statementLines)
  }

  private def toStatementLine(transaction: Deposit): String = {
    balance += transaction.amount

    formatDate(transaction.date) + " " + formatAmount(transaction.amount) + " " + formatAmount(balance)
  }

  private def formatDate(date: Date) : String = {
    forPattern("dd/MM/yyyy").print(date.getTime)
  }

  private def formatAmount(amount: Double) : String = {
    "%1.2f" format amount
  }

}
