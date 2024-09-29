package mvvJavaCalculator.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorService {

    public BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    public BigDecimal divide(BigDecimal a, BigDecimal b) throws IllegalArgumentException {
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Cannot divide by Zero!");
        }

        int currentPrecision = CalculatorSingletonUserSettings.getInstance().getPrecision();
        return a.divide(b, currentPrecision, RoundingMode.HALF_UP);
    }
}
