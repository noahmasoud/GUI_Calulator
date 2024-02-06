package calculatordemo2;

import javax.swing.JButton;

public class CalculatorButton {
    public static JButton createNumberButton(String label) {
        return new JButton(label);
    }

    public static JButton createOperatorButton(String label) {
        return new JButton(label);
    }
}