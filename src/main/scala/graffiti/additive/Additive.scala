package graffiti.additive

/**
  * Example of an implicit parameter
  *
  * @tparam A type
  */
trait Additive[A] {
  /**
    * A a => a -> a -> a
    */
  def plus(a: A, b: A): A

  /**
    * A value corresponds to `0`.
    */
  def zero: A
}
