
object Test {
   def name: String = "Prob the best obj eva"
}

Test.name

object Test3 {
  def hello(name: String): String =
  "Hello " + name
}

Test3.hello("Sarah")

object Test4 {
  val name = "Noel"
  def hello(other: String): String =
    name + " says Hi to " + other
}

Test4.hello("Dave")

object Test7 {
  val simpleField = {
    println("Evaluating simpleField")
    42 }
  def noParameterMethod = {
    println("Evaluating noParameterMethod")
    42
  }
}

Test7
println("test123")
Test7.simpleField
Test7.simpleField
Test7.simpleField
Test7.noParameterMethod
Test7.noParameterMethod
Test7.noParameterMethod


//cat-o-matique
object Oswald {
  val color = "black"
  val food = "milk"
}

object Henderson {
  val color = "ginger"
  val food = "chips"
}

object Quentin {
  val color = "Tabby and white"
  val food = "Curry"
}

//square dance
object calc {
  def square(x: Double) = x * x
  def cube(x: Double) = x * square(x)
}

object calc2 {
  def square(x: Double) = x * x
  def cube(x: Double) = x * square(x)

  def square(x: Int) = x * x
  def cube(x: Int) = x * square(x)



}




object argh {
  def a = {
    println("a")
    1
  }

  val b = {
    println("b")
    a+2
  }
  def c = {
    println("c")
    a
    b + "c"
  }
}

argh.c + argh.b + argh.a


object person {
  val firstName = "Sarah"
  val lastName = "Barber"
}

object alien {
  def greet(p: person.type) = {
    "Hello " + p.firstName + " " + p.lastName
  }
}

alien.greet(person)

