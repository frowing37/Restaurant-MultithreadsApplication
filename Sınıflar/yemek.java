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

    public void aktifYap() {
        if(this.aktiflik == true){
            this.aktiflik = false;
        }
        else{
            this.aktiflik = true;
        }
    }

    @Override
    public void run() {
        try{
            System.out.println("Ben yemeğim pişiyorum amk");
            Thread.sleep(3000);
        }
        catch(Exception e){

        }
    }
}
