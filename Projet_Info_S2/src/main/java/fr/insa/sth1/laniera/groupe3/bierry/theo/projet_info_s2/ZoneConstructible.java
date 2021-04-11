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
public class ZoneConstructible {
    
    private double Xmax;
    private double Xmin;
    private double Ymax;
    private double Ymin;
    private ArrayList<TriangleTerrain> TTContenu;
    
    public ZoneConstructible(double Xmi,double  Xma,double  Ymi,double Yma){
        Xmax = Xma;
        Xmin = Xmi;
        Ymin = Ymi;
        Ymax = Yma;
        TTContenu = new ArrayList<>();
    }


    public double getXmax() {
        return Xmax;
    }


    public double getXmin() {
        return Xmin;
    }

  
    public double getYmax() {
        return Ymax;
    }
    
    public double getYmin() {
        return Ymin;
    }

    public ArrayList<TriangleTerrain> getTTContenu() {
        return TTContenu;
    }
    
    public void addTriangleTerrain(TriangleTerrain TT){
        TTContenu.add(TT);
    }
    
    
}
