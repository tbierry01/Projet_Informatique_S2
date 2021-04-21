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
public class ResolutionContraintes { //Le but de cette classe est de résoudre le système linéaire
    
    /*
    Cette claasse aura pour attribu une liste de noeuds
    Pour chaque noeud, on regarde l'angle de chaques barres avec l'horizontale
    On fait le PFD 
    On résoud le tout avec notre résolution de matrice
    */
    
    private ArrayList<Barre> Barres_Systeme;
    
    public ResolutionContraintes(ArrayList<Barre> Barres){
        Barres_Systeme = Barres;
    }
    
    public double[] Calcul_Angle(){
        double[] Angles = new double [Barres_Systeme.size()];
        
        for (int i = 0; i < Barres_Systeme.size(); i++) {
            //On fait une disjonction de cas pour pouvor calculer l'angle en fonction de si c'est un noeud simple, ou un appui
//            if (Barres_Systeme.get(i) instanceof Appui){ //On test si c'est un appui
//                //TODO
//            } else{ //Si ce n'est pas un appui, c'est un noeud simple et donc on peut travvailer avec les coordonnées de ses points
//                //TODO Faire ici le calcul d'angle d'un noeud et le stocker dans un tableau qui sera ensuite renvoyé
//            }
        // Dans cette partie on calcul l'angle que fait chaque barre avec l'horizontal Pour se faire tout va dépendre du noeud que l'on a à l'extrmité
            
        }
        
        return Angles;
    }
}
