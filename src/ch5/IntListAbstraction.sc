sealed trait IntList {
  def length: Int =
    fold[Int](0,(_,tl) => 1+tl)

  def double: IntList =
    fold[IntList](End,(hd,tl) => Pair(hd * 2, tl))

  def product: Int =
    fold[Int](1,(hd,tl) => hd*tl)

  def sum: Int =
    fold[Int](0,(hd,tl) => hd+tl)

  def fold[A](end: A, f: (Int, A) => A): A =
    this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }
}
case object End extends IntList
case class Pair(hd: Int, tl: IntList) extends IntList

val example = Pair(1,Pair(2,Pair(3, End)))
example.length
example.sum
example.product
example.double
