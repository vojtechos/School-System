module com.example.schoolsystemfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.schoolsystemfx to javafx.fxml;
    exports com.example.schoolsystemfx;
}