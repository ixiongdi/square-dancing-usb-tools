module sdut {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.github.ixiongdi.sdut to javafx.fxml;
    exports com.github.ixiongdi.sdut;
}