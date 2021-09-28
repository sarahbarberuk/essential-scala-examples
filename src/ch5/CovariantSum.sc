sealed trait Sum[+A,+B] {
  def flatMap[AA >: A, C](fn: B => Sum[AA,C]) = {
    this match {
      case Success(v) => fn(v)
      case Failure(v) => Failure(v)
    }
  }
}
final case class Failure[A](value: A) extends Sum[A, Nothing]
final case class Success[B](value: B) extends Sum[Nothing,B]
