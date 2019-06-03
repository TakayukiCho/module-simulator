package dev.modulesimulator.models

import dev.modulesimulator.util.Calc

case class Turn(index: Int) {

  private val costs = List(1.4, 1.1, 0.9, 0.8, 0.7, 0.6, 0.5)

  lazy val cost: Option[Double] = costs.lift(index - 1)
}

object Turn {
  // 消滅までのターン数
  def getRandomTurnNumber = Calc.getRandIntBetween(1, 5)
}