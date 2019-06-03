package dev.modulesimulator.models

sealed trait ModuleType

case object MixModule extends ModuleType {
  val name = "mix"
}
case object AttackModule extends ModuleType {
  val name = "attack"
}
case object DefendModule extends ModuleType {
  val name = "defend"
}
case object CureModule extends ModuleType {
  val name ="cure"
}

