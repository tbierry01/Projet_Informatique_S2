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
    private int Id;
    
    public Force(double N, double A, int Id){
        Norme = N;
        Angle = A;
        this.Id = Id;
    }
    
    public Force(double N, double A){
        this(N, A, 0);
    }
    
    public Force(){
        this(0, -Math.PI/2, 0);
    }

    public double getNorme() {
        return Norme;
    }

    public double getAngle() {
        return Angle;
    }

    public int getId() {
        return Id;
    }
    
    public String Enregistrement() {
        String S;
        S = "Force ; "+this.getId()+" ; "+ this.getNorme() + " ; " + this.getAngle()+ "\n";
        return S;
    }
    
    
}
