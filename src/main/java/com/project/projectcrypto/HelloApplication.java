package com.project.projectcrypto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WORLD.fxml"));
//        fxmlLoader.setController(this);
        Scene scene = new Scene(fxmlLoader.load());
        Image image = new Image("C:\\Users\\HPP\\ProjectCrypto\\src\\main\\resources\\com\\project\\projectcrypto\\tesseract.png");
        stage.getIcons().add(image);
        stage.setTitle("TESSERACT");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {

        launch();
//        csv_Reader fil = new csv_Reader("Tesla");
    }
}

class csv_Reader{

    String fileName;

    public csv_Reader(String fileName) throws FileNotFoundException {
        //parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("src/main/java/com/project/projectcrypto/"+ fileName +".csv"));
        System.out.println("File read");
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            System.out.print(sc.next());  //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner
    }
}

