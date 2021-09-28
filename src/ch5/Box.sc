final case class Box[A](value: A)

Box(2).value

Box("Hi").value

def generic[A](in: A): A = in

generic[String]("foo")
generic(1)