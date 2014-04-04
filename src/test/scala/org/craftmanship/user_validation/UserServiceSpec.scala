package org.craftmanship.user_validation

import org.craftmanship.spec.UnitSpec
import java.lang.IllegalArgumentException
import org.mockito.Mockito.verify

class UserServiceSpec extends UnitSpec {
  "User service" should {
    "not save a user when first name is not valid" in {
      val user = User(INVALID_FIRSTNAME, SURNAME, EMAIL_ADDRESS)

      an [IllegalArgumentException] should be thrownBy userService.save(user)
    }

    "not save a user when surname is not valid" in {
      val user = new User(FIRSTNAME, INVALID_SURNAME, EMAIL_ADDRESS)

      an [IllegalArgumentException] should be thrownBy userService.save(user)
    }

    "not save a user when email address is not valid" in {
      val user = new User(FIRSTNAME, SURNAME, INVALID_EMAIL_ADDRESS)

      an [IllegalArgumentException] should be thrownBy userService.save(user)
    }

    "save a valid user" in {
      val user = new User(FIRSTNAME, SURNAME, EMAIL_ADDRESS)

      userService.save(user)

      verify(userRepository).save(user)
    }
  }
  val userRepository = mock[UserRepository]
  val userService = new UserService(userRepository)

  val FIRSTNAME = "VIV"
  val SURNAME = "SMITH"
  val INVALID_FIRSTNAME = ""
  val INVALID_SURNAME = ""
  val EMAIL_ADDRESS = "valid@valid.co.uk"
  val INVALID_EMAIL_ADDRESS = "invalid"
  
}
