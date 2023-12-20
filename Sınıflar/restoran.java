import java.util.ArrayList;
import java.util.Collections;


public class restoran {
    
    private int asciSayi;
    private int masaSayi;
    private int garsonSayi;
    private int musteriSayi;
    private int oncelikliMusteriSayisi;
    private volatile ArrayList<musteri> siraListesi = new ArrayList<musteri>();
    private volatile ArrayList<musteri> hesapSirasi = new ArrayList<musteri>();

    public ArrayList<musteri> musteriler = new ArrayList<musteri>();
    public ArrayList<asci> ascilar = new ArrayList<asci>();
    public ArrayList<garson> garsonlar = new ArrayList<garson>();
    public ArrayList<masa> masalar = new ArrayList<masa>();
    public kasaelemani kasaElemani = new kasaelemani("KasaElemanı1",this);


    public restoran(int asciSayi,int masaSayi,int garsonSayi,int musteriSayi,int oncelikliMusteriSayisi){
        this.asciSayi = asciSayi;
        this.masaSayi = masaSayi;
        this.garsonSayi = garsonSayi;
        this.musteriSayi = musteriSayi;
        this.oncelikliMusteriSayisi = oncelikliMusteriSayisi;
    }

    public synchronized int hesapSiramNe(musteri musteri){
        return this.hesapSirasi.indexOf(musteri);
    }

    public synchronized void hesapSirasindanCik(musteri musteri){
        this.hesapSirasi.remove(musteri);
    }

    public synchronized void hesapSirasinaGir(musteri musteri){
        this.hesapSirasi.add(musteri);
    }

    public synchronized void sirayaEkle(musteri musteri){
        this.siraListesi.add(musteri);
        sirayiDüzelt();
    }

    public synchronized void siradanCikart(musteri musteri){
       int index = this.siraListesi.indexOf(musteri);
       this.siraListesi.remove(index);
    }

    public synchronized int siramNe(musteri musteri){
        return this.siraListesi.indexOf(musteri);
    }

    public synchronized void sirayiDüzelt(){
        for(int i = 0; i < this.siraListesi.size(); i++ ){
            for(int j = i + 1; j < this.siraListesi.size(); j++ ){
                if(!this.siraListesi.get(i).onceliklimi() && this.siraListesi.get(j).onceliklimi()){
                    Collections.swap(siraListesi, i, j);//indislerdeki müşterilerin yerlerini değiştiriyor
                }
            }
        }
    }

    public int getOncelikliSayi(){
        return this.oncelikliMusteriSayisi;
    }

    public int getasciSayi(){
        return this.asciSayi;
    }
    
    public int getmasaSayi(){
        return this.masaSayi;
    }

    public int getgarsonSayi(){
        return this.garsonSayi;
    }

    public int getmusteriSayi(){
        return this.musteriSayi;
    }

    public void startAll(ArrayList<Thread> allThreads){
        for (Thread thread : allThreads) {
            thread.start();
        }
    }
}
