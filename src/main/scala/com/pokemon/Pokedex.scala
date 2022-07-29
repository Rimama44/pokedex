package com.pokemon

import okhttp3.{OkHttpClient, Request}

import scala.util.control.NonFatal

class PokedexGET(name: String, type1: String) {
  override def toString: String = s"""${name.capitalize}:
    |==============================
    |Type: $type1"""
}
object PokemonGET {
  def main(args: Array[String]): Unit = println("Hello pokédex")
}
object PokedexGETALL {

  def main(args: Array[String]): Unit = println("Hello pokédex")
}
object PokedexWHEREIS {

  def main(args: Array[String]): Unit = println("Hello pokédex")
}
object PokedexMATCH {

  def main(args: Array[String]): Unit = println("Hello pokédex")
}
