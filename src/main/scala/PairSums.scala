import scala.collection.mutable.ListBuffer

object PairSums extends App {

  def pairs(nums: Set[Int], target: Int): List[Set[Int]] = {
    val result = ListBuffer[Set[Int]]()

    for (i <- nums) {
      val complement = target - i
      if (nums.contains(complement) && complement != i) {
        result += Set(i, complement)
      }
    }

    result.toList
  }

  val nums = Set(1, 2, 3, 4, 5)
  val target = 8
  val combinations = pairs(nums, target)
  println(combinations)
}
