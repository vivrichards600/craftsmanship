package org.craftmanship.user_validation

class UserValidation(validators: Validator*) {
  def validate(user: User) {
    validators.foreach(_ validate(user))

  }
}
