import scala.io.Source

object ac3 extends App {

  val filename = "in3_1"
  private val lines = Source.fromFile(filename).getLines
  val pattern = "([A-Z])([0-9]+)".r


  def f(p: (Int, Int), step: Int, dir: String): List[(Int, Int)] = {
    dir match {
      case "R" => List.range(p._1 + 1, p._1 + step + 1).map((_, p._2))
      case "L" => List.range(p._1 - 1, p._1 - step - 1, -1).map((_, p._2))
      case "D" => List.range(p._2 - 1, p._2 - step - 1, -1).map((p._1, _))
      case "U" => List.range(p._2 + 1, p._2 + step + 1).map((p._1, _))
    }
  }

  val wires1 = lines.next().split(",").toList.foldLeft(List((0,0)))((a, b)=>{
    val pattern(dir, step) = b
    a ++ f(a.last,step.toInt,dir)
  })

  val wires2 = lines.next().split(",").toList.foldLeft(List((0,0)))((a, b)=>{
    val pattern(dir, step) = b
    a ++ f(a.last,step.toInt,dir)
  })


  println(wires1.intersect(wires2).tail.minBy(x=>Math.abs(x._1)+Math.abs(x._2)))

  val t = wires1.intersect(wires2).tail.minBy(x => wires1.indexOf(x) + wires2.indexOf(x))

  println(wires1.indexOf(t)+wires2.indexOf(t))



}
