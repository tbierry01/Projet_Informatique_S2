/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author theob
 */
public abstract class Figure { //Ce que l'on appelle figure est tout ce qui est des objets visuellement élémentaires pour faire le Treillis, à savoir: Point, Noeud, Barre, Segment
    private ArrayList<Figure> Objet;
    
    public Figure(){
        Objet = new ArrayList<>();
    }
    
    public String toString(){
        String res = "";
        for (int i = 0; i < Objet.size(); i++) {
            res = res +"\n"+Objet.get(i);;
            
        }
        return res;
    }
    
    public void addFigure(Figure F){
        Objet.add(F);
    }
    
    public static ArrayList<Figure> GenerationListFigure(){
        ArrayList<Figure> AR = new ArrayList<>();
        Point P0 = new Point(500, 500, 0);
        Point P1 = new Point(100, 100, 1);
        Point P2 = new Point(0, 0, 2);
        Point P3 = new Point(300, 250, 3);
        Point P4 = new Point(10, 10, 4);
        AR.add(P0);
        AR.add(P1);
        AR.add(P2);
        AR.add(P3);
        AR.add(P4);
        return AR;
    }
    public abstract void DessineToiNomDeDieu(GraphicsContext Context);
    
    public abstract double getDistance(double x, double y); //Cette méthode premet d'obtenir la distance d'une figure par rapport à des coordonées données
}
