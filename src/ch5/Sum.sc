sealed trait Sum[A, B] {
  def fold[C](error: A => C, success: B => C) : C = {
    this match {
      case Failure(a) => error(a)
      case Success(b) => success(b)
    }
  }

  def map[C](fn: B => C): Sum[A,C] =
    this match {
      case Success(v) => Success(fn(v))
      case Failure(v) => Failure(v)
    }

  def flatMap[C](fn: B => Sum[A,C]) = {
    this match {
      case Success(v) => fn(v)
      case Failure(v) => Failure(v)
    }
  }

}
final case class Failure[A, B](value: A) extends Sum[A, B]
final case class Success[A, B](value: B) extends Sum[A, B]