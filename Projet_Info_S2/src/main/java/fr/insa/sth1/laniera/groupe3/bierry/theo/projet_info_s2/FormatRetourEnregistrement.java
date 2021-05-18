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
public class FormatRetourEnregistrement { 

    
//Cette classe sert juste pour renvoyer es données issues d'un enregistrement
    
    private ZoneConstructible ZC;
    private Treillis T;
    private ArrayList<Figure> AF;
    private double Cout;

    public FormatRetourEnregistrement(ZoneConstructible ZC, Treillis T, ArrayList<Figure> AF, double Prix) {
        this.ZC = ZC;
        this.T = T;
        this.AF = AF;
        Cout = Prix;
    }
    
    public FormatRetourEnregistrement() {
        this.ZC = null;
        this.T = null;
        this.AF = null;
        Cout = 0;
    }

    public ZoneConstructible getZC() {
        return ZC;
    }

    public Treillis getT() {
        return T;
    }

    public ArrayList<Figure> getAF() {
        return AF;
    }
    
    public void setZC(ZoneConstructible ZC) {
        this.ZC = ZC;
    }

    public void setT(Treillis T) {
        this.T = T;
    }

    public void setAF(ArrayList<Figure> AF) {
        this.AF = AF;
    }

    public double getCout() {
        return Cout;
    }

    public void setCout(double Cout) {
        this.Cout = Cout;
    }
    
    
    
    public String toString(){
        String res;
        res = "#--#--# FRE #--#--#\n"+ZC.toString()+"\n"+T.toString()+"\n";
        for(Figure F : AF){
            res = res+F.toString()+"\n";
        }
        res = res + "\n#--#--# FIN #--#--#\n";
        return res;
    }
    
    
}
