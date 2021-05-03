/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.ClassDessin;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

/**
 *
 * @author drumm
 */
public class DessinCanvas extends Pane {
    
    private GlobalPane main;
  
    private Canvas realCanvas ;
    
    public DessinCanvas (GlobalPane main) {
        this.main = main;
        this.realCanvas = new Canvas (this.getWidth(),this.getHeight()); 
        this.getChildren().add(this.realCanvas);
        this.realCanvas.heightProperty().bind(this.heightProperty());
        this.realCanvas.heightProperty().addListener((o) -> {
 //           System.out.println("w = " + this.realCanvas.getWidth() + " ; h = " + this.realCanvas.getHeight());
            this.redrawAll();
        });
        
        this.realCanvas.widthProperty().bind(this.widthProperty());
        this.realCanvas.widthProperty().addListener((o) -> {
            this.redrawAll();
        });
        this.redrawAll();
    }
    
    
    public void redrawAll() {
        GraphicsContext context = this.realCanvas.getGraphicsContext2D();
    //    context.setFill(Color.CORNSILK);
    //    context.fillRect (0, 0, this.realCanvas.getWidth(), this.realCanvas.getHeight());
        ClassDessin model = this.main.getModel();
        model.MaisDessineToutPuree(context);
    }
}
