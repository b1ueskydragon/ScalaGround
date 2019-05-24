package quiz

// x ^ y は x と y のビット毎のXOR (exclusive or; 排他的論理和; x⊕y)を返す．
// 0からnまでのXOR，すなわち 0 ^ 1 ^ 2 ^ ... ^ n はいくつになるか．
object Pra04_05_03 {
  def main(args: Array[String]): Unit = {
    println(generateXOR((0 to 5).toList))
    println(generateXOR((0 to 15).toList))
    println(generateXOR((0 to 31).toList))
    println(generateXOR_((0 to 31).toList))
  }

  // XORは結合的 (x ⊕ (y ⊕ z)) = ((x ⊕ y) ⊕ z)) なので同じ.
  def generateXOR(nums: List[Int]): Int = nums.reduceLeft(_ ^ _)

  def generateXOR_(nums: List[Int]): Int = nums.reduceRight(_ ^ _)

  // 0 から 2n - 1 までの XOR は，すべての桁で1が偶数回現れるから，結果は0になる
  // TODO ↑ 本当に?? 0 to 5 は 1 になる.
}
