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
public class Force {
    private double Norme;
    private double Angle;
    
    public Force(double N, double A){
        Norme = N;
        Angle = A;
    }

    public double getNorme() {
        return Norme;
    }

    public double getAngle() {
        return Angle;
    }
    
    
}
