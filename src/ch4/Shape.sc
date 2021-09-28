sealed trait Color {
  def r: Int
  def g: Int
  def b: Int

  def isLight(): Boolean = {
    if (r > 225 && g > 225 && b > 225) true
    else false
  }
}

case class CustomColor(r: Int, g: Int, b: Int) extends Color


sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
  val color: Color
}

case class Circle(radius: Double, color: Color) extends Shape {
  val sides = 0
  val perimeter = 2 * Math.PI * radius
  val area = Math.PI * radius * radius
}

sealed trait Rectangular extends Shape {

  def width: Double
  def length: Double
  val sides = 4
  val area = width * length
  val perimeter = width + width + length + length
}

case class Rectangle(width: Double, length: Double, color: Color) extends Rectangular

case class Square(size: Double, color: Color) extends Rectangular  {
  val width = size
  val length = size
}

object Red extends Color {
  val r = 255
  val g = 0
  val b = 0
}

object Yellow extends Color {
  val r = 255
  val g = 255
  val b = 0
}
object Pink extends Color {
  val r = 255
  val g = 192
  val b = 203
}

object Draw {
  def apply(shape: Shape): String = shape match {
    case Rectangle(width, length, color) =>
      s"A ${Draw(color)} rectangle of ${width}cm and length ${length}cm"
    case Square(size, color) =>
      s"A ${Draw(color)} square of size ${size}cm"
    case Circle(radius, color) =>
      s"A ${Draw(color)} circle of radius ${radius}cm"
  }

  def apply(color: Color): String = color match {
    case Red => "red"
    case Yellow => "yellow"
    case Pink => "pink"
    case color => if (color.isLight) "light" else "dark"
  }
}

  Draw(Circle(10, Pink))


  val circle = Circle(3, CustomColor(230, 230, 255))
  circle.sides
  circle.perimeter
  circle.area

  val rectangle = Rectangle(2, 4, CustomColor(230, 230, 255))
  rectangle.sides
  rectangle.perimeter
  rectangle.area

  val square = Square(4, CustomColor(230, 230, 255))
  square.sides
  square.perimeter
  square.area

  Draw(Circle(0, Yellow))

  val rect = Rectangle(3, 4, CustomColor(230, 230, 255))
  Draw(rect)

  val rect2 = Rectangle(3, 4, Yellow)
  Draw(rect2)
  Draw(Rectangle(3, 4, Yellow))
  Draw(Square(3, Pink))



