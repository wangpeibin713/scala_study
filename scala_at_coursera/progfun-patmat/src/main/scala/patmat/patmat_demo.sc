package patmat

object patmat_demo {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  Huffman.decodedSecret                           //> res0: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
  
  val left = Huffman.makeCodeTree(Huffman.Leaf('a',1), Huffman.Leaf('b',2))
                                                  //> left  : patmat.Huffman.Fork = Fork(Leaf(a,1),Leaf(b,2),List(a, b),3)
  val right = Huffman.Leaf('c',3)                 //> right  : patmat.Huffman.Leaf = Leaf(c,3)
  val root = Huffman.makeCodeTree(left, right )   //> root  : patmat.Huffman.Fork = Fork(Fork(Leaf(a,1),Leaf(b,2),List(a, b),3),Le
                                                  //| af(c,3),List(a, b, c),6)
  Huffman.convert(root)                           //> res1: patmat.Huffman.CodeTable = List((a,List(0, 0)), (b,List(0, 1)), (c,Lis
                                                  //| t(1)))
  Huffman.convert(left)                           //> res2: patmat.Huffman.CodeTable = List((a,List(0)), (b,List(1)))
  Huffman.convert(right)                          //> res3: patmat.Huffman.CodeTable = List((c,List()))
  
}