package org.craftmanship.user_validation

class UserValidation {
  def validate(user: User) {

    if (user.firstname.isEmpty) throw new IllegalArgumentException

    if (user.surname.isEmpty) throw new IllegalArgumentException

    val EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$".r
    if (!EMAIL_PATTERN.pattern.matcher(user.emailaddress).matches) throw new IllegalArgumentException

  }
}
