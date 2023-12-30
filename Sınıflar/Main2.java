import javax.swing.SwingUtilities;

public class Main2 {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TryFrame pencere = new TryFrame();
            pencere.SimulasyonPenceresi();
        } );
    }
}
