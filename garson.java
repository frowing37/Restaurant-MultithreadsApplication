public class garson implements Runnable {
    
    public garson(String name){
        this.name = name;
        System.out.println(name + " oluşturuldu !\n");
    }

    public String getName(){
        return this.name;
    }

    private String name;
    private boolean musteri = false;

    public void musteriyiKap(){
        musteri = true;
    }

    public void siparisAl(musteri musteri){
        try{
            Thread.sleep(2000);
            musteri.setSiparis();
        }
        catch(Exception e){

        }
    }

    public void asciyaVer(asci asci){
        asci.artirAktifYemek();
    }

    @Override
    public void run(){
        
    }
}
