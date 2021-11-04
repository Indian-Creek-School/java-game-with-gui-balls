import java.util.ArrayList;

public class Team implements Comparable{
    public ArrayList<Player> team;
    public int wins;
    public int losses;
    public int semiWs;
    public int semiLs;
    public int finalWs;
    public int finalLs;

    public Team(ArrayList<Player> t){
        team = t;
        wins = 0;
        losses = 0;
        semiWs = 0;
        semiLs = 0;
        finalWs = 0;
        finalLs = 0;
    }

    public ArrayList<Player> getTeam(){
        return team;
    }

    public int getWins(){
        return wins;
    }

    public int getLosses(){
        return losses;
    }

    public String getRecord(){
        return Integer.toString(wins) + "-" + Integer.toString(losses);
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
    public Player getWorstPlayer() { 
        ArrayList<Player> test = team;
        int worstOvr = team.get(0).getOverall();
        Player worstPlayer = team.get(0);
        for(int i = 0; i < test.size(); i++){
            if(team.get(i).getOverall() < worstOvr){
                worstOvr = team.get(i).getOverall();
                worstPlayer = team.get(i);
            }
        }

        return worstPlayer;

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

    public String toString(){
        String result = "";
        for(int i = 0; i < team.size(); i++){
            result += team.get(i).getName()+", "+team.get(i).getPos()+", "+team.get(i).getOverall() + "<br/>";
        }
        return "<html> "+ result;
    }

    public int compareTo(Team t1) {
        return this.wins - t1.wins;
    }
}
