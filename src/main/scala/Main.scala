import scala.io.StdIn.readLine

object Main extends App {
  println("Bienvenue sur le Pokédex !\n\nLes commandes possibles sont:\n\n- GET <pokemon-name>\n- GETALL <region?> <pokemon-type1?> <generation?> <legendary?>\n- WHEREIS <pokemon-name>\n- MATCH <pokemon-name>")
  
  val url = "https://pokeapi.co/api/v2/"

  print("Entrez votre commande (GET/GETALL/WHEREIS/MATCH):")
  val cmd = readLine()

  if (cmd == "GET") {
    try {
      print("Entrez le pokemon souhaité: ")
      val pokemon = readLine()
      val http = url+"pokemon/"+pokemon
      val result = scala.io.Source.fromURL(http).mkString
      println(result)
      println(http)
    } catch {
      case e: Exception => println("Pas d'informations sur ce Pokemon (existe-il vraiment ?)")
    }
  }
  else if (cmd == "WHEREIS") {
    try {
      print("Entrez le pokemon souhaité: ")
      val pokemon = readLine()
      val http = url+"pokemon/"+pokemon+"/encounters"
      val result = scala.io.Source.fromURL(http).mkString
      println(result)
      println(http)
    } catch {
        case e: Exception => println("Pas d'informations sur ce Pokemon (existe-il vraiment ?)")
    }
  }
  else {val urlnext = "error/"}
  
  // val i = cmd match {
  //   case "GET" => val urlnext = "pokemon/"
  //   // case "GETALL" =>
  //   case "WHEREIS" => val urlnext = "pokemon-habitat/"
  //   // case "MATCH" =>
  // }


}