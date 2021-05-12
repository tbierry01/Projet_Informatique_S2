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
public class ChoixMatériaux {
    
    private String Matériaux;
    
    public ChoixMatériaux (String Matériaux) {
        this.Matériaux = Matériaux;
    }
    
    public String getEpaisseur () {
        return Matériaux;
    }
    
    @Override
    public String toString () {
        return this.Matériaux;
    }
    
}
