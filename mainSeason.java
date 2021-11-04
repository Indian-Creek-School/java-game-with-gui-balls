import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import java.util.ArrayList;
public class mainSeason{
   public static int gamecount;
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

   public static Player getPlayerTradingFor(Team t1) {
      int indexOfPlayerTradingFor = (int)(Math.random()*(7));
      Player tradingFor = t1.team.get(indexOfPlayerTradingFor);
      return tradingFor;
   }

   //add random players in the GUI class rather than here.
   
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
        ArrayList<Team> allTeams = new ArrayList<Team>();
        allTeams.add(t1);
        allTeams.add(t2);
        allTeams.add(t3);
        allTeams.add(t4);
        allTeams.add(t5);

        ArrayList<Team> playoffs = sortByWins(allTeams);
        playoffs.remove(0);
        return playoffs;

     }

     public static ArrayList<Team> sortByWins(ArrayList<Team> team) { //credits to https://www.wikitechy.com/interview-questions/java/what-is-linear-sort-in-java/
         ArrayList<Team> t1 = team;
   
         int n = team.size();  
         for (int j = 1; j < n; j++) {  
               Team key = t1.get(j);  
               int i = j-1;  
               while ( (i > -1) && ( t1.get(i).getWins() > key.getWins() ) ) {  
                  t1.set(i+1, t1.get(i));  
                  i--;  
               }  
               t1.set(i+1, key);
         }  
         System.out.println(t1.toString());
         return t1;
     }  
}
