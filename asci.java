public class asci implements Runnable {
    
    private int yapılanYemek = 0;
    private String name;

    public asci(String name){
        this.name = name;
        System.out.println(name + " oluşturuldu !\n");
    }

    public void artirAktifYemek(){
        this.yapılanYemek++;
    }

    public void siparisiAl(garson garson){
        try{

        }
        catch(Exception e){

        }
    }

    public void yemekYap(){
        try{
            Thread.sleep(3000);
            this.yapılanYemek--;
        }
        catch(Exception e){

        }
    }

    @Override
    public void run(){
        
    }

}
