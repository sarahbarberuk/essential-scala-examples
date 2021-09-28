

//val minOrdering = Ordering.fromLessThan[Int]{(x,y) => (x < y)}
//val minOrdering = Ordering.fromLessThan[Int](_ < _)
//val maxOrdering = Ordering.fromLessThan[Int](_ > _)
//
//List(3, 4, 2).sorted(minOrdering)
//List(3, 4, 2).sorted(maxOrdering)
//
//implicit val ordering = Ordering.fromLessThan[Int](_ < _)
//List(2, 4, 3).sorted
//List(1, 7 ,5).sorted


//implicit val absOrdering = Ordering.fromLessThan[Int]{(x,y) => (abs(x) < abs(y))}
//
//
//assert(List(-4, -1, 0, 2, 3).sorted== List(0, -1, 2, 3, -4))
//assert(List(-4, -3, -2, -1).sorted == List(-1, -2, -3, -4))

//final case class Rational(numerator: Int, denominator: Int)
//
//  implicit val rationalOrdering = Ordering.fromLessThan[Rational] { (x, y) =>
//    x.numerator/x.denominator < y.numerator/y.denominator
//  }
//
//  assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted ==
//    List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))
//
//

//final case class Rational(numerator: Int, denominator: Int)
//
//object Rational {
//  implicit val ordering = Ordering.fromLessThan[Rational]((x, y) =>
//    (x.numerator.toDouble / x.denominator.toDouble) <
//      (y.numerator.toDouble / y.denominator.toDouble) )
//}
//object Example {
//  def example =
//    assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted
//      ==
//      List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))
//  }

//final case class Rational(numerator: Int, denominator: Int)
//
//object Rational {
//  implicit val ordering = Ordering.fromLessThan[Rational]((x, y) =>
//    (x.numerator.toDouble / x.denominator.toDouble) <
//      (y.numerator.toDouble / y.denominator.toDouble) )
//}
//object Example {
//
//  implicit val higherPriorityImplicit = Ordering.fromLessThan[Rational
//  ]((x, y) =>
//    (x.numerator.toDouble / x.denominator.toDouble) > (y.numerator.toDouble / y.denominator.toDouble)
//  )
//
//
//  def example =
//    assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted
//      ==
//      List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))
//}


final case class Rational(numerator: Int, denominator: Int)
object RationalLessThanOrdering {
  implicit val ordering = Ordering.fromLessThan[Rational]((x, y) =>
    (x.numerator.toDouble / x.denominator.toDouble) <
      (y.numerator.toDouble / y.denominator.toDouble) )
}
object RationalGreaterThanOrdering {
  implicit val ordering = Ordering.fromLessThan[Rational]((x, y) =>
    (x.numerator.toDouble / x.denominator.toDouble) >
      (y.numerator.toDouble / y.denominator.toDouble) )
}
