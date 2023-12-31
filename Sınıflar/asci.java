import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class asci implements Runnable {
    
    private String name;
    private ArrayList<yemek> yemekler = new ArrayList<yemek>();
    private int yapilanAktifYemek = 0;
    ExecutorService yemekExec = Executors.newFixedThreadPool(2);
    private Document d = new Document();
    private restoran r;

    public asci(String name, restoran r) {
        this.name = name;
        this.r = r;
        System.out.println(getName() + " oluşturuldu !");
        d.yazdir(getName() + " oluşturuldu !");
    }

    public String getName() {
        return this.name;
    }

    public restoran getRestoran() {
        return this.r;
    }

    public boolean asciUygunmu() {
        if(yemekler.size() < 2  && this.yapilanAktifYemek < 2) {
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<yemek> SiparisListesi() {
        return this.yemekler;
    }

    public void SiparisListesiniGüncelle(ArrayList<yemek> yemeklerGuncel) {
        this.yemekler = yemeklerGuncel;
    }

    public void SiparisListesindenCikart(yemek yemek) {
        this.yemekler.remove(yemek);
    }

    public void decreaseYapilanAktifYemek() {
        this.yapilanAktifYemek--;
    }

    public void siparisiAl(yemek yemek) {
        if(this.yemekler.size() < 2) {
                if(this.yapilanAktifYemek < 2) {
                    this.yemekler.add(yemek);
                    this.yapilanAktifYemek++;
                }
            }
    }

    public void yemekYap(yemek yemek) {
        yemek.run();
    }

    @Override
    public void run() {
        boolean still = true;

        while(still) {
            try {
                if(r.siparisimVarMı(this)) {
                yemekYap(r.siparisYemeginiVer(this));
                }
            } catch(Exception e) {

            }
        }
    }

}
