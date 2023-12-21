import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class asci implements Runnable {
    
    private String name;
    private ArrayList<yemek> yemekler = new ArrayList<yemek>();
    private int yapilanAktifYemek = 0;
    ExecutorService yemekExec = Executors.newFixedThreadPool(2);
    private Document d;

    public asci(String name) {
        this.name = name;
        System.out.println(name + " oluşturuldu !\n");
    }

    public String getName() {
        return this.name;
    }

    public boolean asciUygunmu() {
        if(yemekler.size() < 2) {
            return true;
        }
        else{
            return false;
        }
    }

    public void siparisiAl(yemek yemek) {
        try{
            this.yemekler.add(yemek);
            System.out.println(this.yemekler);
            this.yapilanAktifYemek++;
        }
        catch(Exception e){

        }
    }

    public void yemekYap(yemek yemek) {
        this.yemekExec.submit(yemek);
        yemek.getGarson().siparisHAzır();
        System.out.println(yemek.getAsci().getName() + ", " + yemek.getGarson().getName()  +"'un yemegini pisirdi");
        this.yemekler.remove(yemek);
        this.yapilanAktifYemek--;
    }

    @Override
    public void run(){
        while(true){
            System.out.println(Yemekler());
            if(!Yemekler().isEmpty()) {
                yemekYap(Yemekler().get(0));
            }
        }
    }

    public ArrayList<yemek> Yemekler() {
        return this.yemekler;
    }

}
