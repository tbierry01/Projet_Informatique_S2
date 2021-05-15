/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

/**
 *
 * @author theob
 */
public class Main extends Application {
    
    private Label titre;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("BRIDGIES");
//      Scene scene = new Scene(new MainDessinPane());
        Scene scene = new Scene(new GlobalPane(primaryStage));
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
