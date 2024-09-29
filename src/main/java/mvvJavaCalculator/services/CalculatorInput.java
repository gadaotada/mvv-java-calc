package mvvJavaCalculator.services;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CalculatorInput {
    public Object convertUserInput (String userInput) {
        try {
            if (userInput.contains(".")) {
                return new BigDecimal(userInput);
            } else {
                return new BigInteger(userInput);
            }
        } catch (NumberFormatException err) {
            // Using STDERR for now;
            // TODO: implement a logger;
            System.err.println("Invalid number format provided by the user: " + userInput + " .Please use a valid number!");
            return null;
        }
    }
}
