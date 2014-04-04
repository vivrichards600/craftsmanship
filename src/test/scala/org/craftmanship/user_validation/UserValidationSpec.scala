package org.craftmanship.user_validation

import org.craftmanship.spec.UnitSpec
import org.mockito.Mockito._
import org.mockito.BDDMockito._

class UserValidationSpec extends UnitSpec {

  "User validation" should {
    "invoke a validator" in new context {
      userValidation validate(USER)

      verify(validator).validate(USER)
    }

    "invoke a validator and cause an exception" in new context {
      given(validator.validate(INVALID_USER)) willThrow(new IllegalArgumentException)

      intercept[IllegalArgumentException] {
        userValidation validate  INVALID_USER
      }
    }

    "invoke multiple validators" in new context {
      val another_validator = mock[Validator]
      userValidation = new UserValidation(validator, another_validator)

      userValidation validate(USER)

      verify(validator).validate(USER)
      verify(another_validator).validate(USER)
    }
  }

  trait context {
    val validator = mock[Validator]
    var userValidation = new UserValidation(validator)
  }

  val USER = User("Alice", "Smith", "a@a.com")
  val INVALID_USER = User("", "", "invalid email")

}
