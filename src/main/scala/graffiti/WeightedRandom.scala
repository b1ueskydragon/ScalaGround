package graffiti

import scala.util.Random

class WeightedRandom {

  /** Weighted random number.
    *
    * value: String
    * weight: Int
    */
  def pick(candidates: List[(String, Int)]): String = {
    // total weight.
    val total = candidates.map(_._2).sum

    // random weight.
    // pick a value randomly from a range 1 to total.
    val random = Random.nextInt(total) + 1

    _pick(candidates, random)
  }

  /** Helper (Recursion) */
  def _pick(candidates: List[(String, Int)], random: Int): String = candidates match {
    case h :: _ if h._2 >= random => h._1
    case h :: tail => _pick(tail, random - h._2)
  }
}
