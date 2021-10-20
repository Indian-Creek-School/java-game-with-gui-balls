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

    public int getPGOverall(){
        int average = 0;
        average = (1.5*this.getHandle()+
        this.getClose()+
        0.5*this.getHeight()+
        1.25*this.getIQ()+
        this.getMid()+
        this.getPlaymaking()+
        0.5*this.getSize()+
        1.25*this.getThree()+
        this.getSpeed())/9;
    }
}
