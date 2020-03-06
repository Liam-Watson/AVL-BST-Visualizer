import java.io.*;
import java.util.*;
/**
* @auther Liam Watson 
* A class used throughout the project to write the instrumentation to a text file. 
*/ 
public class WriteFile{
	/**
	* @param a boolean for determing which class we are writing from. An input String to be written 
	* This constructor takes in a string and writes it to a text file 
	*/ 
    public WriteFile(Boolean classInfo, String input){
        try{
		
            File file = new File("/home/liam/Desktop/University/CSC2001F/Assignments/Assignment1/test.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter writer = new PrintWriter(br);
            writer.println(input);
            br.close();
            writer.close();
            
        }catch(IOException e){
            System.out.println("Error while writing to file");
        }        
    }
}
