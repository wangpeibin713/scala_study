package forcomp
import Anagrams._
object forcomp {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  ( "abcd" map (x => x.toLower) groupBy((element: Char) => element) toList )  map (x=>(x._1, x._2.length)) sortBy(x=>x._1)
                                                  //> res0: List[(Char, Int)] = List((a,1), (b,1), (c,1), (d,1))
  
  "abcd".groupBy(symbol => symbol).map({case (symbol, list) => (symbol, list.length)}).toList
                                                  //> res1: List[(Char, Int)] = List((b,1), (d,1), (a,1), (c,1))
  
  var w : Word = "helloWorld"                     //> w  : forcomp.Anagrams.Word = helloWorld
  w                                               //> res2: forcomp.Anagrams.Word = helloWorld
  var m  = ( w map (x => x.toLower) groupBy((element: Char) => element) toList )  map (x=>(x._1, x._2.length))
                                                  //> m  : List[(Char, Int)] = List((e,1), (l,3), (h,1), (r,1), (w,1), (o,2), (d,1
                                                  //| ))
  wordOccurrences(w)                              //> res3: forcomp.Anagrams.Occurrences = List((d,1), (e,1), (h,1), (l,3), (o,2),
                                                  //|  (r,1), (w,1))
                                
val fruit = List("apple", "organge", "pear")      //> fruit  : List[String] = List(apple, organge, pear)
	fruit.map(_.toCharArray).flatten          //> res4: List[Char] = List(a, p, p, l, e, o, r, g, a, n, g, e, p, e, a, r)
 var s : Sentence = List("helloo", "World", "hi", "ih")
                                                  //> s  : forcomp.Anagrams.Sentence = List(helloo, World, hi, ih)
	((s flatMap (x => x map (y => y.toLower))) groupBy((element: Char) => element) toList ) map (x=>(x._1, x._2.length))
                                                  //> res5: List[(Char, Int)] = List((e,1), (i,2), (l,3), (h,3), (r,1), (w,1), (o,
                                                  //| 3), (d,1))
	sentenceOccurrences(s)                    //> res6: forcomp.Anagrams.Occurrences = List((d,1), (e,1), (h,3), (i,2), (l,3),
                                                  //|  (o,3), (r,1), (w,1))
	sentenceOccurrences(s) toMap              //> res7: scala.collection.immutable.Map[Char,Int] = Map(e -> 1, i -> 2, l -> 3,
                                                  //|  h -> 3, r -> 1, w -> 1, o -> 3, d -> 1)
/*
  var freq :Occurrences = List(('e',1), ('t',1), ('a',2))
  def getWords(freq : Occurrences) : List[Word]= {
  		freq match {
  			case List() => List("")
  			case head::tail => {
		  		if(1 == head._2) {
		  			getWords(tail) map (x =>x+ head._1)
		  		}
		  		else {
		  			getWords((head._1, head._2-1)::tail) map (x =>x+ head._1)
		  			}
  			}
  		}
  		
  }
  getWords(freq)
  */
   //s map (x=>wordOccurrences(x)) groupBy(element  => element)
 // var dict = s groupBy(x  => wordOccurrences(x))
                                                  
 // dict(wordOccurrences("hi"))
 ( 1 to 10) map (x => (11,x)) toList              //> res8: List[(Int, Int)] = List((11,1), (11,2), (11,3), (11,4), (11,5), (11,6
                                                  //| ), (11,7), (11,8), (11,9), (11,10))
  
  combinations(List(('a', 2)))                    //> res9: List[forcomp.Anagrams.Occurrences] = List(List((a,1)), List((a,2)), L
                                                  //| ist())
  combinations(List(('a', 2),('b', 1)))           //> res10: List[forcomp.Anagrams.Occurrences] = List(List((a,1), (b,1)), List((
                                                  //| a,1)), List((a,2), (b,1)), List((a,2)), List((b,1)), List())
  var cccc = combinations(List(('a', 2), ('b', 2)))
                                                  //> cccc  : List[forcomp.Anagrams.Occurrences] = List(List((a,1), (b,1)), List(
                                                  //| (a,1), (b,2)), List((a,1)), List((a,2), (b,1)), List((a,2), (b,2)), List((a
                                                  //| ,2)), List((b,1)), List((b,2)), List())
  cccc.length                                     //> res11: Int = 9
  
  
  def subtract(x: Occurrences, y: Occurrences): Occurrences = {
    val yMap = y toMap
    var NilOcc : Occurrences =List()
  	def sub(xs: Occurrences, item: (Char, Int)) : Occurrences = {
  		if (yMap.contains(item._1)) xs ::: List((item._1, item._2 - yMap.apply(item._1)))
  		else  xs ::: List(item)
  	}
  	
  	x.foldLeft(NilOcc)(sub(_,_)) .filter(x=> x._2 > 0)
  }                                               //> subtract: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrences
                                                  //| )forcomp.Anagrams.Occurrences
   val lard = List(('a', 1), ('d', 23), ('l', 1), ('r', 1))
                                                  //> lard  : List[(Char, Int)] = List((a,1), (d,23), (l,1), (r,1))
   val r = List(('r', 1),('d',20))                //> r  : List[(Char, Int)] = List((r,1), (d,20))
   val lad = List(('a', 1), ('d', 1), ('l', 1))   //> lad  : List[(Char, Int)] = List((a,1), (d,1), (l,1))
   subtract(lard,r)                               //> res12: forcomp.Anagrams.Occurrences = List((a,1), (d,3), (l,1))
	 val sentence = List("Lin")               //> sentence  : List[String] = List(Lin)
	 sentenceAnagrams(sentence)               //> java.lang.StackOverflowError
                                                  //| 	at scala.collection.AbstractIterable.<init>(Iterable.scala:54)
                                                  //| 	at scala.collection.AbstractSeq.<init>(Seq.scala:40)
                                                  //| 	at scala.collection.mutable.AbstractSeq.<init>(Seq.scala:47)
                                                  //| 	at scala.collection.mutable.AbstractBuffer.<init>(Buffer.scala:48)
                                                  //| 	at scala.collection.mutable.ListBuffer.<init>(ListBuffer.scala:46)
                                                  //| 	at scala.collection.immutable.List$.newBuilder(List.scala:396)
                                                  //| 	at scala.collection.generic.GenTraversableFactory$ReusableCBF.apply(GenT
                                                  //| raversableFactory.scala:44)
                                                  //| 	at scala.collection.TraversableLike$class.to(TraversableLike.scala:627)
                                                  //| 
                                                  //| 	at scala.collection.AbstractTraversable.to(Traversable.scala:105)
                                                  //| 	at scala.collection.TraversableOnce$class.toList(TraversableOnce.scala:2
                                                  //| 57)
                                                  //| 	at scala.collection.AbstractTraversable.toList(Traversable.scala:105)
                                                  //| 	at scala.collection.immutable.List$.apply(List.scala:400)
                                                  //| 	at forcomp.Anagrams$.combinations(Anagram
                                                  //| Output exceeds cutoff limit.
	 wordAnagrams("Lin")
	 
	 
}