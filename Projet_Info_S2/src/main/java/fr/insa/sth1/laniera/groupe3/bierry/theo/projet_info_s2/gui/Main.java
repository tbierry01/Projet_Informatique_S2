/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import java.awt.event.ActionListener;
import java.util.Timer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author theob
 */
public class Main extends Application {
    
    private Label titre;
    
    
//    private Label Conseil;
//    private Label Loading ;
//    private ToggleButton BoutonInutile ;
//    private ProgressBar barre;
//    public static String Conseil(double i) {
//        System.out.println(i);
//        String res="";
//        if (i<0.25) {
//            res="Boire de l'eau c'est bon pour la santé";
//        }
//        if (i>=0.25 && i<0.50) {
//            res="Pour manger il faut de la nourriture";
//        }
//        if (i>=0.50 && i<0.75) {
//            res="Oui";       
//        }
//        if (i>=0.75) {
//            res="Non";            
//        }
//    return("Conseil : "+ "\n" +res); 
//    }
//
//    @Override
    public void start(Stage primaryStage) throws Exception {
//        long timer = System.currentTimeMillis();
//        this.Conseil = new Label(Conseil(Math.random()));
//        this.BoutonInutile = new ToggleButton("Bouton Inutile");
//        this.BoutonInutile.setContentDisplay(ContentDisplay.BOTTOM);
//        this.BoutonInutile.setPrefSize(100, 100);
//        this.barre = new ProgressBar();
//        
//        VBox page = new VBox(this.Conseil,this.BoutonInutile,this.barre);
//        page.setSpacing(30);
//        page.setPadding(new javafx.geometry.Insets(15,15,15,15));
//        
//        Scene scene1 = new Scene(page,300,300);
//        primaryStage.setScene(scene1);
//        primaryStage.show();
//        primaryStage.getIcons().add(new Image("file:Image_Logo.png"));
//        primaryStage.setTitle("BRIDGIES");
        
        
        
        primaryStage.getIcons().add(new Image("file:Image_Logo.png"));
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
