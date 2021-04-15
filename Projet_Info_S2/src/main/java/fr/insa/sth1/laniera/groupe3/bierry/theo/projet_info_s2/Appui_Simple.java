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
public class Appui_Simple extends Appui{
    
    public Appui_Simple(Treillis T, int iden, double alpha, Segment S){
        super(T, iden, alpha, S);
        
    }
    @Override
    public void addBarre(Barre B) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        super.Barres_Noeud.add(B);
    }
    
    public String toString(){
        String res;
        res = "\n --Appui Double--"+super.toString();
        
        return res;
    }
    
}
