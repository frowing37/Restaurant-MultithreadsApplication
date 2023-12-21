public class masa {

    private boolean uygun = true;
    private musteri _musteri = null;
    private String name;

    public masa(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public musteri getMusteri(){
        if(this._musteri != null){
            return this._musteri;
        }
        else{
            return null;
        }
    }

    public synchronized boolean uygunmu(){
        return uygun;
    }

    public synchronized void doldur(musteri musteri){
        this.uygun = false;
        this._musteri = musteri;
    }

    public synchronized void bosalt(){
        this.uygun = true;
        this._musteri = null;
    }
}
