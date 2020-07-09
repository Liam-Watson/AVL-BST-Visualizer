import java.io.*;
import java.util.*;
/**@auther Liam Watson
*Loadshedding data management using binary search tree
*Note! The BST code was adapted from that created by Hussein Suleman.
*/
public class LSBSTManager<T extends Comparable<? super T>> extends LSBT<T>{
    private int opCounter = 0;
    private int opCounterWOPreProcessing = 0;
	/**
	*@param generic parameter to insert into a BST   
	* 
	*/ 
    public void insert (T d){
      if (root == null){
         root = new LSBSTNode<T> (d, null, null);
      }else
         insert (d, root);
   }
	/**
	* @param a generic parameter to insert as well as a reference node 
	* This method adds nodes to the BST in an algorithmic way
	*/ 
   public void insert ( T d, LSBSTNode<T> node ){
	//System.out.println(opCounter);
      opCounter++;
      if (d.compareTo(node.data) <= 0){
	 //opCounter++;
         if (node.left == null){
            node.left = new LSBSTNode<T> (d, null, null);
         }else
            insert (d, node.left);
      }
      else
      {	 //System.out.println(opCounter);
         //opCounter++;
         if (node.right == null){
            node.right = new LSBSTNode<T> (d, null, null);
         }else{
            insert(d, node.right);
	}
      }
   }
	/**
	* This method is a helper method used to start a full print traversial that is a preorder
	* 
	*/ 
	public void preOrder ()
   {
      preOrder (root);
   }
	/**
	*@param A generic LSBSTNode which is used for traversal 
	* This is a pre order full traversal and brint method 
	*/ 
   public void preOrder ( LSBSTNode<T> node )
   {
      //opCounter++;
      //opCounterWOPreProcessing++;
      if (node != null)
      {	
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }  
   }
	/**
	*@param a generic data emelent to search for 
	* @return a LSBSTNode containg the found element
	*/ 
   public LSBSTNode<T> find (T d)
   {
      //opCounter++;
	//System.out.println(opCounter);
      //opCounterWOPreProcessing++;
      if (root == null){
         System.out.println("Could Not find node");
         System.out.println("The number of comparisons in the insert " + opCounter);
	 System.out.println("The number of comparisons in the search " + opCounterWOPreProcessing);
         return null;
      }else{
         return find (d, root);
	 
	}
   }
	/**
	*@param a generic data element to search for and a LSBSTNode used for traversal  
	* @return LSBSTNode of the found element
	*/ 
   public LSBSTNode find (T d, LSBSTNode<T> node )
   {	
      opCounterWOPreProcessing = opCounterWOPreProcessing + 1;
      if (d.compareTo(node.data) == 0) {
	 System.out.println(node.data.toString());
	 System.out.println("The number of comparisons in the insert " + opCounter);
	 System.out.println("The number of comparisons in the search " + opCounterWOPreProcessing);
         return node;
      }else if (d.compareTo (node.data) < 0){
	 opCounterWOPreProcessing++;     
	 if(node.left == null){
	    System.out.println("Could Not find node");
	  System.out.println("The number of comparisons in the insert " + opCounter);
	 System.out.println("The number of comparisons in the search " + opCounterWOPreProcessing);
	 }    
	return (node.left == null) ? null : find (d, node.left);
      }else{
	 opCounterWOPreProcessing++;
	 if(node.right == null){
            System.out.println("Could Not find node");
           System.out.println("The number of comparisons in the insert " + opCounter);
	 System.out.println("The number of comparisons in the search " + opCounterWOPreProcessing);
         }    
         return (node.right == null) ? null : find (d, node.right);
	}
   }
	/**
	*@return String containg all instrumentation information
	* 
	*/ 
    public String getOpCounter(){
	return opCounter + " " + opCounterWOPreProcessing;
    }
}
