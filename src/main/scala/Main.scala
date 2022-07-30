import scala.io.StdIn.readLine
import spray.json._
import DefaultJsonProtocol._ // if you don't supply your own Protocol (see below)1

object Main extends App {
  var jsonresponse = ""
  println("Bienvenue sur le Pokédex !\n\nLes commandes possibles sont:\n\n- GET <pokemon-name>\n- GETALL <region?> <pokemon-type1?> <generation?> <legendary?>\n- WHEREIS <pokemon-name>\n- MATCH <pokemon-name>")
  
  val url = "https://pokeapi.co/api/v2/"

  print("Entrez votre commande (GET/GETALL/WHEREIS/MATCH):")
  val cmd = readLine()

  //Nous voulions faire un switch case mais nous n'avons pas réussi...
  if (cmd == "GET") {
    try {
      print("Entrez le pokemon souhaité: ")
      val pokemon = readLine()
      val http = url+"pokemon/"+pokemon
      val result = scala.io.Source.fromURL(http).mkString
      jsonresponse = result
      println(jsonresponse)
      println(http)
    } catch {
      case e: Exception => println("Pas d'informations sur ce Pokemon (existe-il vraiment ?)")
    }
  }
  else if (cmd == "GETALL") {
    try {
      print("Vous souhaitez chercher par 'type', 'generation' ou si le pokemon est 'legendaire' ou non ?\n Entrez type/generation/legendaire: ")
      val search = readLine()
      if (search == "type"){
        try {
          print("Quel type de pokemon cherchez-vous ?")
          val typee = readLine()
          val http = url+"type/"+typee
          val result = scala.io.Source.fromURL(http).mkString
          println(result)
          println(http)
        } catch {
            case e: Exception => println("Pas d'informations sur ce type de Pokemon (existent-ils vraiment ?)")
        }
      }
      else if (search == "generation"){
        try {
          print("Quelle generation de pokemon vous interesse ?")
          val gen = readLine()
          val http = url+"generation/"+gen
          val result = scala.io.Source.fromURL(http).mkString
          println(result)
          println(http)
        } catch {
            case e: Exception => println("Pas d'informations sur cette generation de Pokemon (existent-ils vraiment ?)")
        }
      }
      else if (search == "legendaire"){
        try {
          print("Cherchez vous les pokemon legendaire ? (O/N)")
          val legendary = readLine()
          // val http = url+"generation/"+legendary
          // val result = scala.io.Source.fromURL(http).mkString
          // println(result)
          // println(http)
          print("Commande indisponible pour le moment...")
        } catch {
            case e: Exception => println("Pas d'informations sur ces Pokemons (existent-ils vraiment ? o_O)")
        }
      }
    } catch {
        case e: Exception => println("Pas d'informations ou erreur de saisie")
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
  else if (cmd == "MATCH") {
    try {
      print("Commande indisponible pour le moment...")
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