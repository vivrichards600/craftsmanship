package org.craftmanship.bank.unit

import org.craftmanship.spec.UnitSpec
import org.craftmanship.bank._
import org.mockito.Mockito._

class StatementSpec extends UnitSpec {
  "Statement" should {
    "generate a balance" in {
      val statement = mock[Statement]

      statement.balance

      verify(statement).balance
    }
  }
}
