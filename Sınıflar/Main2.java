import javax.swing.SwingUtilities;

public class Main2 {
    public static void main(String[] args) {

        TryFrame pencere = new TryFrame();
        kompakt k = new kompakt();

        restoran r = new restoran(2, 6, 3, 10,4);

        SwingUtilities.invokeLater(() -> {
        pencere.SimulasyonPenceresi(r);
        } );

        while(true) {
                try {
                    k.siradaBekleyenleriGuncelle(r.getSiraListesi());
                    k.ascilariGuncelle(r.getAsciListesi());
                    k.garsonlariGuncelle(r.getGarsonListesi());
                    k.kasaSirasiniGuncelle(r.getHesapSiraListesi());
                    k.masalariGuncelle(r.getMasaListesi());
                } catch(Exception e) {

                }
            }
    }
}
