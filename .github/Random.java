import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
public class Random {
    
    public static String newName(){
        try{
            FileInputStream file=new FileInputStream("names.txt");
            Scanner sc=new Scanner(file);
            ArrayList<String> names=new ArrayList<String>();
            while(sc.hasNext()){
                names.add(sc.nextLine());
            }
            
        }catch (Exception e){}

        return "";
    }

    public static int getRandomInt(double min, double max){
        return (int)(Math.floor(Math.random()*(max-min)+min));
    }
}
