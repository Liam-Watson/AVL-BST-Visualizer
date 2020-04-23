// Code for popping up a window that displays a custom component
// in this case we are displaying a Binary Search tree  
// reference problem 4.38 of Weiss to compute tree node x,y positions

// input is a text file name that will form the Binary Search Tree

//     java DisplaySimpleTree textfile


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class DisplaySimpleTree extends JFrame {
  JScrollPane scrollpane;
  DisplayPanel panel;
  //int counter = 0;  

  public DisplaySimpleTree(LSBT<LSData> t) {
    System.out.println("made it into the important stuff");
    panel = new DisplayPanel(t);
    panel.setPreferredSize(new Dimension(1500, 750));
    scrollpane = new JScrollPane(panel);
    getContentPane().add(scrollpane, BorderLayout.CENTER);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();  // cleans up the window panel
    //t.computeNodePositions(); //finds x,y positions of the tree nodes
    //t.maxheight=t.treeHeight(t.root); //finds tree height for scaling y axis
    //DisplaySimpleTree dt = new DisplaySimpleTree(t);//get a display panel
    //this.setVisible(true); //show the display
    //System.out.println("Ran all the important stuff");
	//System.exit(0);
  }

/*  public static void main(String[] args) {
    int counter = 0;
    MyTree t = new MyTree(); // t is Binary tree we are displaying
    BufferedReader diskInput;
    String [] word;
    // read in the words to create the Binary Search Tree
    if(args.length!=1){
	System.out.println("usage: java DisplayTree textfile");
//        System.exit(0);
    }
    try { //reads in words from a file
//      diskInput = new BufferedReader(new InputStreamReader(
//          new FileInputStream(
//	      new File(args[0]))));// file name is on command line
      Scanner input=new Scanner(new File("/home/liam/Desktop/University/CSC2001F/Assignments/Assignment2/files/RandomizedData.txt"));
      while (input.hasNext() && counter < 1000) { 
        word=input.nextLine().split(" ");
        counter++;             
        //word=word.toLowerCase(); // use lower case only
        t.root = t.insert(t.root, word[0]);  //insert word into Binary Search Tree
        t.inputString= t.inputString + " " + word[0]; // add word to input string
      }
    }
    catch (IOException e) {
        System.out.println("io exception");
      }

    t.computeNodePositions(); //finds x,y positions of the tree nodes
    t.maxheight=t.treeHeight(t.root); //finds tree height for scaling y axis
    DisplaySimpleTree dt = new DisplaySimpleTree(t);//get a display panel
    dt.setVisible(true); //show the display
  }
}*/

  class DisplayPanel extends JPanel {
     LSBT<LSData> t;
     int xs;
     int ys;

    public DisplayPanel(LSBT<LSData>  b) {
      t = b; // allows dispay routines to access the tree
      setBackground(Color.white);
      setForeground(Color.black);
    }

    protected void paintComponent(Graphics g) {
      g.setColor(getBackground()); //colors the window
      g.fillRect(0, 0, getWidth(), getHeight());
      g.setColor(getForeground()); //set color and fonts
      Font MyFont = new Font("SansSerif",Font.PLAIN,5);
      g.setFont(MyFont);
      xs=2;   //where to start printing on the panel
      ys=5;
//      g.drawString("Binary Search tree for the input string:\n",xs,ys);
      ys=ys+5;;
      int start=0;
      //  print input string on panel, 150 chars per line
      // if string longer than 23 lines don't print
      if(t.inputString.length()<23*150){
           while((t.inputString.length()-start)>150){
//              g.drawString(t.inputString.substring(start,start+150),xs,ys);        
              start+=151;
              ys+=15;
           }
  //         g.drawString(t.inputString.substring(start,t.inputString.length()),xs,ys);
      }
      MyFont = new Font("SansSerif",Font.BOLD,5); //bigger font for tree
      g.setFont(MyFont);
      this.drawTree(g, t.root); // draw the tree
      revalidate(); //update the component panel
    }

      public void drawTree(Graphics g, LSBSTNode root) {//actually draws the tree
      int dx, dy, dx2, dy2;
      int SCREEN_WIDTH=3000; //screen size for panel
      int SCREEN_HEIGHT=1200;
      int XSCALE, YSCALE;  
      XSCALE=SCREEN_WIDTH/t.totalnodes; //scale x by total nodes in tree
      YSCALE=(SCREEN_HEIGHT-ys)/(t.maxheight+1); //scale y by tree height

      if (root != null) { // inorder traversal to draw each node
        drawTree(g, root.left); // do left side of inorder traversal 
        dx = root.xpos * XSCALE; // get x,y coords., and scale them 
        dy = root.ypos * YSCALE +ys;
        String s = "0";//(String) root.data; //get the word at this node
        g.drawString(s, dx/2, dy/2); // draws the word
// this draws the lines from a node to its children, if any
        if(root.left!=null){ //draws the line to left child if it exists
          dx2 = root.left.xpos * XSCALE; 
          dy2 = root.left.ypos * YSCALE +ys;
          g.drawLine(dx/2,dy/2,dx2/2,dy2/2);
        }
        if(root.right!=null){ //draws the line to right child if it exists
          dx2 = root.right.xpos * XSCALE;//get right child x,y scaled position
          dy2 = root.right.ypos * YSCALE + ys;
          g.drawLine(dx/2,dy/2,dx2/2,dy2/2);
        }
        drawTree(g, root.right); //now do right side of inorder traversal 
      }
    }
}
}

