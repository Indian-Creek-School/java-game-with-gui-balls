public class PF extends Player{

    private int overall;

    public PF(){
        super(Random.getRandomInt(40,50),
        Random.getRandomInt(30,40),
        Random.getRandomInt(60,85),
        Random.getRandomInt(70,90),
        Random.getRandomInt(40,50),
        Random.getRandomInt(70,85),
        Random.getRandomInt(50,70),
        Random.getRandomInt(40,50),
        Random.getRandomInt(40,45));
        overall = determineOverall();
    }

    public int determineOverall(){
        int average = 0;
        average = (int)(0.5*this.getHandle()+
        1.75*this.getClose()+
        1.5*this.getHeight()+
        0.5*this.getIQ()+
        1.5*this.getMid()+
        0.5*this.getPlaymaking()+
        1.5*this.getSize()+
        0.5*this.getThree()+
        0.75*this.getSpeed())/9;
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
