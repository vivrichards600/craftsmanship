package org.craftmanship.bank

class Account(printer: Printer) {

  def printStatement {
    printer.print(List("DATE AMOUNT BALANCE"))
  }

  def deposit(amount: Double) {

  }

}
