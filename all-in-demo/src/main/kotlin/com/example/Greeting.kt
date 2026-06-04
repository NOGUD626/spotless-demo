package com.example

fun greet(name: String): String = "Hello, $name!"

class User(
    val name: String,
    val age: Int,
) {
    fun describe() = "$name ($age)"
}

fun main() {
    val u = User("Alice", 30)
    println(greet(u.name))
    println(u.describe())
}
