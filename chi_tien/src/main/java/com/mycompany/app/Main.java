package com.mycompany.app;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Mặc định hiển thị màn hình login khi khởi chạy
        scene = new Scene(loadFXML("login_view"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Student Management System");
        stage.show();
    }

    // Phương thức để thay đổi root của Scene (điều hướng giữa các màn hình)
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Phương thức để load tệp FXML tương ứng
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/views/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}