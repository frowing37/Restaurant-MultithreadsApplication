import java.util.concurrent.locks.ReentrantLock;

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
    private Document d;
    private final ReentrantLock lock = new ReentrantLock();


    public void siparisHAzır() {
        this.siparisHazır = true;
    }

    public synchronized boolean musteriyiKap() {
        for (masa m : r.masalar) {
            if(!m.uygunmu()) {
                for (musteri mu : r.musteriler) {
                    if(mu.getMasa() == m && m.getMusteri() == mu) {
                        if(!mu.garsonAtalımı()) {
                            lock.lock();
                            try{
                                mu.garsonAtama(this);
                                this._musteri = mu;
                                System.out.println(this.name + ", " + mu.getName() + " ile ilgilenicek");
                            }finally{
                                lock.unlock();
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
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

    public boolean asciyaVer() {
        for (asci a : r.ascilar) {
            if(a.asciUygunmu()) {
                a.siparisiAl(new yemek(a, this));
                System.out.println(a.getName() + ", " + this.name + " siparisini yapmaya basladı");
                return true;
            }
        }
        return false;
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
                if(musteriyiKap()){
                    sira++;
                }                
                break;
                
                case 1:
                siparisAl();
                sira++;
                break;

                case 2:
                if(asciyaVer()) {
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
