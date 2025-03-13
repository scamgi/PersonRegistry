module com.example.personregistry {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.personregistry to javafx.fxml;
    exports com.example.personregistry;
}