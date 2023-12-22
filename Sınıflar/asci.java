import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class asci implements Runnable {
    
    private String name;
    private volatile ArrayList<yemek> yemekler = new ArrayList<yemek>();
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
        if(yemekler.size() < 2  && this.yapilanAktifYemek != 2) {
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<yemek> SiparisListesi() {
        return this.yemekler;
    }

    public void siparisiAl(yemek yemek) {
        try{
            if(this.yemekler.size() < 2){
                if(this.yapilanAktifYemek < 2){
                    this.yemekler.add(yemek);
                    this.yapilanAktifYemek++;
                }
            }
        }
        catch(Exception e){

        }
    }

    public void yemekYap(yemek yemek) {
        this.yemekExec.submit(yemek);
        this.yemekler.remove(yemek);
        this.yapilanAktifYemek--;
    }

    public void donUlanAsci() {
        boolean still = true;

        while(still) {
            if(!this.yemekler.isEmpty() && yapilanAktifYemek < 2) {
                yemekYap(this.yemekler.get(0));
            }
        }
    }

    @Override
    public void run() {
        donUlanAsci();
    }

}
