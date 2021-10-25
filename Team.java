import java.util.ArrayList;

public class Team {
    public ArrayList<Player> team;

    public Team(ArrayList<Player> t){
        team = t;
    }

    public int getTeamOverall(){ //returns team overall
        int sum = 0;
        int average = 0;
        for(Player p: team){
            sum += p.getOverall();
        }
        average = (int)(sum/team.size()+0.5);
        return average;
    }
}
