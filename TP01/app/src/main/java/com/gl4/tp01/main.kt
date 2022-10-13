package com.gl4.tp01

import kotlin.math.abs

data class Point(var x: Int, var y: Int)

fun distance(p:Point, q:Point) :Int {
    return abs(p.x-q.x) + abs (p.y-q.y)
}

class Rectangle (var p: Point= Point(0,0), var q: Point= Point(1,1)) {
    override fun toString(): String {
        return super.toString()+ "p=$p q=$q"
    }
    fun surface() : Int{
        var l1 = abs(this.p.x-this.q.x)
        var l2 = abs(this.p.y-this.q.y)
        return l1*l2
    }
}

fun main(argv : Array<String> ) {
    println("Hello")
    val p1 : Point
    val p2 : Point
    val R1 = Rectangle()
    val R2 = Rectangle(p=Point(2,2))
    val R3 = Rectangle(q=Point(3,3))
    val arrayOfRect = arrayOf(R1,R2,R3)
    for ( i in arrayOfRect.indices){
        println("la surface de R"+i+" = "+arrayOfRect[i].surface())
    }
}