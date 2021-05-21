/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author theob
 */
public class Segment extends Figure{
    
    private int Id;
    private Point[] Extremite;  // Tableau ou l'on met les points des extrémités du segment
    private ZoneConstructible ZC = new ZoneConstructible(0, 0, 100, 100);
    private ArrayList<Appui> APSegment = new ArrayList<>();
    
    public Segment (int Iden, Point P1, Point P2, Color Couleur){
        super(Couleur);
        Id = Iden;
        Extremite = new Point[2];
        Extremite[0] = P1; //On rempli le tableau des extremité avec les points P1 et P2
        Extremite[1] = P2;
        P1.addSegment(this);
        P2.addSegment(this);
    }
    
    public Segment (int Iden, Point P1, Point P2){
        this(Iden, P1, P2, Color.BLACK);
    }
    
    public Segment (int Iden, ZoneConstructible ZC,  Point P1, Point P2, double r, double g, double b){
        Id = Iden;
        Extremite = new Point[2];
        Extremite[0] = P1; //On rempli le tableau des extremité avec les points P1 et P2
        Extremite[1] = P2;
        P1.addSegment(this);
        P2.addSegment(this);
        this.ZC = ZC;
        ZC.addSegement(this);
        super.setColorRGB(r, g, b);
    }

    @Override
    public String toString(){
        String res;
        res = "\n --Segment "+Id+"--"+"\nExtrémité "+"\n -> "+Extremite[0].getId()+"\n -> "+Extremite[1].getId()+"\nContenu dans le triangle terrain : ";//+TT.getId();
        return res;
    }

    public ZoneConstructible getZoneConstructible() {
        return ZC;
    }
    
    @Override
    public int getId() {
        return Id;
    }

    public Point[] getExtremite() {
        return Extremite;
    }
    
    public Point getExtremite(int Pos){
        return Extremite[Pos];
    }
    
    public void addAppuui (Appui A){
        APSegment.add(A);
    }
    
    public void removeAppui (Appui A){
        APSegment.remove(A);
    }
    
    public ArrayList<Appui> getAppui (){
        return APSegment;
    }
    
    /*
    public void setTriangleTerrain(TriangleTerrain TTer){
        TT = TTer;
    }

    public TriangleTerrain getTriangleTerrain() {
        return TT;
    }
    */
    
    
    public double LongueurSegment(){
        double dist;
        dist = Math.abs(Math.sqrt(Math.pow((Extremite[0].getAbscisse()-Extremite[1].getAbscisse()),2)+Math.pow((Extremite[0].getOrdonnee()-Extremite[1].getOrdonnee()),2))); //Cette éthode permet de donneer la longueur d'un segment en faisant le raisonnement, racine((x1-x2)²+(y1-y2)²)
        return dist;
    }
    
    public EquationDroite EquationSegment(){ //On fait l'équation de droite d'un segment en s'appuyant en fait sur la méthode équation droite dans la classe point
        EquationDroite ED;
        ED = Extremite[0].Droite_deuxPoints(Extremite[1]); //On fait la méthode droitedeuxPoints que l'on applique aux deux extémité du segment;
        return ED;
    }

    @Override
    public void DessineToiNomDeDieu(GraphicsContext Context) {
        Context.setStroke(super.getColor());
        Context.setLineWidth(1);
        Context.strokeLine(Extremite[0].getAbscisse(), Extremite[0].getOrdonnee(), Extremite[1].getAbscisse(), Extremite[1].getOrdonnee());

    }

    @Override
    public double getDistance(double x, double y) {
        double Distance;
        //Ici, on calcul la distance par rapport au centre du segment
        double Xmoitie, Ymoitie;
        Xmoitie = (Extremite[0].getAbscisse()+Extremite[1].getAbscisse())/2; //On fait la formule classique pour avoir la position selon X du point de la moitié du segment
        Ymoitie = (Extremite[0].getOrdonnee()+Extremite[1].getOrdonnee())/2; //On fait la formule classique pour avoir la position selon Y du point de la moitié du segment
        Point Milieu = new Point(Xmoitie, Ymoitie); //On créé le point du miieu du segment
        Point P = new Point(x, y); //On créer un point qui a les coordonés que l'on a entré
        Distance = Milieu.Distance2Points(P); //On cherche la distance entre les deux points
        return Distance;
    }

    @Override
    public double getDistance(Point P) {
        double Distance;
        //Ici, on calcul la distance par rapport au centre du segment
        double Xmoitie, Ymoitie;
        Xmoitie = (Extremite[0].getAbscisse()+Extremite[1].getAbscisse())/2; //On fait la formule classique pour avoir la position selon X du point de la moitié du segment
        Ymoitie = (Extremite[0].getOrdonnee()+Extremite[1].getOrdonnee())/2; //On fait la formule classique pour avoir la position selon Y du point de la moitié du segment
        Point Milieu = new Point(Xmoitie, Ymoitie); //On créé le point du miieu du segment
        Distance = Milieu.Distance2Points(P); //On cherche la distance entre les deux points
        return Distance;
    }

    @Override
    public String Enregistrement() {
        String S;
        double Coul [] = super.getColorTab();
        S = "Segment ; "+ Id + "  ; "+ Extremite[0].getId() + " ; " + Extremite[1].getId()+" ; " + Coul[0]+ " ; " +Coul[1]+ " ; "+ Coul[2]+ "\n";
        return S;
    }

    @Override
    public void setId(int Id) {
        this.Id = Id;
    }
    
   
}
