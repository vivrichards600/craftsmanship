package org.craftmanship.user_validation

import org.craftmanship.spec.UnitSpec
import java.lang.IllegalArgumentException
import org.mockito.Mockito._
import org.mockito.BDDMockito._

class UserServiceSpec extends UnitSpec {
  "User service" should {
    "not save a user when user is invalid" in {
      given(userValidation.validate(INVALID_USER)) willThrow(new IllegalArgumentException)

      intercept[IllegalArgumentException] {
        userService save INVALID_USER
      }

      verifyZeroInteractions(userRepository)
    }

    "save a valid user" in {
      userService save USER

      verify(userValidation) validate USER
      verify(userRepository) save USER
    }

  }
  val userRepository = mock[UserRepository]
  val userValidation = mock[UserValidation]
  val userService = new UserService(userRepository, userValidation)

  val FIRSTNAME = "VIV"
  val SURNAME = "SMITH"
  val INVALID_FIRSTNAME = ""
  val INVALID_SURNAME = ""
  val EMAIL_ADDRESS = "valid@valid.co.uk"
  val INVALID_EMAIL_ADDRESS = "invalid"
  val INVALID_USER = User("", "", "")
  val USER = User("Alice", "Smith", "a@a.com")

}
