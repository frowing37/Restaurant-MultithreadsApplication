import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Document {
    
    public static synchronized void yazdir(String icerik,String dosyaAdi){
        try{
        File file = new File("/Users/frowing/Projects/Yazlab1:3-Threads/Dokümanlar/" + dosyaAdi + ".txt");

        if(!file.exists()){
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file,true);

        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write(icerik);
        writer.newLine();
        writer.close();
    
    }catch(IOException e){
        e.printStackTrace();
        
    }

    }

}
