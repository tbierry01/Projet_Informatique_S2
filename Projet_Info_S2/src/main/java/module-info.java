/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

module Projet_Info_S2 {
    //requires javafx.controlsEmpty;
    requires javafx.controls;
    //requires javafx.graphicsEmpty;
    requires javafx.graphics;
    //requires javafx.baseEmpty;
    requires javafx.base;
    //requires javafx.fxmlEmpty;
    //requires javafx.fxml;
    //requires Projet.Info.S2;
    
    opens fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2 to javafx.graphics;
    opens fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui to javafx.graphics;
}
