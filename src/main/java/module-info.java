module com.example.proyectocitas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.proyectocitas to javafx.fxml;
    exports com.example.proyectocitas;
}