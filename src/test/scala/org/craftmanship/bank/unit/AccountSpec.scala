package org.craftmanship.bank.unit

import org.craftmanship.spec.UnitSpec
import org.craftmanship.bank._
import org.mockito.Mockito._
import org.mockito.BDDMockito._
import org.craftmanship.bank.Transaction
import java.util.Date

class AccountSpec extends UnitSpec {

  "Empty Account" should {
    "print an empty statement" in new context {
      account.printStatement

      verify(statement).print(List())
    }
  }

  "An account with some deposits" should {
    "print a statement containing all the deposits" in new context {
      given(clock.currentDate) willReturn(currentDate)

      account.deposit(100)
      account.deposit(100)

      account.printStatement

      verify(statement).print(List(Transaction(currentDate, 100),Transaction(currentDate, 100)))
    }
  }

  "An account with some withdrawals" should {
    "print a statement containing all the deposits" in new context {
      given(clock.currentDate) willReturn(currentDate)

      account.withdrawal(100)
      account.withdrawal(100)

      account.printStatement

      verify(statement).print(List(Transaction(currentDate, -100),Transaction(currentDate, -100)))
    }
  }

  trait context {
    val statement = mock[Statement]
    val clock = mock[Clock]
    val currentDate = new Date
    val account = new Account(statement, clock)
  }

}
