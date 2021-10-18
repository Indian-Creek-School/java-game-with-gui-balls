import javax.swing.text.html.HTML;

public class Player {
    private int bHandle;
    private int threePoint;
    private int midRange;
    private int closeRange;
    private int IQ;
    private int size;
    private int height;
    private int speed;
    private int playmaking;

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
}
