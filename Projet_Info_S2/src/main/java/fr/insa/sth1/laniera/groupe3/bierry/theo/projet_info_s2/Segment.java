/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author theob
 */
public class Segment extends Figure{
    
    private int Id;
    private Point[] Extremite;  // Tableau ou l'on met les points des extrémités du segment
    private TriangleTerrain TT;
    private Color Couleur;
    
    public Segment (int Iden, Point P1, Point P2){
        Id = Iden;
        Extremite = new Point[2];
        Extremite[0] = P1; //On rempli le tableau des extremité avec les points P1 et P2
        Extremite[1] = P2;
        P1.addSegment(this);
        P2.addSegment(this);
        Couleur = Color.BEIGE;
    }

    @Override
    public String toString(){
        String res;
        res = "\n --Segment "+Id+"--"+"\nExtrémité "+"\n -> "+Extremite[0].getId()+"\n -> "+Extremite[1].getId()+"\nContenu dans le triangle terrain : ";//+TT.getId();
        return res;
    }
    
    public int getId() {
        return Id;
    }

    public Point[] getExtremite() {
        return Extremite;
    }
    
    public Point getExtremite(int Pos){
        return Extremite[Pos];
    }
    
    public void setTriangleTerrain(TriangleTerrain TTer){
        TT = TTer;
    }
    
    public double LongueurSegment(){
        double dist;
        dist = Math.abs(Math.sqrt(Math.pow((Extremite[0].getAbscisse()-Extremite[1].getAbscisse()),2)+Math.pow((Extremite[0].getOrdonnee()-Extremite[1].getOrdonnee()),2))); //Cette éthode permet de donneer la longueur d'un segment en faisant le raisonnement, racine((x1-x2)²+(y1-y2)²)
        return dist;
    }
    
    public EquationDroite EquationSegment(){ //On fait l'équation de droite d'un segment en s'appuyant en fait sur la méthode équation droite dans la classe point
        EquationDroite ED;
        ED = Extremite[0].Droite_deuxPoints(Extremite[1]); //On fait la méthode droitedeuxPoints que l'on applique aux deux extémité du segment;
        return ED;
    }

    @Override
    public void DessineToiNomDeDieu(GraphicsContext Context) {
        Context.setStroke(Couleur);
        Context.strokeLine(Extremite[0].getAbscisse(), Extremite[0].getOrdonnee(), Extremite[1].getAbscisse(), Extremite[1].getOrdonnee());

    }
    
    
}
