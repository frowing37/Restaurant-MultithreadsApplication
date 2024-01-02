public class yemek implements Runnable {
    
    private asci a;
    private garson g;
    private boolean aktiflik = true;
    private restoran r;
    private Document d = new Document();

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
                 r.siparisiListedenCikart(this);
                 this.aktiflik = false;
                 System.out.println(getAsci().getName() + ", " + getGarson().getName()  +"'un yemegini pisirdi");
                 d.yazdir(getAsci().getName() + ", " + getGarson().getName()  +"'un yemegini pisirdi");
                 getGarson().siparisHAzır();
            } else {
                r.siparisiListedenCikart(this);
                System.out.println("SİPARİŞ LİSTEDEN ÇIKMADI");
            }
        } catch(Exception e) {

        }
    }
}
