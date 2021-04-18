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
public class TypeBarre {
    private int Id;
    private String Section;
    private double Lmin;
    private double Lmax;
    private double Cout;
    private double RmC;
    private double RmT;
    private String Materiaux;
    private ArrayList<Barre> Barre_TypeBarre;
    
    //TODO Constructeur avec création de la liste Barre_TypeBarre
    
    public TypeBarre(int Iden){ //On s'en fout de ce qu'il y a dedans c'est juste pour dire qu'il y a un truc quoi
        Id = Iden;
        Section = "Rond";
        Lmin = 3;
        Lmax = 4;
        Cout = 200;
        RmC = 100;
        RmT = 50;
        Materiaux = "Fer";
        Barre_TypeBarre = new ArrayList<>();
    }
    public void addBarre_TypeBarre(Barre B){
        Barre_TypeBarre.add(B);
    }
    
    public String toString(){
        String res;
        res = "\n --Type Barre "+getId()+"--"+"\n- Section : "+Section+"\n- Longueur min : "+Lmin+"\n- Longueur max : "+Lmax+"\n- Resistance à la compression : "+RmC
                +"\n- Resistance à la torsion : "+RmT+"\n- Materiau : "+Materiaux;
        res = res+"\nLes barres suivantes sont de ce type : ";
        for (int i = 0; i < Barre_TypeBarre.size(); i++) {
            res = res+"\n-> "+Barre_TypeBarre.get(i);
            
        }
        
        return res;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }
}
