import java.util.ArrayList;

public class kompakt {
    
    public kompakt() {}

    public static synchronized void siradaBekleyenleriGuncelle(ArrayList<musteri> siradaBekleyenler) {
        ArrayList<String> siradaBekleyenlerIsimListesi = new ArrayList<String>();
        for (musteri musteri : siradaBekleyenler) {
            siradaBekleyenlerIsimListesi.add(musteri.getName());
        }
        TryFrame a = new TryFrame();
        a.siradaBekleyenleriGuncelle(siradaBekleyenlerIsimListesi);
    }

    public synchronized void garsonlariGuncelle() {

    }

    public synchronized void ascilariGuncelle() {

    }

    public synchronized void masalariGuncelle() {

    }

    public synchronized void kasaSirasiniGuncelle() {

    }
}
