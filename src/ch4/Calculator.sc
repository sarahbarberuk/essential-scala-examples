//4.7.0.1 A calculator

sealed trait Calculation

final case class Success(value: Double) extends Calculation

final case class Failure(error: String) extends Calculation


sealed trait Expression {
  def eval: Calculation = {
    this match {
      case Addition(l,r) =>
        l.eval match {
          case Failure(reason) => Failure(reason)
          case Success(r1) =>
            r.eval match {
              case Failure(reason) => Failure(reason)
              case Success(r2) => Success(r1 + r2)
            }
        }
      case Subtraction(l,r) =>
        l.eval match {
          case Failure(reason) => Failure(reason)
          case Success(r1) =>
            r.eval match {
              case Failure(reason) => Failure(reason)
              case Success(r2) => Success(r1 - r2)
            }
        }
      case Division(l,r) =>
        l.eval match {
          case Failure(reason) => Failure(reason)
          case Success(r1) =>
            r.eval match {
              case Failure(reason) => Failure(reason)
              case Success(r2) =>
                if (r2 == 0)
                  Failure("Division by zero")
                else
                  Success(r1 / r2)
            }
        }
      case SquareRoot(v) =>
        v.eval match {
          case Failure(reason) => Failure(reason)
          case Success(r) =>
            if (r < 0)
              Failure("Square root of negative number")
            else
              Success(Math.sqrt(r))
        }
      case Number(value) => Success(value)

    }
  }
}


final case class Addition(l:Expression, r:Expression) extends Expression
final case class Subtraction(l:Expression, r:Expression) extends Expression
final case class Division(l:Expression, r:Expression) extends Expression
final case class SquareRoot(expr:Expression) extends Expression
final case class Number(value:Double) extends Expression

assert(Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval == Failure("Square root of negative number"))
assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success (4.0))
assert(Division(Number(4), Number(0)).eval == Failure("Division by zero"))
