package leetcode.p0061

private class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
  def rotateRight(head: ListNode, k: Int): ListNode = {
    if (head == null) return head

    @scala.annotation.tailrec
    def recToLast(head: ListNode, n: Int): (ListNode, Int) = {
      if (head.next == null) (head, n)
      else recToLast(head.next, n + 1)
    }

    val (last, n) = recToLast(head, 1)
    last.next = head
    val step = n - (k % n)

    val newHead = (1 to step).foldLeft(head) { (node, _) => node.next }

    (1 to step).foldLeft(last) { (node, _) => node.next }.next = null

    newHead
  }
}
