public class Team {
    private ArrayList<Player> team;

    public Team(ArrayList<Player> t){
        team = t;
    }

    public int getTeamOverall(){ //returns team overall
        int sum = 0;
        int average = 0;
        String position="";
        for(Player p: team){
            position = p.getClass()
            if(position.equals("PG")){
                p.getPGOverall();
            }
            sum += p.getOverall();
        }
        average = (int)(sum/team.size()+0.5);
        return average;
    }
}
