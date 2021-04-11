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
public class Barre {
    
    private int Id;
    private Noeud [] Noeuds_Barre;
    private Treillis Treillis_Barre;
    
    public Barre(int Iden, Noeud N1, Noeud N2, Treillis T){
        Id = Iden;
        Noeuds_Barre = new Noeud[2];
        Noeuds_Barre[0] = N1;
        Noeuds_Barre[1] = N2;
        Treillis_Barre = T;
        N1.addBarre(this);
        N2.addBarre(this);
        T.addBarre_Treillis(this);
    }
}
