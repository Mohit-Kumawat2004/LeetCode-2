
import scala.collection.mutable


object Solution {
    def maxEvents(evs: Array[Array[Int]]): Int = {
    val events = evs.sortWith((a: Array[Int],b:Array[Int]) => sortEv(a,b))
    val q = new mutable.PriorityQueue[Pair]()
    var lastUsed = 0
    var count = 0
    var cur = 0
    while (q.nonEmpty || cur < events.length) {
      if (q.isEmpty) lastUsed = events(cur)(0)
      while (cur < events.length && events(cur)(0) <= lastUsed) {
        q.addOne(Pair(events(cur)(0), events(cur)(1)))
        cur += 1
      }
      q.dequeue()
      count += 1
      lastUsed += 1
      while (q.nonEmpty && q.head.end < lastUsed) q.dequeue()
    }
    count
  }

    def sortEv(a: Array[Int], b: Array[Int]): Boolean = {
      if (a(0) == b(0)) return a(1) < b(1)
      a(0) < b(0)
    }
}

case class Pair(val start: Int, val end: Int) extends Comparable[Pair]{

  override def compareTo(o: Pair): Int = if (end == o.end) o.start - start else o.end - end
}