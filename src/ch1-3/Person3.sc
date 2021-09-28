case class Person(firstName: String, lastName: String) {
  def name: String = firstName + " " + lastName
}

object Person {
  def apply(name: String): Person  = {
    val parts = name.split(" ")
    apply(parts(0),parts(1))
  }
}

Person.apply("John Doe").firstName
Person("John Doe").firstName

//cant compare contents easily like with case classes
val equalsTrue = new Person("Noel", "Welsh").equals(new Person("Noel", "Welsh"))
equalsTrue


object Stormtrooper {
  def inspect(person: Person): String =
    person match {
      case Person("Luke", "Skywalker") => "Stop, rebel scum!" case Person("Han", "Solo") => "Stop, rebel scum!"
      case Person(first, last) => s"Move along, $first"
    }
}

Stormtrooper.inspect(Person("Noel", "Welsh"))
Stormtrooper.inspect(Person("Han", "Solo"))