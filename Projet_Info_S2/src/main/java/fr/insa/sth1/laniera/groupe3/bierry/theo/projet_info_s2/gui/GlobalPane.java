/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author drumm
 */
public class GlobalPane extends BorderPane {

    private ToggleButton Terrain;
    private ToggleButton Segment;
    private ToggleButton Point;
    private ToggleButton Pont;
//    private ChoiceBox Appuis;
    private ToggleButton AppuiSimple;
    private ToggleButton AppuiDouble;
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
    private DessinCanvas Dessin;
    private Button Ouvrir;
    private Button Enregistrer;

    public GlobalPane() {

        this.Terrain = new ToggleButton("Terrain");
        this.Segment = new ToggleButton("Segment");
        this.Point = new ToggleButton("Point");
        this.Pont = new ToggleButton("Pont");
 //       this.Appuis = new ChoiceBox();
        this.AppuiSimple = new ToggleButton("Appui Simple");
        this.AppuiDouble = new ToggleButton("Appui Double");
        this.Noeuds = new ToggleButton("Noeuds");
        this.Barres = new ToggleButton("Barres");
        this.Couleur = new ChoiceBox();
        this.Eppaisseur = new ChoiceBox();
        this.Traits = new ChoiceBox();
        this.Style = new Label("Style");
        this.Positions = new Label("Position");
        this.X = new Label("X : ");
        this.Y = new Label("Y : ");
        this.Simulation = new Button("Simulation");
        this.Abscisse = new TextField();
        this.Ordonnee = new TextField();
        this.Aide = new Label();
        this.Dessin = new DessinCanvas();
        this.Ouvrir = new Button("Ouvrir");
        this.Enregistrer = new Button("Enregistrer");

        this.Terrain.setPrefSize(100, 100);
        this.Segment.setPrefSize(100, 50);
        this.Point.setPrefSize(100, 50);
        this.Pont.setPrefSize(100, 100);
 //       this.Appuis.setPrefSize(100, 50);
        this.AppuiSimple.setPrefSize(100, 50);
        this.AppuiDouble.setPrefSize(100, 50);
        this.Noeuds.setPrefSize(100, 50);
        this.Barres.setPrefSize(100, 50);
        this.Couleur.setPrefSize(120, 25);
        this.Eppaisseur.setPrefSize(120, 25);
        this.Traits.setPrefSize(120, 25);
        this.Abscisse.setPrefSize(100, 25);
        this.Ordonnee.setPrefSize(100, 25);
        this.Simulation.setPrefSize(100, 100);
        this.Ouvrir.setPrefSize(50, 50);
        this.Enregistrer.setPrefSize(50, 50);
        
        this.Aide.setFont(javafx.scene.text.Font.font(15));
        
        boolean etatTerrain = false;
        boolean etatPont = false;

        
        
        // Concerne les éléments de la partie haute de l'interface
        
        VBox bTerrain = new VBox(this.Segment, this.Point);
        VBox bPont1 = new VBox(this.AppuiSimple, this.AppuiDouble);
        VBox bPont2 = new VBox(this.Noeuds, this.Barres);
        
        VBox vOptions = new VBox (this.Ouvrir, this.Enregistrer);

        HBox hTerrain = new HBox(this.Terrain, bTerrain);
        HBox hPont = new HBox(this.Pont, bPont1, bPont2);

        hTerrain.setSpacing(8);
        hPont.setSpacing(8);

        HBox entete = new HBox(vOptions, hTerrain, hPont, this.Simulation);
        entete.setSpacing(20);
        entete.setPadding(new javafx.geometry.Insets(15, 20, 10, 10));

        Background bgGrey = new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, null));
        entete.setBackground(bgGrey);

        this.setTop(entete);
        
        
        
        // Concerne les éléments de la partie gauche de l'interface

        HBox pAbscisses = new HBox(this.X, this.Abscisse);
        HBox pOrdonnee = new HBox(this.Y, this.Ordonnee);

        pAbscisses.setSpacing(2);
        pOrdonnee.setSpacing(3);

        HBox hStyle = new HBox(this.Style);
        hStyle.setPadding(new javafx.geometry.Insets(10, 5, 0, 0));

        HBox hPositions = new HBox(this.Positions);
        hPositions.setPadding(new javafx.geometry.Insets(10, 10, 0, 0));

        this.Style.setFont(javafx.scene.text.Font.font(15));
        this.Positions.setFont(javafx.scene.text.Font.font(15));

        VBox coteGauche = new VBox(hStyle, this.Couleur, this.Eppaisseur,
                this.Traits, hPositions, pAbscisses, pOrdonnee);
        coteGauche.setPadding(new javafx.geometry.Insets(2, 15, 10, 10));

        Background bgLightGrey = new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, null));
        coteGauche.setBackground(bgLightGrey);

        this.setLeft(coteGauche);
        
        
        
        // Concerne les éléments de la partie inférieure de l'interface

        Aide.setText("C'est ici que seront les infos attendues de l'utilisateur");
        

        HBox coteBas = new HBox(this.Aide);

        Background bgLightGrey2 = new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, null));
        coteBas.setBackground(bgLightGrey2);

        this.setBottom(coteBas);
        
        
        
        // Concerne la position centrale du canvas

        this.setCenter(Dessin);
        
        
        
        
        // Concerne l'activation et la désactivation des boutons en fonctions des boutons Terrain et Pont
        
        Point.setDisable(true);
        Segment.setDisable(true);
        Barres.setDisable(true);
        AppuiSimple.setDisable(true);
        AppuiDouble.setDisable(true);
        Noeuds.setDisable(true);
        
        ToggleGroup gPointSegment = new ToggleGroup();
        Segment.setToggleGroup(gPointSegment);
        Point.setToggleGroup(gPointSegment);
        
        ToggleGroup gTerrainPont = new ToggleGroup();
        Terrain.setToggleGroup(gTerrainPont);
        Pont.setToggleGroup(gTerrainPont);
        
        ToggleGroup gPont = new ToggleGroup();
        Noeuds.setToggleGroup(gPont);
        Barres.setToggleGroup(gPont);
        AppuiSimple.setToggleGroup(gPont);
        AppuiDouble.setToggleGroup(gPont);
        


        // Concerne les instructions attendues lorqu'on clique sur Point
        
        Point.setOnAction((t) -> {
            Aide.setText("Cliquez sur la zone du dessin pour placer vos points");
        });
        
        
        
        // Concerne les instructions attendues lorqu'on clique sur Segment
        
        Segment.setOnAction((t) -> {
            Aide.setText("Placez 2 points pour créer un segment ou reliez 2 points déjà existants");
        });
        
        
        
        // Concerne les instructions attendues lorqu'on clique sur Terrain
        
        Terrain.setOnAction((t) -> {
            Aide.setText("Cliquez sur le bouton Point ou Segment afin de modéliser votre terrain");
            Point.setDisable(false);
            Segment.setDisable(false);
            Barres.setDisable(true);
            AppuiSimple.setDisable(true);
            AppuiDouble.setDisable(true);
            Noeuds.setDisable(true);
        });
        
        
        
        // Concerne les instructions attendues lorqu'on clique sur Pont
        
        Pont.setOnAction((t) -> {
            Aide.setText("Cliquez sur le bouton Noeuds, Appuis ou Barres pour modéliser votre pont");
            Point.setDisable(true);
            Segment.setDisable(true);
            Barres.setDisable(false);
            AppuiSimple.setDisable(false);
            AppuiDouble.setDisable(false);
            Noeuds.setDisable(false);
        });
        
        
    }

}
