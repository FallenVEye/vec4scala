# Vec4Scala

### A simple library for working with math vectors of variable sizes

### Features
```scala 3

val vec1 = Vector.createRandomVector(size=10)
val vec2 = Vector.createRandomVector(size=10, minValue)
val vec3 = Vector.fromSeq(List(1, 2, 3, 4))
val vec4 = Vector.fromSeq(List(2, 4, 6, 8))


// Vector multiplication by Double
// Multiplies every element by that Double
var muliplyByDouble = vec1.multiply(3)
muliplyByDouble = vec1 * 3

// Vector multiplication by other vector
// Straight multiplication element by element
var muliplyByVector = vec3.multiply(vec4)   // (2, 8, 18, 32)
var muliplyByVector = vec3 * vec4           // (2, 8, 18, 32)

// Vector division by Double
// Divides every element of by that Double
var divideByDouble = vec.divide(3)
divideByDouble = vec / 3

// Summing i element of vec1 to i elemnt of vec2  
var plus = vec1.plus(vec2)
plus = vec1 + vec2

// Dot product
// Calculates 
var dot = vec3.dot(vec4) // 30

// Magnitude
// Length of the vector
var magnitude = vec1.magnitude

// Normalised vector
var normalised = vec1.normalise
```