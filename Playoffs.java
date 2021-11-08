public class Playoffs {
    public static void simSemisPlayoffGame(Team t1, Team t2, int decision) {

      //on any given day, teams first pick can go off so there overall will be boosted till 99 for one game
      int anyGivenDay = (int)(Math.random()*7 + 1);
      int prevOvr = 0;
      if(anyGivenDay == 4){
         prevOvr = t1.team.get(0).setOverall(99);
      }
      if(anyGivenDay == 5){
        prevOvr = t2.team.get(0).setOverall(99);
      }

      int ovr1 = t1.getTeamOverall();
      int ovr2 = t2.getTeamOverall();

      if(anyGivenDay == 2){
         t1.team.get(0).setOverall(prevOvr);
      }
      if(anyGivenDay == 5){
        t2.team.get(0).setOverall(prevOvr);
      }

      //will determine home team (ignore names)
      int determineHome = (int)(Math.random()*2+1.5);
      if(determineHome == 1) {
         ovr1 += 1; //homecourt advantage
      } else {
         ovr2 += 1;
      }

      //updates users overall based on decision he makes
      ovr1 += decision;

      if(ovr1 > ovr2){
         t1.semiWs += 1;
         t2.semiLs += 1;
      } else {
        t1.semiLs += 1;
        t2.semiWs += 1;
      }
    }
   public static void simFinalsPlayoffGame(Team t1, Team t2, int decision) {

     //on any given day, teams first pick can go off so there overall will be boosted till 99 for one game
     int anyGivenDay = (int)(Math.random()*7 + 1);
     int prevOvr = 0;
     if(anyGivenDay == 1){
        prevOvr = t1.team.get(0).setOverall(99);
     }
     if(anyGivenDay == 2){
       prevOvr = t2.team.get(0).setOverall(99);
     }

     int ovr1 = t1.getTeamOverall();
     int ovr2 = t2.getTeamOverall();

     if(anyGivenDay == 1){
        t1.team.get(0).setOverall(prevOvr);
     }
     if(anyGivenDay == 2){
       t2.team.get(0).setOverall(prevOvr);
     }

     //will determine home team (ignore names)
     int determineHome = (int)(Math.random()*2+1.5);
     if(determineHome == 1) {
        ovr1 += 2; //homecourt advantage
     } else {
        ovr2 += 2;
     }

     //updates users overall based on decision he makes
     ovr1 += decision;

     if(ovr1 > ovr2){
       t1.finalWs += 1;
       t2.finalLs += 1;
     } else {
       t1.finalLs += 1;
       t2.finalWs += 1;
     }
   }
}
