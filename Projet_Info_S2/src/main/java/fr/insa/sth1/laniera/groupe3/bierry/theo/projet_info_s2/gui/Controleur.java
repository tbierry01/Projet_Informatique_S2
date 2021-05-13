/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.ClassDessin;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Figure;
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
    private double pos1 [] = new double [2];
    
    private List<Figure> selection;
    
    public Controleur (GlobalPane vue) {
        this.vue = vue;
        this.selection = new ArrayList<>();
    }
    
    public void changeEtat (int nouvelEtat) {
        if (nouvelEtat == 30) {                         // On est dans l'état Point donc on désactive le bouton Segment //
//            this.vue.getSegment().setDisable(true);
        } else if (nouvelEtat == 40) {                  // On est dans l'état Segment donc on désactive le bouton Point //
//            this.vue.getPoint().setDisable(true);
        } else if (nouvelEtat == 41) {                  // On est dans l'état Segment pour créer le 2e point //
//            this.vue.getPoint().setDisable(true);
        } else if (nouvelEtat == 50) {                  // On est dans l'état Appui Simple donc on désactive les boutons Appui Double, Barres et Noeuds  //
            this.vue.getAppuiDouble().setDisable(true);
            this.vue.getBarres().setDisable(true);
            this.vue.getNoeuds().setDisable(true);
        } else if (nouvelEtat == 60) {                  // On est dans l'état Appui Double donc on désactive les boutons Appui Simple, Barres et Noeuds  //
            this.vue.getAppuiSimple().setDisable(true);
            this.vue.getBarres().setDisable(true);
            this.vue.getNoeuds().setDisable(true);
        } else if (nouvelEtat == 70) {                  // On est dans l'état Barres donc on désactive les boutons Appui Simple, Appui Double et Noeuds  //
            this.vue.getAppuiDouble().setDisable(true);
            this.vue.getAppuiSimple().setDisable(true);
            this.vue.getNoeuds().setDisable(true);
        } else if (nouvelEtat == 80) {                  // On est dans l'état Noeuds donc on désactive les boutons Appui Simple, Appui Double et Barres  //
            this.vue.getAppuiSimple().setDisable(true);
            this.vue.getAppuiDouble().setDisable(true);
            this.vue.getBarres().setDisable(true);
        }
        this.etat = nouvelEtat;
    }

    void clicDansZoneDessin(MouseEvent t) {
        if (etat == 20) {
            Point pClic = new Point (t.getX(), t.getY());
            Figure proche = vue.getModel().plusProche(pClic, 10); 
            if(proche != null) {
                if(t.isShiftDown()) {
                    selection.add(proche);
                } else if (t.isControlDown()) {
                    if(selection.contains(proche)) {
                        selection.remove(proche);
                    } else {
                        selection.add(proche);
                    }
                } else {
                    selection.clear();
                    selection.add(proche);
                }
                vue.redrawAll();
            }
        } else if (etat == 30) {            // 30 correspond à l'état Point //
            double px = t.getX();
            double py = t.getY();
            ClassDessin model = this.vue.getModel();
            model.addFigure(new Point(px, py, 0, vue.getCouleur().getValue()));
            this.vue.redrawAll();
        } else if (etat == 40) {            // 40 correspond à l'état Segment //
            pos1[0] = t.getX();
            pos1[1] = t.getY();
            changeEtat(41);                 // 41 correspond au 2e point de l'état Segment //
        } else if (etat == 41) {
            double px2 = t.getX();
            double py2 = t.getY();
            vue.getModel().addFigure(new Segment(0, new Point(pos1[0], pos1[1]), new Point(px2, py2), vue.getCouleur().getValue()));     // Changer 0 par l'indentificateur //
            this.vue.redrawAll();
            this.changeEtat(40);
        } else if (etat ==  50) {
            double px = t.getX();           // A revoir
            double py = t.getY();
        }
    }
    
    void changeColor (Color value) {
        if(etat == 20) {
            for (Figure f : selection) {
                f.setColor(value);
            }
            vue.redrawAll();
        }
    }
    
    void boutonPoint (ActionEvent t) {
        changeEtat(30);
    }
    
    void boutonSegment (ActionEvent t) {
        changeEtat(40);
    }
    
    public List<Figure> getSelection() {
        return selection;
    }
    
    public void boutonSélectionner (ActionEvent t) {
        changeEtat(20);
    }
    
    public void boutonAppuiSimple (ActionEvent t) {
        changeEtat(50);
    }
    
    public void menuNouveau (ActionEvent t) {
        Stage nouveau = new Stage ();
        nouveau.setTitle("Nouveau");
        Scene sc = new Scene(new GlobalPane(nouveau));
        nouveau.setScene(sc);
        nouveau.show();
    }
    
    
    public void menuOuvrir(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(this.vue.getInStage());
        if (f != null) {
            try {
                Figure lue = Figure.lecture(f);
                Groupe glu = (Groupe) lue;
                Stage nouveau = new Stage();
                nouveau.setTitle(f.getName());
                Scene sc = new Scene(new MainPane(nouveau, f, glu), 800, 600);
                nouveau.setScene(sc);
                nouveau.show();
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
            this.vue.getModel().Enregistrement(f);
            this.vue.setCurFile(f);
            this.vue.getInStage().setTitle(f.getName());
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
    
    public void menuSauvegarder (ActionEvent t) {
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
        alert.setContentText("Test");

        alert.showAndWait();
    }
}
