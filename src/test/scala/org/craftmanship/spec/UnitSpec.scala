package org.craftmanship.spec

import org.scalatest._
import org.scalatest.mock.MockitoSugar

abstract class UnitSpec extends WordSpec
with Matchers
with OptionValues
with Inside
with Inspectors
with MockitoSugar