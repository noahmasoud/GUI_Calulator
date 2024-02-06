package calculatordemo2;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CalculatorPanel {
    public static JPanel createCalculatorPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        JTextArea text = new JTextArea(2, 25);
        panel.add(text);
        return panel;
    }
}