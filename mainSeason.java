import java.io.FileInputStream;
import java.util.Scanner;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
import java.util.ArrayList;
public class mainSeason{
   private static int gamecount=0;
   public static Team myTeam;
    public static boolean winGame(Team t1, Team t2){
       gamecount++;
       Team home=t1;
       Team away=t2;
       if(home.getTeamOverall()>away.getTeamOverall()){
           return true;
       }
       return true;
    }
    public static ArrayList<Player> Trade(Team t2){
      ArrayList<Player> tradeP=myTeam.team;
      int centerOv=myTeam.getPosOverall("center");
      int pfOv=myTeam.getPosOverall("pf");
      int pgOv=myTeam.getPosOverall("pg");
      int sfOv=myTeam.getPosOverall("sf");
      int sgOv=myTeam.getPosOverall("sg");
      int smallest=centerOv;
      int centerOv2=myTeam.getPosOverall("center");
      int pfOv2=myTeam.getPosOverall("pf");
      int pgOv2=myTeam.getPosOverall("pg");
      int sfOv2=myTeam.getPosOverall("sf");
      int sgOv2=myTeam.getPosOverall("sg");
      int smallest2=centerOv;
      int[] posOv={centerOv,pfOv,pgOv,sfOv,sgOv};
      int[] posOv2={centerOv2,pfOv2,pgOv2,sfOv2,sgOv2};
       if(gamecount==10||gamecount==20){
          for(int i:posOv){
             if(smallest<i){
                smallest=i;
             }
          }
          for(int j:posOv2){
            if(smallest2<j){
               smallest2=j;
            }
         }
       }

       return tradeP;
    }
    
    public void SoundClipTest() {
  
        try {
           // Open an audio input stream.
           URL url = this.getClass().getClassLoader().getResource(".github\\Bruh-sound-effect.mp3");
           AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
           // Get a sound clip resource.
           Clip clip = AudioSystem.getClip();
           // Open audio clip and load samples from the audio input stream.
           clip.open(audioIn);
           clip.start();
        } catch (UnsupportedAudioFileException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        } catch (LineUnavailableException e) {
           e.printStackTrace();
        }
     }
}
