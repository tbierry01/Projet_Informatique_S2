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
    
    public ResolutionContraintes(ArrayList<Barre> Barres){ //Etant donné que les seuls efforts que l'on calculs s'appliquent sur des barres on n'a besoin que des barres pour calculer les efforts
        Barres_Systeme = Barres;
    }
    
    public double[] Calcul_Angle(){
        double[] Angles = new double [Barres_Systeme.size()];
        double[][] Positions = new double [Barres_Systeme.size()][4]; //Dans ce tableau, on stocke d'abord la coordonée X de l'extremité 1, la position Y de l'extrémité 2, la position X de l'extremité 1, la position Y de l'extrémité 2
        Noeud Ex;
        Point P;
// Ce que l'on fait dans cette boucle, c'est que pour chaque barre qui est dans le tableau, on prend sa première extrémité, on prend sa deuxième extrémité, et ensuit on calcul l'angle avec atan
        for (int i = 0; i < Barres_Systeme.size(); i++) {
            //On fait une disjonction de cas pour pouvoir calculer l'angle en fonction de si c'est un noeud simple, ou un appui
            for (int j = 0; j < 2; j++) { //Ici, pour chaque barre, on prend chaque fois les deux extrémités, pour avoir leurs coordonées
                Ex = Barres_Systeme.get(i).getNoeuds_Barre(j); //Ici, on stocke temporairement l'extremité
                P = Ex.getPos();
                Positions[i][0+2*j] = P.getAbscisse(); //Ici on met les abscisses dans les colones 0 et 2 en fonction de quelles extremité pour laquelle on est
                Positions[i][1+2*j] = P.getOrdonnee(); //Ici on met les ordonnées dans les colones 1 et 3 en fonction de quelles extremité pour laquelle on est
            }
        }
        //Ici, on va calculer l'angle de chaque barres aves les coordonées que l'on a calulé avant
        //On va utiliser la commande Math.atan2(CO, CA) CO = coté opposé = Y Ex 2 - Y Ex 1, CA = coté opposé = X Ex 2 - X Ex 1
        for (int i = 0; i < Barres_Systeme.size(); i++) {
            double CO;
            double CA;
            CO = Positions[i][3] - Positions[i][1];
            CA = Positions[i][2] - Positions[i][0];
            CO = Math.abs(CO);
            CA = Math.abs(CA);
            Angles [i] = Math.atan2(CO, CA);
        }
        return Angles;
    }
    
}
