package org.craftmanship.stack

import scala.collection.mutable.MutableList

 class Stack {
    var elements: MutableList[String] = MutableList()

    def pop(): String = {
      if (elements.length equals 0) throw new IllegalStateException
      val element = elements.last
      elements = elements.take(elements.size - 1)
      element
    }

    def push(element: String) = {
      elements += element
    }
  }

