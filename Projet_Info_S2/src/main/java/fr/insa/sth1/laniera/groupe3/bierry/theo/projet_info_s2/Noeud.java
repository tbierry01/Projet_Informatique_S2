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
        Barres_Noeud = new ArrayList<>();
        T.addNoeuds_Treillis(this);
    }
    
    public abstract void addBarre(Barre B);//{Barres_Noeud.add(B);}
   
    public void setTreillisNoeud(Treillis T){
        Treillis_Noeud = T;
    }
    
    public String toString(){
        String res;
        res = "\n --Noeud "+Id+"--"+"\nAppartient au treillis : "+Treillis_Noeud.getId()+"\nRelie les barres : ";
        for (int i = 0; i < Barres_Noeud.size(); i++) {
            res = res+"\n-> "+Barres_Noeud.get(i).getId();
            
        }
        return res;
    }
    public int getId(){
        return Id;
    }
}


///Pour faire arctan  Math.atan
/// Pour prendre en compte tous les problèmes, toutes les conditions : Math.atan2(CO, CA);  Cote opposé, coté adjacent
