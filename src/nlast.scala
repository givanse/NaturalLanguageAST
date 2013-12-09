
object nlast {

    def main(args: Array[String]) {
        val sentence1 = "ab abab"
        println(sentence1)
        val p = new NlParser
        val nodesList1 = p.parse(sentence1)
        nodesList1.foreach(println)

        val sentence2 = "ab ab abab, abba aaa bbb aaa bbbaaa."
        println(sentence2)
        val nodesList2 = p.parse(sentence2)
        nodesList2.foreach(println)
    }
}
