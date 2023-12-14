import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;


public class restoran {
    
    private int asciSayi;
    private int masaSayi;
    private int garsonSayi;
    private int musteriSayi;
    private int oncelikliMusteriSayisi;
    private static ArrayList<musteri> siraListesi = new ArrayList<musteri>();
    private static ArrayList<musteri> hesapSirasi = new ArrayList<musteri>();

    public static ArrayList<musteri> musteriler = new ArrayList<musteri>();
    public static ArrayList<asci> ascilar = new ArrayList<asci>();
    public static ArrayList<garson> garsonlar = new ArrayList<garson>();
    public static ArrayList<masa> masalar = new ArrayList<masa>();

    public restoran(int asciSayi,int masaSayi,int garsonSayi,int musteriSayi,int oncelikliMusteriSayisi){
        this.asciSayi = asciSayi;
        this.masaSayi = masaSayi;
        this.garsonSayi = garsonSayi;
        this.musteriSayi = musteriSayi;
        this.oncelikliMusteriSayisi = oncelikliMusteriSayisi;
    }

    public int hesapSiramNe(musteri musteri){
        return this.hesapSirasi.indexOf(musteri);
    }

    public void hesapSirasindanCik(musteri musteri){
        this.hesapSirasi.remove(musteri);
    }

    public void hesapSirasinaGir(musteri musteri){
        this.hesapSirasi.add(musteri);
    }

    public void sirayaEkle(musteri musteri){
        this.siraListesi.add(musteri);
        sirayiDüzelt();
    }

    public void siradanCikart(musteri musteri){
       int index = this.siraListesi.indexOf(musteri);
       this.siraListesi.remove(index);
    }

    public int siramNe(musteri musteri){
        return this.siraListesi.indexOf(musteri);
    }

    public void sirayiDüzelt(){
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
