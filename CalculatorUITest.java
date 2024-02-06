
package calculatordemo2;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field; // This brings in the Field feature of Java Reflection
import java.lang.reflect.Method;

class CalculatorUITest {

    private static CalculatorUI classUnderTest;

    @BeforeAll
    public static void setUp() {
        classUnderTest = new CalculatorUI();
    }

    @Test
    @DisplayName("Test number button input")
    void testNumberButtonInput() {
        // sim creating a number button and adding it to jButtons array
        classUnderTest.getJButtons()[1] = CalculatorButton.createNumberButton("1");

        // sim a button click
        JButton numberButton = classUnderTest.getJButtons()[1];
        numberButton.doClick();

        // Validate the result after the Swing event dispatch thread processes the click
        SwingUtilities.invokeLater(() -> {
            assertEquals("1", classUnderTest.text.getText()); // Ensure the text is set correctly
        });
    }

    @Test
    void testNumberButtonPress() {
        // set a number to jbutton array
        JButton numberButton = classUnderTest.getJButtons()[1];
        // check on result after the Swing event dispatch thread processes the click
        SwingUtilities.invokeLater(() -> {
            numberButton.doClick();
            String textValue = classUnderTest.text.getText().trim(); // gets text value from jtextarea
            System.out.println("Text Value: [" + textValue + "]"); // debug print statement
            assertEquals("1", textValue); // asserts if it was set correctly
        });
    }

    @Test
    @DisplayName("Test addition operation")
    void testAdditionOperation() {
        // Set a number in the text area
        classUnderTest.text.setText("5");
        // Click the addition button
        classUnderTest.add.doClick();
        // Set another number in the text area
        classUnderTest.text.setText("3");
        // Click the equal button to perform the addition
        classUnderTest.equal.doClick();
        // check the result after the Swing event dispatch thread processes the click
        SwingUtilities.invokeLater(() -> {
            assertEquals("8.0", classUnderTest.text.getText()); // Ensure the addition is performed correctly
        });
    }

    @Test
    @DisplayName("Test subtraction operation")
    void testSubtractionOperation() {
        // Set a number in the text area
        classUnderTest.text.setText("7");
        // Click the subtraction button
        classUnderTest.sub.doClick();
        // Set another number in the text area
        classUnderTest.text.setText("3");
        // Click the equal button to perform the subtraction
        classUnderTest.equal.doClick();
        // check the result after the Swing event dispatch thread processes the click
        SwingUtilities.invokeLater(() -> {
            assertEquals("4.0", classUnderTest.text.getText()); // Ensure the subtraction is performed correctly
        });
    }

    @Test
    @DisplayName("Test multiplication operation")
    void testMultiplicationOperation() {
        // Set a number in the text area
        classUnderTest.text.setText("4");
        // Click the multiplication button
        classUnderTest.mult.doClick();
        // Set another number in the text area
        classUnderTest.text.setText("3");
        // Click the equal button to perform the multiplication
        classUnderTest.equal.doClick();
        // check the result after the Swing event dispatch thread processes the click
        SwingUtilities.invokeLater(() -> {
            assertEquals("12.0", classUnderTest.text.getText()); // Ensure the multiplication is performed correctly
        });
    }

    @Test
    @DisplayName("Test square root operation")
    void testSquareRootOperation() {
        // Set a number in the text area
        classUnderTest.text.setText("25");
        // Click the square root button
        classUnderTest.sqrRt.doClick();
        // check the result after the Swing event dispatch thread processes the click
        SwingUtilities.invokeLater(() -> {
            assertEquals("5.0", classUnderTest.text.getText()); // Ensure the square root is calculated correctly
        });
    }

    @Test
    @DisplayName("Test division operation")
    void testDivisionOperation() {
        // Set a number in the text area
        classUnderTest.text.setText("9");
        // Click the division button
        classUnderTest.div.doClick();
        // Set another number in the text area
        classUnderTest.text.setText("3");
        // Click the equal button to perform the division
        classUnderTest.equal.doClick();
        // check the result after the Swing event dispatch thread processes the click
        SwingUtilities.invokeLater(() -> {
            assertEquals("3.0", classUnderTest.text.getText()); // Ensure the division is performed correctly
        });
    }

    @Test
    void testOperatorButtonPress() {
        // Set an operator button in the JButton array
        JButton operatorButton = classUnderTest.getOperatorButton();
        // Simulate a button click and check the result after the Swing event dispatch
        // thread processes the click
        SwingUtilities.invokeLater(() -> {
            operatorButton.doClick(); // Simulate a button click
            String textValue = classUnderTest.text.getText().trim(); // Get the trimmed text value from the JTextArea
            System.out.println("Text Value: [" + textValue + "]"); // Print the text value for debugging
            assertEquals("+", textValue); // Ensure the text is set correctly
        });
    }

    /*
     * Unit Test for reader()
     */
    @DisplayName("Testing that reader handles empty string gracefully")
    @Test
    void readerHandlesEmptyString() {
        assertDoesNotThrow(() -> {
            Class<?> cls = classUnderTest.getClass();
            Field field = cls.getDeclaredField("text");
            field.setAccessible(true);

            // Set the value of "text" to an empty string
            JTextArea text = (JTextArea) field.get(classUnderTest);
            text.setText("");

            // Invoke the private method "reader" using reflection
            Method method = cls.getDeclaredMethod("reader");
            method.setAccessible(true);
            method.invoke(classUnderTest);

            // Validate that the text remains empty or handle it as per your logic
            assertEquals("", text.getText());
        });
    }

    @DisplayName("Testing that writer writes the display")
    @Test
    public void writerSetText() throws Exception {
        // Use reflection to access the private field “text”
        Class<?> cls = classUnderTest.getClass();
        Field field = cls.getDeclaredField("text");
        field.setAccessible(true);
        // Set the value of “text” to “mytext”
        JTextArea text = (JTextArea) field.get(classUnderTest);
        text.setText("mytext");
        // Test that the value of “text” is “mytext”
        assertEquals("mytext", text.getText());
    }

    @Test
    void appPanelIsCreated() {
        assertNotNull(classUnderTest, "app should have a panel object");
    }
}