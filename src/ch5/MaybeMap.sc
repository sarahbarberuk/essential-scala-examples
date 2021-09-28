sealed trait Maybe[+A] {
  def flatMap[B](fn: A => Maybe[B]): Maybe[B] = {
    this match {
      case Full(v) => fn(v)
      case Empty => Empty[B]
    }
  }

  def map[B](fn: A => B): Maybe[B] =
    flatMap[B](v => Full(fn(v)))

}

final case class Full[A](value: A) extends Maybe[A]
case object Empty extends Maybe[Nothing]


val possible: Maybe[Int] = Empty

def mightFail1: Maybe[Int] =
  Full(1)
def mightFail2: Maybe[Int] =
  Full(2)

def mightFail3: Maybe[Int] =
  Empty // This one failed

mightFail1 flatMap { x =>
  mightFail2 flatMap { y =>
    mightFail3 flatMap { z =>
      Full(x + y + z)
    } }
}

val y = 10 % 2
val list: List[Maybe[Int]] = List(Full(3), Full(2), Full(1))
list.map(maybe => {
    maybe.flatMap[Int]( x =>
    if (x % 2 == 0)
      Full(x)
    else
      Empty
    )
  }
)
