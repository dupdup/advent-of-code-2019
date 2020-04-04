import scala.io.Source

object ac5 extends App {

  val filename = "input/in5_1"
  val xs = Source.fromFile(filename).getLines.next().split(",").map(_.toInt).toList


  def ins(x:Int) = (List(0,0,0,0) ++ x.toString().split("").map(_.toInt)).takeRight(5)
  val mo = Map(1->((a:Int,b:Int)=>a+b),2->((a:Int,b:Int)=>a*b))
  val mp = Map(0->((a:Int)=>ds(a)),1->((a:Int)=>a))
  //val m

  var ds = xs.updated(225,1)
  var p = 2
/*
  while(p<ds.length){
    val t = ins(ds(p))
    println(t)
    val ps = ds.slice(p+1,p+4)
    println("ps",ps)
    if(t.last == 4 ) {
      println("ppppppp" + mp(t(2))(ps(0)))
      p = p + 2
      if(ps(1) == 99)
        println("hi")
    }
    else {
      ds = ds.updated(ps(2),
        mo(t.last)(
          mp(t(2))(ps(0)),
          mp(t(1))(ps(1)))
      )
      p = p + 4
    }
  }*/


}
