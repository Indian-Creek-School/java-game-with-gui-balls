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

   public static Team generateRandomTeam(Team t1, Team t2, Team t3, Team t4){
      int teamTradingWith = (int)(Math.random()*(4)+1.5);
      if(teamTradingWith == 1){
         return t1;
      }
      if(teamTradingWith == 2){
         return t2;
      }
      if(teamTradingWith == 3){
         return t3;
      }
      if(teamTradingWith == 4){
         return t4;
      }
      return null;
   }

   public static Player getPlayerTradingFor(Team t1, Team t2, Team t3, Team t4) {
      int indexOfPlayerTradingFor = (int)(Math.random()*(7));
      Team teamTradingWith = generateRandomTeam(t1, t2, t3, t4);
      Player tradingFor = teamTradingWith.team.get(indexOfPlayerTradingFor);
      return tradingFor;
   }

   //add random players in the GUI class rather than here.
   
   public static int trade(Boolean wantsTrade, Team t1, Team t2, Team t3, Team t4) {
      Player playerTrading = myTeam.team.get((int)(Math.random()*7));
      Player tradingFor = getPlayerTradingFor(t1, t2, t3, t4);
      int indexOfPlayerTradingFor = t.team.indexOf(tradingFor);
      int indexOfWorstPlayer = myTeam.team.indexOf(myTeam.getWorstPlayer());
      if(wantsTrade) {
         myTeam.team.set(indexOfWorstPlayer, tradingFor);
         t.team.set(indexOfPlayerTradingFor, playerTrading);
         if(indexOfPlayerTradingFor > indexOfWorstPlayer){
            return (int)(Math.random()*5+1);
         } else if(indexOfPlayerTradingFor > indexOfWorstPlayer) {
            return -1*(int)(Math.random()*5+1);
         } else if(indexOfPlayerTradingFor == indexOfWorstPlayer){
            return 0;
         }
      } else {
         if(indexOfPlayerTradingFor > indexOfWorstPlayer){
            return -1*(int)(Math.random()*5+1);
         } else if(indexOfPlayerTradingFor > indexOfWorstPlayer) {
            return (int)(Math.random()*5+1);
         } else if(indexOfPlayerTradingFor == indexOfWorstPlayer){
            return 0;
         }
      }
      return 0;
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
