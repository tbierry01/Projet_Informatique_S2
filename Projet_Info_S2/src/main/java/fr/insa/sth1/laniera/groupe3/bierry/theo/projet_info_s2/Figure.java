/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author theob
 */
public abstract class Figure {
    private ArrayList<Figure> Objet;
    
    public Figure(){
        Objet = new ArrayList<>();
    }
    
    public abstract void DessineToiNomDeDieu(GraphicsContext Context);
    
    
}
