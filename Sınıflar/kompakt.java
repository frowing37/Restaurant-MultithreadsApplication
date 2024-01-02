import java.util.ArrayList;

public class kompakt {
    
    public kompakt() { }

    private static TryFrame t = new TryFrame();

    public synchronized void siradaBekleyenleriGuncelle(ArrayList<musteri> siradaBekleyenler) {
        ArrayList<String> siradaBekleyenlerIsimListesi = new ArrayList<String>();
        for (musteri musteri : siradaBekleyenler) {
            siradaBekleyenlerIsimListesi.add(musteri.getName());
        }
        t.siradaBekleyenleriGuncelle(siradaBekleyenlerIsimListesi);
    }

    public synchronized void garsonlariGuncelle(ArrayList<garson> garsonlar) {
        ArrayList<String> garsonlarIsimListesi = new ArrayList<String>();
        for (garson g : garsonlar) {
            if(g.getMusteri() != null) {
                garsonlarIsimListesi.add(" - " + g.getName() + " " + g.getMusteri().getName());
            } else {
                garsonlarIsimListesi.add(" - " + g.getName() + " Boş");
            }
        }
        t.garsonlariGuncelle(garsonlarIsimListesi);
    }

    public synchronized void ascilariGuncelle(ArrayList<asci> ascilar) {
        ArrayList<String> ascilarIsimListesi = new ArrayList<String>();
        for (asci a : ascilar) {
            if(a.SiparisListesi().size() == 2) {
                ascilarIsimListesi.add(" - " + a.getName() + "  " + a.SiparisListesi().get(0).getGarson().getName() + " " + a.SiparisListesi().get(1).getGarson().getName());
            } else if(a.SiparisListesi().size() == 1) {
                ascilarIsimListesi.add(" - " + a.getName() + a.SiparisListesi().get(0).getGarson().getName());
            } else {
                ascilarIsimListesi.add(" - " + a.getName() + " Boşta");
            }
        }
        t.ascilariGuncelle(ascilarIsimListesi);
    }

    public synchronized void masalariGuncelle(ArrayList<masa> masalar) {
        ArrayList<String> masalarDurumListesi = new ArrayList<String>();
        for (masa m : masalar) {
            if(m.uygunmu()) {
                masalarDurumListesi.add("Boş");
            } else {
                masalarDurumListesi.add(m.getMusteri().getName());
            }
        }
        t.masaDurumlariniGuncelle(masalarDurumListesi);
    }

    public synchronized void kasaSirasiniGuncelle(ArrayList<musteri> kasaSirasi) {
        ArrayList<String> kasasiraIsimListesi = new ArrayList<String>();
        for (musteri m : kasaSirasi) {
            kasasiraIsimListesi.add(m.getName());            
        }
        t.kasaSirasiGuncelle(kasasiraIsimListesi);
    }
}
