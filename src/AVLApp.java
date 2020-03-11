public class AVLApp{

    public static void main(String [] args){
        AVLRead read = new AVLRead(args);
        WriteFile write = new WriteFile(true, "" + read.getOpcounter());                
        
    }
}

