import java.beans.Expression;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Random;

import org.xml.sax.HandlerBase;

public class musteri implements Runnable {
    
    Random rand = new Random();

    public musteri(String name,restoran r){
        this.name = name;
        this.r = r;
        this.ID = rand.nextInt(100000,1000000);
        System.out.println(this.name + " " + this.ID + " ID ile oluşturuldu !\n");
    }

    private String name;
    private int ID;
    private restoran r;
    private boolean siparis = false;
    private masa masa;
    private boolean oncelik = false;
    private boolean hesapDurum = false;
    private boolean yemek = false;
    private int siraBeklemeSuresi = 0;
    private int maxsiraBeklemeSuresi = 20;

    public String getName(){
        return this.name;
    }

    public int getID(){
        return this.ID;
    }

    public void setSiparis(){
        this.siparis = true;
    }

    public void oncelikliyap(){
        this.oncelik = true;
    }

    public boolean onceliklimi(){
        return this.oncelik;
    }

    public void restoranaGir(){
        System.out.println(name+" Restorana girdi");
        r.sirayaEkle(this);
    }

    public boolean bosMasa(){
        if(r.siramNe(this) == 0){
            for (masa m : r.masalar) {
                if(m.uygunmu()){
                    masayaOtur(m);
                    return true;
                }
            }
            return false;
        }
        else{
            return false;
        }
    }

    public void siraBekle(){
        try{
            Thread.sleep(1000);
            siraBeklemeSuresi++;
        }
        catch(Exception e){

        }
    }

    public void masayaOtur(masa masa){
        this.masa = masa;
        masa.doldur();
        System.out.println(name + " " + this.masa.getName() + "'e oturdu\n");
                    
    }

    public void restorandanCik(){
        this.masa.bosalt();
    }

    public boolean restoraniTerket(){
        r.siradanCikart(this);
        return false;
    }

    public void yeUlan(){
        try{
            this.yemek = true;
            Thread.sleep(2000);
            r.hesapSirasinaGir(this);
        }
        catch(Exception e){

        }
    }

    public boolean hesapOde(){
        if(r.hesapSiramNe(this) == 0){
            try{
                Thread.sleep(1000);
                //this.hesapDurum = true; BU DEĞERİ KASA ELEMANI DEĞİŞTİRİCEK 
                r.hesapSirasindanCik(this);
                return true;
            }
            catch(Exception e){

            }
        }
        return false;
    }

    @Override
    public void run() {
        int sira = 0;
        boolean sart = true;
        while(sart){
            switch(sira){
                case 0:
                restoranaGir();
                sira++;
                break;

                case 1:
                if(!bosMasa()){
                    siraBekle();
                }
                if(this.siraBeklemeSuresi == this.maxsiraBeklemeSuresi){
                    sart = restoraniTerket();
                }
                else{
                    sira++;
                }
                break;

                case 2:
                if(siparis){
                    sira++;
                }
                break;
                
                case 3:
                yeUlan();
                sira++;
                break;

                case 4:
                if(hesapOde()){
                    sira++;
                }
                break;

                case 5:
                restorandanCik();
                sart = false;
                break;
            }
        }
        
    }
}   