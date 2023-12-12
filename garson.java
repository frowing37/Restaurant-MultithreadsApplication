public class garson implements Runnable {
    
    public garson(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    private String name;
    private boolean musteri = false;

    public void musteriyiKap(){
        musteri = true;
    }

    public void siparisAl(){
                
    }
}
