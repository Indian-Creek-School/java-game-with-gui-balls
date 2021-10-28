import java.util.ArrayList;

public class Team {
    public ArrayList<Player> team;

    public Team(ArrayList<Player> t){
        team = t;
    }

    public ArrayList<Player> getTeam(){
        return team;
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
    public String getSmallestPosOverall(){
        int centerOv=getPosOverall("center");
        int pfOv=getPosOverall("pf");
        int pgOv=getPosOverall("pg");
        int sfOv=getPosOverall("sf");
        int sgOv=getPosOverall("sg");
        int smallest=centerOv;
        int[] posOv={centerOv,pfOv,pgOv,sfOv,sgOv};
        for(int i:posOv){
            if(smallest<i){
               smallest=i;
            }
         }
         if(smallest==centerOv){
             return "center";
         }else if(smallest==pfOv){
             return "pf";
         }else if(smallest==pgOv){
             return "pg";
         }else if(smallest==sfOv){
             return "sf";
         }else if(smallest==sgOv){
             return "sg";
         }
        return "";
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
}
