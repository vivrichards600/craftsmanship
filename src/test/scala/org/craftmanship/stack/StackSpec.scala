package org.craftmanship.stack

import org.craftmanship.spec.UnitSpec

class StackSpec  extends UnitSpec {
    val stack = new Stack
    val ENGLAND = "element"
    val WALES = "another element"

    "Empty Stack" should {
      "Throw exception when popped" in {
        an [IllegalStateException] should be thrownBy stack.pop
      }
    }

    "A stack with 1 element" should {
      "return the existing element when popped" in {
        stack.push(ENGLAND)

        stack.pop() should equal(ENGLAND)
      }
    }

    "A stack with 2 elements" should {
      "return the last elements added first" in {
        stack.push(ENGLAND)
        stack.push(WALES)

        stack.pop() should equal(WALES)
        stack.pop() should equal(ENGLAND)
      }
    }
  }
