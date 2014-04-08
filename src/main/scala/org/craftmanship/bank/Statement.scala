package org.craftmanship.bank

class Statement(printer: Printer) {
  def print(transactions: List[Deposit]) {
    printer.print(List("DATE AMOUNT BALANCE"))
  }

  def balance: Double = {
    200.00
  }
}
