import akka.{Done, NotUsed}
import akka.actor.ActorSystem
import akka.stream.scaladsl.{Sink, Source}

import scala.concurrent.{ExecutionContextExecutor, Future}

/**
  * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
  */
object problem48 extends App {

  implicit val system: ActorSystem = ActorSystem("problem48")
  val source: Source[BigInt, NotUsed] = Source(BigInt(2) to BigInt(1000))

  val pentagonals =
    source.scan(BigInt(1))((acc, next) => acc + pow(next, next))

  val done: Future[Done] = pentagonals.runForeach(println)

  implicit val ec: ExecutionContextExecutor = system.dispatcher
  done.onComplete(_ => system.terminate())

  def pow(base: BigInt, exponent: BigInt) = {
    var baseVar = base
    var exponentVar = exponent

    var result = BigInt(1)
    while ({
      exponentVar.signum > 0
    }) {
      if (exponentVar.testBit(0)) result = result * baseVar
      baseVar = baseVar * baseVar
      exponentVar = exponentVar >> 1
    }
    result
  }

}
