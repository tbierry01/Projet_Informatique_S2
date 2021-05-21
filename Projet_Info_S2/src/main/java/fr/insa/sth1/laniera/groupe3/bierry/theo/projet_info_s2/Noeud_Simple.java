/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import static fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.Point.RAYON_POINT;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author theob
 */
public class Noeud_Simple extends Noeud{

    private Point Pos;
    
    public Noeud_Simple (Point P, Treillis T, int Id, Force FN){
        super(T, Id, FN);
        this.Pos = P;
    }
    
    public Noeud_Simple (Point P, Treillis T, int Id, Force FN, Color Couleur){
        super(T, Id, FN, Couleur);
        this.Pos = P;
    }
    
    public Noeud_Simple (Point P, int Id, Color Couleur){
        super(Id, Couleur);
        this.Pos = P;
    }
    
    public Noeud_Simple (Point P, Treillis T, int Id, Force FN, double r, double g , double b){
        this(P, T, Id, FN);
        super.setColorRGB(r, g, b);
    }
    
    public Noeud_Simple (double x, double y, Treillis T, int Id, Force FN, double r, double g , double b){
        this(new Point(x, y), T, Id, FN, r, g, b);

    }
    
    public Noeud_Simple (double x, double y, int Id, Color Couleur){
        this(new Point(x, y), Id, Couleur);

    }
    
    public Noeud_Simple (Point P){
        super();
        this.Pos = P;
    }
    
    public void addBarre(Barre B) {
        super.Barres_Noeud.add(B);
    }

    public Point getPos() {
        return Pos;
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
        */
        
        Matrice SystemeNoeud = new Matrice(2, Colones);
        double [] TableauAngle = this.AnglesBarres();
        for (int i = 0; i < Barres_Noeud.size(); i++) {
            SystemeNoeud.set(0, Barres_Noeud.get(i).getId(), Math.cos(TableauAngle[i]));// On met à la ligne 0, colone qui a pour valeur l'identifiacteur de la barre B, la valeur du cos de l'angle de la barre B
        }
        
        for (int i = 0; i < Barres_Noeud.size(); i++) {
            SystemeNoeud.set(1, Barres_Noeud.get(i).getId(), Math.sin(TableauAngle[i]));// On met à la ligne 0, colone qui a pour valeur l'identifiacteur de la barre B, la valeur du sin de l'angle de la barre B
        }
        
        FormatDeRetourSystemNoeuds FR = new FormatDeRetourSystemNoeuds(SystemeNoeud, Egalite);
        return FR;
    }

    @Override
    public void DessineToiNomDeDieu(GraphicsContext Context) {
        Context.setStroke(super.getColor());
        Context.setLineWidth(5);
        Context.strokeOval(Pos.getAbscisse() - 1.5*RAYON_POINT, Pos.getOrdonnee() - 1.5*RAYON_POINT , 3*RAYON_POINT, 3*RAYON_POINT);
    }

    @Override
    public String Enregistrement() {
        String S;
        double Coul [] = super.getColorTab();
        S = "NoeudSimple ; "+super.getId()+ " ; " + super.getTreillis_Noeud().getId()+ " ; "+this.getPos().getAbscisse()+" ; "+this.getPos().getOrdonnee()+" ; "+this.getForceNoeud().getId()+" ; " + Coul[0]+ " ; " +Coul[1]+ " ; "+ Coul[2]+"\n";
        return S;
    }

   
    
}
