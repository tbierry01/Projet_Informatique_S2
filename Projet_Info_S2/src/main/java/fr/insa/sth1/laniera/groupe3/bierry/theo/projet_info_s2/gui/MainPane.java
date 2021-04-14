/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author drumm
 */
public class MainPane extends BorderPane {
    
    private Button bRouge;
    private Button bVert;
    
    public MainPane() {
        this.bRouge = new Button("Rouge");
        this.bRouge.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println("coucou rouge");
            }
        });
        this.bVert = new Button("Vert");
        this.bVert.setOnMouseEntered((t) -> {
            System.out.println("entered en " + t.getScreenX());
        });
        
        HBox entete = new HBox(this.bRouge,this.bVert);
        
        this.setTop(entete);
        
    }
    
}
