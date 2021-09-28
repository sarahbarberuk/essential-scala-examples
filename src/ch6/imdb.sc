case class Film(
                 name: String,
                 yearOfRelease: Int,
                 imdbRating: Double)

case class Director(
                     firstName: String,
                     lastName: String,
                     yearOfBirth: Int,
                     films: Seq[Film])

val memento = new Film("Memento", 2000, 8.5)
val darkKnight   = new Film("Dark Knight", 2008, 9.0)
val inception   = new Film("Inception", 2010, 8.8)
val highPlainsDrifter   = new Film("High Plains Drifter", 1973, 7.7)
val outlawJoseyWales  = new Film("The Outlaw Josey Wales", 1976, 7.9)
val unforgiven  = new Film("Unforgiven", 1992, 8.3)
val granTorino  = new Film("Gran Torino", 2008, 8)
val invictus  = new Film("Invictus", 2009, 7.4)
val predator  = new Film("Predator", 1987, 7.9)
val dieHard  = new Film("Die Hard", 1988, 8.3)
val huntForRedOctober  = new Film("The Hunt for Red October", 1990, 7.6)
val thomasCrownAffair  = new Film("The Thomas Crown Affair", 1999, 6.8)
val eastwood = new Director("Clint", "Eastwood", 1930, Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))
val mcTiernan = new Director("John", "McTiernan", 1951, Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))
val nolan = new Director("Christopher", "Nolan", 1970,  Seq(memento, darkKnight, inception))
val someGuy = new Director("Just", "Some Guy", 1990, Seq())
val directors = Seq(eastwood, mcTiernan, nolan, someGuy)

def directorsWhoHaveDirectedMoreThanXFilms(numberOfFilms: Int): Seq[Director] = {
  directors.filter(_.films.length > numberOfFilms)
}

directorsWhoHaveDirectedMoreThanXFilms(4)


def findDirectorBornBeforeXYear(year: Int): Option[Director] = {
  directors.find(_.yearOfBirth < year)
}

findDirectorBornBeforeXYear(1935)

def directorsWhoHaveDirectedMoreThanXFilmsAndWereBornBeforeYYear(numberOfFilms: Int, year: Int): List[Director] = {
  directors
    .filter(_.films.length > numberOfFilms)
    .filter(_.yearOfBirth < year)
    .toList
}

directorsWhoHaveDirectedMoreThanXFilmsAndWereBornBeforeYYear(4,1940)

def sortDirectorsByAge(ascending: Boolean = true): Seq[Director] = {
  if (ascending) {
    directors.sortWith((a,b) => a.yearOfBirth < b.yearOfBirth)

  } else {
    directors.sortWith((a,b) => a.yearOfBirth > b.yearOfBirth)

  }
}

sortDirectorsByAge(ascending = false)

//nolan.films.map(_.name)
//directors.flatMap(director => director.films.map(film => film.name))
//mcTiernan.films.map(film => film.yearOfRelease).min
//
//mcTiernan.films.foldLeft(Int.MaxValue) { (current, film) =>
//  math.min(current, film.yearOfRelease)
//}
//
//directors
//  .flatMap(director => director.films)
//  .sortWith((a,b) => a.imdbRating > b.imdbRating)
//
//val  films = directors.flatMap(director => director.films)
//films.foldLeft(0.0)((sum, film) => sum + film.imdbRating) / films.length

//directors.foreach{director =>
//  director.films.foreach { film =>
//    println("Tonight only! ${film.name} by ${director.firstName} ${director.lastName}!")
//  }
//}

val allFilms = directors.flatMap(director => director.films)
allFilms.foldLeft(Int.MaxValue) { (current, film) =>
  math.min(current, film.yearOfRelease)
}