package dev.modulesimulator
import dev.modulesimulator.models._

import scala.util.{Either, Try}


object Bootstrap {
  def main(args: Array[String]): Unit = {
    extractMainArgs(args).fold({ errMsg =>
      println(errMsg)
    }, { case (moduleType, count) =>
      println("huga")
    })
  }


  private def extractMainArgs(args: Array[String]): Either[String, (ModuleType, Int)] = args match {
    case Array(moduleType: String, quantity: String, _) => validateMainArgs(moduleType, quantity)
    case _ => Left("Please specify correct number")
  }

  private def validateMainArgs(moduleType: String, strQuantity: String) = {
    for {
      validModuleType <- getModuleType(moduleType)
      intQuantity <- convertQuantityToInt(strQuantity)
      quantity <- if(intQuantity > 0){Right(intQuantity)} else{Left("Please specify number over 1")}
    } yield (validModuleType, quantity)
  }

  private def convertQuantityToInt(strQuantity: String) =
    Try(strQuantity.toInt).toEither.left.map(_ => "Please specify the number of module to be created in the second arg by Integer")

  private def getModuleType(moduleType: String): Either[String, ModuleType] = moduleType match {
    case MixModule.name => Right(MixModule)
    case AttackModule.name => Right(AttackModule)
    case CureModule.name => Right(CureModule)
    case DefendModule.name => Right(DefendModule)
    case _ => Left("Please choose among mix attack cure defend")
  }
}

