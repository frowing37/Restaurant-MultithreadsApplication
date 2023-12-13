import java.util.ArrayList;

public class restoran {
    
    private int asciSayi;
    private int masaSayi;
    private int garsonSayi;
    private int musteriSayi;
    private int oncelikliMusteriSayisi;

    public restoran(int asciSayi,int masaSayi,int garsonSayi,int musteriSayi,int oncelikliMusteriSayisi){
        this.asciSayi = asciSayi;
        this.masaSayi = masaSayi;
        this.garsonSayi = garsonSayi;
        this.musteriSayi = musteriSayi;
        this.oncelikliMusteriSayisi = oncelikliMusteriSayisi;
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
