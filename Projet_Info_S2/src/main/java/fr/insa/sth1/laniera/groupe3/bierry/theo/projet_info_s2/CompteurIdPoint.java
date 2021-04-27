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
public class CompteurIdPoint {
    
    private int Id;
    
    public CompteurIdPoint(){
        Id = -1;
    }
    public int Competur(){
        Id = Id+1;
        return Id;
        
    }
}
