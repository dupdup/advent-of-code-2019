import scala.io.Source

object ac6 extends App {

  case class Orbit(from: String, to: String)

  private val lines = Source.fromFile("in6_1").getLines
  val xs = lines.map(_.split("\\)") match { case Array(a: String, b: String) => Orbit(a, b) }).toList

  val adam = xs.filterNot(x => xs.map(_.to).contains(x.from))
  val sorted = sort(xs, Nil, List(adam.head.from))
  def sort(unsorted: List[Orbit], result: List[Orbit], adjacents: List[String]): List[Orbit] = {
    if (adjacents.isEmpty) result
    else {
      val ns = unsorted.filter(_.from == adjacents.head)
      sort(unsorted diff ns, result ++ ns, adjacents.tail ++ ns.map(_.to))
    }
  }

  val objTOrbits = sorted.foldLeft(Map.empty[String, List[String]])((map, cs) => {
    val addMe = map.get(cs.from) match {
      case Some(x) => Map(cs.to -> (cs.from :: x))
      case None => Map(cs.from -> Nil, cs.to -> List(cs.from))
    }
    map ++ addMe
  })

  println(objTOrbits.values.flatten.size)
  println(objTOrbits.get("YOU").get.diff(objTOrbits.get("SAN").get).size)
  println(objTOrbits.get("SAN").get.diff(objTOrbits.get("YOU").get).size)
}

