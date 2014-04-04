package org.craftmanship.user_validation

class UserService(userRepository: UserRepository, userValidation: UserValidation) {

  def save(user: User) {
    userValidation.validate(user)
    userRepository.save(user)
  }
}
