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
public abstract class Appui extends Noeud{
    
    private double alpha;
    private Segment SegAppui;
    
    public Appui(Treillis T, int Iden, double coeff, Segment Seg){
        super(T, Iden);
        alpha = coeff;
        SegAppui = Seg;
    }
    
    public String toString(){
        String res;
        res = super.toString()+"\nCoefficient alpha : "+alpha+"\nSegment : "+SegAppui;
        return res;
    }
    
    public int getId(){
        return super.getId();
    }
    
}
