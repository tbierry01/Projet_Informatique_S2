/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 *
 * @author drumm
 */
public class MainMenu {
    
    private GlobalPane main;
    
    public MainMenu (GlobalPane main) {
        
        this.main = main;
        
        Menu fichier = new Menu ("Fichier");
        MenuItem nouveau = new MenuItem("Nouveau");
        MenuItem ouvrir = new MenuItem("Ouvrir");
        MenuItem sauvegarder = new MenuItem("Sauvegarder");
        MenuItem sauvegarderSous = new MenuItem("Sauvegarder Sous");
        
        nouveau.setOnAction((t) -> {
            main.getControleur().menuNouveau(t);
        });
        ouvrir.setOnAction((t) -> {
            main.getControleur().menuOuvrir(t);
        });
        sauvegarder.setOnAction((t) -> {
            main.getControleur().menuSauvegarder(t);
        });
        sauvegarderSous.setOnAction((t) -> {
            main.getControleur().menuSauvegarderSous(t);
        });
    }
    
}
