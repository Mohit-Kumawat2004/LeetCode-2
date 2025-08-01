object Solution {
    def generate(numRows: Int): List[List[Int]] = {
        numRows match {
            case 1 => List(List(1))
            case 2 => List(List(1), List(1,1))
            case _ =>
                val list = generate(numRows - 1)
                list :+ (0 +: list.last :+ 0).sliding(2).map(_.sum).toList
        }
    }
}