sealed trait Calculation
case class Success(result: Int) extends Calculation
case class Failure(message: String) extends Calculation

object Calculator {
  def +(calc: Calculation, operand: Int): Calculation = {
    calc match {
      case Success(result) => Success(result+operand)
      case Failure(message) => Failure(message)
    }
  }

  def -(calc: Calculation, operand: Int): Calculation = {
    calc match {
      case Success(result) => Success(result-operand)
      case Failure(message) => Failure(message)
    }
  }

  def /(calc: Calculation, operand: Int): Calculation = {
    calc match {
      case Success(result) => {
        operand match {
          case 0 => Failure("Division by zero")
          case _ => Success(result / operand)
        }
      }
      case Failure(message) => Failure(message)
    }
  }
}

//assert(Calculator.+(Success(1), 1) == Success(2))
//assert(Calculator.-(Success(1), 1) == Success(0))
//assert(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))

assert(Calculator./(Success(4), 2) == Success(2))
assert(Calculator./(Success(4), 0) == Failure("Division by zero"))
assert(Calculator./(Failure("Badness"), 0) == Failure("Badness"))