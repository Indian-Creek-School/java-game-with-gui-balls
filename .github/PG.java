public class PG extends Player {
    //Math.random() * (max - min) + min;
    public PG(){
        super(Random.getRandomInt(70,100),
        Random.getRandomInt(50,91),
        Random.getRandomInt(60,85),
        Random.getRandomInt(70,90),
        Random.getRandomInt(70,100),
        Random.getRandomInt(30,45),
        Random.getRandomInt(30,45),
        Random.getRandomInt(75,100),
        Random.getRandomInt(70,100));
    }

    public int getOverall(){
        int average = 0;
        average = (int)(1.25*this.getHandle()+
        0.5*this.getClose()+
        0.5*this.getHeight()+
        1.25*this.getIQ()+
        1*this.getMid()+
        1.5*this.getPlaymaking()+
        0.5*this.getSize()+
        1.25*this.getThree()+
        1.25*this.getSpeed())/9;

        return average;
    }
}
