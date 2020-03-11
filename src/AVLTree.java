// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman edditied by Liam Watson
// reference: kukuruku.co/post/avl-trees/

public class AVLTree<dataType extends Comparable<? super dataType>> extends LSBT<dataType>
{
   private int insertCounter = 0;
   private int opCounter = 0;
   public int height ( LSBSTNode<dataType> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
   public int balanceFactor ( LSBSTNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }
   
   public void fixHeight ( LSBSTNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   public LSBSTNode<dataType> rotateRight ( LSBSTNode<dataType> p )
   {
      LSBSTNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   public LSBSTNode<dataType> rotateLeft ( LSBSTNode<dataType> q )
   {
      LSBSTNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   public LSBSTNode<dataType> balance ( LSBSTNode<dataType> p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }

   public void insert ( dataType d )
   {
      root = insert (d, root);
   }
   public LSBSTNode<dataType> insert ( dataType d, LSBSTNode<dataType> node )
   {
      if (node == null){
	 //System.out.println("Root added" + insertCounter);
	 
         return new LSBSTNode<dataType> (d, null, null);
	}
      insertCounter++;
      if (d.compareTo (node.data) <= 0)
         node.left = insert (d, node.left);
      else
         node.right = insert (d, node.right);
      return balance (node);
   }
   
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   
   public LSBSTNode<dataType> delete ( dataType d, LSBSTNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else
      {
         LSBSTNode<dataType> q = node.left;
         LSBSTNode<dataType> r = node.right;
         if (r == null)
            return q;
         LSBSTNode<dataType> min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }
   
   public LSBSTNode<dataType> findMin ( LSBSTNode<dataType> node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   public LSBSTNode<dataType> removeMin ( LSBSTNode<dataType> node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }

   public LSBSTNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   public LSBSTNode<dataType> find ( dataType d, LSBSTNode<dataType> node )
   {
	System.out.println(node.height);
      if (d.compareTo (node.data) == 0){
	 //System.out.println(opCounter + "____");
	 opCounter++;
         return node;
      }else if (d.compareTo (node.data) < 0){
	 //System.out.println(opCounter + "----");
	 opCounter = opCounter + 2;
         return (node.left == null) ? null : find (d, node.left);
      }else{
	 opCounter = opCounter + 2;
         return (node.right == null) ? null : find (d, node.right);
	}
   }
   
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   public void treeOrder ( LSBSTNode<dataType> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
   public String getOpcounterT(){
      return insertCounter + " " + opCounter;
   }
}

