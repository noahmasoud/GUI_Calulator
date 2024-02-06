package calculatordemo2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class CalculatorUI implements ActionListener {
	public final JFrame frame;
	public final JPanel panel;
	public final JTextArea text;
	public final JButton jButtons[], add, sub, mult, div, equal, cancel, sqrRt, sqr, inverse, cos, sin, tan, acos, atan,
			asin;
	public final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	public final Calculator calc;

	/**
	 * The main top level GUI of the calculator and it's frame, button, and text
	 * area for # display
	 */
	public CalculatorUI() {
		frame = new JFrame("Calculator");
		frame.setResizable(true);
		panel = CalculatorPanel.createCalculatorPanel();
		text = new JTextArea(2, 25);
		jButtons = new JButton[10];

		for (int i = 0; i < 10; i++) {
			jButtons[i] = CalculatorButton.createNumberButton(String.valueOf(i));
		}

		add = CalculatorButton.createOperatorButton("+");
		sub = CalculatorButton.createOperatorButton("-");
		mult = CalculatorButton.createOperatorButton("*");
		div = CalculatorButton.createOperatorButton("/");
		equal = CalculatorButton.createOperatorButton("=");
		sqrRt = CalculatorButton.createOperatorButton("√");
		sqr = CalculatorButton.createOperatorButton("x*x");
		inverse = CalculatorButton.createOperatorButton("1/x");
		cos = CalculatorButton.createOperatorButton("Cos");
		sin = CalculatorButton.createOperatorButton("Sin");
		tan = CalculatorButton.createOperatorButton("Tan");

		acos = CalculatorButton.createOperatorButton("cos^-1");
		asin = CalculatorButton.createOperatorButton("sin^-1");
		atan = CalculatorButton.createOperatorButton("tan^-1");
		cancel = CalculatorButton.createOperatorButton("C");

		calc = new Calculator();
	}

	/**
	 * Initializes and sets the frame size, buttons, panels. The main runner method
	 * of the UI class.
	 */
	public void init() {
		frame.setSize(300, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(text);
		addButtonsAndActionListeners();
		frame.setVisible(true);
	}

	/**
	 * Helper function that sets the buttons to its respective action listeners
	 * 
	 */
	private void addButtonsAndActionListeners() {
		addNumberButtons();
		addOperatorButtons(add, sub, mult, div, sqr, sqrRt, inverse, cos, sin, tan, equal, cancel, atan, acos, asin);
	}

	/**
	 * Helper function that adds the number buttons and sets action listeners
	 * 
	 */
	private void addNumberButtons() {
		for (int i = 0; i < 10; i++) {
			jButtons[i] = CalculatorButton.createNumberButton(String.valueOf(i));
			panel.add(jButtons[i]);
			jButtons[i].addActionListener(this);
		}
	}

	/**
	 * Helper function that adds the operator buttons
	 * 
	 */
	private void addOperatorButtons(JButton... buttons) {
		for (JButton button : buttons) {
			panel.add(button);
			button.addActionListener(this);
		}
	}

	/**
	 * Event handling implementation for Calculator button pressing
	 * 
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		final Object source = e.getSource();
		// check 0-9 and update textfield
		for (int i = 0; i < 10; i++) {
			if (source == jButtons[i]) {
				text.replaceSelection(buttonValue[i]);
				return;
			}
		}
		if (source == add) {
			writer(calc.twoOpCaller(Calculator.twoOperator.add, reader()));
		}
		if (source == sub) {
			writer(calc.twoOpCaller(Calculator.twoOperator.subtract, reader()));
		}
		if (source == mult) {
			writer(calc.twoOpCaller(Calculator.twoOperator.multiply, reader()));
		}
		if (source == div) {
			writer(calc.twoOpCaller(Calculator.twoOperator.divide, reader()));
		}
		if (source == sqr) {
			writer(calc.calcScience(Calculator.singleOperator.square, reader()));
		}
		if (source == sqrRt) {
			writer(calc.calcScience(Calculator.singleOperator.squareRoot, reader()));
		}
		if (source == inverse) {
			writer(calc.calcScience(Calculator.singleOperator.oneDevidedBy, reader()));
		}
		if (source == cos) {
			writer(calc.calcScience(Calculator.singleOperator.cos, reader()));
		}
		if (source == sin) {
			writer(calc.calcScience(Calculator.singleOperator.sin, reader()));
		}
		if (source == tan) {
			writer(calc.calcScience(Calculator.singleOperator.tan, reader()));
		}
		// new code for arc cos,sin, and tan
		if (source == acos) {
			writer(calc.calcScience(Calculator.singleOperator.acos, reader()));
		}
		if (source == asin) {
			writer(calc.calcScience(Calculator.singleOperator.asin, reader()));
		}
		if (source == atan) {
			writer(calc.calcScience(Calculator.singleOperator.atan, reader()));
		}
		if (source == equal) {
			writer(calc.calculateEqual(reader()));
		}
		if (source == cancel) {
			writer(calc.reset());
		}
		// for easy continued calculations/copy
		text.selectAll();
	}

	/**
	 * Helper function that gets the texfield area and updates the number input
	 * 
	 * @return the updated number
	 */
	public double reader() {
		String textValue = text.getText().trim();

		// Check if the string is empty
		if (textValue.isEmpty()) {
			return 0.0; // Or any default value you want to return for an empty string
		}

		try {
			return Double.parseDouble(textValue);
		} catch (NumberFormatException e) {
			// Handle the case where the string is not a valid double
			e.printStackTrace(); // Or log the exception, display an error message, etc.
			return 0.0; // Or any default value you want to return for an invalid number
		}
	}

	/**
	 * Helper function that sets the textfield with the number, and avoids NaN
	 * issues
	 * 
	 * @param num
	 */
	public void writer(final Double num) {
		if (Double.isNaN(num)) {
			text.setText("");
		} else {
			text.setText(Double.toString(num));
		}
	}

	public JButton[] getJButtons() {
		return jButtons;
	}

	public JButton getOperatorButton() {
		return null;
	}
}
