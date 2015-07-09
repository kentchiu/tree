# tree
java tree model with traversal function 


## How to Use

1. Implement Node<T> interface.  
2. `Tree.buildFromList(all, T.class)` will help to build a full tree
3. If you want to traverse a tree, using visitor
4. If you want to build a path from tree, using `Path` class.    

Checking test code for more details.


```java
// implement Node<T> interface.
public class Composite implements Node<Composite> {
//  ...
}

// fetch all node as list from storage
List<Composite> all = ...

// build tree(s) from list 
List<Composite> nodes = Tree.buildFromList(all);

// build paths from tree 
List<Path<Composite>> paths = Path.buildFormTreeRoot(nodes.get(0));

TreePrintVisitor<Composite> visitor = new TreePrintVisitor<>(function);
// traversing a tree by TreePrintVisitor 
nodes.get(0).accept(visitor)
// after traversal will holding tree structure in a list for print
List<String> lines = visitor.getLines();
```


