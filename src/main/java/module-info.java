module com.unah.tarea3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.unah.tarea3 to javafx.fxml;
    exports com.unah.tarea3;
}
