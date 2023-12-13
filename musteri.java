public class musteri implements Runnable {
    
    public musteri(String name){
        this.name = name;
        System.out.println(name + " oluşturuldu !");
    }

    private String name;
    private boolean siparis = false;
    private masa masa;
    private boolean oncelik = false;
    private boolean hesapDurum = false;
    private int siraBeklemeSuresi = 0;
    private int maxsiraBeklemeSuresi = 20;

    public String getName(){
        return this.name;
    }

    public void oncelikliyap(){
        this.oncelik = true;
    }

    public boolean onceliklimi(){
        return this.oncelik;
    }

    public void restoranaGir(){
        
    }

    public void siraBekle(){

    }

    public void masayaOtur(masa masa){
        this.masa = masa;
        masa.doldur();
    }

    public void restorandanCik(){
        this.hesapDurum = true;
        this.masa.bosalt();
    }

    public void yemekYe(){
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){

        }
    }

    @Override
    public void run(){

    }

}
