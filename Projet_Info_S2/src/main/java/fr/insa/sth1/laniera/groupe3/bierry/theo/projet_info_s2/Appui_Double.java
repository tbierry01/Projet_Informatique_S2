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
public class Appui_Double extends Appui{
    
    private Color Couleur;
    
    public Appui_Double(Treillis T, int iden, double alpha, Segment S, Force FN){
        super(T, iden, alpha, S, FN);
        Couleur = Color.CORAL;
    }
    
    public Appui_Double(double alpha, Segment S){
        super(alpha, S);
        Couleur = Color.CORAL;
    }
     
    @Override
    public void addBarre(Barre B) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        super.Barres_Noeud.add(B);
    }
    
    public String toString(){
        String res;
        res = "\n --Appui Double--"+super.toString();
        
        return res;
    }

    @Override
    public int getId() {
        return super.getId();
    }
    
     
    public double getAngleNormal(){ //ATTENTION ATTENTION ATTENTION, cette méthode n'est pas la meilleure, en effet, on ne va considerer ici que nous n'avons que des appuis sur les parties supérieurs des triangles, pas sur des parties inférieures
        Segment S = super.getSegment(); //On récupère le segment auquel appartient l'appui
        //Ensuite, on cherche lequel des deux points du segment est le plus haut, s'ils sont à la même hauteur, alors il est triviale de dire que l'angle est pi/2
        Point P0 = S.getExtremite(0);
        Point P1 = S.getExtremite(1);
        Point Ps; //On va stocker ici, le point qui sera le plus haut par rapport à notre appui, pour pouvoir ensuite calculer l'angle
        Point Pi; //On va stocker ici l point le plus bas, Point Inférieur
        double P0x = P0.getAbscisse();
        double P0y = P0.getOrdonnee();
        double P1x = P1.getAbscisse();
        double P1y = P1.getOrdonnee();
        if(P0x == P1x && P0y == P1y){
            return Math.PI;
        } else if(P0y > P1y){ //Ici, on compare les ordonnes des points, le point qui a la plus grande ordonée, est le plus haut et donc on va se serivr de lui pour faire le claulu d'angle
            Ps = P0;
            Pi = P1;
        } else{
            Ps = P1;
            Pi = P0;
        }
        double AngleHorizontal = this.Angle(Ps);
        double AngleNormal;
        //Pour l'angle Normal, tout va dépendre des coordonées selon x des points Pi et Ps, si Psx > Pix alors on fait +pi/2, mais si Psx < Pix alors on fait - pi/2
        
        if (Ps.getAbscisse() > Pi.getAbscisse()) {
            AngleNormal = AngleHorizontal + (Math.PI)/2;
        } else {
            AngleNormal = AngleHorizontal - (Math.PI)/2;
        }
        
        return AngleNormal;
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
        //Dans cette partie qui suit, on rajoute la récation normale à notre système 
        //System.out.println("Angle : "+this.getAngleNormal());
        SystemeNoeud.set(0, Pos, Math.cos(this.getAngleNormal()));
        SystemeNoeud.set(1, Pos, Math.sin(this.getAngleNormal()));
        FormatDeRetourSystemNoeuds FR = new FormatDeRetourSystemNoeuds(SystemeNoeud, Egalite);
        return FR;
    }

    @Override
    public void DessineToiNomDeDieu(GraphicsContext Context) {
        Context.setFill(Couleur);
        Context.fillOval(this.getPos().getAbscisse() - RAYON_POINT, this.getPos().getOrdonnee()-RAYON_POINT, 2*RAYON_POINT, 2*RAYON_POINT);
    }

    @Override
    public double getDistance(double x, double y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
