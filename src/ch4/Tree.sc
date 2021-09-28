sealed trait Tree {
  def sum: Int
  def double: Tree
}
final case class Node(l: Tree, r: Tree) extends Tree {
  def sum: Int = l.sum + r.sum
  def double: Tree = Node(l.double, r.double)
}
final case class Leaf(el: Int) extends Tree {
  def sum: Int = el
  def double: Tree = Leaf(el*2)
}

object TreeOps {
  def sum(tree: Tree): Int = {
    tree match {
      case Node(l, r) => sum(l) + sum(r)
      case Leaf(el) => el
    }

  }

  def double(tree: Tree): Tree =
    tree match {
      case Leaf(elt) => Leaf(elt * 2)
      case Node(l, r) => Node(double(l), double(r))
    }

  val example = Node(Leaf(2),Leaf(3))
  val result = sum(example)

}

