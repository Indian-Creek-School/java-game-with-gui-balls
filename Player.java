import javax.swing.JComboBox;
import javax.swing.text.html.HTML;
import java.util.ArrayList;

//Abstract class which builds a player of given attributes. Each position class inherits this class and its constructor
public abstract class Player {

    //fields of the class
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

    /**
     * Constructor
     * @param bH ballhandling
     * @param tP three point 
     * @param mR mid range
     * @param cR close range
     * @param iq basketball iq
     * @param si size
     * @param h height
     * @param sp speed
     * @param plm playmaking ability
     */
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

    //get methods for instance variables
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

    //abstract methods in each class
    //get positions gets returns player given position
    public abstract String getPos();
    //determines overalls of player
    public abstract int determineOverall();
    //gets the overall of the player (fields of position classes)
    public abstract int getOverall();
    //sets the overall of a player (field of position class)
    public abstract int setOverall(int i);

    //toString just returns players name
    public String toString(){
        return name;
    }

    /**
     * 
     * @param arr array of players
     * @return returns highest overall player in array
     */
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

    //adds player to team and removes them from the drafting jComboBox
    public static void addPlayerToTeam(ArrayList<Player> arr1, ArrayList<Player> arr2, JComboBox<String> cb1){
        Player selectedPlayer = Player.highestOvrPlayer(arr1);
        arr2.add(selectedPlayer);
        arr1.remove(selectedPlayer);
        cb1.removeItem(selectedPlayer.getName() + ", " + selectedPlayer.getPos()+ ", " + selectedPlayer.getOverall());
    }

}
