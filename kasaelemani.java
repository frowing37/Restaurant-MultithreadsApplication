public class kasaelemani implements Runnable {

    public kasaelemani(String name,restoran r) {
        this.name = name;
        this.r = r;
        System.out.println(name + " oluşturuldu !\n");
    }

    private String name;
    private restoran r;

    public void hesapAl(musteri musteri) {
        try{
            Thread.sleep(1000);
                musteri.sethesapDurum();
                System.out.println(name + " hesabını ödedi");
                r.hesapSirasindanCik(musteri);
        }catch(Exception e){

        }
    }

    @Override
    public void run(){
        
    }

}
