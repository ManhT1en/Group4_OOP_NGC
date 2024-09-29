package com.mycompany.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login_view"), 640, 480); // Bắt đầu với giao diện đăng nhập
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Chuyển sang giao diện khác
    public static void loadView(String fxml) throws IOException {
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (IOException e) {
            System.out.println("Error loading view: " + fxml);
            e.printStackTrace(); // In chi tiết lỗi ra console
        }
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        // Kiểm tra xem có thể truy cập đúng đường dẫn tới file FXML không
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/views/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }       
    

    public static void main(String[] args) {
        launch();
    }
}
