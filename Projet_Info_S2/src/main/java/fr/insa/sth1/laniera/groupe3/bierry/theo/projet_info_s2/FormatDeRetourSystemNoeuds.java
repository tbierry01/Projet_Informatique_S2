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
public class FormatDeRetourSystemNoeuds {
    
    private Matrice Systeme; //Ici, on a les deux équations par noeuds
    private Matrice Egalite; //Ici on a les équivalence des équations précedentes

    public FormatDeRetourSystemNoeuds(Matrice Systeme, Matrice Egalite) {
        this.Systeme = Systeme;
        this.Egalite = Egalite;
    }

    public Matrice getSysteme() {
        return Systeme;
    }

    public Matrice getEgalite() {
        return Egalite;
    }
    
    public String toString(){
        String res;
        res = "\nSysteme : \n" + Systeme.toString() + "\nEgalité : \n"+Egalite.toString();
        return res;
    }

}
