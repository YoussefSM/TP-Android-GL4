package com.gl4.tp

fun main(argv : Array<String> ){
    print("Hello")

    //var message: String? = "My message can possibly be null !"
    //message.upperCase()

    var hello = "Hello"
    hello = "Hello world!"

    println(hello)

    var toto:String = "Toto"

    println(toto)

    var message: String? = "I’m learning Kotlin!"
    message = null
    println(message.toString())

    println(add(4,5))


}

fun add(a: Int, b:Int) : Int {
    return a+b
}
