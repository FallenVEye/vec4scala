package com.fallenveye

import scala.collection.immutable.AbstractSeq
import scala.util.Random


class Vector(list: List[Double]) extends AbstractSeq[Double]{
    private def getList: List[Double] = list

    def *(value: Double): Vector = multiply(value)
    def multiply(value: Double): Vector = Vector(list.map(elem => elem * value))
    
    def *(vec: Vector): Vector = multiply(vec)
    def multiply(vec: Vector): Vector = Vector(list.zip(vec).map((e1, e2) => e1 * e2))

    def /(value: Double): Vector = divide(value)
    def divide(value: Double): Vector = Vector(list.map(elem => elem / value))

    def +(vec: Vector): Vector = plus(vec)
    def plus(vec: Vector): Vector = Vector(list.zip(vec.getList).map((e1, e2) => e1 + e2))

    def dot(vec: Vector): Double = list.zip(vec.getList).map((e1, e2) => e1 * e2).sum

    def magnitude: Double = Math.sqrt(list.map(e => e * e).sum)
    def normalized: Vector = divide(magnitude)


    override def apply(i: Int): Double = list.apply(i)

    override def length: Int = list.length

    override def iterator: Iterator[Double] = list.iterator
}

object Vector {

    val random = Random()


    def createRandomVector(size: Int): Vector =
        Vector(
            (1 to size)
                .map(_ => random.nextDouble())
                .toList
        )


    def createRandomVector(size: Int, minValue: Double, maxValue: Double): Vector =
        Vector(
            (1 to size)
                .map(_ => random.between(minValue, maxValue))
                .toList
        )

    def fromSeq(seq: Seq[Double]): Vector = Vector(seq.toList)

}
