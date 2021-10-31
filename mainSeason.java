import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import java.util.ArrayList;
public class mainSeason{
   private static int gamecount=0;
   public static Team myTeam;
   public static Team tradeTeam;

   public static boolean simGame(Team t1, Team t2){
      gamecount++;

      //on any given day, teams first pick can go off so there overall will be boosted till 99 for one game
      int anyGivenDay = (int)(Math.random()*7 + 1);
      int prevOvr = 0;
      if(anyGivenDay == 2){
         prevOvr = t1.team.get(0).setOverall(99);
      }

      int ovr1 = t1.getTeamOverall();
      int ovr2 = t2.getTeamOverall();

      int nothing = t1.team.get(0).setOverall(prevOvr);

      //will determine home team (ignore names)
      int determineHome = (int)(Math.random()*2+1.5);
      if(determineHome == 1) {
         ovr1 += 1; //homecourt advantage
      } else {
         ovr2 += 1;
      }

      if(ovr1 > ovr2){
         return true;
      } else {
         return false;
      }
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

   public static Player getPlayerTradingFor(Team t1) {
      int indexOfPlayerTradingFor = (int)(Math.random()*(7));
      Player tradingFor = t1.team.get(indexOfPlayerTradingFor);
      return tradingFor;
   }

   //add random players in the GUI class rather than here.
   
   public static int trade(Boolean wantsTrade, Player p1, Player p2) {
      Player playerTrading = p1;
      Player tradingFor = p2;
      int indexOfPlayerTradingFor = tradeTeam.team.indexOf(tradingFor);
      int indexOfWorstPlayer = myTeam.team.indexOf(myTeam.getWorstPlayer());
      if(wantsTrade) {
         myTeam.team.set(indexOfWorstPlayer, tradingFor);
         tradeTeam.team.set(indexOfPlayerTradingFor, playerTrading);
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
