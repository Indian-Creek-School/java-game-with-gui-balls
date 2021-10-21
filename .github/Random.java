import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
public class Random {
    
    public static String newName(){
        String name="";
        try{
            FileInputStream file=new FileInputStream("C:\\Users\\cmorr\\Desktop\\School\\semester 1\\comp sci\\Indian-Creek-School\\java-game-with-gui-balls\\.github\\names.txt");
            Scanner sc=new Scanner(file);
            ArrayList<String> names=new ArrayList<String>();
            while(sc.hasNext()){
                names.add(sc.nextLine());
            }
            name=names.get(getRandomInt(1, 559));
            sc.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return name;
        
    }

    public static int getRandomInt(int min, int max){
        return (int)(Math.floor(Math.random()*(max-min)+min));
    }
}
