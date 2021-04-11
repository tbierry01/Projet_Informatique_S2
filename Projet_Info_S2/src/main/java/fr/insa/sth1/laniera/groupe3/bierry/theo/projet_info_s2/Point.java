/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import java.util.ArrayList;

/**
 *
 * @author theob
 */
public class Point {

    private double abscisse;
    private double ordonnee;
    private int Id;
    private ArrayList <Segment> Segment_Point; //Cela permet de stocker l'ensemble des segments liés à un point dans un tableau dynamique

    public Point(double x, double y, int Iden) {
        abscisse = x;
        ordonnee = y;
        Id = Iden;
        Segment_Point = new ArrayList<>();
    }

    public double getAbscisse() {
        return abscisse;
    }

    public void setAbscisse(double abscisse) {
        this.abscisse = abscisse;
    }

    public double getOrdonnee() {
        return ordonnee;
    }

    public void setOrdonnee(double ordonnee) {
        this.ordonnee = ordonnee;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public ArrayList <Segment> getSegment_Point(){
        return Segment_Point;
    }
    
}
