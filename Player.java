import javax.swing.JComboBox;
import javax.swing.text.html.HTML;
import java.util.ArrayList;

public abstract class Player {
    private int bHandle;
    private int threePoint;
    private int midRange;
    private int closeRange;
    private int IQ;
    private int size;
    private int height;
    private int speed;
    private int playmaking;
    private String name;

    public Player(int bH, int tP, int mR, int cR, int iq, int si, int h, int sp, int plm) {
        bHandle = bH;
        threePoint = tP;
        midRange = mR;
        closeRange = cR;
        IQ = iq;
        size = si;
        height = h;
        speed = sp;
        playmaking = plm;
        name = Random.newName();
    }

    public int getHandle(){return bHandle;}
    public int getThree(){return threePoint;}
    public int getMid(){return midRange;}
    public int getClose(){return closeRange;}
    public int getIQ(){return IQ;}
    public int getSize(){return size;}
    public int getHeight(){return height;}
    public int getSpeed(){return speed;}
    public int getPlaymaking(){return playmaking;}
    public String getName(){
        return name;
    }

    public abstract String getPos();
    public abstract int determineOverall();
    public abstract int getOverall();
    public abstract int setOverall(int i);


    public String toString(){
        return name;
    }

    public static Player highestOvrPlayer(ArrayList<Player> arr) {
        int highOvr = arr.get(0).getOverall();
        for(int j = 0; j < arr.size() - 1; j++){
            int currOvr = arr.get(j+1).getOverall();
            if(currOvr >= highOvr) {
                highOvr = currOvr;
            }

        }

        Player selectedPlayer = null;
        for(int j = 0; j < arr.size(); j++){
            int desiredOvr = arr.get(j).getOverall();
            if(desiredOvr == highOvr){
                selectedPlayer = arr.get(j);
            }
        }

        return selectedPlayer;
    }

    //will add the highest overall player to a team
    public static void addPlayerToTeam(ArrayList<Player> arr1, ArrayList<Player> arr2, JComboBox<String> cb1){
        Player selectedPlayer = Player.highestOvrPlayer(arr1);
        arr2.add(selectedPlayer);
        arr1.remove(selectedPlayer);
        cb1.removeItem(selectedPlayer.getName() + ", " + selectedPlayer.getPos()+ ", " + selectedPlayer.getOverall());
    }

}
