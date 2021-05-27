package leetcode.p0876.recursive

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
  def middleNode(head: ListNode): ListNode = {
    @scala.annotation.tailrec
    def rec(slow: ListNode, fast: ListNode): ListNode = {
      if (fast == null) slow
      else if (fast.next == null) slow
      else rec(slow.next, fast.next.next)
    }

    rec(head, head)
  }
}
