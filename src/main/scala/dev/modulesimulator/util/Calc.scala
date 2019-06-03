package dev.modulesimulator.util

import scala.util.Random

object Calc {
  def getRandIntBetween(start: Int, end: Int) = start + Random.nextInt( (end - start) + 1 )
}
