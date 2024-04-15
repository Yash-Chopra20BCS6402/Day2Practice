import scala.collection.mutable.ListBuffer

object Solution extends App {
  var ans: ListBuffer[List[Int]] = ListBuffer()

  def solve(i: Int, arr: List[Int], temp: ListBuffer[Int], target: Int): Unit = {
    if (target == 0) {
      ans += temp.toList
      return
    }
    if (target < 0 || i == arr.length) {
      return
    }

    solve(i + 1, arr, temp, target)
    temp += arr(i)
    solve(i, arr, temp, target - arr(i))
    temp.trimEnd(1)
  }

  def combinationSum(arr: List[Int], target: Int): List[List[Int]] = {
    ans.clear()
    solve(0, arr, ListBuffer(), target)
    ans.toList
    }
}