sealed trait Food
case object Antelope extends Food
case object TigerFood extends Food
case object Licorice extends Food
final case class CatFood(food:String) extends Food

sealed trait Feline {
  def dinner: Food =
    this match {
      case Lion() => Antelope
      case Tiger()=> TigerFood
      case Panther() => Licorice
      case Cat(favouriteFood) => CatFood(favouriteFood)
    }
}
final case class Lion() extends Feline {
}
final case class Tiger() extends Feline {
}
final case class Panther() extends Feline {
}



final case class Cat(favouriteFood: String) extends Feline {
}

def dinner(feline: Feline): String = {
  feline match {
    case Cat(favouriteFood) => favouriteFood
    case Lion() => "antelope"
    case Tiger() => "tiger food"
    case Panther() => "licorice"
  }
}
