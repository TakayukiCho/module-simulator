package dev.modulesimulator.models

import scala.util.Random

sealed trait Action {
  val typeCost: Double
}

case object Attack extends Action {
  override val typeCost: Double = 1
}

case object Defend extends Action {
  override val typeCost: Double = 0.5
}

case object Cure extends Action {
  override val typeCost: Double = 0.9
}

case object AllRangeAttack extends Action {
  override val typeCost: Double = 3
}

case object Noop extends Action {
  override val typeCost: Double = -3
}

object Action {
  val allExceptNoop = List(Attack, Defend, Cure, AllRangeAttack)
  lazy val all = Noop :: allExceptNoop
  def getRandomActionExceptNoop = Random.shuffle(allExceptNoop).headOption
  def getRandomAction = Random.shuffle(all).headOption
}
