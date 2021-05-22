/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.ClassDessin;
import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Figure;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

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
            this.redrawAll();
        });
        
        this.realCanvas.widthProperty().bind(this.widthProperty());
        this.realCanvas.widthProperty().addListener((o) -> {
            this.redrawAll();
        });
        this.redrawAll();
        
        this.realCanvas.setOnMouseClicked((t) -> {
            Controleur control = this.main.getControleur();
            control.clicDansZoneDessin(t);
        });
    }
    
    
    public void redrawAll() {
        GraphicsContext context = this.realCanvas.getGraphicsContext2D();
        context.setFill(Color.WHITE);
        context.fillRect(0, 0, realCanvas.getWidth(), realCanvas.getHeight());
        ClassDessin model = this.main.getModel();
        model.MaisDessineToutPuree(context);
        List<Figure> select = main.getControleur().getVue().getModel().getContenu();
        if (! select.isEmpty()) {
            for (Figure f : select) {
                f.DessineToiNomDeDieu(context);
            }
        }   
    }
}
