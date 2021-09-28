class Counter(val count:Int) {
  def inc: Counter = inc()
  def dec: Counter = dec()
  def inc(amount:Int = 1): Counter = new Counter(count+amount)
  def dec(amount:Int = 1): Counter = new Counter(count-amount)

  def adjust(adder: Adder): Counter = new Counter(adder(count))

}

new Counter(10).inc().dec().inc().inc().count
new Counter(10).inc.dec.inc.inc.count
new Counter(10).inc.inc(10).count



class Adder(amount: Int) {
  def apply(in: Int) = in + amount
}

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