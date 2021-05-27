package leetcode.p0876

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
  def middleNode(head: ListNode): ListNode = {
    @scala.annotation.tailrec
    def middleNode(slow: ListNode, fast: ListNode): ListNode = {
      if (fast == null) slow
      else if (fast.next == null) slow
      else middleNode(slow.next, fast.next.next)
    }

    middleNode(head, head)
  }
}
