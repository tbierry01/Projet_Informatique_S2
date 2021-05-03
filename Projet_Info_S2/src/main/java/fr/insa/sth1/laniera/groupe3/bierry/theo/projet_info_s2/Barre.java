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
public class Barre extends ClassDessin{
    
    private int Id;
    private Noeud [] Noeuds_Barre;
    private Treillis Treillis_Barre;
    private TypeBarre Type_de_Barre;
    
    public Barre(int Iden, Noeud N1, Noeud N2, Treillis T, TypeBarre TB){
        Id = Iden;
        Noeuds_Barre = new Noeud[2];
        Noeuds_Barre[0] = N1;
        Noeuds_Barre[1] = N2;
        Treillis_Barre = T;
        Type_de_Barre = TB;
        TB.addBarre_TypeBarre(this); // On complète les listes de chaque élements
        N1.addBarre(this);
        N2.addBarre(this);
        T.addBarre_Treillis(this);
    }
    
    public Barre(int Iden, Noeud N1, Noeud N2){
        Id = Iden;
        Noeuds_Barre = new Noeud[2];
        Noeuds_Barre[0] = N1;
        Noeuds_Barre[1] = N2;
        N1.addBarre(this);
        N2.addBarre(this);
    }
    
    public Barre(Noeud N1, Noeud N2){
        Noeuds_Barre = new Noeud[2];
        Noeuds_Barre[0] = N1;
        Noeuds_Barre[1] = N2;
    }
    
    public String toString(){
        String res;
        res = "\n --Barre "+getId()+"--"+"\nExtremités : "+"\n-> "+Noeuds_Barre[0].getId()+"\n-> "+Noeuds_Barre[1].getId()+"\nAppartient au Treillis : "+Treillis_Barre.getId()+"\nLa Barre est de type : "+Type_de_Barre.getId();
        return res;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @return the Noeuds_Barre
     */
    public Noeud[] getNoeuds_Barre() {
        return Noeuds_Barre;
    }
    
    public Noeud getNoeuds_Barre(int i) {
        return Noeuds_Barre[i];
    }

    /**
     * @return the Treillis_Barre
     */
    public Treillis getTreillis_Barre() {
        return Treillis_Barre;
    }

    /**
     * @return the Type_de_Barre
     */
    public TypeBarre getType_de_Barre() {
        return Type_de_Barre;
    }
    
}
