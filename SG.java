public class SG extends Player{

    public SG(){
        super(Random.getRandomInt(70,85),
        Random.getRandomInt(70,100),
        Random.getRandomInt(80,90),
        Random.getRandomInt(65,85),
        Random.getRandomInt(60,80),
        Random.getRandomInt(35,55),
        Random.getRandomInt(40,55),
        Random.getRandomInt(65,90),
        Random.getRandomInt(60,80));
    }

    public int getOverall(){
        int average = 0;
        average = (int)(1*this.getHandle()+
        0.5*this.getClose()+
        0.5*this.getHeight()+
        1.25*this.getIQ()+
        1.25*this.getMid()+
        1.25*this.getPlaymaking()+
        0.5*this.getSize()+
        1.5*this.getThree()+
        1.25*this.getSpeed())/9;

        return average;
    }

    public String getPos(){
        return "SG";
    }
}
