/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.ClassDessin;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Point;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author drumm
 */
public class Controleur {
    
    private GlobalPane vue;
    
    public Controleur (GlobalPane vue) {
        this.vue = vue;
    }

    void clicDansZoneDessin(MouseEvent t) {
        double px = t.getX();
        double py = t.getY();
        ClassDessin model = this.vue.getModel();
        model.add(new Point(px, py));
    }
    
}
