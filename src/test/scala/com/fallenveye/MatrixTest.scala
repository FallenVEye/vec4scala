package com.fallenveye

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MatrixTest extends AnyFlatSpec with Matchers {


    val mat1 = Matrix.fromSequence(List(
        List(1, 2, 3),
        List(4, 5, 6),
        List(7, 8, 9)
    ))

    val mat2 = Matrix.fromSequence(List(
        List(2, 4, 6),
        List(8, 10, 12),
        List(14, 16, 18)
    ))

    val vec = Vector(List(1, 2, 3, 4))

    "Matrix named operations" should "be valid" in {

        mat1.multiply(2) should (
            have size 3
            and contain allElementsOf List(
                Vector.fromSeq(List(2, 4, 6)),
                Vector.fromSeq(List(8, 10, 12)),
                Vector.fromSeq(List(14, 16, 18))
            )
        )

        mat1.multiply(vec) should (
            have size 3
            and contain allElementsOf List(14, 32, 50)
        )

        mat1.multiply(mat2) should (
            have size 3
            and contain allElementsOf List(
                Vector.fromSeq(List(60, 72, 84)),
                Vector.fromSeq(List(132, 162, 192)),
                Vector.fromSeq(List(204, 252, 300))
            )
        )

        mat1.transpose should(
            have size 3
            and contain allElementsOf List(
                Vector.fromSeq(List(1, 4, 7)),
                Vector.fromSeq(List(2, 5, 8)),
                Vector.fromSeq(List(3, 6, 9))
            )
        )
    }

    "Matrix override operators" should "be valid" in {
        mat1 * 2 should (
            have size 3
            and contain allElementsOf List(
                Vector.fromSeq(List(2, 4, 6)),
                Vector.fromSeq(List(8, 10, 12)),
                Vector.fromSeq(List(14, 16, 18))
            )
        )

        mat1 * vec should (
            have size 3
            and contain allElementsOf List(14, 32, 50)
        )

        mat1 * mat2 should (
            have size 3
            and contain allElementsOf List(
                Vector.fromSeq(List(60, 72, 84)),
                Vector.fromSeq(List(132, 162, 192)),
                Vector.fromSeq(List(204, 252, 300))
            )
        )

    }
}
