public class kasaelemani implements Runnable {

    public kasaelemani(String name,restoran r) {
        this.name = name;
        this.r = r;
        System.out.println(name + " oluşturuldu !");
    }

    private String name;
    private restoran r;
    private Document d;

    public void hesapAl(musteri musteri) {
        try{
            Thread.sleep(1000);
                System.out.println(musteri.getName() + " hesabını ödedi");
                musteri.sethesapDurum();
                r.hesapSirasindanCik(musteri);
        }catch(Exception e){

        }
    }

    @Override
    public void run(){
        
    }

}
