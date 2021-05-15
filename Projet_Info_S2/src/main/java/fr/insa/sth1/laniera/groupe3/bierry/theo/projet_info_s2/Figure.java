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
public abstract class Figure { //Ce que l'on appelle figure est tout ce qui est des objets visuellement élémentaires pour faire le Treillis, à savoir: Point, Noeud, Barre, Segment
    private Color Couleur;
    

    public Figure(){
        Couleur= Color.BLACK;
    }
    
    public Figure(Color Coul){
        Couleur = Coul;
    }
    
    public Figure(double r, double g, double b){
        this(); //On créer une couleur donc on s'en fiche 
        setColorRGB(r, g, b);
    }
    
    public abstract int getId();
    
    public abstract void setId(int Id);
    
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
    
    public abstract double getDistance(Point P); //Cette méthode premet d'obtenir la distance d'une figure par rapport à un point donné

    public double [] getColorTab() { //Cela renvoit un tableau RGB
        double  [] Coul = new double  [3];
        Coul[0] = Couleur.getRed();
        Coul[1] = Couleur.getGreen();
        Coul[2] = Couleur.getBlue();
        return Coul;
    }

    public Color getColor() {
        return Couleur;
    }
    

    public void setColor(Color Couleur) {
        this.Couleur = Couleur;
    }
    
    public abstract String Enregistrement(); //Cette classe va permettre de faire des Strings pour pouvoir s'enregistrer

    public void setColorRGB(double r, double g, double b) {
        this.Couleur = Color.color(r, g, b);
    }
    
    public void MAJ_Identifiacteurs (int Id){ //Cette méthode va permettre de mettre à jours les identificateurs pour quand on va supprimer des figures
        if (this.getId() > Id){
            this.setId(this.getId() - 1);
        }
    }
    
}
