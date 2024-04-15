import scala.collection.mutable.ListBuffer

object Solution extends App {
  def combinationSum(candidates: Set[Int], target: Int): List[Set[Int]] = {
    val ans = ListBuffer[Set[Int]]()

    def solve(arr: List[Int], i: Int, sum: Int, op: Set[Int]): Unit = {
      if (i >= arr.length) {
        return
      }

      if (arr(i) + sum == target) {
        ans += (op + arr(i))
        return
      }

      if (arr(i) + sum < target) {
        val op1 = op
        val op2 = op + arr(i)
        solve(arr, i, sum + arr(i), op2)
        solve(arr, i + 1, sum, op1)
      } else {
        solve(arr, i + 1, sum, op)
      }
    }

    solve(candidates.toList.sorted, 0, 0, Set.empty)
    ans.toList
    }
}