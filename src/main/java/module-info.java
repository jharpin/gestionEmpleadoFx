module co.edu.uniquindio.gestionempleadofx.gestionempleadofx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens co.edu.uniquindio.gestionempleadofx.gestionempleadofx to javafx.fxml;
    exports co.edu.uniquindio.gestionempleadofx.gestionempleadofx;
}