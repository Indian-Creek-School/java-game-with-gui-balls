public class PF extends Player{

    public PF(){
        super(Random.getRandomInt(40,50),
        Random.getRandomInt(20,40),
        Random.getRandomInt(45,85),
        Random.getRandomInt(70,90),
        Random.getRandomInt(35,50),
        Random.getRandomInt(70,85),
        Random.getRandomInt(50,70),
        Random.getRandomInt(30,50),
        Random.getRandomInt(30,45));
    }

    public int getOverall(){
        int average = 0;
        average = (int)(0.5*this.getHandle()+
        1.5*this.getClose()+
        1.5*this.getHeight()+
        0.5*this.getIQ()+
        1.5*this.getMid()+
        0.5*this.getPlaymaking()+
        1.5*this.getSize()+
        0.75*this.getThree()+
        0.75*this.getSpeed())/9;

        return average;
    }

    public String getPos(){
        return "PF";
    }
    
}
