import scala.io.Source


object ac1 extends App {

  val filename = "input/in1_1"
  val xs = for (
    line <- Source.fromFile(filename).getLines
  ) yield line.toInt

  print(xs.flatMap(LazyList.iterate(_)(x => Math.floor(x / 3).toInt - 2).takeWhile(_ > 0).tail).sum)


}

