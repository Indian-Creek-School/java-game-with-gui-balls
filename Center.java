public class Center extends Player{

    private int overall;
    public Center(){
        super(Random.getRandomInt(30,40),
        Random.getRandomInt(30,40),
        Random.getRandomInt(35,65),
        Random.getRandomInt(80,100),
        Random.getRandomInt(40,60),
        Random.getRandomInt(80,100),
        Random.getRandomInt(80,100),
        Random.getRandomInt(25,45),
        Random.getRandomInt(30,45));
        overall = determineOverall();
    }

    public int determineOverall(){
        int average = 0;
        average = (int)(0.25*this.getHandle()+
        1.75*this.getClose()+
        1.5*this.getHeight()+
        0.5*this.getIQ()+
        1.5*this.getMid()+
        0.5*this.getPlaymaking()+
        1.75*this.getSize()+
        0.5*this.getThree()+
        0.75*this.getSpeed())/9;

        return average;
    }

    public String getPos(){
        return "Center";
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
