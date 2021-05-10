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
    private Treillis Treillis_ZoneConstructible;

    public ZoneConstructible(double Xmi, double Xma, double Ymi, double Yma) {
        Xmax = Xma;
        Xmin = Xmi;
        Ymin = Ymi;
        Ymax = Yma;
        TTContenu = new ArrayList<>();
    }

    public String toString() {
        String res;
        res = "\n --ZoneConstructible--\n- Xmin : " + Xmin + "\n- Xmax : " + Xmax + "\n- Ymin : " + Ymin + "\n- Ymax : " + Ymax + "\nContient les treillis : "+ Treillis_ZoneConstructible.getId()+ "\nContient les triangles terrain : ";
        for (int i = 0; i < TTContenu.size(); i++) {
            res = res + "\n-> " + TTContenu.get(i).getId();

        }
        
        return res;
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

    public void addTriangleTerrain(TriangleTerrain TT) {
        TTContenu.add(TT);
    }

    public void setTreillisZoneConstructible(Treillis T) {
        setTreillis_ZoneConstructible(T);
    }

    /**
     * @param Treillis_ZoneConstructible the Treillis_ZoneConstructible to set
     */
    public void setTreillis_ZoneConstructible(Treillis Treillis_ZoneConstructible) {
        this.Treillis_ZoneConstructible = Treillis_ZoneConstructible;
    }

    public String Enregistrement() {
        String S;
        S = "ZoneConstructible ; "+ Xmin + "  ; "+ Xmax + " ; " + Ymin +" ; " + Ymax+ "\n";
        return S;
    }
}
