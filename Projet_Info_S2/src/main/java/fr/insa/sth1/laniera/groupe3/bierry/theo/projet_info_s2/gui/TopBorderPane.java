/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import java.awt.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    private ChoiceBox Couleur;
    private ChoiceBox Eppaisseur;
    private ChoiceBox Traits;
    private Label Style;
    private Label Positions;
    private Label X;
    private Label Y;
    private Button Simulation;
    private TextField Abscisse;
    private TextField Ordonnee;
    private Label Aide;
    private Canvas Dessin;
    
    public TopBorderPane (){
        
        this.Terrain = new ToggleButton ("Terrain");
        this.Segment = new ToggleButton ("Segment");
        this.Point = new ToggleButton ("Point");
        this.Pont = new ToggleButton ("Pont");
        this.Appuis = new ChoiceBox();
        this.Noeuds = new ToggleButton ("Noeuds");
        this.Barres = new ToggleButton ("Barres");
        this.Couleur = new ChoiceBox ();
        this.Eppaisseur = new ChoiceBox ();
        this.Traits = new ChoiceBox ();
        this.Style = new Label ("Style");
        this.Positions = new Label ("Position");
        this.X = new Label ("X : ");
        this.Y = new Label ("Y : ");
        this.Simulation = new Button ("Simulation");
        this.Abscisse = new TextField ();
        this.Ordonnee = new TextField ();
        this.Aide = new Label ();
        this.Dessin = new Canvas ();
         
        this.Terrain.setPrefSize(100, 100);
        this.Segment.setPrefSize (100,50);
        this.Point.setPrefSize (100,50);
        this.Pont.setPrefSize (100,100);
        this.Appuis.setPrefSize (100,50);
        this.Noeuds.setPrefSize (100,50);
        this.Barres.setPrefSize (100,50);
        this.Couleur.setPrefSize (100,50);
        this.Eppaisseur.setPrefSize (100,50);
        this.Traits.setPrefSize (100,50);
        this.Abscisse.setPrefSize (100,25);
        this.Ordonnee.setPrefSize (100,25);
        this.Simulation.setPrefSize (100,100);
        
//        this.Style.setFont(javafx.scene.text.Font.font("Magneto", 30));
               
        VBox bTerrain = new VBox (this.Segment, this.Point);
        VBox bPont1 = new VBox (this.Appuis, this.Barres);
        VBox bPont2 = new VBox (this.Noeuds);
        
        HBox entete = new HBox (this.Terrain, bTerrain, this.Pont, bPont1, bPont2, this.Simulation);
        
        this.setTop(entete);
        
       
        HBox pAbscisses = new HBox (this.X, this.Abscisse);
        HBox pOrdonnee = new HBox (this.Y, this.Ordonnee);
        
        this.Style.setFont(javafx.scene.text.Font.font(15));
        this.Positions.setFont(javafx.scene.text.Font.font(15));
        
        VBox coteGauche = new VBox (this.Style, this.Couleur, this.Eppaisseur,
            this.Traits, this.Positions, pAbscisses, pOrdonnee);
        
        this.setLeft(coteGauche);
        
        
        Aide.setText("Toto cduo dhio dax hbuaa huivda huixqbuip dhov huxpv huipx huixs bic bipvd bip c");
        this.Aide.setFont(javafx.scene.text.Font.font(15));
        
        HBox coteBas = new HBox (this.Aide);
        
        this.setBottom (coteBas);
        
        
//        this.setCenter(Dessin);
// Voir comment mettre le canvas au centre de la border pane
        
        
          //insets (4 valeurs d'espace    mets l'espace entre les boutons
    }
    
}
