import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
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
      ArrayList<Player> tradeP=new ArrayList<Player>();
      ArrayList<Player> t2P=t2.team;
      ArrayList<Player> t2Trades=new ArrayList<Player>();
      ArrayList<Player> t1Trades=new ArrayList<Player>();
      String smallest=myTeam.getSmallestPosOverall();

      if(smallest.equals("center")){
         for(Player p:myTeam.team){
            if(p instanceof Center){
               t1Trades.add(p);
            }
         }
         for(Player p: t2P){
            if(p instanceof Center){
               t2Trades.add(p);
            }
         }
      }
      if(smallest.equals("pf")){
         for(Player p:myTeam.team){
            if(p instanceof PF){
               t1Trades.add(p);
            }
         }
         for(Player p: t2P){
            if(p instanceof PF){
               t2Trades.add(p);
            }
         }
      }
      if(smallest.equals("pg")){
         for(Player p:myTeam.team){
            if(p instanceof PG){
               t1Trades.add(p);
            }
         }
         for(Player p: t2P){
            if(p instanceof PG){
               t2Trades.add(p);
            }
         }
      }
      if(smallest.equals("sf")){
         for(Player p:myTeam.team){
            if(p instanceof SF){
               t1Trades.add(p);
            }
         }
         for(Player p: t2P){
            if(p instanceof SF){
               t2Trades.add(p);
               
            }
         }
      }
      if(smallest.equals("sg")){
         for(Player p:myTeam.team){
            if(p instanceof SG){
               t1Trades.add(p);
            }
         }
         for(Player p: t2P){
            if(p instanceof SG){
               t2Trades.add(p);
            }
         }
      }
      tradeP.add(t1Trades.get(Random.getRandomInt(0, 2)));
      tradeP.add(t2Trades.get(Random.getRandomInt(0, 2)));
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
