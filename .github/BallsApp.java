public class BallsApp {
    //main class that will run
    public static void main(String args[]){
        System.out.println(Random.newName());

        PG bob = new PG();
        System.out.println(bob.getOverall());
        System.out.println(bob.getThree());
    }
}
