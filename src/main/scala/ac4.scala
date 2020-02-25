
object ac4 extends App {

  val res = List.range(147981, 691423).map(_.toString)
    .filter(x => x.toSeq.sorted.unwrap == x)
    .filter(x => x.toSeq.groupBy(_.toString).values.exists(_.size == 2))
    .size
  println(res)


}
