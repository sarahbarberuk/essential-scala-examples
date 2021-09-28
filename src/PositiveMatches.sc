object Positive {
  def unapply(in: Int): Option[Int] =
    if(in > 0)
      Some(in)
    else
      None
}

assert(
  "No" ==
    (0 match {
      case Positive(_) => "Yes"
      case _ => "No"
    })
)


assert(
  "Yes" ==
    (42 match {
      case Positive(_) => "Yes"
      case _ => "No"
    }) )