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
public class Resolution_equation_degres2 {
    
    private double a;
    private double b;
    private double c;
    private double Delta;
    private double x1;
    private double x2;
    
    public Resolution_equation_degres2(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double [] Resolution(){
        Delta = b*b - 4*a*c;
        double [] Sol;
        if (Delta == 0) {
            Sol = new double[1];
            Sol[0] = (-b)/(2*a);
        } else if(Delta > 0){
            Sol = new double [2];            
            Sol[0] = (-b - Math.sqrt(Delta))/(2*a);
            Sol[1] = (-b + Math.sqrt(Delta))/(2*a);
        } else{
            Sol = new double [0]; // En fait, pour voir s'il n'y a pas de racines sans que ca affiche un message direct, c'est plus simple de travailler sur lalongueur du tableau que sur le ocntenu
        }
        return Sol;
    }
}
