/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.*;/*
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Appui;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Barre;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.ClassDessin;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Figure;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Point;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Segment; */
import java.io.File;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
    private ToggleButton Simulation;
    private Label Aide;
    private DessinCanvas Dessin;
    private Button Ouvrir;
    private Button Enregistrer;
    private Button Nouveau;
    private ColorPicker Couleur;
    private ToggleButton Sélectionner;
    private ToggleButton Vertical;
    private ToggleButton Horizontal;
    private Button Force;
    private Button Valider;
    private TextField Norme;
    private TextField Angle;
    private Button Supprimer;
    private Label posX = new Label("");
    private Label posY = new Label("");
    private Label Type = new Label("");
    private Label NormeForce = new Label();
    private Label AngleForce = new Label();
    private Label ContraintesBarres = new Label();
    private  Label Cout = new Label("0");
    private Label NomCout = new Label("Cout : ");
    private Label SymboleEuro = new Label(" €");

    private ClassDessin model;
    private Controleur controleur;

    private File curFile;
    private Stage inStage;

    private Label UTextLabel;
    private MainMenu menu;
    private String NomUtilisatuer = "";
    
    private Tooltip precision;
    private Tooltip precision2;
    private Tooltip precision3;
    private Tooltip precision4;

    
    public GlobalPane(Stage inStage, String UText){
        this(inStage, null, new ClassDessin(),0, 0, 0, 0, 0, 0, UText);
    }
    
    public GlobalPane(Stage inStage) {
        this(inStage, new ClassDessin());
    }

    public GlobalPane(Stage inStage, ClassDessin model) {
        this(inStage, null, model);
    }
    
    public GlobalPane(Stage inStage, File fromFile, ClassDessin model){
        this(inStage, fromFile, model, 0, 0, 0, 0, 0, 0,"");

    }

    public GlobalPane(Stage inStage, File fromFile, ClassDessin model, int IDS, int IDP, int IDN, int IDB, int IDF, double  Prix, String UText) {
        this.inStage = inStage;
        this.model = model;
        this.controleur = new Controleur(this, IDN, IDB, IDS, IDP, IDF);
        
        NomUtilisatuer = UText;
        UText = "Connecté en tant que "+UText;
        this.UTextLabel= new Label(UText);
        UTextLabel.setTextFill(Color.DARKSLATEGREY);
        UTextLabel.setStyle("-fx-font-weight: bold");
        
        this.Noeuds = new ToggleButton("Noeuds");
        this.Barres = new ToggleButton("Barres");
        this.Style = new Label("Style");
        this.Positions = new Label("Position");
        this.Simulation = new ToggleButton("Simulation");
        this.Aide = new Label();
        this.Dessin = new DessinCanvas(this);
        this.Sélectionner = new ToggleButton("Sélectionner");
        this.Vertical = new ToggleButton("Vertical");
        this.Horizontal = new ToggleButton("Horizontal");
        this.Force = new Button("Force");
        this.Valider = new Button("Valider");
        this.Norme = new TextField("Norme (en N)");
        this.Angle = new TextField("Angle (en rad)");
        this.Supprimer = new Button("Supprimer");
        this.setCout("" + ((int)Prix));
        this.Vertical.setPrefSize(120, 25);
        this.Horizontal.setPrefSize(120, 25);
        this.Sélectionner.setPrefSize(120, 25);
        this.Norme.setPrefSize(100, 25);
        this.Angle.setPrefSize(100, 25);
        this.Supprimer.setPrefSize(120, 25);

        this.Aide.setFont(javafx.scene.text.Font.font(15));
        
       

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
        this.Ouvrir = new Button("  Ouvrir", iconOuvrir);
        this.Ouvrir.setPrefSize(120, 33);

        //----------- Bouton Enregistrer -----------//
        ImageView iconEnregistrer = new ImageView(new Image("file:Image_Enregistrer.png"));
        this.Enregistrer = new Button("  Enregistrer", iconEnregistrer);
        this.Enregistrer.setPrefSize(120, 33);

        //----------- Bouton Nouveau -----------//
        ImageView iconNouveau = new ImageView(new Image("file:Image_Nouveau.png"));
        this.Nouveau = new Button("  Nouveau", iconNouveau);
        this.Nouveau.setPrefSize(120, 33);

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

        // ----------- Logo INSA -----------//
        ImageView iconINSA = new ImageView(new Image("file:Image_INSA.png"));

        //----------- Bouton Pont -----------//
        ImageView iconSimulation = new ImageView(new Image("file:Image_Simulation.png"));
        this.Simulation = new ToggleButton("Simulation", iconSimulation);
        this.Simulation.setContentDisplay(ContentDisplay.TOP);
        this.Simulation.setPrefSize(100, 100);
        
        //----------- Bouton Force -----------//
        ImageView iconForce = new ImageView(new Image("file:Image_Force.png"));
        this.Force = new Button(" Force", iconForce);
        this.Force.setPrefSize(100, 50);
        
        //----------- Bouton Barres -----------//
        ImageView iconValider = new ImageView(new Image("file:Image_Valider.png"));
        this.Valider = new Button(" Valider", iconValider);
        this.Valider.setPrefSize(200, 50);



//----------- Concerne les éléments de la partie haute de l'interface -----------//
        
        // Gère les groupe de boutons à l'aide de HBox et VBox
        VBox bTerrain = new VBox(this.getSegment(), this.getPoint());
        VBox bPont1 = new VBox(this.getAppuiSimple(), this.getAppuiDouble());
        VBox bPont2 = new VBox(this.getNoeuds(), this.getBarres());
        
        VBox vOptions = new VBox(this.Nouveau, this.Ouvrir, this.getEnregistrer());

        HBox hTerrain = new HBox(this.getTerrain(), bTerrain);
        HBox hPont = new HBox(this.getPont(), bPont1, bPont2);

        hTerrain.setSpacing(8);
        hPont.setSpacing(8);
        
        //partie déco (logo INSA, connecté en tant que etc...)
        Rectangle rectangle0 = new Rectangle();
        rectangle0.setWidth(100);
        rectangle0.setHeight(3);
        rectangle0.setFill(Color.LIGHTSEAGREEN);
        VBox LogoUsername = new VBox(iconINSA,rectangle0,this.UTextLabel);
        LogoUsername.setSpacing(10);
        LogoUsername.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        NormeForce.setTextFill(Color.WHITE);
        ContraintesBarres.setTextFill(Color.WHITE);
        AngleForce.setTextFill(Color.WHITE);
        Cout.setTextFill(Color.WHITE);
        NomCout.setTextFill(Color.WHITE);
        Type.setTextFill(Color.WHITE);
        SymboleEuro.setTextFill(Color.WHITE);
        
        // Défini les rectangles de séparation entre les groupes de boutons
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setWidth(5);
        rectangle1.setHeight(100);
        rectangle1.setFill(Color.LIGHTSEAGREEN);

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setWidth(5);
        rectangle2.setHeight(100);
        rectangle2.setFill(Color.LIGHTSEAGREEN);

        Rectangle rectangle3 = new Rectangle();
        rectangle3.setWidth(5);
        rectangle3.setHeight(100);
        rectangle3.setFill(Color.LIGHTSEAGREEN);
        
        // Gère les groupes des différents boutons en définissant des couleurs de fond pour les H/VBox
        VBox NormeAngle = new VBox(Norme, Angle);
        HBox ForceDonnees = new HBox (Force, NormeAngle);
        VBox vbForce = new VBox(ForceDonnees, Valider);

        HBox SimFor = new HBox(Simulation, vbForce);
        SimFor.setSpacing(8);

        HBox entete = new HBox(vOptions, rectangle1, hTerrain, rectangle2, hPont, rectangle3, SimFor);
        entete.setSpacing(20);
        entete.setPadding(new javafx.geometry.Insets(15, 20, 10, 10));

        // Place la barre de menu en haut de l'interface
        this.menu = new MainMenu(this);
        VBox barreMenus = new VBox(menu, entete);

        Background bgBlue = new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, null));
        barreMenus.setBackground(bgBlue);

        BorderPane haut = new BorderPane();
        HBox logoINSA = new HBox(LogoUsername);
        logoINSA.setBackground(bgBlue);
        HBox JeSersARien = new HBox();
        JeSersARien.setBackground(bgBlue);
        haut.setLeft(entete);
        haut.setRight(logoINSA);
        haut.setTop(menu);
        haut.setCenter(JeSersARien);
        entete.setBackground(bgBlue);

        this.setTop(haut);

        
        
//----------- Concerne les éléments de la partie gauche de l'interface -----------//

        //----------- Définit le bouton Couleur en définissant la couleur Noir par défaut -----------//
        Couleur = new ColorPicker(Color.BLACK);
        Couleur.setOnAction((t) -> {
            controleur.changeColor(Couleur.getValue());
        });
        Couleur.setPrefSize(120, 25);

        //----------- Définit les choix de la ChoiceBox style trait -----------//
        ChoixStyleTrait stylTrait = new ChoixStyleTrait("Style trait");
        ChoixStyleTrait traitPointilles = new ChoixStyleTrait("En attente d'une mise à jour");
        
        
        ObservableList<ChoixStyleTrait> styleTrait = FXCollections.observableArrayList(stylTrait, traitPointilles);
        ChoiceBox<ChoixStyleTrait> cbTrait = new ChoiceBox<ChoixStyleTrait>(styleTrait);
        cbTrait.getSelectionModel().select(stylTrait);
        cbTrait.setPrefSize(120, 25);
        this.precision = new Tooltip("Work In Progress...");
        precision.setFont(new Font("Bauhaus 93",15));
        precision.setPrefSize(150,16);
        precision.setStyle("-fx-text-fill: DARKCYAN");
        cbTrait.setStyle("-fx-text-fill: -fx-text-inner-color");
        Tooltip.install(cbTrait, precision);


        //----------- Définit les choix de la ChoiceBox épaisseur -----------//
        ChoixEpaisseur fin = new ChoixEpaisseur("En attente d'une mise à jour");
        ChoixEpaisseur épaisseur = new ChoixEpaisseur("Epaisseur");
        ChoixEpaisseur épais = new ChoixEpaisseur("En attente d'une mise à jour");

        ObservableList<ChoixEpaisseur> epaisseur = FXCollections.observableArrayList(fin, épaisseur, épais);
        ChoiceBox<ChoixEpaisseur> cbEpaisseur = new ChoiceBox<ChoixEpaisseur>(epaisseur);
        cbEpaisseur.getSelectionModel().select(épaisseur);
        cbEpaisseur.setPrefSize(120, 25);
        Tooltip.install(cbEpaisseur, precision);

        //----------- Définit les choix de la ChoiceBox matériaux -----------//
        ChoixMatériaux matériau = new ChoixMatériaux("Matériaux");
        ChoixMatériaux matBois = new ChoixMatériaux("En attente d'une mise à jour");
        ChoixMatériaux matPolystyrène = new ChoixMatériaux("En attente d'une mise à jour");

        ObservableList<ChoixMatériaux> matériaux = FXCollections.observableArrayList(matériau, matBois, matPolystyrène);
        ChoiceBox<ChoixMatériaux> cbMatériaux = new ChoiceBox<ChoixMatériaux>(matériaux);
        cbMatériaux.getSelectionModel().select(matériau);
        cbMatériaux.setPrefSize(120, 25);
        Tooltip.install(cbMatériaux, precision);

        //----------- On place les différents éléments qui composent la partie gauche -----------//
        
        // On défini une BorderPane pour la partie gauche pour bien placer les éléments
        BorderPane gauche = new BorderPane();

        // On défini les groupes de bouton à l'aide de H/VBox, on modifie la taille police et les couleurs
        HBox hStyle = new HBox(this.Style);
        hStyle.setPadding(new javafx.geometry.Insets(10, 5, 0, 0));

        HBox hPositions = new HBox(this.Positions);
        hPositions.setPadding(new javafx.geometry.Insets(10, 10, 0, 0));

        this.Style.setFont(javafx.scene.text.Font.font(15));
        this.Positions.setFont(javafx.scene.text.Font.font(15));

        VBox coteGauche = new VBox(hStyle, getCouleur(), cbEpaisseur,
                cbTrait, cbMatériaux, hPositions, this.Vertical, this.Horizontal, this.Sélectionner, Supprimer);
        coteGauche.setPadding(new javafx.geometry.Insets(2, 15, 10, 10));

        Background bgLightBlue = new Background(new BackgroundFill(Color.LIGHTSEAGREEN, CornerRadii.EMPTY, null));
        coteGauche.setBackground(bgLightBlue);

        // Permet d'afficher les coordonnées du pointeurs en direct lorsqu'on bouge la souris sur le Canvas
        Dessin.setOnMouseMoved((t) -> {
            double x;
            double y;
            x = t.getSceneX() - 145.6;
            y = t.getSceneY() - 152.8;
            posX.setText("X : " + ((int) x));
            posX.setStyle("-fx-font-weight: bold");
            posY.setText("Y : " + ((int) y));
            posY.setStyle("-fx-font-weight: bold");
        });
        
        VBox posCurseur = new VBox(posX, posY);
        
        HBox FormatPrix = new HBox(NomCout, Cout, SymboleEuro);
        VBox IndicationElement = new VBox(Type, NormeForce, AngleForce, ContraintesBarres, FormatPrix);
        VBox Assemblage = new VBox (IndicationElement, posCurseur);
        VBox JeSersARienBis = new VBox();
        
        Assemblage.setBackground(bgLightBlue);
        JeSersARienBis.setBackground(bgLightBlue);

        gauche.setTop(coteGauche);
        gauche.setCenter(JeSersARienBis);
        gauche.setBottom(Assemblage);

        this.setLeft(gauche);

        
        
//----------- Concerne les éléments de la partie inférieure de l'interface -----------//
        
        Aide.setText("Cliquez sur un bouton pour modéliser votre pont");

        HBox coteBas = new HBox(this.Aide);

        Background bgLightBlue2 = new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, null));
        coteBas.setBackground(bgLightBlue2);

        this.setBottom(coteBas);

        
        
//----------- Concerne la position centrale du canvas -----------//
        this.setCenter(Dessin);

        
        
//----------- Concerne l'activation et la désactivation des boutons par défaut / Met les ToggleButton dans des groupes -----------//
        Point.setDisable(true);
        Segment.setDisable(true);
        Barres.setDisable(true);
        AppuiSimple.setDisable(true);
        AppuiDouble.setDisable(true);
        Noeuds.setDisable(true);
        Valider.setDisable(true);
        Norme.setDisable(true);
        Angle.setDisable(true);
        Supprimer.setDisable(true);

        ToggleGroup gPointSegment = new ToggleGroup();
        Segment.setToggleGroup(gPointSegment);
        Point.setToggleGroup(gPointSegment);

        ToggleGroup gTerrainPont = new ToggleGroup();
        Terrain.setToggleGroup(gTerrainPont);
        Pont.setToggleGroup(gTerrainPont);
        Sélectionner.setToggleGroup(gTerrainPont);
        Vertical.setToggleGroup(gTerrainPont);
        Horizontal.setToggleGroup(gTerrainPont);

        ToggleGroup gPont = new ToggleGroup();
        Noeuds.setToggleGroup(gPont);
        Barres.setToggleGroup(gPont);
        AppuiSimple.setToggleGroup(gPont);
        AppuiDouble.setToggleGroup(gPont);

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Point -----------//
        Point.setOnAction((t) -> {
            Aide.setText("Cliquez sur la zone du dessin pour placer vos points");

            if (Segment.isDisabled() == true) {
                controleur.boutonEtatNeutre(t);
            } else {
                controleur.boutonPoint(t);
            }

            // Quand Point est activé, on désactive tous les autres boutons
            if (Segment.isDisabled() == true) {
                Pont.setDisable(false);
                Terrain.setDisable(false);
                Force.setDisable(false);
                Simulation.setDisable(false);
                Segment.setDisable(false);
                Sélectionner.setDisable(false);
                Vertical.setDisable(false);
                Horizontal.setDisable(false);
            } else {
                Pont.setDisable(true);
                Terrain.setDisable(true);
                Force.setDisable(true);
                Simulation.setDisable(true);
                Segment.setDisable(true);
                Sélectionner.setDisable(true);
                Vertical.setDisable(true);
                Horizontal.setDisable(true);
            }
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Segment -----------//
        Segment.setOnAction((t) -> {
            Aide.setText("Placez 2 points pour créer un segment ou reliez 2 points déjà existants");
            if (Point.isDisabled() == true) {
                controleur.boutonEtatNeutre(t);
            } else {
                controleur.boutonSegment(t);
            }

            // Quand Segment est activé, on désactive tous les autres boutons
            if (Point.isDisabled() == true) {
                Point.setDisable(false);
                Pont.setDisable(false);
                Terrain.setDisable(false);
                Force.setDisable(false);
                Simulation.setDisable(false);
                Sélectionner.setDisable(false);
                Vertical.setDisable(false);
                Horizontal.setDisable(false);
            } else {
                Point.setDisable(true);
                Pont.setDisable(true);
                Terrain.setDisable(true);
                Force.setDisable(true);
                Simulation.setDisable(true);
                Sélectionner.setDisable(true);
                Vertical.setDisable(true);
                Horizontal.setDisable(true);
            }
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Appui Simple -----------//
        AppuiSimple.setOnAction((t) -> {
            Aide.setText("Cliquez sur un segment du terrain pour y placer un appui simple");
            if (AppuiDouble.isDisabled() == true) { 
                controleur.boutonEtatNeutre(t);
            } else {
                controleur.boutonAppuiSimple(t);
            }

            // Quand Appui Simple est activé, on désactive tous les autres boutons
            if (Barres.isDisabled() == true) {
                Pont.setDisable(false);
                Terrain.setDisable(false);
                Simulation.setDisable(false);
                Force.setDisable(false);
                Barres.setDisable(false);
                AppuiDouble.setDisable(false);
                Noeuds.setDisable(false);
                Sélectionner.setDisable(false);
                Vertical.setDisable(false);
                Horizontal.setDisable(false);
            } else {
                Pont.setDisable(true);
                Terrain.setDisable(true);
                Simulation.setDisable(true);
                Force.setDisable(true);
                Barres.setDisable(true);
                AppuiDouble.setDisable(true);
                Noeuds.setDisable(true);
                Sélectionner.setDisable(true);
                Vertical.setDisable(true);
                Horizontal.setDisable(true);
            }
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Appui Double -----------//
        AppuiDouble.setOnAction((t) -> {
            Aide.setText("Cliquez sur un segment du terrain pour y placer un appui double");
            if (AppuiSimple.isDisabled() == true) {
                controleur.boutonEtatNeutre(t);
            } else {
                controleur.boutonAppuiDouble(t);
            }

            // Quand Appui Double est activé, on désactive tous les autres boutons
            if (Barres.isDisabled() == true) {
                Pont.setDisable(false);
                Terrain.setDisable(false);
                Simulation.setDisable(false);
                Force.setDisable(false);
                Barres.setDisable(false);
                AppuiSimple.setDisable(false);
                Noeuds.setDisable(false);
                Sélectionner.setDisable(false);
                Vertical.setDisable(false);
                Horizontal.setDisable(false);
            } else {
                Pont.setDisable(true);
                Terrain.setDisable(true);
                Simulation.setDisable(true);
                Force.setDisable(true);
                Barres.setDisable(true);
                AppuiSimple.setDisable(true);
                Noeuds.setDisable(true);
                Sélectionner.setDisable(true);
                Vertical.setDisable(true);
                Horizontal.setDisable(true);
            }
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Barres -----------//
        Barres.setOnAction((t) -> {
            Aide.setText("Cliquez sur 2 noeuds pour créer une barre");
            if (Noeuds.isDisabled() == true) {
                controleur.boutonEtatNeutre(t);
            } else {
                controleur.boutonBarres(t);
            }

            // Quand Appui Double est activé, on désactive tous les autres boutons
            if (Noeuds.isDisabled() == true) {
                Pont.setDisable(false);
                Terrain.setDisable(false);
                Simulation.setDisable(false);
                Force.setDisable(false);
                AppuiDouble.setDisable(false);
                AppuiSimple.setDisable(false);
                Noeuds.setDisable(false);
                Sélectionner.setDisable(false);
                Vertical.setDisable(false);
                Horizontal.setDisable(false);
            } else {
                Pont.setDisable(true);
                Terrain.setDisable(true);
                Simulation.setDisable(true);
                Force.setDisable(true);
                AppuiDouble.setDisable(true);
                AppuiSimple.setDisable(true);
                Noeuds.setDisable(true);
                Sélectionner.setDisable(true);
                Vertical.setDisable(true);
                Horizontal.setDisable(true);
            }
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Noeuds -----------//
        Noeuds.setOnAction((t) -> {
            Aide.setText("Cliquez sur un point pour créer un noeud");
            if (Barres.isDisabled() == true) {
                controleur.boutonEtatNeutre(t);
            } else {
                controleur.boutonNoeuds(t);
            }

            // Quand Noeuds est activé, on désactive tous les autres boutons
            if (Barres.isDisabled() == true) {
                Pont.setDisable(false);
                Terrain.setDisable(false);
                Simulation.setDisable(false);
                Force.setDisable(false);
                Barres.setDisable(false);
                AppuiSimple.setDisable(false);
                AppuiDouble.setDisable(false);
                Sélectionner.setDisable(false);
                Vertical.setDisable(false);
                Horizontal.setDisable(false);
            } else {
                Pont.setDisable(true);
                Terrain.setDisable(true);
                Simulation.setDisable(true);
                Force.setDisable(true);
                Barres.setDisable(true);
                AppuiSimple.setDisable(true);
                AppuiDouble.setDisable(true);
                Sélectionner.setDisable(true);
                Vertical.setDisable(true);
                Horizontal.setDisable(true);
            }
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Terrain -----------//
        Terrain.setOnAction((t) -> {
            Aide.setText("Cliquez sur le bouton Point ou Segment afin de modéliser votre terrain");
            Barres.setDisable(true);
            AppuiSimple.setDisable(true);
            AppuiDouble.setDisable(true);
            Noeuds.setDisable(true);

            // Quand Terrain est activé, on active Point et Terrain et on désactive tous les autres boutons
            if (Segment.isDisabled() == true) {
                Segment.setDisable(false);
                Point.setDisable(false);
                Pont.setDisable(true);
                Simulation.setDisable(true);
            } else {
                Segment.setDisable(true);
                Point.setDisable(true);
                Pont.setDisable(false);
                Simulation.setDisable(false);
            }
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Pont -----------//
        Pont.setOnAction((t) -> {
            Aide.setText("Cliquez sur le bouton Noeuds, Appui (Simple/Double) ou Barres pour modéliser votre pont");
            Point.setDisable(true);
            Segment.setDisable(true);

            // Quand Pont est activé, on active Appui Simple, Appui Double, Noeuds et Barres et on désactive tous les autres boutons
            if (Barres.isDisabled() == true) {
                Barres.setDisable(false);
                AppuiSimple.setDisable(false);
                AppuiDouble.setDisable(false);
                Noeuds.setDisable(false);
                Terrain.setDisable(true);
                Simulation.setDisable(true);
            } else {
                Barres.setDisable(true);
                AppuiSimple.setDisable(true);
                AppuiDouble.setDisable(true);
                Noeuds.setDisable(true);
                Terrain.setDisable(false);
                Simulation.setDisable(false);
            }
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Sélectionner -----------//
        Sélectionner.setOnAction((t) -> {
            Aide.setText("Cliquez sur des éléments pour les sélectionner");
            this.controleur.boutonSélectionner(t);
            
            // On désactive tous les bouton et on active le bouton Supprimer
            if (Segment.isDisabled() == false || Barres.isDisabled() == false) {
                Segment.setDisable(true);
                Point.setDisable(true);
                AppuiSimple.setDisable(true);
                AppuiDouble.setDisable(true);
                Barres.setDisable(true);
                Noeuds.setDisable(true);
            }
            if (Supprimer.isDisable() == true) {
                Supprimer.setDisable(false);
            } else {
                Supprimer.setDisable(true);
            }

        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Force -----------//
        Force.setOnAction((t) -> {
            Aide.setText("Sélectionnez le noeuds puis entrez la norme et l'angle de la force qui s'y applique");
            controleur.boutonEtatNeutre(t);
            
            // On active les zones de texte et le bouton valider
            if (Angle.isDisabled() == true) {
                Angle.setDisable(false);
                Norme.setDisable(false);
                Valider.setDisable(false);
                Sélectionner.setDisable(true);
                Vertical.setDisable(true);
                Horizontal.setDisable(true);
            } else {
                Angle.setDisable(true);
                Norme.setDisable(true);
                Valider.setDisable(true);
                Sélectionner.setDisable(false);
                Vertical.setDisable(false);
                Horizontal.setDisable(false);
            }
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Vertical -----------//  
        Vertical.setOnAction((t) -> {
            controleur.boutonVertical(t);
            
            // On désactive tous les boutons lorsqu'on clique sur Vertical
            if (Segment.isDisabled() == false || Barres.isDisabled() == false || Angle.isDisabled() == false) {
                Segment.setDisable(true);
                Point.setDisable(true);
                AppuiSimple.setDisable(true);
                AppuiDouble.setDisable(true);
                Barres.setDisable(true);
                Noeuds.setDisable(true);
                Angle.setDisable(true);
                Norme.setDisable(true);
                Valider.setDisable(true);
            }
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Horizontal -----------//  
        Horizontal.setOnAction((t) -> {
            controleur.boutonHorizontal(t);
            
            // On désactive tous les boutons lorsqu'on clique sur Horizontal
            if (Segment.isDisabled() == false || Barres.isDisabled() == false || Angle.isDisabled() == false) {
                Segment.setDisable(true);
                Point.setDisable(true);
                AppuiSimple.setDisable(true);
                AppuiDouble.setDisable(true);
                Barres.setDisable(true);
                Noeuds.setDisable(true);
                Angle.setDisable(true);
                Norme.setDisable(true);
                Valider.setDisable(true);
            }
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Simulation -----------//
        Simulation.setOnAction((t) -> {
            
            // Permet de lancer les calculs et de dire si le treillis est isostatique / Affiche une erreur si le calcul est impossible
            ArrayList<Noeud> AN = controleur.getVue().getModel().Tri_Des_Noeuds();
            ArrayList<Barre> AB = controleur.getVue().getModel().Tri_Des_Barres();
            ArrayList<Segment> AS = controleur.getVue().getModel().Tri_Des_Segment();
            if(AN.isEmpty() || AB.isEmpty() || AS.size() == 0){
                Aide.setText("La simulation est impossible, vous devez avoir au moins un Segment, une Barre et un Noeud.");
            } else {
                controleur.boutonSimulation(t);
            }
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Supprimer -----------//
        Supprimer.setOnAction((t) -> {
  
            int i = 0;
            for (Figure F : controleur.getSelection()) { //On récupère toutes les figures de la séléction
                if (controleur.getVue().getModel().getContenu().contains(F)) { //Comme dans la suite, on va enlever des figures qui ne sont pas demander d'enlever, mais qui créent des ncohérence, alors, on vérfie si cette figure est déjà enlevé ou pas
                    if (F instanceof Point) { //On regarde le tupe de la figure
                        System.out.println("+++Point");
                        ArrayList<Segment> AS = ((Point) F).getSegment_Point();//On récupère tous les segments qui touchent le point
                        System.out.println("AS : " + AS);
                        if (AS.size() > 0) {
                            for (Segment S : AS) {
                                ArrayList<Appui> AA = S.getAppui();//On récupère tous les appuis qui touchent les segments qui touchent le point
                                System.out.println("AA : " + AA);
                                if (AA.size() > 0) {
                                    for (Appui A : AA) {
                                        ArrayList<Barre> AB = A.getBarre(); //On récupère toutes les barres de tous les appuis
                                        System.out.println("AB : " + AB);
                                        if (AB.size() > 0) {
                                            for (Barre B : AB) {
                                                controleur.getVue().getModel().Remove(B); //On enlève la barre de la liste de figure du model
                                                controleur.getVue().getModel().MAJ_Ids(B, B.getId()); //On met à jours les identificateurs
                                                controleur.setIdBarre(controleur.getIdBarre() - 1); //On met à jour l'identificateur pour la création de nouvelles barres ensuite
                                                System.out.println("OK " + i + " fois");
                                                i++;

                                                for (int j = 0; j < 2; j++) { 
                                                    if (B.getNoeuds_Barre(j) != A) {//On prend l'autre noued que l'appui pour lui enlever la barre pour ne pas avoir de bare présente dans la liste de ce noeud alors que normalement elle n'existe plus
                                                        B.getNoeuds_Barre(j).removeBarre(B);
                                                    }
                                                }//System.out.println("\nID Barres : "+controleur.getIdBarre()+"\n");
                                            }
                                        }
                                        controleur.getVue().getModel().Remove(A); //On enlève l'appui
                                        controleur.getVue().getModel().MAJ_Ids(A, A.getId()); //On met à jour les Id des noeuds
                                        controleur.setIdNoeud(controleur.getIdNoeud() - 1);//On met à jour l'identificateur des appuis pour pouvoir ensuite créer des noueds appui sans problème d'id
                                    }
                                }
                                controleur.getVue().getModel().Remove(S); //On enlève le segment
                                controleur.getVue().getModel().MAJ_Ids(S, S.getId()); //On met à jour les id des segments
                                controleur.setIdSegment(controleur.getIdSegment() - 1);//On met à jour l'id de création de segment
                                for (int j = 0; j < 2; j++) {
                                    if (S.getExtremite(j) != (Point) F) { //On enlève le segment de la liste des segments du point qui n'est pas pris en compte ici
                                        S.getExtremite(j).removeSegment(S);
                                    }
                                }
                            }
                        }
                        controleur.getVue().getModel().Remove(F); //On enlève la figure
                        controleur.getVue().getModel().MAJ_Ids(F, F.getId()); //On met à jour ses id
                        controleur.setIdPoint(controleur.getIdPoint() - 1); //On met à jour l'Id de création
                    } else if (F instanceof Segment) {
                        System.out.println("+++Segment");
                        ArrayList<Appui> AA = ((Segment) F).getAppui();
                        for (Appui A : AA) {
                            ArrayList<Barre> AB = A.getBarre();
                            for (Barre B : AB) {
                                controleur.getVue().getModel().Remove(B);
                                controleur.getVue().getModel().MAJ_Ids(B, B.getId());
                                controleur.setIdBarre(controleur.getIdBarre() - 1);
                                System.out.println("OK " + i + " fois");
                                i++;
                                /*
                                for(int i = 0; i < 2 ; i++){
                B.getNoeuds_Barre(i).removeBarre(B);
                                 */
                            }
                            //}
                            controleur.getVue().getModel().Remove(A);
                            controleur.getVue().getModel().MAJ_Ids(A, A.getId());
                            controleur.setIdNoeud(controleur.getIdNoeud() - 1);
                        }
                        controleur.getVue().getModel().Remove(F);
                        controleur.getVue().getModel().MAJ_Ids(F, F.getId());
                        controleur.setIdSegment(controleur.getIdSegment() - 1);
                        /*
                        Segment S = (Segment) F;
                        for(int i = 0; i < 2; i++){
                S.getExtremite(i).removeSegment(S);
            }*/
                        for (int j = 0; j < 2; j++) {

                            ((Segment) F).getExtremite(j).removeSegment(((Segment) F));

                        }

                    } else if (F instanceof Noeud) {
                        System.out.println("+++Noeud");
                        ArrayList<Barre> AB = ((Noeud) F).getBarre();
                        for (Barre B : AB) {
                            controleur.getVue().getModel().Remove(B);
                            controleur.getVue().getModel().MAJ_Ids(B, B.getId());
                            controleur.setIdBarre(controleur.getIdBarre() - 1);
                            System.out.println("OK " + i + " fois");
                            i++;

                            for (int j = 0; j < 2; j++) {
                                if (B.getNoeuds_Barre(j) != ((Noeud) F)) {
                                    B.getNoeuds_Barre(j).removeBarre(B);
                                }
                            }
                            /* for(int i = 0; i < 2 ; i++){
                B.getNoeuds_Barre(i).removeBarre(B);
            }*/
                        }
                        controleur.getVue().getModel().Remove(F);
                        controleur.getVue().getModel().MAJ_Ids(F, F.getId());
                        controleur.setIdNoeud(controleur.getIdNoeud() - 1);

                    } else if (F instanceof Barre) {
                        System.out.println("+++Barre");
                        controleur.getVue().getModel().Remove(F);
                        controleur.getVue().getModel().MAJ_Ids(F, F.getId());
                        controleur.setIdBarre(controleur.getIdBarre() - 1);
                        System.out.println("OK " + i + " fois");
                        i++;
                        for (int j = 0; j < 2; j++) {

                            ((Barre) F).getNoeuds_Barre(j).removeBarre((Barre) F);

                        }
                    }
                }
            }
            controleur.getTreillisControleur().setTreillis(controleur.getVue().getModel());
            System.out.println("Treilis: " + controleur.getTreillisControleur());
            System.out.println("\n-|-|-|- ID BARRE : " + controleur.getIdBarre() + "\n");
            controleur.getVue().redrawAll();
        });

        
           
//----------- Concerne les instructions attendues lorsqu'on clique sur Terrain -----------//
        Nouveau.setOnAction((t) -> {
            controleur.menuNouveau(t);
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Ouvrir -----------//  
        Ouvrir.setOnAction((t) -> {
            controleur.menuOuvrir(t);
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Nouveau -----------//  
        Nouveau.setOnAction((t) -> {
            controleur.menuNouveau(t);
        });

        
        
//----------- Concerne les instructions attendues lorsqu'on clique sur Sauvegarder -----------//  
        Enregistrer.setOnAction((t) -> {
            ArrayList<Noeud> AN = controleur.getVue().getModel().Tri_Des_Noeuds();
            ArrayList<Barre> AB = controleur.getVue().getModel().Tri_Des_Barres();
            ArrayList<Segment> AS = controleur.getVue().getModel().Tri_Des_Segment();
            if(AN.isEmpty() || AB.isEmpty() || AS.size() == 0){//En fait, seule le fait que la liste des segments ne doit pas être vide suffit,mais cela n'a pas vraiment de sens d'enregistrer un fichier sans au moins une des trois conditions donc ce n'est pas très déreangant
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Problème durant la sauvegarde\n\nPour sauvegarder un fichier, celui_ci doit contenir au moins : \n-Une barre\n-Un noeud simple\n-Un segment"); 
                alert.showAndWait();
                controleur.boutonEtatNeutre(t);
            } else{
            controleur.menuSauvegarder(t);
            }
        });

    
    
//----------- Concerne les actions quand on veut valider une force -------------------------//
        Valider.setOnAction((t) -> {
            controleur.BoutonValider(t);
            
            // Une fois cliqué sur Valider, on désactive les champ et ce même bouton
            Valider.setDisable(true);
            Norme.setDisable(true);
            Angle.setDisable(true);
        });
        
        
        
//----------- Concerne les actions lorsqu'on entre une norme -------------------------//        
        Norme.setOnMouseClicked((ti) -> {
            if (Norme.getText().equals("Norme (en N)")){
                Norme.setText("");
            }
        });
        
        
        
//----------- Concerne les actions lorsqu'on entre un angle -------------------------//         
        Angle.setOnMouseClicked((ti) -> {
            if (Angle.getText().equals("Angle (en rad)")){
                Angle.setText("");
            }
        }); 
    }

    public void redrawAll() {
        this.Dessin.redrawAll();
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
    public ToggleButton getSimulation() {
        return Simulation;
    }

    /**
     * @return the Enregistrer
     */
    public Button getEnregistrer() {
        return Enregistrer;
    }

    /**
     * @return the Couleur
     */
    public ColorPicker getCouleur() {
        return Couleur;
    }

    public File getCurFile() {
        return curFile;
    }

    public void setCurFile(File curFile) {
        this.curFile = curFile;
    }

    public Stage getInStage() {
        return inStage;
    }

    public MainMenu getMenu() {
        return menu;
    }

    public void setTextByMoi(String text) {
        Aide.setText(text);
    }
    
    public double getChampNorme(){
        double Val;
        Val = Double.parseDouble(Norme.getText());
        return Val;
    }
    
    public double getChampAngle(){
        double Val;
        Val = Double.parseDouble(Angle.getText());
        return Val;
    }

    public void setType(String S) {
        this.Type.setText(S);
    }

    public void setNormeForce(String S) {
        this.NormeForce.setText(S);
    }

    public void setAngleForce(String S) {
        this.AngleForce.setText(S);
    }

    public void setContraintesBarres(String S) {
        this.ContraintesBarres.setText(S);
    }
    
    public String getCout(){
        return Cout.getText();
    }
    
    public void setCout(String S){
        Cout.setText(S);
    }
    
    public String getUText(){
        return NomUtilisatuer;
    }
    
    public void setTextNorme(String Instructions) {
        Norme.setText(Instructions);
    }
    
    public void setTextAngle(String Instructions) {
        Angle.setText(Instructions);
    }

}
