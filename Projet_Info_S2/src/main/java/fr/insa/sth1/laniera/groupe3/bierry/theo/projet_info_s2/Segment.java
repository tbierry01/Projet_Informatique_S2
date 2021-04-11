/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

/**
 *
 * @author theob
 */
public class Segment {
    
    private int Id;
    private Point[] Extremite; // Tableau ou l'on met les points des extrémités du segment
    private TriangleTerrain TT;
            
    public Segment (int Iden, Point P1, Point P2, TriangleTerrain TTe){
        Id = Iden;
        Extremite[0] = P1; //On rempli le tableau des extremité avec les points P1 et P2
        Extremite[1] = P2;
        TT = TTe;
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
    
    
}
