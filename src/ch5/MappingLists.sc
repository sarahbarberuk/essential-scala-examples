sealed trait LinkedList[A] {
  def map[B](fn: A => B): LinkedList[B] =
    this match {
      case Pair(hd, tl) => Pair(fn(hd),tl.map(fn))
      case End() => End()
    } }
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
final case class End[A]() extends LinkedList[A]
val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, End())))

list.map(_ * 2)
list.map(_ + 1)
list.map(_ / 3)


val list2 = List(1, 2, 3)
val negativeList = list2.map(_ * -1)
val finalList = list2.appendedAll(negativeList)

val finalList2 = list2.flatMap(x => List(x,-x))



