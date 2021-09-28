//sealed trait TrafficLight {
//  def next: TrafficLight
//}
//
//case object RedTrafficLight extends TrafficLight {
//  def next: TrafficLight = GreenTrafficLight
//}
//
//case object YellowTrafficLight extends TrafficLight {
//  def next: TrafficLight = RedTrafficLight
//}
//
//case object GreenTrafficLight extends TrafficLight {
//  def next: TrafficLight = YellowTrafficLight
//}
//
//val next2 = RedTrafficLight.next

sealed trait TrafficLight {
  def next: TrafficLight =
    this match {
      case RedTrafficLight => GreenTrafficLight
      case YellowTrafficLight => RedTrafficLight
      case GreenTrafficLight => YellowTrafficLight
    }
}

case object RedTrafficLight extends TrafficLight

case object YellowTrafficLight extends TrafficLight

case object GreenTrafficLight extends TrafficLight

val next2 = RedTrafficLight.next