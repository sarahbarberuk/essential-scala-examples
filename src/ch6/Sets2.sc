val people = Set(
  "Alice",
  "Bob",
  "Charlie",
  "Derek",
  "Edith",
  "Fred")

val buildings = Set(
  "House A",
  "HouseB",
  "Empire State",
  "Town hall",
  "Eiffel Tower",
  "Buckingham Palace")

//def union[String] (setA: Set[String], setB: Set[String]): String = {
//  setA.foldLeft("")((a,b) => a+b + "")
//}

val ppl = people.foldLeft("")((a,b) => a+b + "")


def union[A](set1: Set[A], set2: Set[A]): Set[A] = {
  set1.foldLeft(set2){ (set, elt) => (set + elt) }
}
union(people,buildings)

