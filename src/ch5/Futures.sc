import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

val a = Future { Thread.sleep(10*100); 42 }

val b = a.map(_ * 2)

val c: Future[Unit] = a.map { x =>
  Thread.sleep(10000)
  println("The program waited patiently for this callback to finish.")
}

Await.ready(c, Duration.Inf)

