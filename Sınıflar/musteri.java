import java.util.Random;

public class musteri implements Runnable {
    
    Random rand = new Random();

    public musteri(String name,restoran r) {
        this.name = name;
        this.r = r;
        this.ID = rand.nextInt(100000,1000000);
        System.out.println(this.name + " oluşturuldu !");
    }

    private String name;
    private int ID;
    private restoran r;
    private boolean siparisAlindi = false;
    private boolean siparisHazır = false;
    private masa masa;
    private boolean oncelik = false;
    private boolean hesapDurum = false;
    private boolean yemek = false;
    private boolean garsonAtaması = false;
    private garson _garson;
    private int siraBeklemeSuresi = 0;
    private int maxsiraBeklemeSuresi = 20;
    private boolean bitti = false;
    private Document d;

    public String getName(){
        return this.name;
    }

    public int getID(){
        return this.ID;
    }

    public masa getMasa(){
        return this.masa;
    }

    public void restorandaIsımBitti() {
        this.bitti = true;
    }

    public boolean ciktinMi() {
        return this.bitti;
    }

    public void siparisSunum(){
        this.siparisHazır = true;
    }

    public boolean SiparisSunulduMu() {
        return this.siparisHazır;
    }

    public void sethesapDurum(){
        this.hesapDurum = true;
    }

    public boolean garsonAtalımı(){
        return this.garsonAtaması;
    }

    public void garsonAtama(garson garson) {
        this.garsonAtaması = true;
                this._garson = garson;
    }

    public void setSiparis() {
        this.siparisAlindi = true;
    }

    public void oncelikliyap(){
        this.oncelik = true;
    }

    public boolean onceliklimi(){
        return this.oncelik;
    }

    public void restoranaGir(){
        System.out.println(getName() + " restorana girdi");
        r.sirayaEkle(this);
    }

    public boolean bosMasa(){
        if(r.siramNe(this) == 0){
            for (masa m : r.masalar) {
                if(m.uygunmu()){
                    masayaOtur(m);
                    r.siradanCikart(this);
                    return true;
                }
            }
            return false;
        }
        else{
            return false;
        }
    }

    public void siraBekle(){
        try{
            Thread.sleep(1000);
            //System.out.println(this.name + " " + r.siramNe(this)  + ". sırada bekliyor");
            siraBeklemeSuresi++;
        }
        catch(Exception e){

        }
    }

    public void masayaOtur(masa masa){
        this.masa = masa;
        masa.doldur(this);
        System.out.println(name + " " + this.masa.getName() + "'e oturdu");
                    
    }

    public void restorandanCik(){
        this.masa.bosalt();
        System.out.println(name + " restorandan çıktı");
        r.RestorandanCiktimGardasim(this);
    }

    public boolean restoraniTerket(){
        r.siradanCikart(this);
        System.out.println(name + " restoranı terk etti");
        r.RestorandanCiktimGardasim(this);
        return false;
    }

    public void yeUlan(){
        try{
            this.yemek = true;
            Thread.sleep(2000);
            System.out.println(getName() + " yemeğini yedi");
            r.hesapSirasinaGir(this);
        }
        catch(Exception e){

        }
    }

    public boolean hesapOde(){
        if(r.hesapSiramNe(this) == 0){
            try{
                r.kasaElemani.hesapAl(this);
                return true;
            }
            catch(Exception e){

            }
        }
        return false;
    }

    public boolean odedinMiLan(){
        return this.hesapDurum;
    }

    @Override
    public synchronized void run() {
        int sira = 0;
        boolean sart = true;
        while(sart) {
            switch(sira) {
                case 0:
                restoranaGir();
                sira++;
                break;

                case 1:
                if(!bosMasa()) {
                    siraBekle();
                    if(this.siraBeklemeSuresi == this.maxsiraBeklemeSuresi) {
                    sart = restoraniTerket();
                    }
                } else {
                    sira++;
                }
                break;

                case 2:
                if(r.SiparisiSunulduMu(this)) {
                    sira++;
                }
                break;
                
                case 3:
                yeUlan();
                sira++;
                break;

                case 4:
                if(hesapOde()) {
                    sira++;
                }
                break;

                case 5:
                restorandanCik();
                sart = false;
                break;
            }
        }
        
    }
}   