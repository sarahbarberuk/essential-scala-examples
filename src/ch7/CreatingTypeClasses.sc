

//trait HtmlWriteable {
//  def toHtml: String
//}
//final case class Person(name: String, email: String) extends HtmlWriteable {
//  def toHtml = s"<span>$name &lt;$email&gt;</span>" }
//
//Person("John", "john@example.com").toHtml

//object HtmlWriter {
//  def write(in: Any): String =
//    in match {
//      case Person(name, email) => ???
//      case d: Date => ???
//      case _ => throw new Exception(s"Can't render ${in} to HTML")
//    } }


//trait HtmlWriter[A] {
//  def write(in: A): String
//}
//object PersonWriter extends HtmlWriter[Person] {
//  def write(person: Person) = s"<span>${person.name} &lt;${person.
//    email}&gt;</span>"
//}

//PersonWriter.write(Person("John", "john@example.com"))
//
//import java.util.Date
//object DateWriter extends HtmlWriter[Date] {
//  def write(in: Date) = s"<span>${in.toString}</span>"
//}

//object ObfuscatedPersonWriter extends HtmlWriter[Person] { def write(person: Person) =
//  s"<span>${person.name} (${person.email.replaceAll("@", " at ")})</ span>"
//}

//ObfuscatedPersonWriter.write(Person("John", "john@example.com"))

//case class Person(name: String, email: String)
//
//trait Equal[A] {
//  def equal(x: A, y: A): Boolean
//}

//object EmailEqual extends Equal[Person] {
//  def equal(v1: Person, v2: Person) : Boolean   =
//    v1.email == v2.email
//
//}
//
//object NameEmailEqual extends Equal[Person] {
//  def equal(v1: Person, v2: Person) : Boolean    =
//    v1.name == v2.name && v1.email == v2.email
//
//}


//object HtmlUtil {
//  def htmlify[A](data: A)(implicit writer: HtmlWriter[A]): String = {
//    writer.write(data)
//  }
//}

//implicit object PersonWriter extends HtmlWriter[Person] { def write(in: Person): String =
//  s"${in.name} has email email address of ${in.email}" }


//implicit object ApproximationWriter extends HtmlWriter[Int] { def write(in: Int): String =
//  s"It's definitely less than ${((in / 10) + 1) * 10}" }

//HtmlUtil.htmlify(20)


//object HtmlWriter {
//  def write[A](in: A)(implicit writer: HtmlWriter[A]): String =
//    writer.write(in)
//}

case class Person(name: String, email: String)

trait Equal[A] {
  def equal(v1: A, v2: A): Boolean
}

object EmailImplicit {
  implicit object EmailEqual extends Equal[Person] {
    def equal(v1: Person, v2: Person): Boolean =
      v1.email == v2.email
  }
}

object NameAndEmailImplicit {
  implicit object NameEmailEqual extends Equal[Person] {
    def equal(v1: Person, v2: Person): Boolean =
      v1.email == v2.email && v1.name == v2.name
  }
}

object Eq {
  def apply[A](x: A, y: A)(implicit equal: Equal[A]): Boolean = {
    equal.equal(x,y)
  }
}

object Equal {
  def apply[A](implicit instance: Equal[A]): Equal[A] =
    instance }

object Examples {
  def byNameAndEmail = {
    import NameAndEmailImplicit._
    Eq(Person("Noel", "noel@example.com"), Person("Noel", "noel@example.com"))
  }
  def byEmail = {
    import EmailImplicit._
    Eq(Person("Noel", "noel@example.com"), Person("Dave", "noel@example.com"))
  }
}


import NameAndEmailImplicit._
Equal[Person].equal(Person("Noel", "noel@example.com"), Person("Noel","noel@example.com"))
