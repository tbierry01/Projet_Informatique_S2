/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author theob
 */
public class Appui_Simple extends Appui{
    
    public Appui_Simple(Treillis T, int iden, double alpha, Segment S, Force FN){
        super(T, iden, alpha, S, FN);
        
    }
    
    public Appui_Simple(double alpha, Segment S){
        super(alpha, S);
    }
    
    @Override
    public void addBarre(Barre B) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        super.Barres_Noeud.add(B);
    }
    
    public String toString(){
        String res;
        res = "\n --Appui Simple--"+super.toString();
        
        return res;
    }
    
    @Override
    public int getId() {
        return super.getId();
    }
   
   
    @Override
    public FormatDeRetourSystemNoeuds Generation_Syteme(int Colones, int Pos) {
        //On commence par remplir la matrice de l'égalité avec les forces qui nous sont données. ATTENTION, comme ici, on passe toutes les forces données de l'autre côté de l'égalité alors on inverse le signe
        Matrice Egalite = new Matrice(2, 1);
        Egalite.set(0, 0, -super.getForceNoeud().getNorme()* (Math.cos(super.getForceNoeud().getAngle()))); 
        Egalite.set(1, 0, -super.getForceNoeud().getNorme()* (Math.sin(super.getForceNoeud().getAngle())));
        
        /*On rempli maintenant l'ensemble des angles calculées en les placants au bon endroit en fonction de la barre
        Tout se joue en fonction de l'identificateur de la barre
        Soient B barres
        On pose par convetion avec le sujet que les B premières colones correspondent aux valeurs des forces de tension des B premières barres
        La position d'une valeur de tension dépend de l'identificateur de la barre
        Les identificateurs des barres commencent à 0 et finissent à B-1
        Donc ce que l'on va faire c'est que l'on va parcourir toute l'ArrayList des barres de notre noeuds, et à chaque fois on va placer dans la colone de la matrice équivalente à la valeur de l'identificateur
        On va faire ca deux fois, une fois pour la valeur selon les abscisses où l'on multipliera par le cos de l'angle et une fois selon les ordonnée où on multiplirea par le sin de l'angle
        On ne se préoccupe pas de l'ordre entre le tableau des angle et l'ArrayList des barres du noeuds car ils sont de même dimensions et normalement dans le même ordre
        Différence avec l'appui double c'est que l'on a une inconnue en plus qui est la resistance normale
        */
        
        Matrice SystemeNoeud = new Matrice(2, Colones);
        double [] TableauAngle = this.AnglesBarres();
        for (int i = 0; i < Barres_Noeud.size(); i++) {
            SystemeNoeud.set(0, Barres_Noeud.get(i).getId(), Math.cos(TableauAngle[i]));// On met à la ligne 0, colone qui a pour valeur l'identifiacteur de la barre B, la valeur du cos de l'angle de la barre B
        }
        
        for (int i = 0; i < Barres_Noeud.size(); i++) {
            SystemeNoeud.set(1, Barres_Noeud.get(i).getId(), Math.sin(TableauAngle[i]));// On met à la ligne 0, colone qui a pour valeur l'identifiacteur de la barre B, la valeur du sin de l'angle de la barre B
        }
        
        //Dans les deux lignes qui suivent, on complete le system avec les inconnus en x et en y de la réaction de l'appui simple, respectivement dans les colones pos et pos + 1 
        SystemeNoeud.set(0, Pos, 1);
        SystemeNoeud.set(1, Pos+1, 1);
        
        FormatDeRetourSystemNoeuds FR = new FormatDeRetourSystemNoeuds(SystemeNoeud, Egalite);
        return FR;
    }

    @Override
    public void DessineToiNomDeDieu(GraphicsContext Context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
