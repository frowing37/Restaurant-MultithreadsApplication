public class yemek extends Thread {
    
    private asci a;
    private garson g;

    public yemek(asci a,garson g) {
        this.a = a;
        this.g = g;
    }

    @Override
    public void run(){
        try{
            Thread.sleep(3000);
        }
        catch(Exception e){

        }

    }
}
