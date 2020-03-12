/* @auther Liam Watson and Hussein Suleman 
* An AVLTree that has a balance condition added ontop of a binary search tree
* Hussein Suleman edditied by Liam Watson
*/
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
   /*
   * @param LSBSTNode node The starting node
   * @return int corrsponding to the balance factor used for blancing the tree
   * 
   */
   public int balanceFactor ( LSBSTNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }
   /*
   * This method traverses the tree and helps in fixing the height
   *@param LSBSTNode node , the starting node for which the method will traverse the tree and fix the height
   */
   public void fixHeight ( LSBSTNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   /*
   * This method is used for fixing the failed AVL condition
   * @param p LSBSTNode for which we consider a rotate right
   * @return LSBSTNode the node to review after the roation 
   */
   public LSBSTNode<dataType> rotateRight ( LSBSTNode<dataType> p )
   {
      LSBSTNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }
   /*
   * 
   * This method is used for fixing the failed AVL condition
   * @param q LSBSTNode for which we consider a rotate left
   * @return LSBSTNode the node to review after the roation 
   */
   public LSBSTNode<dataType> rotateLeft ( LSBSTNode<dataType> q )
   {
      LSBSTNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   /*
   * This method is used to begin the balancing process and decide which rotation to preform
   *@param p LSBSTNode which is used to begin the balancing
   *@return LSBSTNode the fixed node reference 
   */
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
   /*
   *This method is a helper for the main insert method
   *@param d dataType this is the data to be added to the tree
   */
   public void insert ( dataType d )
   {
      root = insert (d, root);
   }
   /*
   *This method inserts an object into the AVL tree
   *@param d node to be inserted and LSBSTNode aswell as the current node under consideration
   */
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
   /*
   *This is the helpr for the main fund method
   *@param d dataType which is the entry being searched for
   *@return LSBSTNode which is the node containg the data element that was searched for
   */
   public LSBSTNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   /*
   *This is the search method to find a data element in the AVL tree
   *@param d dataType which is the entry being searched for
   *@return LSBSTNode which is the node containg the data element that was searched for
   */
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
   /*
   *This is the helper method for producing a full tree output
   */
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   /*
   *This is the method used to output all the data in the AVL tree to the screen
   *@param node the node under consideration and level int which is the height of the current subtree
   */
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
   /*
   *This method is used to parse the instrumentation results to the read class then the main class
   *@retrun String value of the instrumentation 
   */
   public String getOpcounterT(){
      return insertCounter + " " + opCounter;
   }
}

