import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TryFrame extends JFrame {

    public void AnaMenu(){
        JFrame mainFrame = new JFrame("Restoran Simülasyonu - Başlangıç");
        mainFrame.setSize(500,500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.YELLOW);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);

        JButton loginButton = new JButton("Login");
        mainPanel.add(loginButton);
        mainFrame.add(mainPanel);

        mainFrame.setVisible(true);
    }


    public void RolMenusu() {
        // JFrame oluştur
        JFrame frame = new JFrame("Restoran Simülasyonu - Rol Menüsü");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // JPanel oluştur ve düzeni ayarla
        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);

        // 5 adet buton oluştur
        JButton buttonA = new JButton("Aşçılar");
        JButton buttonG = new JButton("Garsonlar");
        JButton buttonK = new JButton("Kasa Elemanı");
        JButton buttonM = new JButton("Müşteriler");

        Dimension buttonDimension = new Dimension(100,100);
        buttonA.setSize(100,100);

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
