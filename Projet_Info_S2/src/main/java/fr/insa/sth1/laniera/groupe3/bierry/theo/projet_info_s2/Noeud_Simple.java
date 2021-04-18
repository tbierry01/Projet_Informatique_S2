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
public class Noeud_Simple extends Noeud{

    private Point Pos;
    
    public Noeud_Simple (Point P, Treillis T, int Id){
        super(T, Id);
        this.Pos = P;
    }
    
    public void addBarre(Barre B) {
        super.Barres_Noeud.add(B);
    }
    
    
}
