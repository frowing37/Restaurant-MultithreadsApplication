import java.time.chrono.ThaiBuddhistChronology;
import java.util.ArrayList;

public class asci implements Runnable {
    
    private String name;
    private ArrayList<garson> yemekler = new ArrayList<garson>();
    private yemek y1 = null;
    private yemek y2 = null;

    public asci(String name) {
        this.name = name;
        System.out.println(name + " oluşturuldu !\n");
    }

    public boolean asciUygunmu() {
        if(yemekler.size() < 2){
            return true;
        }
        else{
            return false;
        }
    }

    public void siparisiAl(garson garson) { //Burası hatalı olabilir
        try{
            yemekler.add(garson);
            if(y1 == null){
                y1 = new yemek(this, garson);
            }
            else if(y2 == null){
                y2 = new yemek(this, garson);
            }
        }
        catch(Exception e){

        }
    }

    public void yemekYap() {
        
    }

    @Override
    public void run(){

    }

}
