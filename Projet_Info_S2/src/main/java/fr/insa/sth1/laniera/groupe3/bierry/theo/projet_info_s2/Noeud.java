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
public abstract class Noeud {
    
    private int Id;
    protected ArrayList<Barre> Barres_Noeud; //Portected pour que ce soit plus simple avec les sous classes
    private Treillis Treillis_Noeud;
    
    public Noeud(Treillis T, int Iden){
        Treillis_Noeud = T;
        Id = Iden;
        
    }
    public abstract void addBarre(Barre B);//{Barres_Noeud.add(B);}
   
    public void setTreillisNoeud(Treillis T){
        Treillis_Noeud = T;
    }
}
