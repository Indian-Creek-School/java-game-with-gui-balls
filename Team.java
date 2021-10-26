import java.util.ArrayList;

public class Team {
    public ArrayList<Player> team;

    public Team(ArrayList<Player> t){
        team = t;
    }
    public int getPosOverall(String pos){
        int total=0;
        int count=0;
        if(pos.equals("center")){
            for(Player p:team){
                if (p instanceof Center){
                    total+=p.getOverall();
                    count++;
                }
            }
        }else if(pos.equals("pf")){
            for(Player p:team){
                if (p instanceof PF){
                    total+=p.getOverall();
                    count++;
                }
            }
        }else if(pos.equals("pg")){
            for(Player p:team){
                if (p instanceof PG){
                    total+=p.getOverall();
                    count++;
                }
            }
        }else if(pos.equals("sf")){
            for(Player p:team){
                if (p instanceof SF){
                    total+=p.getOverall();
                    count++;
                }
            }
        }else if(pos.equals("sg")){
            for(Player p:team){
                if (p instanceof SG){
                    total+=p.getOverall();
                    count++;
                }
            }
        }
        return total/count;
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
