import java.io.*;
import javax.swing.*;
import java.util.*;
/**
* @auther Liam Watson
* This class is used to read in data from a text file and assign it to a binary search tree as well as act as an intermediate between the main class and the manager
*/ 

public class AVLRead{
    private AVLTree<LSData> man = new  AVLTree<LSData>();
    private String stages, day, time, fle;
    private int counterWrk = 0;
	/**
	*@param String[], the arguemnts passed into the main class as parameters 
	* Logic is used to decide how many elements to read as well as assign values to instance variables if needed
	*/ 
    public AVLRead(String [] args){
        if(args.length == 0){
                fle = 2976 +"";
		read();
        }else{
            fle = args[3];
	    read();
       }
	if(args.length == 0){
		man.treeOrder();
	}else if(args.length == 4){
		this.stages = args[0];
		this.day = args[1];
		this.time = args[2];	
		findMethod();
		
	}
    }
	
	/**
	*This class reads in a prescribed number of data elements from a text file 
	* 
	*/ 
    public void read(){
        try{
            Scanner sc = new Scanner(new File("/home/liam/Desktop/University/CSC2001F/Assignments/Assignment2/files/RandomizedData.txt"));
            String line = "";
            String buildLines = "";
            Scanner scLine;
            String [] splitData;
            Scanner tmp; 
            while(sc.hasNext() && Integer.parseInt(fle) > counterWrk){
                counterWrk++;
                scLine = new Scanner(sc.nextLine()).useDelimiter(" ");
                splitData = scLine.next().split("_");
                while(scLine.hasNext()){
                    buildLines = buildLines.trim() + scLine.next().trim();
                }
                man.insert(new LSData(splitData[0].trim(), splitData[1].trim(), splitData[2].trim(), buildLines.trim()));
                buildLines = "";
                scLine.close();
            }
            sc.close();
        }catch(IOException e){
            System.out.println("IO Error, file not found");
        }
        
    }
	/**
	* This is an intermediate method used to for finding elements in a BST 
	* 
	*/ 
	public void findMethod(){
	        JFrame f = new JFrame();
	        man.find(new LSData(stages,day,time,""));
	        LSBSTNode<LSData> node = man.find(new LSData(stages,day,time,""));
	        if(node == null){
	            //System.out.println("Could Not find node");
	            JOptionPane.showMessageDialog(f,null,"Could not find load shedding data", JOptionPane.WARNING_MESSAGE);
	            System.exit(0);
	        }else{
                    System.out.println(node.data.toString());
                    }
	}
	/**
	*@return String of instrumentation data 
	* This method is used as an intermediate between the main class and the manager
	*/ 
	public String getOpcounter(){
		return man.getOpcounterT();
	}
}
