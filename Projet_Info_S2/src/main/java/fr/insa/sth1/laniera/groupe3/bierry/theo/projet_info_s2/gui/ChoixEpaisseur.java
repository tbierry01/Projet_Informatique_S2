/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

/**
 *
 * @author drumm
 */
public class ChoixEpaisseur {
    
    private String Epaisseur;
    
    public ChoixEpaisseur (String Epaisseur) {
        this.Epaisseur = Epaisseur;
    }
    
    public String getEpaisseur () {
        return Epaisseur;
    }
    
    @Override
    public String toString () {
        return this.Epaisseur;
    }
    
}
