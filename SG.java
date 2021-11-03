public class SG extends Player{

    private int overall;
    public SG(){
        super(Random.getRandomInt(70,85),
        Random.getRandomInt(70,80),
        Random.getRandomInt(80,90),
        Random.getRandomInt(65,85),
        Random.getRandomInt(60,80),
        Random.getRandomInt(35,55),
        Random.getRandomInt(40,55),
        Random.getRandomInt(65,90),
        Random.getRandomInt(60,80));
        overall = determineOverall();
    }

    public int determineOverall(){
        int average = 0;
        average = (int)(0.75*this.getHandle()+
        0.75*this.getClose()+
        0.5*this.getHeight()+
        1.25*this.getIQ()+
        1.25*this.getMid()+
        1.25*this.getPlaymaking()+
        0.75*this.getSize()+
        1.25*this.getThree()+
        1.25*this.getSpeed())/9;

        return average;
    }

    public String getPos(){
        return "SG";
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
