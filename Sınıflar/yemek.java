public class yemek implements Runnable {
    
    private asci a;
    private garson g;
    private boolean aktiflik = false;

    public yemek(asci a,garson g) {
        this.a = a;
        this.g = g;
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

    @Override
    public void run() {
        try{
            Thread.sleep(3000);
            getGarson().siparisHAzır();
            System.out.println(getAsci().getName() + ", " + getGarson().getName()  +"'un yemegini pisirdi");
        }
        catch(Exception e){

        }
    }
}
