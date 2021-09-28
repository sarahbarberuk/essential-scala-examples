final case class Order(units: Int, unitPrice: Double) {
  val totalPrice: Double = units * unitPrice
}

object Order {
  implicit val ordering = Ordering.fromLessThan[Order] { (x, y) =>
    x.totalPrice < y.totalPrice
  }
}

object NumberOfUnitsOrdering {
  implicit val ordering = Ordering.fromLessThan[Order] { (x, y) =>
    x.units < y.units
  }
}

object UnitPriceOrdering {
  implicit val ordering = Ordering.fromLessThan[Order] { (x, y) =>
    x.unitPrice <  y.unitPrice
  }
}