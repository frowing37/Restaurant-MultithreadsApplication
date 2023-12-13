public class restoran {
    
    private int asciSayi;
    private int masaSayi;
    private int garsonSayi;
    private int musteriSayi;

    public restoran(int asciSayi,int masaSayi,int garsonSayi,int musteriSayi){
        this.asciSayi = asciSayi;
        this.masaSayi = masaSayi;
        this.garsonSayi = garsonSayi;
        this.musteriSayi = musteriSayi;
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
}
