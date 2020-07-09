/*
*@author Liam Watson
*This is the main class for the AVL tree experment
*/
public class AVLApp{
    public static void main(String [] args){
        AVLRead read = new AVLRead(args);
        WriteFile write = new WriteFile(true, "" + read.getOpcounter());                      
    }
}

