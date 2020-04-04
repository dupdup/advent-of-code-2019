import scala.io.Source

object ac8 extends App {

  private val lines = Source.fromFile("input/in8").getLines.next().split("").toList.grouped(150).toList
  val min = lines.minBy(_ count ("0".equals))
  println(min.count("2".equals) * min.count("1".equals))

  val g = for{
    i<- 0 to 149
    r <- lines.map(_(i)).dropWhile(_.equals("2")).head
  } yield r
  g.grouped(25).map(_.mkString("")) foreach println


}

