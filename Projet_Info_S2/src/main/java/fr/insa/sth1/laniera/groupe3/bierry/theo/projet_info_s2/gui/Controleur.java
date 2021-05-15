/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Appui_Double;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Appui_Simple;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Barre;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.ClassDessin;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Figure;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.FormatRetourEnregistrement;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Noeud;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Noeud_Simple;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Point;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Segment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
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
    private int IdPoint = 0;
    private int IdSegment = 0;
    private int IdBarre = 0;
    private int IdNoeud = 0;

    private List<Figure> selection;

    public Controleur(GlobalPane vue) {
        this.vue = vue;
        this.selection = new ArrayList<>();
    }

    public void changeEtat(int nouvelEtat) {
        if (nouvelEtat == 30) {                         // On est dans l'état Point donc on désactive le bouton Segment //
//            this.vue.getSegment().setDisable(true);
        } else if (nouvelEtat == 40) {                  // On est dans l'état Segment donc on désactive le bouton Point //
//            this.vue.getPoint().setDisable(true);
        } else if (nouvelEtat == 41) {                  // On est dans l'état Segment pour créer le 2e point //
//            this.vue.getPoint().setDisable(true);
        } else if (nouvelEtat == 50) {                  // On est dans l'état Appui Simple donc on désactive les boutons Appui Double, Barres et Noeuds  //
/*            this.vue.getAppuiDouble().setDisable(true);
            this.vue.getBarres().setDisable(true);
            this.vue.getNoeuds().setDisable(true);
             */        } else if (nouvelEtat == 60) {                  // On est dans l'état Appui Double donc on désactive les boutons Appui Simple, Barres et Noeuds  //
/*            this.vue.getAppuiSimple().setDisable(true);
            this.vue.getBarres().setDisable(true);
            this.vue.getNoeuds().setDisable(true);
             */        } else if (nouvelEtat == 70) {                  // On est dans l'état Barres donc on désactive les boutons Appui Simple, Appui Double et Noeuds  //
/*            this.vue.getAppuiDouble().setDisable(true);
            this.vue.getAppuiSimple().setDisable(true);
            this.vue.getNoeuds().setDisable(true);
             */        } else if (nouvelEtat == 71) {
        } else if (nouvelEtat == 80) {                  // On est dans l'état Noeuds donc on désactive les boutons Appui Simple, Appui Double et Barres  //
/*            this.vue.getAppuiSimple().setDisable(true);
            this.vue.getAppuiDouble().setDisable(true);
            this.vue.getBarres().setDisable(true);
             */        }
        this.etat = nouvelEtat;
    }

    void clicDansZoneDessin(MouseEvent t) {
        if (etat == 10) {
        }
        if (etat == 20) {
            Point pClic = new Point(t.getX(), t.getY());
            Figure proche = vue.getModel().plusProche(pClic, Double.MAX_VALUE);
            Color C = proche.getColor();
            System.out.println("je mets un petit message " + proche);
            if (proche != null) {
                if (t.isShiftDown()) {
                    selection.add(proche);
                    proche.setColor(Color.BLUE);
                } else if (t.isControlDown()) {
                    if (selection.contains(proche)) {
                        selection.remove(proche);
                        proche.setColor(Color.PINK);
                    } else {
                        selection.add(proche);
                        proche.setColor(Color.BLUE);
                    }
                } else {
                    selection.clear();
                    selection.add(proche);
                    proche.setColor(Color.BLUE);
                }
                vue.redrawAll();
            }
        } else if (etat == 30) {            // 30 correspond à l'état Point //
            double px = t.getX();
            double py = t.getY();
            ClassDessin model = this.vue.getModel();
            this.vue.getModel().addFigure(new Point(px, py, IdPoint, vue.getCouleur().getValue()));
            IdPoint++;
            this.vue.redrawAll();
        } else if (etat == 40) {            // 40 correspond à l'état Segment //
            Point pClic = new Point(t.getX(), t.getY());
            Point proche = vue.getModel().PointPlusProche(pClic, Double.MAX_VALUE);
            pos1[0] = proche;
            changeEtat(41);                 // 41 correspond au 2e point de l'état Segment //
        } else if (etat == 41) {
            Point pClic = new Point(t.getX(), t.getY());
            Point proche = vue.getModel().PointPlusProche(pClic, Double.MAX_VALUE);
            pos1[1] = proche;
            if (pos1[0] == pos1[1]) {
                changeEtat(41);
                vue.setTextByMoi("Vous ne pouvez pas créer de segment entre deux points en même position");
            } else {
                vue.getModel().addFigure(new Segment(IdSegment, pos1[0], pos1[1], vue.getCouleur().getValue()));     // Changer 0 par l'indentificateur //
                IdSegment++;
                vue.redrawAll();
                vue.setTextByMoi("Placez 2 points pour créer un segment ou reliez 2 points déjà existants");
                changeEtat(40);
            }
        } else if (etat == 50) {
            Point pClic = new Point(t.getX(), t.getY());
            Segment S = vue.getModel().SegmentPlusProche(pClic, Double.MAX_VALUE);
            Appui_Simple AS = Appui_Simple.CreationAppuiPossibleOuPas(IdNoeud, S, pClic, vue.getCouleur().getValue());
            
            if (AS == null) {
                changeEtat(50);
                vue.setTextByMoi("La création de l'appui n'est pas possible");
            } else {
                vue.getModel().addFigure(AS);
                IdNoeud ++;
                System.out.println("Alpha1 : "+AS.getAlpha());
                vue.redrawAll();
                vue.setTextByMoi("Cliquez sur un segment du terrain pour y placer un appui simple");
            }
        } else if (etat == 60) {
            //System.out.println("Ok on passe par l'état 60");
            Point pClic = new Point(t.getX(), t.getY());
            Segment S = vue.getModel().SegmentPlusProche(pClic, Double.MAX_VALUE);
            Appui_Double AS = Appui_Double.CreationAppuiPossibleOuPas(IdNoeud, S, pClic, vue.getCouleur().getValue());
            if (AS == null) {
                changeEtat(60);
                vue.setTextByMoi("La création de l'appui n'est pas possible");
            } else {
                vue.getModel().addFigure(AS);
                IdNoeud++;
                System.out.println("Alpha2 : "+AS.getAlpha());
                vue.redrawAll();
                vue.setTextByMoi("Cliquez sur un segment du terrain pour y placer un appui simple");
            }
        } else if (etat == 70) {
            Point pClic = new Point(t.getX(), t.getY());
            Noeud proche = vue.getModel().NoeudPlusProche(pClic, Double.MAX_VALUE);
            pos2[0] = proche;
            changeEtat(71);
        } else if (etat == 71) {
            Point pClic = new Point(t.getX(), t.getY());
            Noeud proche = vue.getModel().NoeudPlusProche(pClic, Double.MAX_VALUE);
            pos2[1] = proche;
            if (pos2[0] == pos2[1]) {
                changeEtat(70);
                vue.setTextByMoi("Vous ne pouvez pas créer de barre entre deux noeuds en même position");
            } else {
                vue.getModel().addFigure(new Barre(IdBarre, pos2[0], pos2[1], vue.getCouleur().getValue()));     // Changer 0 par l'indentificateur //
                IdBarre++;
                vue.redrawAll();
                vue.setTextByMoi("Placez 2 points pour créer une barre ou reliez 2 noeuds déjà existants");
                changeEtat(70);
            }
        } else if (etat == 80) {
            Point pClic = new Point(t.getX(), t.getY());
            vue.getModel().addFigure(new Noeud_Simple(pClic, IdNoeud, vue.getCouleur().getValue()));
            IdNoeud++;
            vue.redrawAll();
        } else if (etat == 90) {
            Point pClic = new Point(t.getX(), t.getY());
            Point P = vue.getModel().PointPlusProche(pClic, Double.MAX_VALUE);
            Noeud N = vue.getModel().NoeudPlusProche(pClic, Double.MAX_VALUE);
            double D0 = P.getDistance(pClic);
            double D1 = N.getDistance(pClic);
            if(D0 < D1){
                double Abs = P.getAbscisse();
                vue.getModel().addFigure(new Point(Abs, t.getY()));
                vue.redrawAll();
            } else{
                double Abs = N.getPos().getAbscisse();
                vue.getModel().addFigure(new Noeud_Simple(Abs, t.getY(), 0, vue.getCouleur().getValue()));
                vue.redrawAll();
            }
        } else if (etat == 100) {
            Point pClic = new Point(t.getX(), t.getY());
            Point P = vue.getModel().PointPlusProche(pClic, Double.MAX_VALUE);
            Noeud N = vue.getModel().NoeudPlusProche(pClic, Double.MAX_VALUE);
            double D0 = P.getDistance(pClic);
            double D1 = N.getDistance(pClic);
            if(D0 < D1){
                double Ord = P.getOrdonnee();
                vue.getModel().addFigure(new Point(t.getX(), Ord));
                vue.redrawAll();
            } else{
                double Ord = N.getPos().getOrdonnee();
                vue.getModel().addFigure(new Noeud_Simple(t.getX(), Ord, 0, vue.getCouleur().getValue()));
                vue.redrawAll();
            }
        }
    }

    void changeColor(Color value) {
        if (etat == 20) {
            for (Figure f : selection) {
                f.setColor(value);
            }
            vue.redrawAll();
        }
    }

    void boutonEtatNeutre(ActionEvent t) {
        changeEtat(10);
    }

    public void boutonSélectionner(ActionEvent t) {
        System.out.println("Je passe par là");
        changeEtat(20);
    }

    void boutonPoint(ActionEvent t) {
        changeEtat(30);
    }

    void boutonSegment(ActionEvent t) {
        changeEtat(40);
    }

    public void boutonAppuiSimple(ActionEvent t) {
        changeEtat(50);
    }

    public void boutonAppuiDouble(ActionEvent t) {
        changeEtat(60);
    }

    public void boutonBarres(ActionEvent t) {
        changeEtat(70);
    }

    public void boutonNoeuds(ActionEvent t) {
        changeEtat(80);
    }
    
    public void boutonVertical (ActionEvent t) {
        changeEtat(90);
    }
    
    public void boutonHorizontal (ActionEvent t) {
        changeEtat(100);
    }

    public List<Figure> getSelection() {
        return selection;
    }

    public void menuNouveau(ActionEvent t) {
        Stage nouveau = new Stage();
        nouveau.setTitle("BRIDGE");
        Scene sc = new Scene(new GlobalPane(nouveau));
        nouveau.setScene(sc);
        nouveau.show();
    }

    public void menuOuvrir(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(this.vue.getInStage());
        if (f != null) {
            try {
                FormatRetourEnregistrement FRE = ClassDessin.Lecture_Fichier(f);
                ArrayList<Figure> af = FRE.getAF();
                ClassDessin cdOuvrir = new ClassDessin(af);
                Stage nouveau = new Stage();
                nouveau.setTitle("BRIDGE " + f.getName());
                GlobalPane GP = new GlobalPane(nouveau, f, cdOuvrir);
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
            this.vue.getModel().getTreillisCD();
            this.vue.getModel().Enregistrement(f);
            this.vue.setCurFile(f);
            this.vue.getInStage().setTitle("BRIDGE" + f.getName());
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
        if (this.vue.getCurFile() == null) {
            this.menuSauvegarderSous(t);
        } else {
            this.realSauvegarder(this.vue.getCurFile());
        }
    }

    public void menuSauvegarderSous(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showSaveDialog(this.vue.getInStage());
        if (f != null) {
            this.realSauvegarder(f);
        }
    }

    public void menuAPropos(ActionEvent t) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("A propos");
        alert.setHeaderText(null);
        alert.setContentText("Yo Cocorico, j'ai une blague : \nf et f' sont sur un bateau, f tombe à l'eau, que se passe t-il?\n\n\nLe bateau dérive \nmdrrr");

        alert.showAndWait();
    }
}
