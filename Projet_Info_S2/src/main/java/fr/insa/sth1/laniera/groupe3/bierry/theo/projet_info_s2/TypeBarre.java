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
    public void addBarre_TypeBarre(Barre B){
        Barre_TypeBarre.add(B);
    }
}
