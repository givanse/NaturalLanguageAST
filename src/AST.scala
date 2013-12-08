
case class Pos(line: Int, column: Int)

abstract class Node

case class noun(        string: String, pos: Pos, offset: Int) extends Node
case class pronoun(     string: String, pos: Pos, offset: Int) extends Node
case class verb(        string: String, pos: Pos, offset: Int) extends Node
case class adverb(      string: String, pos: Pos, offset: Int) extends Node
case class adjective(   string: String, pos: Pos, offset: Int) extends Node
case class preposition( string: String, pos: Pos, offset: Int) extends Node
case class conjunction( string: String, pos: Pos, offset: Int) extends Node
// determiners or articles
case class interjection(string: String, pos: Pos, offset: Int) extends Node

