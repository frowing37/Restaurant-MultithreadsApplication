import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class exampleplayground {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("JList Update Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> jList = new JList<>(listModel);

        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newItem = JOptionPane.showInputDialog(frame, "Enter item:");
                if (newItem != null && !newItem.isEmpty()) {
                    listModel.addElement(newItem);
                }
            }
        });

        JButton removeButton = new JButton("Remove Selected");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = jList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(jList));
        panel.add(addButton);
        panel.add(removeButton);

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
