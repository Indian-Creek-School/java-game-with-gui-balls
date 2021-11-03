public class PF extends Player{

    private int overall;

    public PF(){
        super(Random.getRandomInt(40,50),
        Random.getRandomInt(30,40),
        Random.getRandomInt(60,85),
        Random.getRandomInt(70,90),
        Random.getRandomInt(40,50),
        Random.getRandomInt(75,90),
        Random.getRandomInt(50,70),
        Random.getRandomInt(45,60),
        Random.getRandomInt(40,55));
        overall = determineOverall();
    }

    public int determineOverall(){
        int average = 0;
        average = (int)(0.5*this.getHandle()+
        2*this.getClose()+
        1.75*this.getHeight()+
        0.25*this.getIQ()+
        1.75*this.getMid()+
        0.25*this.getPlaymaking()+
        1.75*this.getSize()+
        0.25*this.getThree()+
        0.5*this.getSpeed())/9;
        return average;
    }

    public String getPos(){
        return "PF";
    }

    public int getOverall() {
        return overall;
    }

    public int setOverall(int i) {
        int temp = overall;
        overall = i;
        return temp;
    }
    
}
