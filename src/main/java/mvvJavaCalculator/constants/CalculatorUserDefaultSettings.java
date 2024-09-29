package mvvJavaCalculator.constants;

public class CalculatorUserDefaultSettings {
    private final int precision;
    private final boolean userLogging;
    private final CalculatorThemes theme;

    private CalculatorUserDefaultSettings() {
        this.precision = 4;
        this.userLogging = false;
        this.theme = CalculatorThemes.SYSTEM_DEFAULT;
    }

    private static class SingletonHelper {
        private static final CalculatorUserDefaultSettings INSTANCE = new CalculatorUserDefaultSettings();
    }

    public static CalculatorUserDefaultSettings getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public int getPrecision() {
        return precision;
    }

    public boolean getUserLogging() {
        return userLogging;
    }

    public CalculatorThemes getTheme() {
        return theme;
    }
}
