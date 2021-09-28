case class Pair[A,B](one: A, two: B) {
}


def intAndString: Pair[Int, String] = Pair(3,"test")
intAndString.one
intAndString.two

def booleanAndDouble: Pair[Boolean, Double] = Pair(true,2.3)
booleanAndDouble.one
booleanAndDouble.two


trait Sum[A,B] {

}
case class Left[A,B](value: A) extends Sum[A,B] {
}

case class Right[A,B](value: B) extends Sum[A,B] {
}

def intOrString(input: Boolean): Sum[Int, String] =
  if(input == true) {
    Left[Int, String](123)
  } else {
    Right[Int, String]("abc")
  }


Left[Int, String](1).value
// res9: Int = 1
Right[Int, String]("foo").value
// res10: String = foo
val sum: Sum[Int, String] = Right("foo")
// sum: sum.Sum[Int,String] = Right(foo)
sum match {
  case Left(x) => x.toString
  case Right(x) => x
}
// res11: String = foo