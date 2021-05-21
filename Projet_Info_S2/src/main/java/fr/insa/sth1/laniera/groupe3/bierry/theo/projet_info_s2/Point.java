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
public class Point extends Figure{

    public static double RAYON_POINT = 10;
    private double abscisse;
    private double ordonnee;
    private int Id;
    private ArrayList<Segment> Segment_Point; //Cela permet de stocker l'ensemble des segments liés à un point dans un tableau dynamique
    
    public Point(double x, double y, int Iden) {
        abscisse = x;
        ordonnee = y;
        Id = Iden;
        Segment_Point = new ArrayList<>();
    }
    
    public Point(){
        abscisse = 0;
        ordonnee = 0;
        Id = 0;
    }
    public Point(double x, double y, int Iden, double  r, double  g, double  b) {
        this(x, y, Iden);
        super.setColorRGB(r, g, b);
    }
    
    public Point(double x, double y, int Iden, Color C) {
        this(x, y, Iden);
        super.setColor(C);
    }

    public Point(double x, double y) { //Ce constructeur permet de ne pas se casser la tête avec l'identificateur, il sert à créer des points qui ne sont pas vraiment des points du trerrain, mais plutôt des points pour les tests ou pour les calculs
        abscisse = x;
        ordonnee = y;
        Segment_Point = new ArrayList<>();
//        Id = CompteurId;
//        CompteurId = CompteurId + 1;
    }
    
    @Override
    public String toString() {
        String res;
        res = "\n --Point " + Id + "--" + "\nAbscisse : " + abscisse + "\nOrdonnée : " + ordonnee +"\nEst l'extremité des segements : ";
        for (int i = 0; i < Segment_Point.size(); i++) {
            res = res + "\n -> " + Segment_Point.get(i).getId();

        }
        return res;
    }

    public double getAbscisse() {
        return abscisse;
    }

    public void setAbscisse(double abscisse) {
        this.abscisse = abscisse;
    }

    public double getOrdonnee() {
        return ordonnee;
    }

    public void setOrdonnee(double ordonnee) {
        this.ordonnee = ordonnee;
    }

    @Override
    public int getId() {
        return Id;
    }

    @Override
    public void setId(int Id) {
        this.Id = Id;
    }

    public ArrayList<Segment> getSegment_Point() { //On retourne le tableau de tous les segments
        return Segment_Point;
    }

    public void addSegment(Segment S) {
        Segment_Point.add(S);
    }

    public EquationDroite Droite_deuxPoints(Point P2) { // Cette classe permet de determiner l'équation de la droite qui relie le point this au point P2
        EquationDroite ED;
        double m;
        double p;
        if (this.getAbscisse() == P2.getAbscisse() && this.getOrdonnee() == P2.getOrdonnee()) {
            m = 0;
            p = 0;
        } else {
            m = (P2.getOrdonnee() - this.getOrdonnee()) / (P2.getAbscisse() - this.getAbscisse()); //On calcule le coeff directeur m = Delta y/ Delta x
            p = this.getOrdonnee() - m * this.getAbscisse(); //On calcul maintenant p avec p = y - mx que l'on applique au point this
        }
        ED = new EquationDroite(m, p); //On renvoit tout ça dans al micro classe EquationDroite
        return ED;
    }
    
    public double AngleVertical_DeuxPoints(Point P2){
        double Angle;
        Angle = Math.atan(Math.abs(P2.getAbscisse()-this.getAbscisse())/(P2.getOrdonnee()-this.getOrdonnee()));//Ici, on calcul l'angle entre les deux angles en applicant la tangente avec Cote Opposé/Coté Adjacent. Avec a<b Pour calculer Cote Opposé : xb-xa, Cote adjacent : yb - ya. Ensuite, on applique l'arctan avec la commande atan
        return Angle;
    }
    
    public double AngleHorizontal_DeuxPoints(Point P2){
        double Angle;
        Angle = Math.atan(Math.abs((P2.getOrdonnee()-this.getOrdonnee())/(P2.getAbscisse()-this.getAbscisse())));//Ici, on calcul l'angle entre les deux angles en applicant la tangente avec Cote Opposé/Coté Adjacent. Avec a<b Pour calculer Cote Adjacent : xb-xa, Cote Opposé : yb - ya. Ensuite, on applique l'arctan avec la commande atan
        return Angle;
    }

    @Override
    public void DessineToiNomDeDieu(GraphicsContext Context) {
        Context.setFill(super.getColor());
        Context.fillOval(abscisse - 1*RAYON_POINT, ordonnee- 1*RAYON_POINT, 2*RAYON_POINT, 2*RAYON_POINT);
    }
    
    public void DessineToiNomDeDieu(GraphicsContext Context, Color C) {
        Context.setFill(C);
        Context.fillOval(abscisse - 1*RAYON_POINT, ordonnee- 1*RAYON_POINT, 2*RAYON_POINT, 2*RAYON_POINT);
    }

  
    public double Distance2Points(Point P) { //Cette méthode permet de calculer la distance entre 2 points
        double Distance;
        Distance = Math.abs(Math.sqrt((Math.pow(P.getAbscisse() - abscisse, 2))+(Math.pow(P.getOrdonnee() - ordonnee, 2)))); //Ici, on calcul la distance algebrique avec racine(xa-xb)²+(ya-yb)²
        return Distance;
    }
    
    @Override
    public double getDistance(double x, double y) {
        double Distance;
        Point P = new Point(x, y);
        Distance = this.Distance2Points(P);
        return Distance;
    }

   @Override
    public double getDistance(Point P) {
        double Distance;
        Distance = this.Distance2Points(P);
        return Distance;
    }

    @Override
    public String Enregistrement() {
        String S;
        double [] Coul = super.getColorTab();
        S = "Point ; " + Id + " ; " + abscisse + " ; " + ordonnee + " ; "+ Coul[0] + " ; " + Coul[1] + " ; " + Coul[2] + "\n";
        return S;
    }
    
    public void removeSegment (Segment S){
        Segment_Point.remove(S);
    }
    
    
}
