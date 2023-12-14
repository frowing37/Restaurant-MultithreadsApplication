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

    public boolean uygunmu(){
        return uygun;
    }

    public void doldur(){
        this.uygun = false;
    }

    public void bosalt(){
        this.uygun = true;
    }
}
