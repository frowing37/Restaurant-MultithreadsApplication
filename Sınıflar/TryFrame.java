import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TryFrame extends JFrame {

    public void AnaMenü(){
        // JFrame oluştur
        JFrame frame = new JFrame("Restoran Simülasyonu");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel oluştur ve düzeni ayarla
        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // 5 adet buton oluştur
        JButton buttonA = new JButton("Aşçılar");
        JButton buttonG = new JButton("Garsonlar");
        JButton buttonK = new JButton("Kasa Elemanı");
        JButton buttonM = new JButton("Müşteriler");
        buttonA.setBackground(Color.cyan);
        buttonA.setSize(100, 60);
        buttonG.setBackground(Color.cyan);
        buttonG.setSize(100, 60);
        buttonK.setBackground(Color.cyan);
        buttonK.setSize(100, 60);
        buttonM.setBackground(Color.cyan);
        buttonM.setSize(100, 60);

        // Butonları panele ekle
        panel.add(buttonA);
        panel.add(buttonG);
        panel.add(buttonK);
        panel.add(buttonM);

        // Paneli frame'e ekle
        frame.add(panel);

        // Pencereyi görünür yap
        frame.setVisible(true);
    }
}
