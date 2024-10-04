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
        // Bắt đầu với giao diện login
        scene = new Scene(loadFXML("login_view"), 640, 480);
        stage.setTitle("Login Application"); // Đặt tiêu đề cho cửa sổ
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void loadView(String fxml) throws IOException {
        try {
            setRoot(fxml); // Nạp giao diện từ file FXML
        } catch (IOException e) {
            System.out.println("Error loading view: " + fxml);
            e.printStackTrace(); // In lỗi ra console
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/views/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
