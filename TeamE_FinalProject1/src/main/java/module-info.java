module org.example.teamerestaurant {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.teamerestaurant to javafx.fxml;
    exports org.example.teamerestaurant;
}