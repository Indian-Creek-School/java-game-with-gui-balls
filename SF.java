public class SF extends Player{

    private int overall; 

    public SF(){
        super(Random.getRandomInt(50,75),
        Random.getRandomInt(50,80),
        Random.getRandomInt(80,90),
        Random.getRandomInt(65,80),
        Random.getRandomInt(50,75),
        Random.getRandomInt(70,75),
        Random.getRandomInt(50,70),
        Random.getRandomInt(50,70),
        Random.getRandomInt(45,60));
        overall = determineOverall();
    }

    public int determineOverall(){
        int average = 0;
        average = (int)(0.5*this.getHandle()+
        1.25*this.getClose()+
        1*this.getHeight()+
        0.5*this.getIQ()+
        2*this.getMid()+
        0.5*this.getPlaymaking()+
        1.25*this.getSize()+
        1*this.getThree()+
        1*this.getSpeed())/9;

        return average;
    }

    public String getPos(){
        return "SF";
    }

    public int getOverall(){
        return overall;
    }

    //sets new overall and returns old overall
    public int setOverall(int i){
        int temp = overall;
        overall = i;
        return temp;
    }
    
}
