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
public class  ClassDessin {
    
    private ArrayList<Figure> Contenu;
    
    public ClassDessin(ArrayList<Figure> Fig){
        Contenu = Fig;
    }
    
    public void MaisDessineToutPuree(GraphicsContext Context){
        for (Figure Fig : Contenu) {
            Fig.DessineToiNomDeDieu(Context);
        }
    }
}
