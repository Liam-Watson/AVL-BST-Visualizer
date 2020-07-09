import java.util.*;
public class Random{
    public static void main(String [] args){
    LSManager manager = new LSManager();
    WriteFile write;
    String build = "";
    for(int i = 0; i <10; i++){
        int random = (int)(Math.random()*2975);
        System.out.println(manager.getIndexEntry(random));
        }        
        for(int i = 0; i <2976; i++){
        int random = (int)(Math.random()*2975);
        build = build +"\n" +(manager.getIndexEntry(random));
        }
        write = new WriteFile(true,build);
    }
}