public class kasaelemani implements Runnable {

    public kasaelemani(String name,restoran r) {
        this.name = name;
        this.r = r;
        System.out.println(getName() + " oluşturuldu !");
        d.yazdir(getName() + " oluşturuldu !");
    }

    private String name;
    private restoran r;
    private Document d = new Document();

    public String getName() {
        return this.name;
    }

    public void hesapAl(musteri musteri) {
        try{
            Thread.sleep(1000);
                System.out.println(musteri.getName() + " hesabını ödedi");
                d.yazdir(musteri.getName() + " hesabını ödedi");
                musteri.sethesapDurum();
                r.hesapSirasindanCik(musteri);
        }catch(Exception e){

        }
    }

    @Override
    public void run(){
        
    }

}
