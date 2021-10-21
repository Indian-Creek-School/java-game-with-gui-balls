public class SF extends Player{

    public SF(){
        super(Random.getRandomInt(50,75),
        Random.getRandomInt(50,80),
        Random.getRandomInt(75,100),
        Random.getRandomInt(70,85),
        Random.getRandomInt(50,75),
        Random.getRandomInt(50,70),
        Random.getRandomInt(50,70),
        Random.getRandomInt(50,70),
        Random.getRandomInt(45,60));
    }

    public int getOverall(){
        int average = 0;
        average = (int)(0.5*this.getHandle()+
        1.25*this.getClose()+
        1*this.getHeight()+
        1*this.getIQ()+
        1.25*this.getMid()+
        0.75*this.getPlaymaking()+
        1.25*this.getSize()+
        1*this.getThree()+
        1*this.getSpeed())/9;

        return average;
    }
    
}
