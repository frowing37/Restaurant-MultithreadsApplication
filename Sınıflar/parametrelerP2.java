public class parametrelerP2  {
    
    //Süreler
    private int musteriMaxBeklemeSuresi = 20;
    private int musteriYemekYemeSuresi = 3;
    private int musteriGelmeAraligi;
    private int musteriGelmeSayisiAralikta;
    private int garsonSiparisAlmaSuresi = 2;
    private int kasaHesapAlmaSuresi = 1;
    private int asciYemekPisirmeSuresi = 3;
    private int simulasyonSuresi;

    //Maliyetler & Kazançlar
    private int maliyetMasa = -1;
    private int maliyetGarson = -1;
    private int maliyetAsci = -1;
    private int kazancMusteri = 1;

    //Başlangıç
    private int gelicekMusteriSayisi;

    public parametrelerP2(int simulasyonSuresi, int musteriGelmeAraligi, int musteriGelmeSayisiAralikta, int gelicekMusteriSayisi) {
        this.simulasyonSuresi = simulasyonSuresi;
        this.musteriGelmeAraligi = musteriGelmeAraligi;
        this.musteriGelmeSayisiAralikta = musteriGelmeSayisiAralikta;
        this.gelicekMusteriSayisi = gelicekMusteriSayisi;
    }

    public int getmaliyetMasa() {
        return this.maliyetMasa;
    }

    public int getmaliyetGarson() {
        return this.maliyetGarson;
    }

    public int getmaliyetAsci() {
        return this.maliyetAsci;
    }

    public int getkazancMusteri() {
        return this.kazancMusteri;
    }
    
    public int getmusteriMaxBeklemeSuresi() {
        return this.musteriMaxBeklemeSuresi;
    }

    public int getmusteriYemekYemeSuresi() {
        return this.musteriYemekYemeSuresi;
    }

    public int getmusteriGelmeAraligi() {
        return this.musteriGelmeAraligi;
    }

    public int getmusteriGelmeSayisiAralikta() {
        return this.musteriGelmeSayisiAralikta;
    }

    public int getgarsonSiparisAlmaSuresi() {
        return this.garsonSiparisAlmaSuresi;
    }

    public int getkasaHesapAlmaSuresi() {
        return this.kasaHesapAlmaSuresi;
    }

    public int getasciYemekPisirmeSuresi() {
        return this.asciYemekPisirmeSuresi;
    }

    public int getsimulasyonSuresi() {
        return this.simulasyonSuresi;
    }

    public int getgelicekMusteriSayisi() {
        return this.gelicekMusteriSayisi;
    }

}