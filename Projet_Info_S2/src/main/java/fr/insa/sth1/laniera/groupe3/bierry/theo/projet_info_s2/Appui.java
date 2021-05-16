/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import javafx.scene.paint.Color;

/**
 *
 * @author theob
 */
public abstract class Appui extends Noeud {

    private double alpha; //Alpha est pris en comptea partir de la première extremité du segment SegApui, à savoir SegAppui.getExtremite(0)
    private Segment SegAppui; //Segment du triangle terrain auquel il appartient

    public Appui(Treillis T, int Iden, double coeff, Segment Seg, Force FN) {
        super(T, Iden, FN);
        if (coeff > 1 || coeff < 0) {
            throw new Error("Le coefficient n'est pas dans le bon intervalle, celui ci doit être compris entre 0 et 1");
        }
        alpha = coeff;
        SegAppui = Seg;
        Seg.addAppuui(this);
    }
    
    public Appui(Treillis T, int Iden, double coeff, Segment Seg, Force FN, Color Couleur) {
        super(T, Iden, FN, Couleur);
        if (coeff > 1 || coeff < 0) {
            throw new Error("Le coefficient n'est pas dans le bon intervalle, celui ci doit être compris entre 0 et 1");
        }
        alpha = coeff;
        SegAppui = Seg;
        Seg.addAppuui(this);
    }
    
    public Appui(Treillis T, int Iden, double coeff, Segment Seg, Force FN, double r, double g, double b) {
        super(T, Iden, FN);
        if (coeff > 1 || coeff < 0) {
            throw new Error("Le coefficient n'est pas dans le bon intervalle, celui ci doit être compris entre 0 et 1");
        }
        alpha = coeff;
        SegAppui = Seg;
        Seg.addAppuui(this);
        super.setColorRGB(r, g, b);
    }

    public Appui(double coeff, Segment Seg) {
        super();
        if (coeff > 1 || coeff < 0) {
            throw new Error("Le coefficient n'est pas dans le bon intervalle, celui ci doit être compris entre 0 et 1");
        }
        alpha = coeff;
        SegAppui = Seg;
        Seg.addAppuui(this);
    }
    
    public Appui(int Id, double coeff, Segment Seg, Color C) {
        super(Id, C);
        if (coeff > 1 || coeff < 0) {
            throw new Error("Le coefficient n'est pas dans le bon intervalle, celui ci doit être compris entre 0 et 1");
        }
        alpha = coeff;
        SegAppui = Seg;
        Seg.addAppuui(this);
    }

    public String toString() {
        String res;
        res = "\nCoefficient alpha : " + alpha + "\nSegment : " + SegAppui.getId();
        return res;
    }
    
    @Override
    public int getId() {
        return super.getId();
    }

    public Segment getSegment() {
        return SegAppui;
    }

    public double getAlpha() {
        return alpha;
    }
    
    

    public Point getPos() { //On renvoit le point où se trouve l'appui et comme ca, on aura ses coordonées et se sera plus simple pour le claul d'angle
        Point P;
        if (SegAppui.getExtremite(0).getAbscisse() == SegAppui.getExtremite(1).getAbscisse()) { //Ici, on prend en compte le cas particulier de si les deux points ont la même abcsisse, auquel cas, on ne peut pas faire l'équation de la droite et tout et tout 
            double x = SegAppui.getExtremite(0).getAbscisse();
            double y = SegAppui.LongueurSegment()*alpha;
            //Enusite on met y au bon endroit : Soit on fait extremité(0) + y soit extremité(0) - y, tout va dépendre de la position de extremité(0) par rapport à extremité(1), il faut juste qu'à la fin, y se trouve entre extremité(0) et extremité(1)
            if(SegAppui.getExtremite(0).getOrdonnee() > SegAppui.getExtremite(1).getOrdonnee()){
                y = SegAppui.getExtremite(0).getOrdonnee()-y; //Si l'extremité(0) est plus haute que l'extremité(1) alors on fait - y
            } else if(SegAppui.getExtremite(0).getOrdonnee() < SegAppui.getExtremite(1).getOrdonnee()){
                y = SegAppui.getExtremite(0).getOrdonnee()+y; //Si l'extremité(0) est plus basse que l'extremité(1) alors on fait + y
            } else{ //Dans le dernier cas, alors les deux extremité sont aux même coordonées, donc y est égale à leur coordonées
                y = SegAppui.getExtremite(0).getOrdonnee();
            }
            P = new Point(x, y);
        } else { //Par contre, s'ils ne sont pas sur la même abscisse, alors tout se passe bien en ce qui concerne l'equation de la droite
            EquationDroite ED;
            ED = SegAppui.EquationSegment();
            //On determine là la valeur de l'abscisse du point PositionAppui, et celle-ci revient à trouver deux solutions. On résoud l'équation, alpha*L = sqrt((xc-xa)²+(yc-ya)²)
            //Ce qui fait que l'on va obtenir une équation de degrès 2 sur xP, on aura donc a*xP² + b*xP+ c
            double m = ED.getCoefficient_directeur();
            double p = ED.getReste();
            double xa = SegAppui.getExtremite(0).getAbscisse();
            double xb = SegAppui.getExtremite(1).getAbscisse();
            double ya = SegAppui.getExtremite(0).getOrdonnee();
            double L = SegAppui.LongueurSegment();
            double a = 1 + m * m;
            double b = 2 * m * p - 2 * ya * m - 2 * xa;
            double c = xa * xa + p * p - 2 * p * ya + ya * ya - (L * alpha) * (L * alpha);
            Resolution_equation_degres2 Polynome = new Resolution_equation_degres2(a, b, c);
            double xpotentiel[] = Polynome.Resolution();
            if (xpotentiel.length == 0) {
                throw new Error("Il n'y a pas de racine, problème");
            }
            double x; //x est la valeur en abcsisse de notre point final
            if (Math.abs(xpotentiel[0] - xa) <= Math.abs(xa - xb) && Math.abs(xpotentiel[0] - xb) <= Math.abs(xa - xb)) { //Si notre delta a deux racines, alors si les choses sont bien faites, ont est censé avoir que une seule des deux racines, que une seule des deux valeurs de x qui est comprises entre xa et xb, ainsi on teste les distance, et la distance entre cette valeur de x et a, ainsi que la distance entre la valeur de x et xb doivent être inférieur ou égale à la distance entre xa et xb
                x = xpotentiel[0];
            } else {
                x = xpotentiel[1]; //Comme, normalement, il y a obligatoirement une des deux qui convient, alors si ce n'est pas le premier xpotentiel, c'est que c'est le second
            }
            double y; //y est l'ordonné de notre point
            y = m * x + p; //Comme le point appartient au segement, on peut trouver y avec l'équation de la droite
            P = new Point(x, y);
        }
        
        return P;
    }
    
    
    
    
    
    /*public double getAlphaNoeud(Point P, Segment S){
        TODO
    }
*/

}
