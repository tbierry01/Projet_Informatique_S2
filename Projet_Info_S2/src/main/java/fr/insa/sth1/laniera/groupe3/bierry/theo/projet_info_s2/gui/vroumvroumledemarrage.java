/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;


import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
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
 * @author Youri
 */
public class vroumvroumledemarrage extends BorderPane  {

    private Label Conseil;
    private Label Loading ;
    private Label Password;
    private Stage inStage2;
    private Button BoutonInutile ;
    private ProgressBar barre;
    private Label Bridgies;
    private Button Identifiant;
    public boolean Vbouton;
    public Button closeButton;
    private Label Username;
    private TextField UText;
    private PasswordField PText;
    private ToggleButton showbutton;
    private Label show;
    private HBox PasswordHBox;
    private ToggleGroup AfficherMasquer;
    private ToggleButton hidebutton;
    private HBox PasswordHBox2;
    private Button SeConnecter;
    private Label Indication;
    private boolean CodeBon=false;
    private Hyperlink MDPOublie; 
    private Scene scene2;
    double i=0;
    private ProgressIndicator pourcentage;
    private boolean justeUnefois=true;
    private Font fonte;
    private VBox page;

    
    public static String Conseil(double i) {
        String res="";
        if (i<0.25) {
            res="  Boire de l'eau c'est bon pour la santé  ";
        }
        if (i>=0.25 && i<0.50) {
            res="  Pour manger il faut de la nourriture  ";
        }
        if (i>=0.50 && i<0.75) {
            res="  Pour lutter contre le covid, il faut ouvrir la fenêtre  ";       
        }
        if (i>=0.75) {
            res="  Un projet d'informatique se travaille  ";            
        }
    return("      Conseil : "+ "\n" +res); 
    }



    public vroumvroumledemarrage(Stage primaryStage) throws FileNotFoundException {
        this.Conseil = new Label(Conseil(Math.random()));
        this.Bridgies = new Label(" Bridgies ");
        Bridgies.setFont(new Font("Bauhaus 93",100));
        //Bridgies.setStyle("-fx-background-color:grey");
        Conseil.setFont(new Font("Harrington",20));
        Conseil.setStyle("-fx-background-color:lightgrey");
        Image Image_Logo2 = new Image("file:Image_Logo2-2.png");
        ImageView ImageSimu = new ImageView(new Image("file:Image_Simulation.png"));
        this.BoutonInutile = new Button("Bouton \n Inutile");
        this.BoutonInutile.setContentDisplay(ContentDisplay.BOTTOM);
        
        this.BoutonInutile.setPrefSize(100, 100);
        BoutonInutile.setStyle("-fx-background-color:lightgrey");
        BoutonInutile.setFont(new Font("Harrington",20));
        BoutonInutile.setTextFill(Color.DARKGRAY);
        //deco
        Rectangle rectangledeco = new Rectangle();
        rectangledeco.setWidth(500);
        rectangledeco.setHeight(3);
        rectangledeco.setFill(Color.TRANSPARENT);
        Rectangle rectangledeco2 = new Rectangle();
        rectangledeco2.setWidth(500);
        rectangledeco2.setHeight(3);
        rectangledeco2.setFill(Color.TRANSPARENT);
        Rectangle rectangledeco3 = new Rectangle();
        rectangledeco3.setWidth(500);
        rectangledeco3.setHeight(3);
        rectangledeco3.setFill(Color.TRANSPARENT);
                
        //HBox Chargement et identifiant
        this.Identifiant = new Button("Rentrer ses identifiants");
        this.barre = new ProgressBar(0);
        this.pourcentage = new ProgressIndicator(0);
        //pourcentage.setStyle("-fx-background-color:lightgrey");

        HBox chargement = new HBox(this.barre,this.pourcentage);
        chargement.setSpacing(10);
        chargement.setAlignment(Pos.CENTER);
        Identifiant.setFont(new Font("Bell MT",20));
        
        //VBox final
        this.page = new VBox(this.Bridgies,rectangledeco2,this.BoutonInutile,chargement,this.Identifiant,rectangledeco3,this.Conseil);
        this.setLeft(page);
        page.setSpacing(25); //545
        page.setPadding(new javafx.geometry.Insets(15,0,15,0));
        page.setAlignment(Pos.CENTER);
        BackgroundImage backgroundimage = new BackgroundImage(Image_Logo2, 
                                             BackgroundRepeat.NO_REPEAT, 
                                             BackgroundRepeat.NO_REPEAT, 
                                             BackgroundPosition.DEFAULT, 
                                             BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);
        this.setBackground(background);
        System.out.println(Image_Logo2.getWidth());
        
        //C'est la barre de chargement, avec un bouton identifiant disable tant que la barre n'est pas complète
        //Identifiant.setDisable(true);
        
        BoutonInutile.setOnAction((ttt)-> {
            if (justeUnefois==true) {
                barre.setProgress(barre.getProgress()+ Math.random()/7);
                pourcentage.setProgress(barre.getProgress());
            }
            if (barre.getProgress() >= 0.5 && barre.getProgress()<0.6 ) {
                Conseil.setText("      Conseil : "+ "\n"+" On y est presque ");
            } 
            if (justeUnefois==false)
                barre.setProgress(barre.getProgress()+ 0.334);
                pourcentage.setProgress(barre.getProgress());
            if (barre.getProgress() >= 0.9 && justeUnefois==true) {
                    barre.setProgress(0);
                    pourcentage.setProgress(barre.getProgress());
                    Conseil.setText("      Conseil : "+ "\n"+" Dommage, c'est revenu à zéro.. ");
                    justeUnefois=false;
            }

            if (barre.getProgress() >= 1) {
                Identifiant.setDisable(false);
                Conseil.setText("      Conseil : "+ "\n"+"Allez rentrer vos identifiants ");
            }
        });
        primaryStage.setResizable(false);
        //page qui s'affiche quand on clique sur identifiant
        
        
        Identifiant.setOnAction((t) -> {
                
                //définition des attributs
                
                this.Username = new Label("Nom d'utilisateur :");
                this.UText = new TextField("Entrer le nom d'utilisateur");
                this.Password = new Label("Mot de passe :");
                this.PText = new PasswordField();
                this.SeConnecter = new Button("Se Connecter");
                Rectangle rectangledeco5 = new Rectangle();
                rectangledeco5.setWidth(145);
                rectangledeco5.setHeight(2);
                rectangledeco5.setFill(Color.GREY);
                
                //On crée les boutons pour masquer
                this.AfficherMasquer = new ToggleGroup();
                this.hidebutton = new ToggleButton("Masquer");
                this.showbutton = new ToggleButton("Afficher");
                hidebutton.setToggleGroup(AfficherMasquer);
                showbutton.setToggleGroup(AfficherMasquer);
                
                hidebutton.setSelected(true); //le bouton masquer est appuyer par défaut
                this.show = new Label("");
                this.Indication = new Label("Conseil : Rentrez votre mot de passe et votre nom d'utilisateur");
                
                //On fixe le bouton "Afficher" pour afficher le mot de passe à gauche de la HBox
                showbutton.setOnAction(new EventHandler<ActionEvent>() {
 
                    @Override
                    public void handle(ActionEvent event) {
                        String password = PText.getText();
                        show.setText(password);
                    }
                });
                //On fixe le bouton "Masquer" pour masquer le mot de passe à gauche de la HBox
                hidebutton.setOnAction(new EventHandler<ActionEvent>() {
 
                    @Override
                    public void handle(ActionEvent event) {
                        show.setText("");
                    }
                });
                
                //on fait en sorte que lorsqu'on appuie sur la barre de texte, le "entrer.." disparait
                UText.setOnMouseClicked((ti) -> {
                        if (UText.getText().equals("Entrer le nom d'utilisateur")){
                            UText.setText("");
                        }
                });
                
                //on crée un hyperlink pour pouvoir rouvrir une nouvelle page pour mot de passe oublié
                this.MDPOublie = new Hyperlink("Mot de passe oublié ?");
                
                //on définit une nouvelle scène pour mot de passe oublié
                MDPOublie.setOnAction(new EventHandler<ActionEvent>() {
                    private VBox VBoxInutile;
                    private Button BoutonInutile2;
                    @Override
                    public void handle(ActionEvent event) {
                        this.BoutonInutile2 = new Button("Pour vous consoler :"  +"\n" +"un bouton satisfaisant"); 
                        this.VBoxInutile = new VBox(this.BoutonInutile2);
                        VBoxInutile.setPadding(new javafx.geometry.Insets(15,15,15,15));
                        //On configure la scene
                        Scene SceneOublie = new Scene(VBoxInutile, 200,75);
                        Stage UselessWindow = new Stage();
                        UselessWindow.setScene(SceneOublie);                
                        UselessWindow.getIcons().add(new Image("file:Image_Logo.png"));
                        UselessWindow.setTitle("Dommage");
                        UselessWindow.setX(primaryStage.getX() + 400);
                        UselessWindow.setY(primaryStage.getY() + 100);
                        UselessWindow.setResizable(false);
                        UselessWindow.show();
                    }
                });
                //on définit la disposition de la scène Identifiant
                this.PasswordHBox = new HBox(this.showbutton,this.hidebutton,this.show);
                PasswordHBox.setSpacing(20);
                this.PasswordHBox2 = new HBox(this.PText,this.SeConnecter,this.MDPOublie);
                PasswordHBox2.setSpacing(20);

                VBox PasswordVBox = new VBox(this.Username,this.UText,this.Password,this.PasswordHBox2,this.PasswordHBox,rectangledeco5,this.Indication);
                Scene Scene2 = new Scene(PasswordVBox, 500, 220);
                PasswordVBox.setSpacing(10);
                PasswordVBox.setPadding(new javafx.geometry.Insets(15,15,15,15));
                PasswordVBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY))); //on change la couleur de fond de la VBox
 
                // on crée la nouvelle page
                Stage PasswordWindow = new Stage();
                PasswordWindow.setScene(Scene2);
                PasswordWindow.getIcons().add(new Image("file:Image_Logo.png"));
                PasswordWindow.setTitle("Connexion...");
                
 
                // fixer la position et la taille par rapport au stage de base et on la rend insizable
                PasswordWindow.setX(primaryStage.getX() + 200);
                PasswordWindow.setY(primaryStage.getY() + 100);
                PasswordWindow.setResizable(false);
                
 
                PasswordWindow.show();
                
                //On configure le bouton SeConnecter avec les indications
                SeConnecter.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {

                        if (PText.getText().equals("")){
                            Indication.setText("Conseil : Vous n'avez même pas écrit votre mot de passe...");
                            Indication.setTextFill(Color.rgb(0, 0, 0));
                        }
                        else if (!(PText.getText().equals("DeBeuvron") || PText.getText().equals("Coulibaly"))) { //tant que l'un des 2 mdp n'est pas rentré, on renvoie des choses différentes dans conseils
                            Indication.setText("Conseil : Votre mot de passe est incorrect");
                            Indication.setTextFill(Color.rgb(210, 39, 30));
                        } 
                        else {
                            Indication.setText("Conseil : Votre mot de passe est correct");
                            Indication.setTextFill(Color.rgb(21, 117, 84));
                            CodeBon=true; //le mdp devient correct, reste à savoir si le nom d'utilisateur est toujours correct
                        }
                        if (UText.getText().equals("") || UText.getText().equals("Entrer le nom d'utilisateur")) {
                            Indication.setText("Conseil : Votre nom d'utilisateur");
                            CodeBon=false; //le code redevient faux, même si le mdp est juste, car le nom d'utilisateur n'est pas rentré
                        }
                        if (CodeBon==true) { 

                            //si le code est bon, on passe à la scène suivante
                            
                            PasswordWindow.close();
                            scene2 = new Scene(new GlobalPane(primaryStage));
                            primaryStage.setScene(scene2);
                            primaryStage.setX(primaryStage.getX() - 500);
                            primaryStage.setResizable(true);
                        }
                        PText.clear();
                    }
                });
            }
        );

                
        
        

    }
    
    
}


