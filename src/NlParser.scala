import scala.util.parsing.combinator.RegexParsers

class NlParser extends RegexParsers {

    /**
     * Entry point for the parser.
     */
    def parse(text: String): List[Node] = {
        this.parseAll(rText, text) match {
            case ns: NoSuccess => Nil
            case Success(list, _) =>
                list
        }
    }

    /** 
     * Start of rules
     * 
     * All of the following are parser objects of the form:
     *     p: Parser[T]
     *
     * In their names, read r as 'rule for'.
     */

    def rText: Parser[List[Node]] =
        rep( rWord ) ^^ {
            case nodesList => nodesList
        }

    def rWord: Parser[Node] =
        ( "\\s*".r ~> pos("ab".r) ) ^^ {
            case (s, p, o) => WordN(s, p, o)
        } | 
        ( "\\s+".r ) ^^ { case _ => EmptyNode() }

    /**
     * End of rules (parsers definitions) 
     */

    private def pos(p: Parser[String]): Parser[(String, Pos, Int)] =
      new Parser[(String, Pos, Int)] {
        def apply(in: Input): ParseResult[(String, Pos, Int)] = {
          val source = in.source
          val offset = in.offset
          val start = handleWhiteSpace(source, offset)
          p(in) match {
            case Success(str, otherIn) =>
              val p = in.drop(start - offset).pos
              Success((str, Pos(p.line, p.column), offset), otherIn)
            case nosucc: NoSuccess =>
              nosucc
          }
        }
      }
}
