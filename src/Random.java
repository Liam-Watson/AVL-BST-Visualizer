import java.util.*;
public class Random{
    public static void main(String [] args){
    LSManager manager = new LSManager();
    //manager.read();
    WriteFile write;
    String build = "";
    for(int i = 0; i <10; i++){
        int random = (int)(Math.random()*2975);
        //random = 300;
        //LSManager manager = new LSManager();
        System.out.println(manager.getIndexEntry(random));
        }        
        for(int i = 0; i <2976; i++){
        int random = (int)(Math.random()*2975);
        //random = 300;
        //LSManager manager = new LSManager();
        build = build +"\n" +(manager.getIndexEntry(random));
        }
        write = new WriteFile(true,build);
    }
}