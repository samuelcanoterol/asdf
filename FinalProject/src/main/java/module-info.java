module com.example.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens proyect to javafx.fxml;
    exports proyect;
}