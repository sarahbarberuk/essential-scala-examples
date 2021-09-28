trait Feline {

  def colour: String
  def sound: String

}

trait BigCat extends Feline {
  override val sound = "roar"
}


case class Cat(
                colour: String,
                food: String
              ) extends Feline {

  val sound = "meow"
}

case class Lion(
                colour: String,
                maneSize: Int
              ) extends BigCat {
}

case class Tiger(colour: String) extends BigCat {
}

case class Panther(colour: String) extends BigCat {
}


val cat = Cat("ginger", "chips")
cat.food
cat.sound
cat.colour

val lion = Lion("yellow", 3)
lion.sound
lion.colour
lion.maneSize

val panther = Panther("black")
panther.sound
panther.colour