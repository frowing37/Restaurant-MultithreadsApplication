public class garson implements Runnable {
    
    public garson(String name,restoran r) {
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

    public void siparisHAzır() {
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

    public boolean siparisHazırmı(){
        return this.siparisHazır;
    }

    @Override
    public void run(){
        
        int sira = 0;

        while(true){
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
                if(siparisHazırmı()) {
                    sira++;
                }
                break;

                case 4:
                _musteri.siparisSunum();
                sira++;
                break;

                case 5:
                if(_musteri.odedinMiLan()){
                    _musteri = null;
                    musteri = false;
                    sira = 0;
                }
                break;
            }
        }

    }
}
