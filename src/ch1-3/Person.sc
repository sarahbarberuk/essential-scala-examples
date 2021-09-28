class Person(val firstName: String, val lastName: String) {
  def name: String =
    s"$firstName $lastName"
}

object Person {
  def apply(name: String): Person  = {
    val parts = name.split(" ")
    new Person(parts(0),parts(1))
  }
}

Person.apply("John Doe").firstName
Person("John Doe").firstName

//cant compare contents easily like with case classes
val equalsTrue = new Person("Noel", "Welsh").equals(new Person("Noel", "Welsh"))
equalsTrue
