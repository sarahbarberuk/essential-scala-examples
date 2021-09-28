case class Person2(firstName: String, lastName: String) {
  def name = firstName + lastName

}


val dave = new Person2("Dave", "Guernell")

Person2("Sarah", "Barber")

Person2


dave.firstName

val equalsTrue = new  Person2("Noel", "Welsh").equals(new Person2("Noel", "Welsh"))
equalsTrue

dave.copy()

dave.copy(firstName = "Dave2")
dave.copy(lastName = "Gurnell2")


new Person2("Noel", "Welsh") eq (new Person2("Noel", "Welsh"))
dave eq dave


case object Citizen {
  def firstName = "John"
  def lastName  = "Doe"
  def name = firstName + " " + lastName
}

Citizen.toString