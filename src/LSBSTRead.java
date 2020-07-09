import java.io.*;
import java.util.*;
/**
* @auther Liam Watson
* This class is used to read in data from a text file and assign it to a binary search tree as well as act as an intermediate between the main class and the manager
*/ 
public class LSBSTRead{
    private LSBSTManager<LSData> man = new LSBSTManager<LSData>();
    private String stages, day, time, fle;
    private int counterWrk = 0;
	/**
	*@param String[], the arguemnts passed into the main class as parameters 
	* Logic is used to decide how many elements to read as well as assign values to instance variables if needed
	*/ 
    public LSBSTRead(String [] args){
        if(args.length == 0){
                fle = 2976 +"";
		read();
        }else{
            fle = args[3];
	    read();
       }
	if(args.length == 0){
		man.preOrder();
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
                    buildLines = buildLines + scLine.next();
                }
                man.insert(new LSData(splitData[0], splitData[1], splitData[2], buildLines));
                buildLines = "";
                scLine.close();
            }
            sc.close();
        }catch(IOException e){
            System.out.println("IO Error, file not found");
        }
        man.computeNodePositions(); //finds x,y positions of the tree nodes
    man.maxheight=man.treeHeight(man.root); //finds tree height for scaling y axis
    DisplaySimpleTree dt = new DisplaySimpleTree(man);//get a display panel
    dt.setVisible(true); //show the display
    }
	/**
	* This is an intermediate method used to for finding elements in a BST 
	* 
	*/ 
	public void findMethod(){
		man.find(new LSData(stages,day,time,""));
	}
	/**
	*@return String of instrumentation data 
	* This method is used as an intermediate between the main class and the manager
	*/ 
	public String getOpCounter(){
		return man.getOpCounter();
	}
}
