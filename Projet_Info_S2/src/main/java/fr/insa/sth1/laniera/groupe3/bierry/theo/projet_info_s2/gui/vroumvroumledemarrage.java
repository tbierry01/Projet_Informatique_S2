/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author Youri
 */
public class vroumvroumledemarrage extends BorderPane {

    private Label Conseil;
    private Label Loading ;
    private Label Password;
    private Stage inStage2;
    private ToggleButton BoutonInutile ;
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

    
    public static String Conseil(double i) {
        System.out.println(i);
        String res="";
        if (i<0.25) {
            res="Boire de l'eau c'est bon pour la santé";
        }
        if (i>=0.25 && i<0.50) {
            res="Pour manger il faut de la nourriture";
        }
        if (i>=0.50 && i<0.75) {
            res="Pour lutter contre le covid, il faut ouvrir la fenêtre";       
        }
        if (i>=0.75) {
            res="Non";            
        }
    return("Conseil : "+ "\n" +res); 
    }



    public vroumvroumledemarrage(Stage primaryStage) {
        this.Conseil = new Label(Conseil(Math.random()));
        this.Bridgies = new Label("Bridgies");
        
        ImageView ImageSimu = new ImageView(new Image("file:Image_Simulation.png"));
        this.BoutonInutile = new ToggleButton("Bouton Inutile",ImageSimu);
        this.BoutonInutile.setContentDisplay(ContentDisplay.BOTTOM);
        this.BoutonInutile.setPrefSize(100, 100);
        
        this.Identifiant = new Button("Rentrer ses identifiants");
        this.barre = new ProgressBar(0);
        this.pourcentage = new ProgressIndicator(0);
        HBox chargement = new HBox(this.barre,this.pourcentage);
        chargement.setSpacing(10);
        
        
        VBox page = new VBox(this.Bridgies,this.BoutonInutile,chargement,this.Identifiant,this.Conseil);
        this.setRight(page);
        page.setSpacing(25);
        page.setPadding(new javafx.geometry.Insets(15,15,15,15));
        
        
        while (i<100) {
            Identifiant.setDisable(true);
            i=i+1;
        }
        Identifiant.setDisable(false);
        Identifiant.setOnAction((t) -> {
                this.Username = new Label("Nom d'utilisateur");
                this.UText = new TextField("Entrer le nom d'utilisateur");
                this.Password = new Label("Mot de passe");
                this.PText = new PasswordField();
                this.SeConnecter = new Button("Se Connecter");
                
                //On crée les boutons pour masquer
                this.AfficherMasquer = new ToggleGroup();
                this.hidebutton = new ToggleButton("Masquer");
                this.showbutton = new ToggleButton("Afficher");
                hidebutton.setToggleGroup(AfficherMasquer);
                showbutton.setToggleGroup(AfficherMasquer);
                hidebutton.setSelected(true);
                this.show = new Label("");
                this.Indication = new Label("Conseil : Rentrez votre mot de passe et votre nom d'utilisateur");
                
 
                showbutton.setOnAction(new EventHandler<ActionEvent>() {
 
                    @Override
                    public void handle(ActionEvent event) {
                        String password = PText.getText();
                        show.setText(password);
                    }
                });
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

                this.MDPOublie = new Hyperlink("Mot de passe oublié ?");
 
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
                        UselessWindow.show();
                    }
                });
                this.PasswordHBox = new HBox(this.showbutton,this.hidebutton,this.show);
                PasswordHBox.setSpacing(20);
                this.PasswordHBox2 = new HBox(this.PText,this.SeConnecter,this.MDPOublie);
                PasswordHBox2.setSpacing(20);

                VBox PasswordVBox = new VBox(this.Username,this.UText,this.Password,this.PasswordHBox2,this.PasswordHBox,this.Indication);
                Scene Scene2 = new Scene(PasswordVBox, 500, 200);
                PasswordVBox.setSpacing(10);
                PasswordVBox.setPadding(new javafx.geometry.Insets(15,15,15,15));
 
                // on crée la nouvelle page
                Stage PasswordWindow = new Stage();
                PasswordWindow.setScene(Scene2);
                PasswordWindow.getIcons().add(new Image("file:Image_Logo.png"));
                PasswordWindow.setTitle("Connexion...");
 
                // fixer la position et la taille par rapport au stage de base
                PasswordWindow.setX(primaryStage.getX() + 200);
                PasswordWindow.setY(primaryStage.getY() + 100);
                
 
                PasswordWindow.show();
                
                //On configure le bouton SeConnecter avec les indications
                SeConnecter.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent e) {

                        if (PText.getText().equals("")){
                            Indication.setText("Conseil : Vous n'avez même pas écrit votre mot de passe...");
                            Indication.setTextFill(Color.rgb(0, 0, 0));
                        }
                        else if (!(PText.getText().equals("DeBeuvron") || PText.getText().equals("Coulibaly"))) {
                            Indication.setText("Conseil : Votre mot de passe est incorrect");
                            Indication.setTextFill(Color.rgb(210, 39, 30));
                        } 
                        else {
                            Indication.setText("Conseil : Votre mot de passe est correct");
                            Indication.setTextFill(Color.rgb(21, 117, 84));
                            CodeBon=true;
                        }
                        if (UText.getText().equals("") || UText.getText().equals("Entrer le nom d'utilisateur")) {
                            Indication.setText("Conseil : Votre nom d'utilisateur");
                            CodeBon=false;
                        }
                        if (CodeBon==true) {
                            //attendre 1secondes
                            Indication.setText("Veuillez patientez...");
                            //attendre 3 secondes
                            PasswordWindow.close();
                            scene2 = new Scene(new GlobalPane(primaryStage));
                            primaryStage.setScene(scene2);
                            primaryStage.setX(primaryStage.getX() - 500);
                        }
                        PText.clear();
                    }
                });
            }
        );

                
        
        

    }
}


