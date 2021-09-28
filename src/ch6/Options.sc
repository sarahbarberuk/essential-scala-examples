def readInt(str: String): Option[Int] =
  if (str matches "-?\\d+") Some(str.toInt) else None

readInt("abc").getOrElse(0)

readInt("123") match {
  case Some(number) => number + 1
  case None => 0
}

def sum(optionA: Option[Int], optionB: Option[Int]): Option[Int] =
  optionA.flatMap(a => optionB.map(b => a + b))

sum(readInt("1"), readInt("2"))

Seq(readInt("1"), readInt("b"), readInt("3")).flatMap(x => x)

val optionA = readInt("123")
val optionB = readInt("234")

for {
  a <- optionA
  b <- optionB
} yield a + b

def addOptions(optionA: Option[Int], optionB: Option[Int]): Option[Int] = {
  for {
  a <- optionA
  b <- optionB
  } yield a + b
}

def addOptions2(optionA: Option[Int], optionB: Option[Int]): Option[Int] = {
  optionA.flatMap(a => optionB.map(b => a+b))
}

def addOptions3(optionA: Option[Int], optionB: Option[Int]): Option[Int] = {
  optionA flatMap { a =>
    optionB map { b =>
      a + b
    }
  }
}

def divide(numerator: Int, denomimator: Int): Option[Int] = {
  if (denomimator == 0) None
  else Some(numerator/denomimator)
}

def divideOptions(numeratorOption: Option[Int], denomimatorOption: Option[Int]): Option[Int] = {
  for {
    num <- numeratorOption
    den <- denomimatorOption
    ans <- divide(num,den)
  } yield ans

}

def calculator(operand1: String, operator: String, operand2: String): Unit = {
  val result = for {
    a <- readInt(operand1)
    b <- readInt(operand2)
    ans <- operator match {
      case "+" => Some(a+b)
      case "-" => Some(a-b)
      case "*" => Some(a*b)
      case "/" => divide(a,b)
      case "_" => None
    }
  } yield ans

  result match {
    case Some(number) => println(s"The answer is $number")
    case None         => println(s"Error calculating $operand1 $operator $operand2")
  }

}

calculator("2", "+", "1")


def calculator2(operand1: String, operator: String, operand2: String): Unit = {

  def calcInternal2(a: Int, b: Int) =
    operator match {
      case "+" => Some(a + b)
      case "-" => Some(a - b)
      case "*" => Some(a * b)
      case "/" => divide(a, b)
      case "_" => None
    }

  val result =
    readInt(operand1) flatMap(a =>
        readInt(operand2) flatMap(b =>
            calcInternal2(a, b) map { result =>
              result
            }
          )
      )

  result match {
    case Some(number) => println(s"The answer is $number")
    case None         => println(s"Error calculating $operand1 $operator $operand2")
  }

}




import scala.util.Try
val opt1 = Some(1)
val opt2 = Some(2)
val opt3 = Some(3)
val seq1 = Seq(1)
val seq2 = Seq(2)
val seq3 = Seq(3)
val try1 = Try(1)
val try2 = Try(2)
val try3 = Try(3)


for {
  a <- opt1
  b <- opt2
  c <- opt3
} yield a + b + c


for {
  a <- seq1
  b <- seq2
  c <- seq3
} yield a + b + c


for {
  a <- try1
  b <- try2
  c <- try3
} yield a + b + c
