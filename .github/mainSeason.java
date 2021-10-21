public class mainSeason {
    Team myTeam;

    public mainSeason(Team t){
        myTeam=t;
    }
    public static boolean winGame(Team t1, Team t2){
       Team home=t1;
       Team away=t2;
       if(home.getTeamOverall()>away.getTeamOverall()){
           return true;
       }
       return true;
    }

}
