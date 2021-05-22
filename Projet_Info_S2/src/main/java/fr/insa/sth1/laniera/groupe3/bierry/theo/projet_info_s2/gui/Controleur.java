/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.*;/*
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Appui_Double;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Appui_Simple;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Barre;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.ClassDessin;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Figure;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.FormatRetourEnregistrement;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Noeud;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Noeud_Simple;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Point;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Remonte_Inversion;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Segment;*/
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author drumm
 */
public class Controleur {

    private GlobalPane vue;

    private int etat;
    private Point pos1[] = new Point[2];
    private Noeud pos2[] = new Noeud[2];
    private double pos3[] = new double [2];
    private int IdPoint = 0;
    private int IdSegment = 0;
    private int IdBarre = 0;
    private int IdNoeud = 0;
    private int IdForce = 0;
    private Color Couleur;
    private Treillis TreillisControleur = new Treillis();

    private List<Figure> selection;

    public Controleur(GlobalPane vue) {
        this.vue = vue;
        this.selection = new ArrayList<>();
    }
    
    public Controleur(GlobalPane vue, int IDN, int IDB, int IDS, int IDP, int IDF) {
        this.vue = vue;
        this.selection = new ArrayList<>();
        IdPoint = IDP;
        IdSegment = IDS;
        IdBarre = IDB;
        IdNoeud = IDN;
        IdForce = IDF;
    }

    public void setIdPoint() {
        IdPoint = IdPoint - 1;
    }

    public void setIdSegment() {
        IdSegment = IdSegment - 1;
    }

    public void setIdBarre() {
        IdBarre = IdBarre - 1;
    }

    public void setIdNoeud() {
        IdNoeud = IdNoeud -1;
    }
    
    /*
    public void setIdNoeud(int i){
        IdNoeud = i;
    }
    
    public void setIdBarre(int i){
        IdBarre = i;
    }
    
    public void setIdPoint(int i){
        IdPoint = i;
    }
    
    public void setIdSegment(int i){
        IdSegment = i;
    }
    */


//----------- Permet de gérer les changements d'état pour savoir quelle fonction réaliser plus tard -----------//    
    
    public void changeEtat(int nouvelEtat) {
        this.etat = nouvelEtat;
    }
    
    
    
//----------- Permet de réaliser les fonctions de dessin lorsqu'on clique dans le canvas, en fonction du bouton appuyé -----------//    

    void clicDansZoneDessin(MouseEvent t) {
        if(etat!= 10){
            // Affiche ce sur quoi on clique dans la partie inférieure gauche et donne ses caractéristiques
            getVue().setNormeForce("");
            getVue().setAngleForce("");
            getVue().setContraintesBarres("");
            getVue().setType("");
        }
        if (etat == 10) {
            Point pClic = new Point(t.getX(), t.getY());
            Figure proche = getVue().getModel().plusProche(pClic, Double.MAX_VALUE);
            if(proche instanceof Point){
                getVue().setNormeForce("");
                getVue().setAngleForce("");
                getVue().setContraintesBarres("");
                getVue().setType("Point");
            } else if(proche instanceof Segment){
                getVue().setNormeForce("");
                getVue().setAngleForce("");
                getVue().setContraintesBarres("");
                getVue().setType("Segment");
            } else if(proche instanceof Barre){
                getVue().setNormeForce("");
                getVue().setAngleForce("");
                getVue().setContraintesBarres("Contraintes : "+((Barre)proche).getEffort());
                getVue().setType("Barre");
            } else if(proche instanceof Noeud_Simple){
                getVue().setNormeForce("Norme Force :"+((Noeud) proche ).getForceNoeud().getNorme());
                getVue().setAngleForce("Angle Force : "+ (((Noeud) proche).getForceNoeud().getAngle() + Math.PI/2));
                getVue().setContraintesBarres("");
                getVue().setType("Noeud");
            } 
            else if(proche instanceof Appui_Double){
                getVue().setNormeForce("Norme Force :"+((Noeud) proche ).getForceNoeud().getNorme());
                getVue().setAngleForce("Angle Force : "+ (((Noeud) proche).getForceNoeud().getAngle() + Math.PI/2));
                getVue().setContraintesBarres("");
                getVue().setType("Appui Double");
            }
            else if(proche instanceof Appui_Simple){
                getVue().setNormeForce("Norme Force :"+((Noeud) proche ).getForceNoeud().getNorme());
                getVue().setAngleForce("Angle Force : "+ (((Noeud) proche).getForceNoeud().getAngle() + Math.PI/2));
                getVue().setContraintesBarres("");
                getVue().setType("Appui Simple");
            }
        }
        if (etat == 20) {  
            // Gère la fonction du bouton Sélectionner
            Point pClic = new Point(t.getX(), t.getY());
            Figure proche = getVue().getModel().plusProche(pClic, Double.MAX_VALUE);
            if(proche.getColor() != Couleur){
                Couleur = proche.getColor();
            }
            if (proche != null) {
                // Défini l'action lorsqu'on clique sur une figure en appuyant avec une touche du clavier
                if (t.isShiftDown()) {
                    // Change la couleur de la figure en bleu et l'ajoute à la liste de sélection quand Shift appuyé
                    selection.add(proche);
                    proche.setColor(Color.BLUE);
                } else if (t.isControlDown()) {
                    if (selection.contains(proche)) {
                        // Enlève la figure de la sélection si elle y est deja et remet la couleur noir quand CTRL est appuyé
                        selection.remove(proche);
                        proche.setColor(Color.BLACK);
                    } else {
                        // Ajoute la figure de la sélection si elle n'y est pas et lui met la couleur bleu quand CTRL est appuyé
                        selection.add(proche);
                        proche.setColor(Color.BLUE);
                    }
                } else {
                    // Si on clique simplement sur les figures, la(es) précédente(s) figure(s) se déselectionne(nt) et se remet(tent) en noir
                    for(Figure F : selection){
                        F.setColor(Color.BLACK);
                    }
                    selection.clear();
                    selection.add(proche);
                    proche.setColor(Color.BLUE);
                }
                getVue().redrawAll();
            }
            String S = "Liste : ";
            for (Figure f : vue.getModel().getContenu()){
                S = S+f.toString();
            }
        } else if (etat == 30) {        
            //Gère la fonction du bouton Point
            double px = t.getX();
            double py = t.getY();
            ClassDessin model = this.getVue().getModel();
            this.getVue().getModel().addFigure(new Point(px, py, IdPoint, getVue().getCouleur().getValue()));
            IdPoint++;
            System.out.println("\n"+getVue().getModel());
            this.getVue().redrawAll();
        } else if (etat == 40) {            
            // Gère la fonction du bouton Segment
            Point pClic = new Point(t.getX(), t.getY());
            Point proche = getVue().getModel().PointPlusProche(pClic, Double.MAX_VALUE);
            pos1[0] = proche;
            changeEtat(41);                 
        } else if (etat == 41) {
            // Gère le deuxième point pour créer un Segment
            Point pClic = new Point(t.getX(), t.getY());
            Point proche = getVue().getModel().PointPlusProche(pClic, Double.MAX_VALUE);
            pos1[1] = proche;
            if (pos1[0] == pos1[1]) {
                changeEtat(41);
                getVue().setTextByMoi("Vous ne pouvez pas créer de segment entre deux points en même position");
            } else {
                getVue().getModel().addFigure(new Segment(IdSegment, pos1[0], pos1[1], getVue().getCouleur().getValue()));     // Changer 0 par l'indentificateur //
                IdSegment++;
                getVue().redrawAll();
                System.out.println("\n"+getVue().getModel());
                getVue().setTextByMoi("Placez 2 points pour créer un segment ou reliez 2 points déjà existants");
                changeEtat(40);
            }
        } else if (etat == 50) {
            // Gère la fonction du bouton Appui Simple
            Point pClic = new Point(t.getX(), t.getY());
            Segment S = getVue().getModel().SegmentPlusProche(pClic, Double.MAX_VALUE);
            Appui_Simple AS = Appui_Simple.CreationAppuiPossibleOuPas(IdNoeud, S, pClic, getVue().getCouleur().getValue());
            
            if (AS == null) {
                changeEtat(50);
                getVue().setTextByMoi("La création de l'appui n'est pas possible");
            } else {
                getVue().getModel().addFigure(AS);
                IdNoeud ++;
                System.out.println("Alpha1 : "+AS.getAlpha());
                System.out.println("\n"+getVue().getModel());
                getVue().redrawAll();
                getVue().setTextByMoi("Cliquez sur un segment du terrain pour y placer un appui simple");
            }
        } else if (etat == 60) {
            // Gère la fonction du bouton Appui Double
            Point pClic = new Point(t.getX(), t.getY());
            Segment S = getVue().getModel().SegmentPlusProche(pClic, Double.MAX_VALUE);
            Appui_Double AS = Appui_Double.CreationAppuiPossibleOuPas(IdNoeud, S, pClic, getVue().getCouleur().getValue());
            if (AS == null) {
                changeEtat(60);
                getVue().setTextByMoi("La création de l'appui n'est pas possible");
            } else {
                getVue().getModel().addFigure(AS);
                IdNoeud++;
                System.out.println("Alpha2 : "+AS.getAlpha());
                System.out.println("\n"+getVue().getModel());
                getVue().redrawAll();
                getVue().setTextByMoi("Cliquez sur un segment du terrain pour y placer un appui simple");
            }
        } else if (etat == 70) {
            // Gère la fonction du bouton Barre
            Point pClic = new Point(t.getX(), t.getY());
            Noeud proche = getVue().getModel().NoeudPlusProche(pClic, Double.MAX_VALUE);
            pos2[0] = proche;
            changeEtat(71);
        } else if (etat == 71) {
            // Gère le deuxième Noeud nécessaire pour créer une Barre
            Point pClic = new Point(t.getX(), t.getY());
            Noeud proche = getVue().getModel().NoeudPlusProche(pClic, Double.MAX_VALUE);
            pos2[1] = proche;
            if (pos2[0] == pos2[1]) {
                changeEtat(70);
                getVue().setTextByMoi("Vous ne pouvez pas créer de barre entre deux noeuds en même position");
            } else {
                Barre B = new Barre(IdBarre, pos2[0], pos2[1], getVue().getCouleur().getValue());
                getVue().getModel().addFigure(B);     // Changer 0 par l'indentificateur //
                IdBarre++;
                double C = Double.parseDouble(getVue().getCout());
                C = C + B.getCout();
                getVue().setCout(""+((int)C));
                System.out.println("\n"+getVue().getModel());
                getVue().redrawAll();
                getVue().setTextByMoi("Placez 2 points pour créer une barre ou reliez 2 noeuds déjà existants");
                changeEtat(70);
            }
        } else if (etat == 80) {
            // Gère la fonction du bouton Noeud
            Point pClic = new Point(t.getX(), t.getY());
            getVue().getModel().addFigure(new Noeud_Simple(pClic, IdNoeud, getVue().getCouleur().getValue()));
            IdNoeud++;
            System.out.println("\n"+getVue().getModel());
            getVue().redrawAll();
        } else if (etat == 90) {
            // Gère la fonction du bouton Vertical (reconnaissance du point ou noeud le plus proche
            getVue().setTextByMoi("Cliquez sur la figure sur laquelle vous voulez vous baser");
            Point pClic = new Point(t.getX(), t.getY());
            Figure proche = getVue().getModel().PointPlusProche(pClic, Double.MAX_VALUE);
            Point P = getVue().getModel().PointPlusProche(pClic, Double.MAX_VALUE);
            Noeud N = getVue().getModel().NoeudPlusProche(pClic, Double.MAX_VALUE);
            double D0 = P.getDistance(pClic);
            double D1 = N.getDistance(pClic);
            if(D0 < D1){
                pos3[0] = P.getAbscisse();
                changeEtat(91);
            } else{
                pos3[0] = N.getPos().getAbscisse();
                changeEtat(92);
            }
        } else if(etat == 91) {
            // Gère la fonction du bouton Vertical (placer un point)
            getVue().setTextByMoi("Cliquez à l'endroit où vous voulez positionner votre Point");
            double Ord = t.getY();
            getVue().getModel().addFigure(new Point(pos3[0], Ord));
            getVue().redrawAll();
            
        } else if (etat == 92) {
            // Gère la fonction du bouton Vertical (placer un noeud)
            getVue().setTextByMoi("Cliquez à l'endroit où vous voulez positionner votre Noeud");
            double Ord = t.getY();
            getVue().getModel().addFigure(new Noeud_Simple(pos3[0], Ord, IdNoeud, getVue().getCouleur().getValue()));
            getVue().redrawAll();
        } else if (etat == 100) {
            // Gère la fonction du bouton Horizontal (reconnaissance du point ou du noeud le plus proche
            getVue().setTextByMoi("Cliquez sur la figure sur laquelle vous voulez vous baser");
            Point pClic = new Point(t.getX(), t.getY());
            Figure proche = getVue().getModel().PointPlusProche(pClic, Double.MAX_VALUE);
            Point P = getVue().getModel().PointPlusProche(pClic, Double.MAX_VALUE);
            Noeud N = getVue().getModel().NoeudPlusProche(pClic, Double.MAX_VALUE);
            double D0 = P.getDistance(pClic);
            double D1 = N.getDistance(pClic);
            if(D0 < D1){
                pos3[0] = P.getOrdonnee();
                changeEtat(101);
            } else{
                pos3[0] = N.getPos().getOrdonnee();
                changeEtat(102);
            }
        } else if (etat==101) {
            // Gère la fonction du bouton Horizontal (placer un point)
            getVue().setTextByMoi("Cliquez à l'endroit où vous voulez positionner votre Point");
            double Abs = t.getX();
            getVue().getModel().addFigure(new Point(Abs, pos3[0]));
            getVue().redrawAll();
        } else if (etat==102) {
            // Gère la fonction du bouton Horizontal (placer un noeud)
            getVue().setTextByMoi("Cliquez à l'endroit où vous voulez positionner votre Noeud");
            double Abs = t.getX();
            getVue().getModel().addFigure(new Noeud_Simple(Abs, pos3[0], IdNoeud, getVue().getCouleur().getValue()));
            getVue().redrawAll();
        } else if (etat == 120){
            // Gère la fonction du bouton Valider
            Point pClic = new Point(t.getX(), t.getY());
            Figure Proche = getVue().getModel().NoeudPlusProche(pClic, Double.MAX_VALUE);
            Force F = new Force(getVue().getChampNorme(), getVue().getChampAngle()-(Math.PI/2), IdForce);//Le Math.PI, permet de se décaler d'un angle de 90° vers le bas, ce qui est plus intutif et donc les force, vont par défaut verticalement vers le bas
            ((Noeud) Proche).setForceNoeud(F);
            IdForce++;
            vue.setTextNorme("Norme (en N)");
            vue.setTextAngle("Angle (en rad)");
            changeEtat(10);
        }
        TreillisControleur.setTreillis(vue.getModel());
    }

    
    
//----------- Permet de changer la couleur des figures sélectionnées -----------//    
    
    void changeColor(Color value) {
        if (etat == 20) {
            for (Figure f : selection) {
                f.setColor(value);
            }
            getVue().redrawAll();
        }
    }

    
    
//----------- Permet de mettre l'état adéquat en fonction du bouton cliqué -----------//
    
    void boutonEtatNeutre(ActionEvent t) {
        changeEtat(10);
    }

    public void boutonSélectionner(ActionEvent t) {
        // Bouton Sélectionner
        changeEtat(20);
    }

    void boutonPoint(ActionEvent t) {
        // Bouton Point
        changeEtat(30);
    }

    void boutonSegment(ActionEvent t) {
        // Bouton Segment
        changeEtat(40);
    }

    public void boutonAppuiSimple(ActionEvent t) {
        // Bouton Appui Simple
        changeEtat(50);
    }

    public void boutonAppuiDouble(ActionEvent t) {
        // Bouton Appui Double
        changeEtat(60);
    }

    public void boutonBarres(ActionEvent t) {
        //Bouton Barre
        changeEtat(70);
    }

    public void boutonNoeuds(ActionEvent t) {
        // Bouton Noeud
        changeEtat(80);
    }
    
    public void boutonVertical (ActionEvent t) {
        // Bouron Vertical
        changeEtat(90);
    }
    
    public void boutonHorizontal (ActionEvent t) {
        // Bouton Horizontal
        changeEtat(100);
    }
    
    public void boutonSimulation (ActionEvent t) {
        // Gère la fonction du bouton Simulation
            Remonte_Inversion ri = getVue().getModel().Simulation();
            if(ri.isPossible() == false){
                getVue().setTextByMoi("Le treillis n'est pas isostatique");
            } else {
                ArrayList<Barre> AB = getVue().getModel().Tri_Des_Barres();
                for (Barre B : AB) {
                    B.setEffort(ri.getSolution());
                }
                getVue().redrawAll();
            }
    }

    public List<Figure> getSelection() {
        return selection;
    }

    public void menuNouveau(ActionEvent t) {
        Stage nouveau = new Stage();
        nouveau.setTitle("BRIDGE");
        nouveau.getIcons().add(new Image("file:Image_Logo.png"));
        Scene sc = new Scene(new GlobalPane(nouveau, getVue().getUText()));
        nouveau.setScene(sc);
        nouveau.show();
    }

    public void menuOuvrir(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(this.getVue().getInStage());
        if (f != null) {
            try {
                FormatRetourEnregistrement FRE = ClassDessin.Lecture_Fichier(f);
                ArrayList<Figure> af = FRE.getAF();
                ClassDessin cdOuvrir = new ClassDessin(af);
                ArrayList<Noeud> AN = cdOuvrir.Tri_Des_Noeuds();
                ArrayList<Barre> AB = cdOuvrir.Tri_Des_Barres();
                ArrayList<Segment> AS = cdOuvrir.Tri_Des_Segment();
                ArrayList<Point> AP = cdOuvrir.Tri_Des_Point();
                ArrayList<Force> AF = cdOuvrir.Recup_Force(AN);
                Stage nouveau = new Stage();
                nouveau.setTitle("BRIDGIES " + f.getName());
                GlobalPane GP = new GlobalPane(nouveau, f, cdOuvrir, AS.size(), AP.size(), AN.size(), AB.size(), AF.size(), FRE.getCout(),getVue().getUText());
                Scene sc = new Scene(GP);
                nouveau.setScene(sc);
                nouveau.show();
                GP.redrawAll();
            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Problème durant la sauvegarde");
                alert.setContentText(ex.getLocalizedMessage());

                alert.showAndWait();
            } finally {
                this.changeEtat(20);
            }
        }
    }

    private void realSauvegarder(File f) {
        try {
            this.getVue().getModel().getTreillisCD();
            this.getVue().getModel().Enregistrement(f, getVue());
            this.getVue().setCurFile(f);
            this.getVue().getInStage().setTitle("BRIDGE" + f.getName());
        } catch (IOException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Problème durant la sauvegarde");
            alert.setContentText(ex.getLocalizedMessage());

            alert.showAndWait();
        } finally {
            this.changeEtat(20);
        }
    }

    public void menuSauvegarder(ActionEvent t) {
        if (this.getVue().getCurFile() == null) {
            this.menuSauvegarderSous(t);
        } else {
            this.realSauvegarder(this.getVue().getCurFile());
        }
    }

    public void menuSauvegarderSous(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showSaveDialog(this.getVue().getInStage());
        if (f != null) {
            this.realSauvegarder(f);
        }
    }

    public void menuAPropos(ActionEvent t) {
        Label aPropos = new Label ("Ce logiciel a été dévellopé par trois gugus en STH1 durant l'année de 2020 / 2021, année Coronus, dans le cadre d'un projet d'informatique pour le deuxième semestre.\n\n\nSinon, j'ai une blague : \nf et f' sont sur un bateau, f tombe à l'eau, que se passe t-il?\n\n\nLe bateau dérive ;-) ;-)\n");
       
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(aPropos);
        Scene secondScene = new Scene(secondaryLayout);
        
        Stage newWindow = new Stage();
        newWindow.getIcons().add(new Image("file:Image_Logo.png"));
        newWindow.setTitle("BRIDGIES - Fenêtre d'aide");
        newWindow.setScene(secondScene);
        
        newWindow.show();
    }
    
    public void menuAideUtilisation (ActionEvent t) {
        Label indications = new Label (" - Boutons Point / Segment: appuyez d'abord sur Terrain \n"
            + " - Boutons Appuis, Noeuds, Barres : appuyez d'abord sur Pont\n\n"
            + " - Point : appuyez où vous voulez sur la zone centrale pour placer les points qui définirons le terrain (vous pouvez changer les couleurs avec le bouton prévu à cet effet sur le côté gauche)\n"
            + " - Segment : reliez deux points existants pour former le terrain (vous pouvez changer les couleurs avec le bouton prévu à cet effet sur le côté gauche)\n\n"
            + " - Appui Simple : appuyez sur un segment existant pour y placer l'appui simple\n"
            + " - Appui Double : appuyez sur un segment existant pour y placer l'appui double\n"
            + " - Noeud : appuyez sur la zone de dessin pour y placer un noeud\n"
            + " - Barre : reliez 2 noeuds / appuis pour y former une barre\n\n"
            + " - Simulation : une fois le treillis fini, appuyez sur simulation. Un treillis vert = treillis isostatique, si message dans la partie inférieure, alors le treillis n'est pas isostatique\n\n"
            + " - Force : entrez la norme du vecteur force ainsi que son angle, puis validez et sélectionnez le noeud sur lesquel vous voulez appliquer cette force\n\n"
            + " - Vertical : sélectionnez le point ou le noeud sur lequel vous voulez vous baser (pour son abscisse), puis cliquez où vous voulez pour créer la nouvelle figure voulue\n"
            + " - Horizontal : sélectionnez le point ou le noeud sur lequel vous voulez vous baser (pour son ordonnée), puis cliquez où vous voulez pour créer la nouvelle figure voulue\n\n"
            + " - Sélectionner : cliquez et la forme sélectionnée devient bleue. Appuyez sur ctrl et vous pourrez en sélectionner plusieurs\n"
            + " - Supprimer : sélectionnez d'abord les figures avec le bouton sélectionner (voir au-dessus) puis appuyez sur supprimer. Les figures auront disparues");
        
             
        VBox textInfo = new VBox (indications);
        
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(textInfo);
        Scene secondScene = new Scene(secondaryLayout);
        
        Stage newWindow = new Stage();
        newWindow.getIcons().add(new Image("file:Image_Logo.png"));
        newWindow.setTitle("BRIDGIES - Fenêtre d'aide");
        newWindow.setScene(secondScene);
        
        newWindow.show();
    }
    
    public void menuFAQ (ActionEvent t) {
        Label premireQuestion = new Label ("\nQuelle est la différence entre un Point, un Noeud, un Appui Simple et un Appui Double?\nUn Point est l'extremité d'un segment ou le lieu d'intersection, tandis qu'un Noeud, un Appui Simple ou un Appui double sont des extrémités ou des lieu d'intersection de barres.\n\nQuelle est la différence entre une Barre et un Segment?\nUne Barre relie 2 Noeuds/Appui Simple/Appui Double, tandis qu'un segment relie 2 Points.\n\nQuelle est la différence entre un Appui Simple/Double et un Noeud?\nUn Appui Simple/Double est obligatoirement fixé à un segment tandis qu'un Noeud peut-être situé n'importe ou dans l'espace.\n\nQuelle est la différence entre un Appui Simple et un Appui Double?\nUn appui Simple peut se déplacer tangeanciellement au terrain, c'est à dire que sa réaction est perpendiculaire au terrain, \npar contre, un appui Double, lui, est fixe par rapport au terrain, ainsi il poossède deux valeurs de réaction inconnues et indépendantes, une selon X et la seconde selon Y.\n\nComment définir un terrain?\nUn terrain se définie simplement par un segment, il n'y a alor pas besoin de faire un triangle terrain, \nvous pouvez eventuellement le dessiner mais celui-ci ne rentrera pas en compte dans les calculs.\n\n Comment créer une force?\nPour créer une force, il faut d'abord cliquer sur le bouton force, puis entre la norme de la force et l'angle. Ensuite cliquer sur valider \net cliquer sur un Noeud dans la zone dessin, vous ne verrai alors pas directement, mais la force sera bien ajoutée.\n\nA quoi correspond l'angle d'une force?\nL'angle permet de définir la direction et le sens de la force. L'angle 0 est définie come étant l'angle décrivant une direction verticale et un sens vers le bas. \nEnsuite, les valeurs sont demandées en radiant et cela tourne dans le sens trigonométrique, ce qui signifie qu'un angle de PI/2 définit une direction verticale et un sens vers la droite.\nATTENTION, le logiciel n'accepte pas les Strings en entrés dans les champs de l'angle et de la force. Ainsi, il faut mettre 1.57 au lieu de PI/2 par exemple.\n\nComment enregistrer un fichier?\nPour enregistre un fichier, il faut clqieur sur enregistre se placer ou l'on veut, mettre le nom que l'on souhaite, et surtout, ATTENTION, il ne faut pas oublier de mettre à la fin.txt pour que le fichier puise être relue\n\nComment fait-on des frites à la poelle?\nPour faire des frites dans une poele, on prend une poele, on met un fond d'huile, on fait cahuffer, pendant ce temps, \non coupe finement les pommes de terre en forme de frite, puis on les même dans la poêle.\nOn laisse cuirre 20-25 minutes histoire que se soit un petit peu cramé croisstillant, et on déguste.\n\nQuelle est la meilleur équipe de football au monde?\nC'est bien évidemment l'AJAuxerre :-).");
        
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(premireQuestion);
        Scene secondScene = new Scene(secondaryLayout);
        
        Stage newWindow = new Stage();
   //     newWindow.setX()
        newWindow.getIcons().add(new Image("file:Image_Logo.png"));
        newWindow.setTitle("BRIDGIES - FAQ");
        newWindow.setScene(secondScene);
        
        newWindow.show();
    }

    /**
     * @return the vue
     */
    public GlobalPane getVue() {
        return vue;
    }

    public int getIdPoint() {
        return IdPoint;
    }

    public int getIdSegment() {
        return IdSegment;
    }

    public int getIdBarre() {
        return IdBarre;
    }

    public int getIdNoeud() {
        return IdNoeud;
    }

    public void setIdPoint(int IdPoint) {
        this.IdPoint = IdPoint;
    }

    public void setIdSegment(int IdSegment) {
        this.IdSegment = IdSegment;
    }

    public void setIdBarre(int IdBarre) {
        this.IdBarre = IdBarre;
    }

    public void setIdNoeud(int IdNoeud) {
        this.IdNoeud = IdNoeud;
    }
    
    public Treillis getTreillisControleur(){
        return TreillisControleur;
    }

    void BoutonValider(ActionEvent t) {
        changeEtat(120);
    }
    
    
    
    
}
