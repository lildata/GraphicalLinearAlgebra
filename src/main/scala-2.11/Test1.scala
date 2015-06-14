import breeze.linalg._


object Test1 extends App {

  val m_generator_add =     DenseMatrix((1,1))
  val m_generator_zero =    DenseMatrix.zeros[Int](1,0)
  val m_generator_copy =    DenseMatrix((1),(1))
  val m_generator_discard = DenseMatrix.zeros[Int](0,1)

  val m_wiring_identity =   DenseMatrix((1))
  val m_wiring_twist =      DenseMatrix((0,1),(1,0))

  val a = ⊕(m_generator_add, m_generator_add)
  val b = ⊕(⊕(m_wiring_identity, m_wiring_twist), m_wiring_identity)
  val c = ⊕(m_generator_copy, m_generator_copy)

  println( a :* b /*:* c */ )

  //println( m_generator_copy :* m_generator_add)

  /**
   *
   * Quick implementation of Direct Sum ⊕
   *
   * @param a
   * @param b
   * @return Direct Sum of the two matrices
   */
  def ⊕(a:DenseMatrix[Int], b:DenseMatrix[Int]) = {
    DenseMatrix.horzcat(
      DenseMatrix.vertcat(a, DenseMatrix.zeros[Int](b.rows,a.cols)),
      DenseMatrix.vertcat(DenseMatrix.zeros[Int](a.rows,b.cols), b)
    )
  }





}
