package org.craftmanship.user_validation

class UserService(userRepository: UserRepository) {

  def save(user: User) {
    val EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$".r

    EMAIL_PATTERN.pattern.matcher(user.emailaddress).matches match {
      case true => {
        if ((user.firstname.length < 1) || (user.surname.length < 1)) throw new IllegalArgumentException
        else userRepository.save(user)
      }
      case false => throw new IllegalArgumentException
    }
  }
}
