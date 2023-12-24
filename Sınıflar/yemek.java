public class yemek implements Runnable {
    
    private asci a;
    private garson g;
    private boolean aktiflik = true;
    private restoran r;

    public yemek(asci a,garson g, restoran r) {
        this.a = a;
        this.g = g;
        this.r = r;
    }

    public asci getAsci() {
        return this.a;
    }

    public garson getGarson() {
        return this.g;
    }

    public boolean aktifMi(){
        return this.aktiflik;
    }

    public void setDeaktif() {
        this.aktiflik = false;
    }

    public void pistimListedenCikiyorum() {
        asci a = getAsci();
        a.SiparisListesindenCikart(this);
    }

    @Override
    public void run() {
        try{
            if(aktifMi()) {
                 Thread.sleep(3000);
                 getGarson().siparisHAzır();
                 r.siparisiListedenCikart(this);
                 this.aktiflik = false;
                 System.out.println(getAsci().getName() + ", " + getGarson().getName()  +"'un yemegini pisirdi");
            } else {
                System.out.println("YEMEK LİSTEDEN ÇIKMADI");
            }
        }catch(Exception e){

        }
    }
}
