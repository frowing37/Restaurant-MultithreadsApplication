import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args){

        //TryFrame pencere = new TryFrame();
        //Document doküman = new Document();

        //pencere.AnaMenu();
        //doküman.yazdir("gardaş sakin la");

        //Baslangic değerlerinin girilmesi
        restoran r = new restoran(2, 6, 3, 10,4);
        ExecutorService musteriExec = Executors.newFixedThreadPool(r.getmusteriSayi());
        ExecutorService garsonExec = Executors.newFixedThreadPool(r.getgarsonSayi());
        ExecutorService asciExec = Executors.newFixedThreadPool(r.getasciSayi());
        Random random = new Random();

        int ref = 0;
        while(true) {
            if(ref < r.getasciSayi()){
                r.ascilar.add(new asci("Aşçı"+ref,r));
            }
            if(ref < r.getmusteriSayi()){
                r.musteriler.add(new musteri("Müşteri"+ref, r));
            }
            if(ref < r.getgarsonSayi()){
                r.garsonlar.add(new garson("Garson"+ref, r));
            }
            if(ref < r.getmasaSayi()){
                r.masalar.add(new masa("Masa"+ref));
            }
            if(ref > 10){
                ref = 0;
                break;
            }
            ref++;
        }

        //Öncelikli olan müşterilerin rastgele atanması
        while(true){
            if(ref <= r.getOncelikliSayi()) {
                int rand = random.nextInt(10);
                r.musteriler.get(rand).oncelikliyap();
            }
            else{
                ref = 0;
                break;
            }
            ref++;
        }


        for (musteri m : r.musteriler) {
            musteriExec.submit(m);            
        }
        for (garson g : r.garsonlar) {
            garsonExec.submit(g);
        }
        for (asci a : r.ascilar) {
            asciExec.submit(a);
        }
        Thread kasaElemaniT = new Thread(r.kasaElemani);

        musteriExec.shutdown();
        garsonExec.shutdown();
        asciExec.shutdown();
        kasaElemaniT.start();



        try{
            musteriExec.awaitTermination(50, TimeUnit.SECONDS);
            garsonExec.awaitTermination(50, TimeUnit.SECONDS);
            asciExec.awaitTermination(50, TimeUnit.SECONDS);
        }catch(Exception e){

        }

    }
}