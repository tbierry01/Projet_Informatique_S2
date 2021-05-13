/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author theob
 */
public class Treillis {

    private ArrayList<Barre> Barre_Treillis;
    private ArrayList<Noeud> Noeuds_Treillis;
    private int Id;

    public Treillis(int Iden, ZoneConstructible ZC) {
        Id = Iden;
        Barre_Treillis = new ArrayList<>();
        Noeuds_Treillis = new ArrayList<>();
        ZC.setTreillisZoneConstructible(this);
        
    }
    
    public Treillis(int Iden, ArrayList<Noeud> AN, ArrayList<Barre> AB) {
        Id = Iden;
        Barre_Treillis = AB;
        Noeuds_Treillis = AN;
        
    }

    public String toString() {
        String res;
        res = "\n --Treillis " + getId() + "--" + "\nContient les barres : ";
        for (int i = 0; i < Barre_Treillis.size(); i++) {
            res = res + "\n-> " + Barre_Treillis.get(i).getId();
        }
        res = res + "\nContient les noeuds :";
        for (int i = 0; i < Noeuds_Treillis.size(); i++) {
            res = res + "\n-> " + Noeuds_Treillis.get(i).getId();

        }
        return res;
    }

    public ArrayList<Barre> getBarre_Treillis() {
        return Barre_Treillis;
    }

    public ArrayList<Noeud> getNoeuds_Treillis() {
        return Noeuds_Treillis;
    }

    public void addBarre_Treillis(Barre B) { //Ceci permet d'ajouter des barres dans notre list de barres
        Barre_Treillis.add(B);
    }

    public void addNoeuds_Treillis(Noeud N) { //Ceci permet de rajouter des noeuds dans notre list de noeuds
        Noeuds_Treillis.add(N);
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }
    
    public String Enregistrement(){
        String res;
        res = "Treillis ; "+this.getId();
        return res;
    }
    
    
    

}
