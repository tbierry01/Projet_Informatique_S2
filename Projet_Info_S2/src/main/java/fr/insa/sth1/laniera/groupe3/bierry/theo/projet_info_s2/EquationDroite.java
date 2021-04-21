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
public class EquationDroite {
    
    private double Coefficient_directeur;
    private double Reste; //J'appelle reste la valeur de p quand on a : y = mx + p
    
    public EquationDroite(double m, double p){
        Coefficient_directeur = m;
        Reste = p;
    }

    public double getCoefficient_directeur() {
        return Coefficient_directeur;
    }

    public double getReste() {
        return Reste;
    }
    
     
}
