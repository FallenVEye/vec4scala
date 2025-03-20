package com.fallenveye

import scala.collection.immutable.AbstractSeq
import scala.util.Random

class Matrix(mat: List[Vector]) extends AbstractSeq[Vector]{

    private def getMat: List[Vector] = mat

    def get(i: Int, k: Int): Double = mat.apply(i).apply(k)

    def *(value: Double): Matrix = multiply(value)
    def multiply(value: Double): Matrix = Matrix(mat.map(elem => elem * value))

    def *(vec: Vector): Vector = multiply(vec)
    def multiply(vec: Vector): Vector = Vector(mat.map(v1 => (v1 * vec).sum))

    def *(mat: Matrix): Matrix = multiply(mat)
    def multiply(matrix: Matrix): Matrix = {
        val transposed = matrix.transpose
        Matrix(mat.map(m1 => {
            Vector.fromSeq(transposed.map(m2 => m2 dot m1))
        }))
    }

    def transpose: Matrix = Matrix.fromSequence(mat.transpose)

    override def toString(): String = mat.mkString("\n")

    override def apply(i: Int): Vector = mat.apply(i)
    override def length: Int = mat.length
    override def iterator: Iterator[Vector] = mat.iterator

}

object Matrix {

    val random = Random()

    def createRandomMatrix(size: Int): Matrix =
        Matrix((1 to random.nextInt())
            .map(_ => Vector.createRandomVector(random.nextInt()))
            .toList
        )

    def createRandomMatrix(size: Int, minValue: Double, maxValue: Double): Matrix =
        Matrix((1 to random.nextInt())
            .map(_ => Vector.createRandomVector(random.nextInt(), minValue, maxValue))
            .toList
        )

    def fromSequence(sequences: Seq[Seq[Double]]): Matrix =
        Matrix(sequences
            .map(seq => Vector.fromSeq(seq))
            .toList
        )

}
