sealed trait Maybe[A] {
  def fold[B](full: A => B, empty: B): B = {
    this match {
      case Full(value) => full(value)
      case Empty() => empty
    }

  }
}

case class Full[A](value: A) extends Maybe[A] {

}

case class Empty[A]() extends Maybe[A] {

}


val perhaps: Maybe[Int] = Empty[Int]
val perhaps: Maybe[Int] = Full(1)