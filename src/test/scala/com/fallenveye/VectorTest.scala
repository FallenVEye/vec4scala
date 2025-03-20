package com.fallenveye

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.contain
import org.scalatest.matchers.should.Matchers

class VectorTest extends AnyFlatSpec with Matchers {
    val vec1 = Vector(List(1, 2, 3, 4))
    val vec2 = Vector(List(2, 4, 6, 8))
    "Vector named operations" should "be valid" in {

        vec1.multiply(2) should (
            have size 4
            and contain allElementsOf List(2, 4, 6, 8)
        )

        vec1.multiply(vec2) should (
            have size 4
            and contain allElementsOf List(2, 8, 18, 32)
        )

        vec2.divide(2) should (
            have size 4
            and contain allElementsOf List(1, 2, 3, 4)
        )

        vec1.plus(vec2) should (
            have size 4
            and contain allElementsOf List(3, 6, 9, 12)
        )

        vec1.dot(vec2) should equal (60)

        vec1.magnitude should equal (5.477225575051661)

        vec1.normalized should (
            have size 4
            and contain allElementsOf
                List(
                    0.18257418583505536,
                    0.3651483716701107,
                    0.5477225575051661,
                    0.7302967433402214
                )
        )

    }

    "Vector override operators" should "be valid" in {
        vec1 * 2 should (
            have size 4
            and contain allElementsOf List(2, 4, 6, 8)
        )

        vec1 * vec2 should(
            have size 4
            and contain allElementsOf List(2, 8, 18, 32)
        )

        vec2 / 2 should (
            have size 4
            and contain allElementsOf List(1, 2, 3, 4)
        )

        vec1 + vec2 should (
            have size 4
            and contain allElementsOf List(3, 6, 9, 12)
        )

        vec1.dot(vec2) should equal(60)
    }
}