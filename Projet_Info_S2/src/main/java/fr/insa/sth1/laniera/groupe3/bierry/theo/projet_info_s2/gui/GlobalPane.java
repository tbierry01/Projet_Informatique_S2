/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.shape.Rectangle;

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
//    private ChoiceBox Couleur;
    private ChoiceBox Eppaisseur;
//    private ChoiceBox Traits;
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
//        this.Couleur = new ChoiceBox();
        this.Eppaisseur = new ChoiceBox();
//        this.Traits = new ChoiceBox();
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
//        this.Couleur.setPrefSize(120, 25);
        this.Eppaisseur.setPrefSize(120, 25);
//        this.Traits.setPrefSize(120, 25);
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
        
        Rectangle rectangle1 = new Rectangle ();
        rectangle1.setWidth(10);
        rectangle1.setHeight(100);
        rectangle1.setFill(Color.LAVENDER);
        
        Rectangle rectangle2 = new Rectangle ();
        rectangle2.setWidth(5);
        rectangle2.setHeight(100);
        rectangle2.setFill(Color.LAVENDER);
        
        Rectangle rectangle3 = new Rectangle ();
        rectangle3.setWidth(5);
        rectangle3.setHeight(100);
        rectangle3.setFill(Color.LAVENDER);

        HBox entete = new HBox(vOptions, rectangle1, hTerrain, rectangle2, hPont, rectangle3, this.Simulation);
        entete.setSpacing(20);
        entete.setPadding(new javafx.geometry.Insets(15, 20, 10, 10));

        Background bgBlue = new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, null));
        entete.setBackground(bgBlue);

        this.setTop(entete);
        
        
        
        // Concerne les éléments de la partie gauche de l'interface
        
            // Définit les choix de la ChoiceBox en définissant la couleur Noir par défaut
        
        ChoixCouleur bleu = new ChoixCouleur ("Bleu");
        ChoixCouleur vert = new ChoixCouleur ("Vert");
        ChoixCouleur orange = new ChoixCouleur ("Orange");
        ChoixCouleur noir = new ChoixCouleur ("Noir");
        
        ObservableList<ChoixCouleur>couleurs = FXCollections.observableArrayList(bleu, vert, orange, noir);
        ChoiceBox<ChoixCouleur>cbCouleurs = new ChoiceBox<ChoixCouleur>(couleurs);
        cbCouleurs.getSelectionModel().select(noir);
        cbCouleurs.setPrefSize(120, 25);
        
            // Définit les choix de la ChoiceBox en définissant le trait plein par défaut

        ChoixStyleTrait traitPlein = new ChoixStyleTrait ("Trait plein");
        ChoixStyleTrait traitPointilles = new ChoixStyleTrait ("Trait pointillé");
        
        ObservableList<ChoixStyleTrait>styleTrait = FXCollections.observableArrayList(traitPlein, traitPointilles);
        ChoiceBox<ChoixStyleTrait>cbTrait = new ChoiceBox<ChoixStyleTrait>(styleTrait);
        cbTrait.getSelectionModel().select(traitPlein);
        cbTrait.setPrefSize(120, 25);
        
            // On place les différents éléments qui composent la partie gauche

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

        VBox coteGauche = new VBox(hStyle, cbCouleurs, this.Eppaisseur,
                cbTrait, hPositions, pAbscisses, pOrdonnee);
        coteGauche.setPadding(new javafx.geometry.Insets(2, 15, 10, 10));

        Background bgLightBlue = new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, null));
        coteGauche.setBackground(bgLightBlue);

        this.setLeft(coteGauche);
        
        
        
        // Concerne les éléments de la partie inférieure de l'interface

        Aide.setText("Cliquez sur un bouton pour modéliser votre pont");
        

        HBox coteBas = new HBox(this.Aide);

        Background bgLightBlue2 = new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, null));
        coteBas.setBackground(bgLightBlue2);

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
        
        
        
        // Concerne les instructions attendues lorqu'on clique sur Appui Simple
        
        AppuiSimple.setOnAction((t) -> {
            Aide.setText("Cliquez sur un segment du terrain pour y placer un appui simple");
        });
        
        
        
        // Concerne les instructions attendues lorqu'on clique sur Appui Double
        
        AppuiDouble.setOnAction((t) -> {
            Aide.setText("Cliquez sur un segment du terrain pour y placer un appui double");
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
            Aide.setText("Cliquez sur le bouton Noeuds, Appui (Simple/Double) ou Barres pour modéliser votre pont");
            Point.setDisable(true);
            Segment.setDisable(true);
            Barres.setDisable(false);
            AppuiSimple.setDisable(false);
            AppuiDouble.setDisable(false);
            Noeuds.setDisable(false);
        });
        
    }

}
