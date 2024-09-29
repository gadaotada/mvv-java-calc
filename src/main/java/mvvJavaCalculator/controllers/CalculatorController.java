package mvvJavaCalculator.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import mvvJavaCalculator.services.CalculatorService;

import java.math.BigDecimal;

public class CalculatorController {

    @FXML
    private TextField display;

    private final CalculatorService calculatorService = new CalculatorService();

    private String currentInput = "";
    private String operator = "";
    private BigDecimal operand1 = BigDecimal.ZERO;
    private boolean startNewInput = true;

    @FXML
    private void handleNumber(javafx.event.ActionEvent event) {
        String number = ((Button) event.getSource()).getText();

        if (startNewInput) {
            currentInput = number;
            startNewInput = false;
        } else {
            currentInput += number;
        }

        display.setText(currentInput);
    }

    @FXML
    private void handleOperator(javafx.event.ActionEvent event) {
        String selectedOperator = ((Button) event.getSource()).getText();

        if (!currentInput.isEmpty()) {
            operand1 = new BigDecimal(currentInput);
        }
        operator = selectedOperator;
        startNewInput = true;
    }

    @FXML
    private void handleEquals(javafx.event.ActionEvent event) {
        if (currentInput.isEmpty()) return;

        BigDecimal operand2 = new BigDecimal(currentInput);
        BigDecimal result = BigDecimal.ZERO;

        try {
            switch (operator) {
                case "+":
                    result = calculatorService.add(operand1, operand2);
                    break;
                case "-":
                    result = calculatorService.subtract(operand1, operand2);
                    break;
                case "*":
                    result = calculatorService.multiply(operand1, operand2);
                    break;
                case "/":
                    result = calculatorService.divide(operand1, operand2);
                    break;
                default:
                    display.setText("Error: Invalid operator");
                    return;
            }

            display.setText(result.stripTrailingZeros().toPlainString());
            currentInput = result.stripTrailingZeros().toPlainString();
            startNewInput = true;

        } catch (IllegalArgumentException e) {
            display.setText(e.getMessage());
            currentInput = "";
            startNewInput = true;
        }
    }

    @FXML
    private void handleDecimal(javafx.event.ActionEvent event) {
        if (!currentInput.contains(".")) {
            currentInput += ".";
            display.setText(currentInput);
        }
    }

    @FXML
    private void handleClear(javafx.event.ActionEvent event) {
        currentInput = "";
        operator = "";
        operand1 = BigDecimal.ZERO;
        display.setText("");
    }
}