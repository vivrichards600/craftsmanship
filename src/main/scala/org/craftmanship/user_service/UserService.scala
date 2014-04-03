package org.craftmanship.user_service

class UserService(userRepository: UserRepository) {
  def save(user: User) = {
    if (userRepository.exists(user))
      userRepository.update(user)
    else
      userRepository.create(user)
  }
}
