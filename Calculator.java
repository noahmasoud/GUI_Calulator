package calculatordemo2;

public class Calculator {

	public enum twoOperator {
		normal, add, subtract, multiply, divide
	}

	public enum singleOperator {
		square, squareRoot, oneDevidedBy, cos, sin, tan, acos, atan, asin;
	}

	private Double num1, num2;
	private twoOperator mode = twoOperator.normal;

	/**
	 * The final call in enumeration that returns the specificed operation result
	 * 
	 * @return returns the called operation's result
	 */
	public Double twoOpOperations() {
		if (mode == twoOperator.normal) {
			return num2;
		}
		if (mode == twoOperator.add) {
			return num1 + num2;
		}
		if (mode == twoOperator.subtract) {
			return num1 - num2;
		}
		if (mode == twoOperator.multiply) {
			return num1 * num2;
		}
		if (mode == twoOperator.divide) {
			return num1 / num2;
		}
		// never reach
		throw new Error();
	}

	
	public Double twoOpCaller(twoOperator newMode, Double num) {
		if (mode == twoOperator.normal) {
			num1 = num;
			mode = newMode;
			return num; // not in normal mode, update num2 with the current number
		} else {
			num2 = num;
			Double result = twoOpOperations();
			num1 = result;
			mode = newMode;
			return result;
		}
	}

	/**
	 * The caller for equal to determine if Primitives or =
	 * 
	 * @param num the number passed from the calculator
	 * @return
	 */
	public Double calculateEqual(Double num) {
		return twoOpCaller(twoOperator.normal, num);
	}

	/**
	 * Clears all numbers and text from the calculator
	 * 
	 * @return
	 */
	public Double reset() {
		num2 = 0.0;
		num1 = 0.0;
		mode = twoOperator.normal;

		return Double.NaN;
	}

	/**
	 * Caller function that passes the mode for a single operator function, and
	 * returns the proper value
	 * depending on which math button newMode is pressed for Squared, square root,
	 * 1/x, cos, sin, tan
	 * 
	
	 */
	public Double calcScience(singleOperator newMode, Double num) {
		if (newMode == singleOperator.square) {
			return num * num;
		}
		if (newMode == singleOperator.squareRoot) {
			return Math.sqrt(num);
		}
		if (newMode == singleOperator.oneDevidedBy) {
			return 1 / num;
		}
		if (newMode == singleOperator.cos) {
			return Math.cos(num);
		}
		if (newMode == singleOperator.sin) {
			return Math.sin(num);
		}
		if (newMode == singleOperator.tan) {
			return Math.tan(num);
		}
		// new instruction for inverse: tangent, cosine, sine
		if (newMode == singleOperator.acos) {
			return Math.acos(num);
		}
		if (newMode == singleOperator.asin) {
			return Math.asin(num);
		}
		if (newMode == singleOperator.atan) {
			return Math.atan(num);
		}
		// never reach
		throw new Error();
	}

	// setters for unit testing in calculatorTest.Java
	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public void setMode(Calculator.twoOperator operationMode) {
		this.mode = operationMode;
	}

}
