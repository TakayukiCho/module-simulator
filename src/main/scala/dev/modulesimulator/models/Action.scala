package dev.modulesimulator.models

import scala.util.Random

sealed trait Action {
  val typeCost: Double
  def cost: Double
}

case class Attack(force: Double) extends Action {
  override val typeCost: Double = 1
  override lazy val cost = typeCost * force
}

case class Defend(force: Double) extends Action {
  override val typeCost: Double = 0.5
  override lazy val cost = typeCost * force
}

case class Cure(force: Double) extends Action {
  override val typeCost: Double = 0.9
  override lazy val cost = typeCost * force
}

case class AllRangeAttack(force: Double) extends Action {
  override val typeCost: Double = 3
  override lazy val cost = typeCost * force
}

case object Noop extends Action {
  override val typeCost: Double = -3
  override val cost = typeCost
}

object Action {
  val allExceptNoop = List(Attack, Defend, Cure, AllRangeAttack)
  lazy val all = Noop :: allExceptNoop
  def getRandomActionExceptNoop = Random.shuffle(allExceptNoop).headOption
  def getRandomAction = Random.shuffle(all).headOption
}
