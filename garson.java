public class garson implements Runnable {
    
    public garson(String name,restoran r){
        this.name = name;
        this.r = r;
        System.out.println(name + " oluşturuldu !\n");
    }

    public String getName(){
        return this.name;
    }

    private String name;
    private boolean musteri = false;
    private boolean siparisHazır = false;
    private musteri _musteri;
    private restoran r;

    public void servisYap() {
        this.siparisHazır = true;
    }

    public boolean musteriyiKap(musteri musteri) {
        for (musteri m : r.musteriler) {
            if(m.garsonAtalımı()) {
                m.garsonAtama();
                this._musteri = musteri;
                return true;
            }
        }
        return false;
    }

    public void siparisAl(){
        try{
            Thread.sleep(2000);
            _musteri.setSiparis();
        }
        catch(Exception e){

        }
    }

    public void asciyaVer() {
        for (asci a : r.ascilar) {
            if(a.asciUygunmu()){
                a.siparisiAl(this);
            }
        }
    }

    public bool siparisHazırmı(){
        
    }

    @Override
    public void run(){

        boolean sart = true;
        int sira = 0;

        while(sart){
            switch(sira){
                case 0:
                if(musteriyiKap(_musteri)){
                    sira++;
                }                
                break;
                
                case 1:
                siparisAl();
                sira++;
                break;

                case 2:
                asciyaVer();
                break;

                case 3:
                break;
            }
        }

    }
}
