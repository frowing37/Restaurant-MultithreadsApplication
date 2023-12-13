import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args){
        
        //Baslangic değerlerinin girilmesi
        restoran r = new restoran(2, 6, 3, 10,4);
        Random random = new Random();

        //Kullanılıcak nesnelerin oluşturulması
        ArrayList<musteri> musteriler = new ArrayList<musteri>();
        ArrayList<asci> ascilar = new ArrayList<asci>();
        ArrayList<garson> garsonlar = new ArrayList<garson>();
        ArrayList<masa> masalar = new ArrayList<masa>();

        int ref = 0;
        while(true){
            if(ref < r.getasciSayi()){
                ascilar.add(new asci("Aşçı"+ref));
            }
            if(ref < r.getmusteriSayi()){
                musteriler.add(new musteri("Müşteri"+ref));
            }
            if(ref < r.getgarsonSayi()){
                garsonlar.add(new garson("Garson"+ref));
            }
            if(ref < r.getmasaSayi()){
                masalar.add(new masa("Masa"+ref));
            }
            if(ref > 10){
                ref = 0;
                break;
            }
            ref++;
        }
        kasaelemani kasaElemani = new kasaelemani("KasaElemanı1");

        //Öncelikli olan müşterilerin rastgele atanması
        while(true){
            if(ref <= r.getOncelikliSayi()){
                int rand = random.nextInt(10);
                musteriler.get(rand).oncelikliyap();
            }
            else{
                ref = 0;
                break;
            }
        }

        //Kullanılıcak threadlerin oluşturulması
        ArrayList<Thread> musterilerT = new ArrayList<Thread>();
        ArrayList<Thread> ascilarT = new ArrayList<Thread>();
        ArrayList<Thread> garsonlarT = new ArrayList<Thread>();
        ArrayList<Thread> main = new ArrayList<Thread>();

        for(int i=0; i< r.getmusteriSayi(); i++){
            musterilerT.add(new Thread(musteriler.get(i)));
        }

        for(int i=0; i< r.getgarsonSayi(); i++){
            garsonlarT.add(new Thread(garsonlar.get(i)));
        }

        for(int i=0; i< r.getasciSayi(); i++){
            ascilarT.add(new Thread(ascilar.get(i)));
        }
        Thread kasaElemaniT1 = new Thread(kasaElemani);

        //Toplu başlatmak için threadleri bir listeye topladık
        main.addAll(musterilerT);
        main.addAll(ascilarT);
        main.addAll(garsonlarT);
        main.add(kasaElemaniT1);

        r.startAll(main);

    }
}