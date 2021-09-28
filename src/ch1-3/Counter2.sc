
class Adder(amount: Int) {
  def apply(in: Int) = in + amount
}

case class Counter(val count:Int = 0) {
  def inc: Counter = inc()
  def dec: Counter = dec()
  def inc(amount:Int = 1) = copy(count = count + amount)
  def dec(amount:Int = 1) = copy(count = count - amount)

  def adjust(adder: Adder): Counter = new Counter(adder(count))

}

new Counter(10).inc().dec().inc().inc().count
new Counter(10).inc.dec.inc.inc.count
new Counter(10).inc.inc(10).count

Counter(0) // construct objects without `new`
Counter().inc // printout shows the value of `count`
Counter().inc.dec == Counter().dec.inc // semantic equality check

val add3 = new Adder(3)
add3.apply(2)
add3(4)

class Timestamp(val seconds: Long)
object Timestamp {
  def apply(hours: Int, minutes: Int, seconds: Int): Timestamp =
    new Timestamp(hours*60*60 + minutes*60 + seconds)
}
Timestamp(1, 1, 1).seconds
new Timestamp(3661).seconds
Timestamp