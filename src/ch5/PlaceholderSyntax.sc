((_: Int) * 2)

object Sum {
  def sum(x: Int, y: Int) = x + y
}

  Sum.sum _

object MathStuff {
  def add1(num: Int) = num + 1
}

case class Counter(val count:Int = 0) {
  def inc: Counter = inc()
  def dec: Counter = dec()
  def inc(amount:Int = 1) = copy(count = count + amount)
  def dec(amount:Int = 1) = copy(count = count - amount)

  def adjust(adder: Adder): Counter = new Counter(adder(count))

}


Counter(2).adjust(MathStuff.add1)