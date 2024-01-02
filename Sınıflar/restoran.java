import java.util.ArrayList;
import java.util.Collections;

public class restoran {
    
    private int asciSayi;
    private int masaSayi;
    private int garsonSayi;
    private int musteriSayi;
    private int oncelikliMusteriSayisi;
    private kompakt k = new kompakt();
    private ArrayList<musteri> siraListesi = new ArrayList<musteri>();
    private ArrayList<musteri> hesapSirasi = new ArrayList<musteri>();
    private ArrayList<musteri> restorandanCikanlar = new ArrayList<musteri>();

    public ArrayList<musteri> musteriler = new ArrayList<musteri>();
    public ArrayList<asci> ascilar = new ArrayList<asci>();
    public ArrayList<garson> garsonlar = new ArrayList<garson>();
    public ArrayList<masa> masalar = new ArrayList<masa>();
    public kasaelemani kasaElemani = new kasaelemani("KasaElemanı1",this);

    Document d = new Document();

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
        k.siradaBekleyenleriGuncelle(this.siraListesi);
    }

    public synchronized void siradanCikart(musteri musteri){
       int index = this.siraListesi.indexOf(musteri);
       this.siraListesi.remove(index);
       k.siradaBekleyenleriGuncelle(this.siraListesi);
    }

    public synchronized int siramNe(musteri musteri){
        return this.siraListesi.indexOf(musteri);
    }

    public synchronized boolean SiparisiSunulduMu(musteri musteri) {
        return musteri.SiparisSunulduMu();
    }

    public synchronized void sirayiDüzelt(){
        for(int i = 0; i < this.siraListesi.size(); i++ ){
            for(int j = i + 1; j < this.siraListesi.size(); j++ ){
                if(!this.siraListesi.get(i).onceliklimi() && this.siraListesi.get(j).onceliklimi()) {
                    Collections.swap(siraListesi, i, j);//indislerdeki müşterilerin yerlerini değiştiriyor
                }
            }
        }
    }

    public synchronized boolean musterigarsonEslestir(garson garson) {
        for (masa m : this.masalar) {
            if(!m.uygunmu()) {
                for (musteri musteri : this.musteriler) {
                    if(musteri.getMasa() == m && m.getMusteri() == musteri) {
                        if(!musteri.garsonAtalımı()) {
                            try{
                                musteri.garsonAtama(garson);
                                garson.musteriAta(musteri);
                                System.out.println(garson.getName() + ", " + musteri.getName() + " ile ilgilenicek");
                                d.yazdir(garson.getName() + ", " + musteri.getName() + " ile ilgilenicek");
                            }catch(Exception e) {

                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public synchronized boolean ascisiparisEslestir(garson garson) {
        for (asci asci : this.ascilar) {
            if(asci.asciUygunmu()) {
                asci.siparisiAl(new yemek(asci,garson,asci.getRestoran()));
                System.out.println(asci.getName() + ", " + garson.getName() + " siparisini yapmaya basladı");
                d.yazdir(asci.getName() + ", " + garson.getName() + " siparisini yapmaya basladı");
                return true;
            }
        }
        return false;
    }

    public synchronized boolean siparisimVarMı(asci asci) {
        if(!asci.SiparisListesi().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public yemek siparisYemeginiVer(asci asci) {
        yemek y  = asci.SiparisListesi().get(0);
        asci.decreaseYapilanAktifYemek();
        return y;
    }

    public synchronized void siparisiListedenCikart(yemek yemek) {
        asci asci = yemek.getAsci();
        ArrayList<yemek> yemeks = asci.SiparisListesi();
        yemeks.remove(yemek);
        asci.SiparisListesiniGüncelle(yemeks);
    }

    public synchronized void RestorandanCiktimGardasim(musteri musteri) {
        this.restorandanCikanlar.add(musteri);
        if(restorandanCikanlar.size() == this.musteriSayi) {
            System.out.println("RESTORANDA HİÇ MÜŞTERİ KALMADI");
            d.yazdir("RESTORANDA HİÇ MÜŞTERİ KALMADI");
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

    public void startAll(ArrayList<Thread> allThreads) {
        for (Thread thread : allThreads) {
            thread.start();
        }
    }
}
