
case class Pos(line: Int, column: Int)

abstract class Node

case class EmptyNode() extends Node

case class SentenceN (string: String, pos: Pos, offset: Int) extends Node
case class WordN     (string: String, pos: Pos, offset: Int) extends Node
