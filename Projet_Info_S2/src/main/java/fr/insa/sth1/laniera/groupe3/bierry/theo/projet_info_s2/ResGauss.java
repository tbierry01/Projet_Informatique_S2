/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

/**
 *
 * @author theob / Théo BIERRY
 */
public class ResGauss {
    
    public int rang;
    
    public int signature;
    
    public ResGauss(){
        
        this.rang = 0;
        
        this.signature = 0;
    }
    
    public ResGauss (int rang, int signature){
        
        this.rang = rang;
        
        this.signature = signature;
    }
    
    public String toString (){
        
        String res = "Le rang de la descente de la matrice est : " + this.rang + "\nLa signature de la descente de la matrice est : "+ this.signature;
        
        return res;
    }
    
    
    
    public static void main(String[] args) {
        ResGauss Res = new ResGauss(2, 56);
        System.out.println("Resultat "+Res);
    }
    
}
