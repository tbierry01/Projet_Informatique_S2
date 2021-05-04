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
        if (this.Contenu.isEmpty()) {
            return new Point(0, 0).getDistance(p);
        } else {
            double dist = this.Contenu.get(0).getDistance(p);
            for (int i = 1; i < this.Contenu.size(); i++) {
                double cur = this.Contenu.get(i).getDistance(p);
                if (cur < dist) {
                    dist = cur;
                }
            }
            return dist;
        }
    }
}
