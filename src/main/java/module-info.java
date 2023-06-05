module com.example.calculator_workshop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculator_workshop to javafx.fxml;
    exports com.example.calculator_workshop;
}