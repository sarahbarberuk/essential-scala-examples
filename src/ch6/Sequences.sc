import scala.collection.immutable._
val sequence = Seq(1,2,3)
sequence.tail.head
Seq().headOption
sequence.headOption
sequence.length
sequence.contains(2)
sequence.find(_ == 3)
sequence.find(_ > 4)

sequence.filter(_ > 1)
sequence.sortWith(_ > _)
sequence :+ 4
sequence.:+(4)
sequence.+:(0)
0 +: sequence
sequence ++ Seq(4,5,6)

Nil
List()
val list = 1 :: 2 :: 3 :: Nil
4 :: 5 :: Nil
Nil ::: List(4, 5, 6)
import scala.collection.immutable.Vector.apply
Vector(1, 2, 3)
Queue(1, 2, 3)
apply(1,2,3)