//import statements
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import java.util.ArrayList;
import java.util.Collections;

//class the runs the regular season
public class mainSeason{
   //counts number of games played-> really irrelevant
   public static int gamecount;

   /**
    * Simulates a game based on overalls. Random events are done by temporarily editing overalls.
    Directly edits public fields to changes loses and wins of a team
    * @param t1 first team in game
    * @param t2 second team in game
    * @return
    */
   public static boolean simGame(Team t1, Team t2){
      //adds one to gamecount
      gamecount++;

      //on any given day, teams first pick can go off so there overall will be boosted till 99 for one game
      int anyGivenDay = (int)(Math.random()*7 + 1);
      int prevOvr = 0;
      if(anyGivenDay == 2){
         prevOvr = t1.team.get(0).setOverall(99);
      }

      int ovr1 = t1.getTeamOverall();
      int ovr2 = t2.getTeamOverall();

      if(anyGivenDay == 2){
         t1.team.get(0).setOverall(prevOvr);
      }

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

   /**
    * returns a random team given an input of 4 teams
    * @param t1 first sim team
    * @param t2 second sim team
    * @param t3 third sim team
    * @param t4 fourth sim team
    * @return returns randomly generated team
    */
   public static Team generateRandomTeam(Team t1, Team t2, Team t3, Team t4){
      int teamTradingWith = (int)(Math.random()*(4)+1);
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

   /**
    * 
    * @param t1 team of player trading for
    * @return returns player trading for
    */
   public static Player getPlayerTradingFor(Team t1) {
      int indexOfPlayerTradingFor = (int)(Math.random()*(7));
      Player tradingFor = t1.team.get(indexOfPlayerTradingFor);
      return tradingFor;
   }

   /**
    * Trading algorithm which depending on user input for trade through boolean
    * Sets player on one team to player on users Team if boolean wantsTrade is true (users way of accepting a trade)
    * @param wantsTrade user input on trade (true is accepted, false is declind)
    * @param p1 player user is trading
    * @param p2 player user is trading for
    * @param userTeam team of user
    * @param tradeTeam team user is trading with
    */
   public static void trade(Boolean wantsTrade, Player p1, Player p2, Team userTeam, Team tradeTeam) {
      Player playerTrading = p1;
      Player tradingFor = p2;
      int indexOfPlayerTradingFor = tradeTeam.team.indexOf(tradingFor);
      int indexOfPlayer = userTeam.team.indexOf(playerTrading);
      if(wantsTrade) {
         userTeam.team.set(indexOfPlayer, tradingFor);
         tradeTeam.team.set(indexOfPlayerTradingFor, playerTrading);
      }
   }
    
   //ignore this
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

     public static ArrayList<Team> setPlayoffs(Team t1, Team t2, Team t3, Team t4, Team t5) {
        ArrayList<Team> playoffs = new ArrayList<Team>();
        playoffs.add(t1);
        playoffs.add(t2);
        playoffs.add(t3);
        playoffs.add(t4);
        playoffs.add(t5);

        Collections.sort(playoffs);
        playoffs.remove(0);
        return playoffs;

     } 
}
