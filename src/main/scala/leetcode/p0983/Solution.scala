package leetcode.p0983

object Solution {
  // top-down.
  // f(i) = min(f(i + 1) + costs[0], f(i + 7) + costs[1], f(i + 30) + costs[2])
  def mincostTickets(days: Array[Int], costs: Array[Int]): Int = {
    val payments: Array[Option[Int]] = Array.fill(366)(None)
    val travelDays = days.toSet

    def f(day: Int): Int = {
      if (day > 365) 0
      else payments(day).getOrElse({
        val isTravelDay = travelDays.contains(day)
        // no travel day := same payment as previous travel day.
        val accDay = if (isTravelDay) f(day + 1) + costs(0) else f(day + 1)
        val accWeek = if (isTravelDay) f(day + 7) + costs(1) else Integer.MAX_VALUE
        val accMonth = if (isTravelDay) f(day + 30) + costs(2) else Integer.MAX_VALUE
        val min = Math.min(Math.min(accDay, accWeek), accMonth)
        payments(day) = Some(min)
        min
      })
    }

    // f(365) is day 0 and vice-versa, since this is a top-down retrieval.
    f(0) // same as f(days.head)
  }
}
