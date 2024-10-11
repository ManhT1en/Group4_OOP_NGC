
module com.mycompany.app {

    requires javafx.fxml;

    requires javafx.base;

    requires javafx.graphics;

    requires javafx.controls; // Add this line to include javafx.controls module

    requires java.base;
    requires java.sql;



    opens com.mycompany.app.controllers to javafx.fxml;

    exports com.mycompany.app;

}
