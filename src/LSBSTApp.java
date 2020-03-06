/**
* @auther Liam Watson 
* This class is used to call the relevant classes to initialize the project run
*/ 
public class LSBSTApp{
    public static void main(String [] args){
	LSBSTRead read = new LSBSTRead(args); 
	WriteFile write = new WriteFile(true,""+ read.getOpCounter());        
       	
    }
}
