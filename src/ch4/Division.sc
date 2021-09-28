sealed trait DivisionResult

final case class Finite(value: Int) extends DivisionResult

case object Infinite extends DivisionResult

object divide {
  def apply(numerator: Int, denumerator: Int): DivisionResult = {
    if (denumerator == 0) Infinite else Finite(numerator/denumerator)
  }
}

divide(1,0) match {
  case Finite(value) => s"It's finite: ${value}"
  case Infinite => s"It's infinite"
}