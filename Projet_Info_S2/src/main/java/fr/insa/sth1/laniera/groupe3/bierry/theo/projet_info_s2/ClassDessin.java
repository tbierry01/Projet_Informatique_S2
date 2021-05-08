/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author theob
 */
public class  ClassDessin { //Cette classe porte en fait mal son nom, de base, elle a été faite juste pour nous depanner de quelques problèmes, mais au fur et a mesure du temps, on s'est rendu compte qu'elle était essentielle dans la liaison entre l'interface graphique et les class de traitement de données pour calculer le treillis
    
    private ArrayList<Figure> Contenu;
    
    public ClassDessin(ArrayList<Figure> Fig){
        Contenu = Fig;
    }
    
    public ClassDessin(){
        Contenu = Figure.GenerationListFigure();
    }

    public ArrayList<Figure> getContenu() {
        return Contenu;
    }
    
    public void addFigure(Figure F){
        Contenu.add(F);
    }
    
    public void MaisDessineToutPuree(GraphicsContext Context){
        for (Figure Fig : Contenu) {
            Fig.DessineToiNomDeDieu(Context);
        }
    }
    
    public double distancePoint(Point p) {
        if (Contenu.isEmpty()) {
            return new Point(0, 0).getDistance(p);
        } else {
            double dist = Contenu.get(0).getDistance(p);
            for (int i = 1; i < Contenu.size(); i++) {
                double cur = Contenu.get(i).getDistance(p);
                if (cur < dist) {
                    dist = cur;
                }
            }
            return dist;
        }
    }
    
    public Figure plusProche(Point p, double distMax) {
        if (Contenu.isEmpty()) {
            return null;
        } else {
            Figure fmin = Contenu.get(0);
            double min = fmin.getDistance(p);
            for (int i = 1; i < Contenu.size(); i++) {
                Figure fcur = Contenu.get(i);
                double cur = fcur.getDistance(p);
                if (cur < min) {
                    min = cur;
                    fmin = fcur;
                }
            }
            if (min <= distMax) {
                return fmin;
            } else {
                return null;
            }
        }
    }
    
    public void changeCouleur (Color value) {
        for (Figure f : Contenu) {
            f.setColor(value);
        }
    }
    
    public ArrayList<Noeud> Tri_Des_Noeuds (){ //Cette méthode ermet de trier les noeuds dans une liste de figure pour que l'on puisse appliquer le calcul de treillis ensuite
        ArrayList<Noeud> AN = new ArrayList<Noeud>();
        for (int i = 0; i < Contenu.size(); i++) { //On parcours là toute la liste de figure
            if (Contenu.get(i) instanceof Noeud) { //On teste si la figure est un noeud
                AN.add((Noeud) Contenu.get(i)); //Et si c'est un noeud , on le Cast en Noeud et on l'ajoute à la liste 
            }
            
        }
        return AN;
    }
}
