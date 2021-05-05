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
public class  ClassDessin {
    
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
}
