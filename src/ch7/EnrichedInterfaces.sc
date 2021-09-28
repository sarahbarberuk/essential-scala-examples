def numberOfVowels(str: String) =
  str.filter(Seq('a', 'e', 'i', 'o', 'u').contains(_)).length

numberOfVowels("the quick brown fox")




implicit class ExtraStringMethods(str: String) {
  val vowels = Seq('a', 'e', 'i', 'o', 'u')
  def numberOfVowels =
    str.toList.filter(vowels contains _).length
}

"the quick brown fox".numberOfVowels




//object IntImplicits {
//
//  implicit class IntOps(n: Int) {
//    def yeah() =
//      times(_ => println("Oh yeah"))
//
//    def times(func: Int => Unit) =
//    for (i <- 0 until n) func(i)
//
//  }
//
//}
//
//import IntImplicits._
//2.yeah()
//3.yeah()
//
//3.times(i => println(s"Look - it's the number $i!"))






trait Equal[A] {
  def equal(v1: A, v2: A): Boolean
}

object Equal {
  def apply[A](implicit instance: Equal[A]): Equal[A] =
    instance

  implicit class ToEqual[A](in: A) {
    def ===(other: A)(implicit equal: Equal[A]) =
      equal.equal(in, other)


  }
}


implicit val caseInsensitiveEquals = new Equal[String] {
  def equal(s1: String, s2: String) =
    s1.toLowerCase == s2.toLowerCase
}

import Equal._
"foo".===("FOO")



trait HtmlWriteable {
  def toHtml: String
}
final case class Person(name: String, email: String) extends HtmlWriteable {
  def toHtml = s"<span>$name &lt;$email&gt;</span>" }

trait HtmlWriter[A] {
  def write(in: A): String
}

object PersonWriter extends HtmlWriter[Person] {
  def write(person: Person) = s"<span>${person.name} &lt;${person.
    email}&gt;</span>"
}

//def pageTemplate[A](body: A)(implicit writer: HtmlWriter[A]): String = {
//  val renderedBody = body.toHtml s"<html><head>...</head><body>${renderedBody}</body></html>"
//}
//
//def pageTemplate[A : HtmlWriter](body: A): String = {
//  val renderedBody = body.toHtml
//  s"<html><head>...</head><body>${renderedBody}</body></html>" }





case class Example(name: String)
implicit val implicitExample = Example("implicit")
implicitly[Example]
implicitly[Example] == implicitExample


class B {
  def bar = "This is the best method ever!"
}
class A
implicit def aToB(in: A): B = new B()

new A().bar

object IntImplicits {
  class IntOps(n: Int) {
    def yeah() =
      times(_ => println("Oh yeah!"))
    def times(func: Int => Unit) =
      for(i <- 0 until n) func(i)
  }
  implicit def intToIntOps(value: Int) =
    new IntOps(value)
}
import IntImplicits._
5.yeah()