/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author drumm
 */
public class TopBorderPane extends BorderPane{
    
    private ToggleButton Terrain;
    private ToggleButton Segment;
    private ToggleButton Point;
    private ToggleButton Pont;
    private ChoiceBox Appuis;
    private ToggleButton Noeuds;
    private ToggleButton Barres;
    
    public TopBorderPane (){
        
        this.Terrain = new ToggleButton ("Terrain");
        this.Segment = new ToggleButton ("Segment");
        this.Point = new ToggleButton ("Point");
        this.Pont = new ToggleButton ("Pont");
        this.Appuis = new ChoiceBox();
        this.Noeuds = new ToggleButton ("Noeuds");
        this.Barres = new ToggleButton ("Barres");
        
        this.Barres.setPrefSize(100, 100);
        
/*        this.setLeft(this.Terrain);
        this.setLeft(this.Segment);
        this.setLeft(this.Point);
        
        this.setCenter(this.Pont);
        
        this.setRight(this.Appuis);
        this.setRight(this.Barres);
        this.setRight(this.Noeuds);
*/      
        HBox enteteGauche = new HBox(this.Terrain);
        HBox enteteCentre = new HBox (this.Segment, this.Point, this.Pont);
        HBox enteteDroite = new HBox (this.Appuis, this.Barres, this.Noeuds);
        
/*        BorderPane entete = new BorderPane ();
        entete.setLeft();
 */       
        this.setLeft(enteteGauche);
        this.setCenter(enteteCentre);
        this.setRight(enteteDroite);
        
        
    }
    
}
