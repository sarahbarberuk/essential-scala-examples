class Director(
                val firstName: String,
                val lastName: String,
                val yearOfBirth: Int) {
  def name: String =
    s"$firstName $lastName"
  def copy(
            firstName: String = this.firstName,
            lastName: String = this.lastName,
            yearOfBirth: Int = this.yearOfBirth): Director =
              new Director(firstName, lastName, yearOfBirth)
}

object Director {
  def apply(
             firstName: String,
             lastName: String,
             yearOfBirth: Int): Director =
    new Director(firstName, lastName, yearOfBirth)

  def older(d1: Director, d2: Director): Director =
    if (d1.yearOfBirth < d2.yearOfBirth) d1 else {
      d2
    }
}

  class Film(
              val name: String,
              val yearOfRelease: Int,
              val imdbRating: Double,
              val director: Director) {
    def directorsAge =
      director.yearOfBirth - yearOfRelease

    def isDirectedBy(director: Director) = this.director == director

    def copy(
              name: String = this.name,
              yearOfRelease: Int = this.yearOfRelease,
              imdbRating: Double = this.imdbRating,
              director: Director = this.director): Film =
      new Film(name, yearOfRelease, imdbRating, director)
  }


  object Film {
    def apply(name: String,
              yearOfRelease: Int,
              imdbRating: Double,
              director: Director
             ): Film = new Film(name, yearOfRelease, imdbRating, director)

    def newer(film1: Film, film2: Film): Film =
      if (film1.yearOfRelease < film2.yearOfRelease) film1 else film2

    def highestRating(f1: Film, f2: Film): Double = {
      val rating1 = f1.imdbRating
      val rating2 = f2.imdbRating
      if (rating1 > rating2) rating1 else rating2
    }

    def oldestDirectorAtTheTime(f1: Film, f2: Film): Director =
      if (f1.director.yearOfBirth > f2.director.yearOfBirth) f1.director else f2.director
  }


  val eastwood = new Director("Clint", "Eastwood", 1930)
  val mcTiernan = new Director("John", "McTiernan", 1951)
  val nolan = new Director("Christopher", "Nolan", 1970)
  val someBody = new Director("Just", "Some Body", 1990)
  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)
  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
  val invictus = new Film("Invictus", 2009, 7.4, eastwood)
  val predator = new Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)







