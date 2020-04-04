
import scala.io.Source

object ac2 extends App {
  val filename = "input/in2_1"
  val ds = Source.fromFile(filename).getLines.next().split(",").map(_.toInt).toList
  val range = Range(0, 100)

  range.map(x => range.find(f(ds, x, _) == 19690720).headOption.map(println(_, x)))

  def f(ts: List[Int], x: Int, y: Int) = {
    var xs = ts.updated(1, x).updated(2, y)
    xs.grouped(4).foreach(_ match {
      case List(1, a, b, p) => xs = xs.updated(p, xs(a) + xs(b))
      case List(2, a, b, p) => xs = xs.updated(p, xs(a) * xs(b))
      case _ => xs(0)
    })
    xs(0)
  }


}


