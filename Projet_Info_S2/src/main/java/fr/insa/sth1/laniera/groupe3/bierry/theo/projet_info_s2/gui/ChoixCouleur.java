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
public class ChoixCouleur {
    
    private String couleur;
    
    public ChoixCouleur (String couleur) {
        this.couleur = couleur;
    }
    
    public String getCouleur () {
        return couleur;
    }
    
    @Override
    public String toString () {
        return this.couleur;
    }
    
}
