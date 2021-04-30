/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
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
public class TopBorderPane extends BorderPane {

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
    private DessinCanvas Dessin;

    public TopBorderPane() {

        this.Terrain = new ToggleButton("Terrain");
        this.Segment = new ToggleButton("Segment");
        this.Point = new ToggleButton("Point");
        this.Pont = new ToggleButton("Pont");
        this.Appuis = new ChoiceBox();
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

        this.Terrain.setPrefSize(100, 100);
        this.Segment.setPrefSize(100, 50);
        this.Point.setPrefSize(100, 50);
        this.Pont.setPrefSize(100, 100);
        this.Appuis.setPrefSize(100, 50);
        this.Noeuds.setPrefSize(100, 50);
        this.Barres.setPrefSize(100, 50);
        this.Couleur.setPrefSize(120, 25);
        this.Eppaisseur.setPrefSize(120, 25);
        this.Traits.setPrefSize(120, 25);
        this.Abscisse.setPrefSize(100, 25);
        this.Ordonnee.setPrefSize(100, 25);
        this.Simulation.setPrefSize(100, 100);

//        this.Style.setFont(javafx.scene.text.Font.font("Magneto", 30));
        VBox bTerrain = new VBox(this.Segment, this.Point);
        VBox bPont1 = new VBox(this.Appuis, this.Barres);
        VBox bPont2 = new VBox(this.Noeuds);

        HBox hTerrain = new HBox(this.Terrain, bTerrain);
        HBox hPont = new HBox(this.Pont, bPont1, bPont2);

        hTerrain.setSpacing(8);
        hPont.setSpacing(8);

        HBox entete = new HBox(hTerrain, hPont, this.Simulation);
        entete.setSpacing(20);
        entete.setPadding(new javafx.geometry.Insets(15, 20, 10, 10));

        Background bgGrey = new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, null));
        entete.setBackground(bgGrey);

        this.setTop(entete);

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

        Aide.setText("C'est ici que seront les infos attendues de l'utilisateur");
        this.Aide.setFont(javafx.scene.text.Font.font(15));

        HBox coteBas = new HBox(this.Aide);

        Background bgLightGrey2 = new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, null));
        coteBas.setBackground(bgLightGrey2);

        this.setBottom(coteBas);

       this.setCenter(Dessin);
// Voir comment mettre le canvas au centre de la border pane

    }

}
