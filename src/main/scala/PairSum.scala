import scala.collection.mutable.ListBuffer

object PairSum extends App {

  def pairs(nums: Set[Int], target: Int): List[Set[Int]] = {
    val result = ListBuffer[Set[Int]]()

    def helper(start: Int, remaining: Int, path: Set[Int]): Unit = {
      if (remaining == 0) {
        result += path
        return
      }
      if (remaining < 0 || start >= nums.size) {
        return
      }
      val num = nums.toList(start)
      if (num <= remaining && !path.contains(num)) {
        helper(start + 1, remaining, path)
        helper(start + 1, remaining - num, path + num)
      } else {
        helper(start + 1, remaining, path)
      }
    }

    helper(0, target, Set())
    result.toList
  }

  val nums = Set(1, 2, 3, 4, 5)
  val target = 8
  val combinations = pairs(nums, target).filter(_.sum == target)
  println(combinations)
}
