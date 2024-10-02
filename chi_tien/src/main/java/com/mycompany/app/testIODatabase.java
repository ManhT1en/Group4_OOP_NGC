package com.mycompany.app;

import com.mycompany.app.models.FileManager;

public class testIODatabase {
    public static void main(String[] args) {
        String pathh = "D:\\OOP\\oop_group4_1_1_24_N02\\chi_tien\\file\\login.txt";
        FileManager testData = new FileManager(pathh);
        testData.iDataLogin("Nguyen Manh Tien", "abscdef123");
        testData.oDataLogin();
    }
}
