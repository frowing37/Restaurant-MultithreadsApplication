
public class garson implements Runnable {
    
    public garson(String name,restoran r) {
        this.name = name;
        this.r = r;
        System.out.println(name + " oluşturuldu !");
    }

    public String getName(){
        return this.name;
    }

    private String name;
    //private boolean musteri = false;
    private boolean siparisHazır = false;
    private musteri _musteri;
    private restoran r;
    private Document d;


    public void siparisHAzır() {
        this.siparisHazır = true;
    }

    public void musteriAta(musteri musteri) {
        this._musteri = musteri;
    }

    public void musteridenBosan() {
        this._musteri = null;
        System.out.println(getName() + ", yeni bir musteri icin hazir");
    }

    public musteri getMusteri() {
        return this._musteri;
    }

    public void siparisAl(){
        try{
            Thread.sleep(2000);
            _musteri.setSiparis();
            System.out.println(this.name + " " + this._musteri.getName() + "'in siparisini aldı" );
        }
        catch(Exception e){
            
        }
    }

    public boolean siparisHazırmı() {
        return this.siparisHazır;
    }

    @Override
    public void run(){
        int sira = 0;
        while(true){
            switch(sira) {
                case 0:
                if(r.musterigarsonEslestir(this)) {
                    sira++;
                }                
                break;
                
                case 1:
                siparisAl();
                sira++;
                break;

                case 2:
                if(r.ascisiparisEslestir(this)) {
                    sira++;
                }
                break;

                case 3:
                if(siparisHazırmı()) {
                    sira++;
                }
                break;

                case 4:
                _musteri.siparisSunum();
                System.out.println(getName() + ", " + getMusteri().getName() + "'in siparisini servis ediyor.");
                sira++;
                break;

                case 5:
                if(_musteri.odedinMiLan()) {
                    musteridenBosan();
                    sira = 0;
                }
                break;
            }
        }

    }
}
