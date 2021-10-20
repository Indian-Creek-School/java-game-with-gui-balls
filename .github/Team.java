import java.util.ArrayList;

public class Team {
    private ArrayList<Player> team;

    public Team(ArrayList<Player> t){
        team = t;
    }

    public int getTeamOverall(){ //returns team overall
        int sum = 0;
        int average = 0;
        for(Player p: team) {
            if(p instanceof PG){
                sum += p.getPGOverall();
            } else if(p instanceof SG){
                sum += p.getSGOverall();
            } else if(p instanceof SF){
                sum += p.getSFOverall();
            } else if(p instanceof PF){
                sum += p.getPFOverall();
            } else if(p instanceof Center){
                sum += p.getCenterOverall();
            }
        }

        average = (int)(sum/team.size()+0.5);
        return average;
    }
}
