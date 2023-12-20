import javax.sound.midi.MetaMessage;

public class masa {

    private boolean uygun = true;
    private String name;

    public masa(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public synchronized boolean uygunmu(){
        return uygun;
    }

    public synchronized void doldur(){
        this.uygun = false;
    }

    public synchronized void bosalt(){
        this.uygun = true;
    }
}
