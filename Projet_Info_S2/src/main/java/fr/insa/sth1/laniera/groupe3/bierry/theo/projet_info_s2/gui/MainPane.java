/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

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
        this.bVert = new Button("Vert");
        
        HBox entete = new HBox(this.bRouge,this.bVert);
        
        this.setTop(entete);
    }
    
}
