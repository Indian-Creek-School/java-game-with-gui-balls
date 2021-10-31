public class SF extends Player{

    private int overall; 

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
        overall = determineOverall();
    }

    public int determineOverall(){
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
