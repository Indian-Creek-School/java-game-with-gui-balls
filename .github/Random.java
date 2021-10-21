import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
public class Random {
    
    public static String newName(){
        String name="";
        try{
            FileInputStream file=new FileInputStream(".github\\names.txt");
            FileInputStream file2=new FileInputStream(".github\\lastNames.txt");
            Scanner sc=new Scanner(file);
            Scanner sc2=new Scanner(file2);
            ArrayList<String> names=new ArrayList<String>();
            ArrayList<String> lastNames=new ArrayList<String>();
            while(sc.hasNext()){
                names.add(sc.nextLine());
            }
            while(sc2.hasNext()){
                lastNames.add(sc2.nextLine());
            }
            name=names.get(getRandomInt(1, 559))+" "+lastNames.get(getRandomInt(1, 559));
            sc.close();
            sc2.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return name;
        
    }

    public static int getRandomInt(int min, int max){
        return (int)(Math.floor(Math.random()*(max-min)+min));
    }
}
