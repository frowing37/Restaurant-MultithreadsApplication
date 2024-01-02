import javax.swing.SwingUtilities;

public class Main2 {
    public static void main(String[] args) {

        TryFrame pencere = new TryFrame();
        SwingUtilities.invokeLater(() -> {
            pencere.SimulasyonPenceresi();
            
        } );
    }
}
