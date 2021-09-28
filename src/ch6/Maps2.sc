
val map1 = Map("a" -> 1, "b" -> 2)
val map2 = Map("a" -> 2, "b" -> 4)

val map3 = Map('a' -> 3, 'b' -> 6)

def union[A](map1: Map[A,Int], map2: Map[A,Int]): Map[A,Int] = {
  map1.foldLeft(map2){ (acc, curr) =>
  val (key, value1) = curr
    val value2 = acc.get(key)
    val total = value1+value2.getOrElse(0)
    acc + (key -> total)
  }
}


union(map1,  map2)


//def union2[A,B](map1: Map[A,B], map2: Map[A,B]): Map[A,B] = {
//  map1.foldLeft(map2){ (acc, curr) =>
//    val (key, value) = curr
//    val newValue = acc.get(key).map(v2 => add(value,v2)).getOrElse(value)
//    acc + (key -> newValue)
//  }
//}