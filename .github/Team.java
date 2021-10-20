import java.util.ArrayList;

public class Team {
    private ArrayList<Player> team;

    public Team(ArrayList<Player> t){
        team = t;
    }

    public int getTeamOverall(){ //returns team overall
        int sum = 0;
        int average = 0;
        String position = "";
        for(Player p: team) {
            position = p.getClass();
            if(position.equals("PG")){
                sum += p.getPGOverall();
            } else if(position.equals("SG")){
                sum += p.getSGOverall();
            } else if(position.equals("SF")){
                sum += p.getSFOverall();
            } else if(position.equals("PF")){
                sum += p.getPFOverall();
            } else if(position.equals("Center")){
                sum += p.getCenterOverall();
            }
        }
        
        average = (int)(sum/team.size()+0.5);
        return average;
    }
}
