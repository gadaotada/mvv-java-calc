package mvvJavaCalculator.services;

import mvvJavaCalculator.constants.CalculatorThemes;
import mvvJavaCalculator.constants.CalculatorUserDefaultSettings;

public class CalculatorSingletonUserSettings {

    private static CalculatorSingletonUserSettings instance = null;

    private int precision;
    private boolean userLogging;
    private CalculatorThemes theme;

    private CalculatorSingletonUserSettings() {
        CalculatorUserDefaultSettings defaultSettings = CalculatorUserDefaultSettings.getInstance();
        this.precision = defaultSettings.getPrecision();
        this.userLogging = defaultSettings.getUserLogging();
        this.theme = defaultSettings.getTheme();
    }

    public static CalculatorSingletonUserSettings getInstance() {
        if (instance == null) {
            instance = new CalculatorSingletonUserSettings();
        }
        return instance;
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

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public void setUserLogging(boolean userLogging) {
        this.userLogging = userLogging;
    }

    public void setTheme(CalculatorThemes theme) {
        this.theme = theme;
    }
}
