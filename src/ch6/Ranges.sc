1 until 10

10 until 1
10 until 1 by -1

for(i <- 99 until 0 by -1) println(i + " bottles of beer on the wall!" )



(1 until 10) ++ (20 until 30)


val subjects = List("Noel","The cat","The dog")
val verbs = List("wrote","chased","slept on")
val objects = List("the book","the ball","the bed")


def allSentences : List[(String,String,String)] = {
  for {
    subject <- subjects
    verb <- verbs
    obj <- objects
  } yield (subject, verb, obj)
}

allSentences


def verbsFor(subject: String): List[String] =
  subject match {
    case "Noel" => List("wrote", "chased", "slept on")
    case "The cat" => List("meowed at", "chased", "slept on")
    case "The dog" => List("barked at", "chased", "slept on")
  }


def objectsFor(verb: String): List[String] =
  verb match {
    case "wrote" => List("the book", "the letter", "the code")
    case "chased" => List("the ball", "the dog", "the cat")
    case "slept on" => List("the bed", "the mat", "the train")
    case "meowed at" => List("Noel", "the door", "the food cupboard")
    case "barked at" => List("the postman", "the car", "the cat")
  }

def allSentencesConditional: List[(String, String, String)] =
  for {
    subject <- subjects
    verb <- verbsFor(subject)
    obj <- objectsFor(verb)
  } yield (subject, verb, obj)

allSentencesConditional


final case class Distribution[A] (events: List[(A, Double)]) {

  def uniform(atoms: List[A]): Distribution[A] = {
    val p = 1.0/events.length
    Distribution(atoms.map(a => a -> p))
  }

  def map[B](f: A => B): Distribution[B] =
    Distribution(events map {
      case (a,p) => f(a) -> p
    })

  def flat[B](f: A => Distribution[B]): Distribution[B] =
    Distribution(events flatMap {
      case (a, p1) => f(a).events map {
        case (b, p2) => b -> (p1 * p2)
      }
    }).compact.normalize

  def normalize: Distribution[A] = {
    val totalWeight = (events map { case (a, p) => p }).sum
    Distribution(events map {
      case (a,p) => a -> (p / totalWeight)
    })
  }

  def compact: Distribution[A] = {
    val distinct = (events map { case (a, p) => a }).distinct
    def prob(a: A): Double =
      (events filter { case (x, p) => x == a } map { case (a, p) => p }).sum
    Distribution(distinct map { a => a -> prob(a) })
  }


}

object Distribution {
  def uniform[A](atoms: List[A]): Distribution[A] = {
    val p = 1.0 / atoms.length
    Distribution(atoms.map(a => a -> p))
  }
}


sealed trait Coin
case object Heads extends Coin
case object Tails extends Coin

val fairCoin: Distribution[Coin] = Distribution.uniform(List(Heads, Tails))

//
//
//  for {
//    c1 <- fairCoin
//    c2 <- fairCoin2
//    c3 <- fairCoin3
//  } yield (c1, c2, c3)

//finished chapter but didn't fully learn everything