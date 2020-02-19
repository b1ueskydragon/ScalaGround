package leetcode.p0802

object Solution {
  def eventualSafeNodes(graph: Array[Array[Int]]): List[Int] = {
    val terminalNodes = new scala.collection.mutable.TreeSet[Int] // umm ...

    def found(start: Int, visited: Set[Int]): Boolean = {
      if (terminalNodes.contains(start)) return true
      if (visited.contains(start)) return false
      if (graph(start).exists(step => !found(step, visited + start))) return false
      terminalNodes.add(start)
      true
    }

    graph.zipWithIndex.foreach(p => found(p._2, Set.empty[Int]))
    terminalNodes.toList
  }
}
