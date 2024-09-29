module com.example.mvvjavacalc {
    requires javafx.controls;
    requires javafx.fxml;

    opens mvvJavaCalculator.controllers to javafx.fxml;
    exports mvvJavaCalculator;
}