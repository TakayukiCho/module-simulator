package dev.modulesimulator.models

abstract class Module {
  val moduleType: ModuleType
  val totalTurn: Int
  val actions: Seq[Action]
  def totalCost: Int
  def Slot: Int
  def Memory: Int
}
