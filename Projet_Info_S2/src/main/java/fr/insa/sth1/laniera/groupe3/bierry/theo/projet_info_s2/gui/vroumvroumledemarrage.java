/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author Youri
 */
public class vroumvroumledemarrage extends VBox {

    private Label Conseil;
    private Label Loading ;
    private Label Password;


    public void start(Stage fenetre) throws Exception {
        ProgressBar progressBar = new ProgressBar();
        ProgressIndicator progressIndicator = new ProgressIndicator(); //on crée les progressbar
        VBox page = new VBox();
        page.setSpacing(10);
        page.setPadding(new javafx.geometry.Insets(15,15,15,15));
        
        
        Scene scene = new Scene(page,600,300);
        fenetre.setTitle("tkt");
        fenetre.setScene(scene);
        fenetre.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}


}