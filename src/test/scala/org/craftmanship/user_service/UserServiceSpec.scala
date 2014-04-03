package org.craftmanship.user_service

import org.craftmanship.spec.UnitSpec
import org.mockito.Mockito.verify
import org.mockito.BDDMockito.given

class UserServiceSpec extends UnitSpec {

  "User service" should {
    "create a user if it does not already exist" in {
      given(userRepository.exists(NON_EXISTING_USER)) willReturn false

      userService.save(NON_EXISTING_USER)

      verify(userRepository).create(NON_EXISTING_USER)
    }

    "should update if a user already exists" in {
      given(userRepository.exists(EXISTING_USER)) willReturn true

      userService.save(EXISTING_USER)

      verify(userRepository).update(EXISTING_USER)
    }
  }

  val userRepository = mock[UserRepository]
  val userService = new UserService(userRepository)
  val NON_EXISTING_USER = new User
  val EXISTING_USER = new User

}
