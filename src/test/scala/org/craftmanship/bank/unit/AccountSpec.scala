package org.craftmanship.bank.unit

import org.craftmanship.spec.UnitSpec
import org.craftmanship.bank._
import org.mockito.Mockito._
import org.mockito.BDDMockito._
import org.craftmanship.bank.Deposit

class AccountSpec extends UnitSpec {

  "Empty Account" should {
    "print an empty statement" in {
      val statement = mock[Statement]
      val clock = mock[Clock]
      val account = new Account(statement, clock)

      account.printStatement

      verify(statement).print(List())
    }
  }

  "An account with one deposit" should {
    "print a statement containing one deposit" in {
      val statement = mock[Statement]
      val clock = mock[Clock]
      given(clock.currentDate) willReturn("08/04/2014")
      val account = new Account(statement, clock)
      account.deposit(100)

      account.printStatement

      verify(statement).print(List(Deposit(100, clock.currentDate)))
    }
  }

}
