/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.ClassDessin;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Figure;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ToggleButton AppuiSimple;
    private ToggleButton AppuiDouble;
    private ToggleButton Noeuds;
    private ToggleButton Barres;
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
    private ColorPicker Couleur;
//    private Button Grouper;
    
    private ClassDessin model;
    private Controleur controleur;
    
    private ArrayList<Figure> EnsembleFigures;
    
    private int IDSegment;
    private int IDPoint;
    private int IDAppuiSimple;
    private int IDAppuiDouble;
    private int IDBarres;
    private int IDNoeuds;
    
    public GlobalPane () {
        this(new ClassDessin());  
    }
    
    public GlobalPane(ClassDessin model) {
        this.model = model;
        this.controleur = new Controleur(this);

        this.Noeuds = new ToggleButton("Noeuds");
        this.Barres = new ToggleButton("Barres");
        this.Style = new Label("Style");
        this.Positions = new Label("Position");
        this.X = new Label("X : ");
        this.Y = new Label("Y : ");
        this.Simulation = new Button("Simulation");
        this.Abscisse = new TextField();
        this.Ordonnee = new TextField();
        this.Aide = new Label();
        this.Dessin = new DessinCanvas(this);

        this.Noeuds.setPrefSize(100, 50);
        this.Barres.setPrefSize(100, 50);
        this.Abscisse.setPrefSize(100, 25);
        this.Ordonnee.setPrefSize(100, 25);
        this.Simulation.setPrefSize(100, 100);
        
        this.Aide.setFont(javafx.scene.text.Font.font(15));
        
        IDPoint = 0;
        
        
        
//----------- Concerne les insertions des icones dans les différents boutons ainsi que leur taille -----------//
        
    //----------- Bouton Terrain -----------//

        ImageView iconTerrain = new ImageView(new Image("file:Image_Terrain.png"));
        this.Terrain = new ToggleButton("Terrain", iconTerrain);
        this.Terrain.setContentDisplay(ContentDisplay.TOP);
        this.Terrain.setPrefSize(100, 100);
        
    //----------- Bouton Pont -----------//
        
        ImageView iconPont = new ImageView(new Image("file:Image_Pont.png"));
        this.Pont = new ToggleButton("Pont", iconPont);
        this.Pont.setContentDisplay(ContentDisplay.TOP);
        this.Pont.setPrefSize(100, 100);
        
    //----------- Bouton Ouvrir -----------//
            
        ImageView iconOuvrir = new ImageView(new Image("file:Image_Ouvrir.png"));
        this.Ouvrir = new Button("    Ouvrir", iconOuvrir);
        this.Ouvrir.setPrefSize(120, 50);
        
    //----------- Bouton Enregistrer -----------//
            
        ImageView iconEnregistrer = new ImageView(new Image("file:Image_Enregistrer.png"));
        this.Enregistrer = new Button("Enregistrer", iconEnregistrer);
        this.Enregistrer.setPrefSize(120, 50);
        
    //----------- Bouton Segment -----------//
            
        ImageView iconSegment = new ImageView(new Image("file:Image_Segment.png"));
        this.Segment = new ToggleButton("Segment", iconSegment);
        this.Segment.setPrefSize(100, 50);
        
    //----------- Bouton Point -----------//
            
        ImageView iconPoint = new ImageView(new Image("file:Image_Point.png"));
        this.Point = new ToggleButton("    Point", iconPoint);
        this.Point.setPrefSize(100, 50);
        
    //----------- Bouton Appui Simple -----------//
            
        ImageView iconAppuiSimple = new ImageView(new Image("file:Image_Appui_Simple.png"));
        this.AppuiSimple = new ToggleButton(" Appui \n Simple", iconAppuiSimple);
        this.AppuiSimple.setPrefSize(100, 50);
    
    //----------- Bouton Appui Double -----------//
            
        ImageView iconAppuiDouble = new ImageView(new Image("file:Image_Appui_Double.png"));
        this.AppuiDouble = new ToggleButton(" Appui \n Double", iconAppuiDouble);
        this.AppuiDouble.setPrefSize(100, 50);
        
    //----------- Bouton Noeuds -----------//
            
        ImageView iconNoeuds = new ImageView(new Image("file:Image_Noeuds.png"));
        this.Noeuds = new ToggleButton("Noeuds", iconNoeuds);
        this.Noeuds.setPrefSize(100, 50);
        
    //----------- Bouton Barres -----------//
            
        ImageView iconBarres = new ImageView(new Image("file:Image_Barres.png"));
        this.Barres = new ToggleButton(" Barres", iconBarres);
        this.Barres.setPrefSize(100, 50);

        
//----------- Concerne les éléments de la partie haute de l'interface -----------//
        
        VBox bTerrain = new VBox(this.getSegment(), this.getPoint());
        VBox bPont1 = new VBox(this.getAppuiSimple(), this.getAppuiDouble());
        VBox bPont2 = new VBox(this.getNoeuds(), this.getBarres());
        
        VBox vOptions = new VBox (this.Ouvrir, this.getEnregistrer());

        HBox hTerrain = new HBox(this.getTerrain(), bTerrain);
        HBox hPont = new HBox(this.getPont(), bPont1, bPont2);

        hTerrain.setSpacing(8);
        hPont.setSpacing(8);
        
        Rectangle rectangle1 = new Rectangle ();
        rectangle1.setWidth(5);
        rectangle1.setHeight(100);
        rectangle1.setFill(Color.LIGHTSEAGREEN);
        
        Rectangle rectangle2 = new Rectangle ();
        rectangle2.setWidth(5);
        rectangle2.setHeight(100);
        rectangle2.setFill(Color.LIGHTSEAGREEN);
        
        Rectangle rectangle3 = new Rectangle ();
        rectangle3.setWidth(5);
        rectangle3.setHeight(100);
        rectangle3.setFill(Color.LIGHTSEAGREEN);

        HBox entete = new HBox(vOptions, rectangle1, hTerrain, rectangle2, hPont, rectangle3, this.getSimulation());
        entete.setSpacing(20);
        entete.setPadding(new javafx.geometry.Insets(15, 20, 10, 10));

        Background bgBlue = new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, null));
        entete.setBackground(bgBlue);

        this.setTop(entete);
        
        
        
//----------- Concerne les éléments de la partie gauche de l'interface -----------//
        
    //----------- Définit les choix de la ChoiceBox en définissant la couleur Noir par défaut -----------//
        
        ChoixCouleur bleu = new ChoixCouleur ("Bleu");
        ChoixCouleur vert = new ChoixCouleur ("Vert");
        ChoixCouleur orange = new ChoixCouleur ("Orange");
        ChoixCouleur noir = new ChoixCouleur ("Noir");
        
        ObservableList<ChoixCouleur>couleurs = FXCollections.observableArrayList(bleu, vert, orange, noir);
        ChoiceBox<ChoixCouleur>cbCouleurs = new ChoiceBox<ChoixCouleur>(couleurs);
        cbCouleurs.getSelectionModel().select(noir);
        cbCouleurs.setPrefSize(120, 25);
       
    /*    Couleur = new ColorPicker(Color.BLACK);
        Couleur.setOnAction((t) -> {
            controleur.changeColor(Couleur.getValue());
        });
    */    
    //----------- Définit les choix de la ChoiceBox en définissant le trait plein par défaut -----------//

        ChoixStyleTrait traitPlein = new ChoixStyleTrait ("Trait plein");
        ChoixStyleTrait traitPointilles = new ChoixStyleTrait ("Trait pointillé");
        
        ObservableList<ChoixStyleTrait>styleTrait = FXCollections.observableArrayList(traitPlein, traitPointilles);
        ChoiceBox<ChoixStyleTrait>cbTrait = new ChoiceBox<ChoixStyleTrait>(styleTrait);
        cbTrait.getSelectionModel().select(traitPlein);
        cbTrait.setPrefSize(120, 25);
        
    //----------- Définit les choix de la ChoiceBox en définissant le trait plein par défaut -----------//
            
        ChoixEpaisseur fin = new ChoixEpaisseur("Trait fin");
        ChoixEpaisseur moyen = new ChoixEpaisseur("Trait moyen");
        ChoixEpaisseur épais = new ChoixEpaisseur("Trait épais");
        
        ObservableList<ChoixEpaisseur>epaisseur = FXCollections.observableArrayList(fin, moyen, épais);
        ChoiceBox<ChoixEpaisseur>cbEpaisseur = new ChoiceBox<ChoixEpaisseur>(epaisseur);
        cbEpaisseur.getSelectionModel().select(moyen);
        cbEpaisseur.setPrefSize(120, 25);
        
    //----------- On place les différents éléments qui composent la partie gauche -----------//

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

        VBox coteGauche = new VBox(hStyle, cbCouleurs, cbEpaisseur,
                cbTrait, hPositions, pAbscisses, pOrdonnee);
        coteGauche.setPadding(new javafx.geometry.Insets(2, 15, 10, 10));

        Background bgLightBlue = new Background(new BackgroundFill(Color.LIGHTSEAGREEN, CornerRadii.EMPTY, null));
        coteGauche.setBackground(bgLightBlue);

        this.setLeft(coteGauche);
        
        
        
//----------- Concerne les éléments de la partie inférieure de l'interface -----------//

        Aide.setText("Cliquez sur un bouton pour modéliser votre pont");
        

        HBox coteBas = new HBox(this.Aide);

        Background bgLightBlue2 = new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, null));
        coteBas.setBackground(bgLightBlue2);

        this.setBottom(coteBas);
        
        
        
//----------- Concerne la position centrale du canvas -----------//

        this.setCenter(Dessin);
        
        
        

//----------- Concerne l'activation et la désactivation des boutons en fonctions des boutons Terrain et Pont -----------//
        
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
        


//----------- Concerne les instructions attendues lorqu'on clique sur Point -----------//
        
        Point.setOnAction((t) -> {
            Aide.setText("Cliquez sur la zone du dessin pour placer vos points");
            controleur.boutonPoint(t);
        });
        
        
        
//----------- Concerne les instructions attendues lorqu'on clique sur Segment -----------//
        
        Segment.setOnAction((t) -> {
            Aide.setText("Placez 2 points pour créer un segment ou reliez 2 points déjà existants");
            controleur.boutonSegment(t);
        });
        
        
        
//----------- Concerne les instructions attendues lorqu'on clique sur Appui Simple -----------//
        
        AppuiSimple.setOnAction((t) -> {
            Aide.setText("Cliquez sur un segment du terrain pour y placer un appui simple");
        });
        
        
        
//----------- Concerne les instructions attendues lorqu'on clique sur Appui Double -----------//
        
        AppuiDouble.setOnAction((t) -> {
            Aide.setText("Cliquez sur un segment du terrain pour y placer un appui double");
        });
        
        
        
//----------- Concerne les instructions attendues lorqu'on clique sur Terrain -----------//
        
        Terrain.setOnAction((t) -> {
            Aide.setText("Cliquez sur le bouton Point ou Segment afin de modéliser votre terrain");
            Point.setDisable(false);
            Segment.setDisable(false);
            Barres.setDisable(true);
            AppuiSimple.setDisable(true);
            AppuiDouble.setDisable(true);
            Noeuds.setDisable(true);
        });
        
        
//----------- Concerne les instructions attendues lorqu'on clique sur Pont -----------//
        
        Pont.setOnAction((t) -> {
            Aide.setText("Cliquez sur le bouton Noeuds, Appui (Simple/Double) ou Barres pour modéliser votre pont");
            Point.setDisable(true);
            Segment.setDisable(true);
            Barres.setDisable(false);
            AppuiSimple.setDisable(false);
            AppuiDouble.setDisable(false);
            Noeuds.setDisable(false);
        });
        
        
        
//----------- Concerne les instructions attendues lorqu'on clique sur Grouper -----------//
        
/*        Grouper.setOnAction((t) -> {
            Aide.setText("Sélectionnez les éléments que vous voulez grouper");
 //           controleur.boutonGrouper(t);
        });
 */       
    }
    
    public void redrawAll() {
            this.Dessin.redrawAll ();
        }

    /**
     * @return the model
     */
    public ClassDessin getModel() {
        return model;
    }

    /**
     * @return the controleur
     */
    public Controleur getControleur() {
        return controleur;
    }

    /**
     * @return the Terrain
     */
    public ToggleButton getTerrain() {
        return Terrain;
    }

    /**
     * @return the Segment
     */
    public ToggleButton getSegment() {
        return Segment;
    }

    /**
     * @return the Point
     */
    public ToggleButton getPoint() {
        return Point;
    }

    /**
     * @return the Pont
     */
    public ToggleButton getPont() {
        return Pont;
    }

    /**
     * @return the AppuiSimple
     */
    public ToggleButton getAppuiSimple() {
        return AppuiSimple;
    }

    /**
     * @return the AppuiDouble
     */
    public ToggleButton getAppuiDouble() {
        return AppuiDouble;
    }

    /**
     * @return the Noeuds
     */
    public ToggleButton getNoeuds() {
        return Noeuds;
    }

    /**
     * @return the Barres
     */
    public ToggleButton getBarres() {
        return Barres;
    }

    /**
     * @return the Simulation
     */
    public Button getSimulation() {
        return Simulation;
    }

    /**
     * @return the Enregistrer
     */
    public Button getEnregistrer() {
        return Enregistrer;
    }

    /**
     * @return the Grouper
     */
/*    public Button getGrouper() {
        return Grouper;
    }
 */   
    

}
