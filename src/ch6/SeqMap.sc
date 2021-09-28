val test = "dog".permutations.toList

Seq("a", "wet", "dog").flatMap(_.permutations.toList)

Seq(1, 2, 3).flatMap(num => Seq(num, num * 10))

Seq(1, 2, 3).map(num => Seq(num, num * 10))

Vector(1, 2, 3).flatMap(num => Seq(num, num * 10))

Seq(1, 2, 3).foldLeft(1)(_ + _)

Seq(1, 2, 3).foldRight(0)(_ + _)

List(1, 2, 3).foreach(num => println("And a " + num + "..."))