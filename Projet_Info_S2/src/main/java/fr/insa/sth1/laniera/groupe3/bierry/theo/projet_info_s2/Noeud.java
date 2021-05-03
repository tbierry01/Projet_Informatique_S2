/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import java.util.ArrayList;

/**
 *
 * @author theob
 */
public abstract class Noeud extends Figure{

    private int Id;
    protected ArrayList<Barre> Barres_Noeud; //Portected pour que ce soit plus simple avec les sous classes
    private Treillis Treillis_Noeud;
    private Force ForceNoeud;


    public Noeud(Treillis T, int Iden, Force FN) {
        Treillis_Noeud = T;
        Id = Iden;
        Barres_Noeud = new ArrayList<>();
        T.addNoeuds_Treillis(this);
        ForceNoeud = FN;
    }

    public Noeud() { //C'est juste un constructeur pour les tests
        Treillis_Noeud = null;
        Id = 0;
        Barres_Noeud = new ArrayList<>();
    }

    public abstract void addBarre(Barre B);//{Barres_Noeud.add(B);}

    public void setTreillisNoeud(Treillis T) {
        Treillis_Noeud = T;
    }

    public String toString() {
        String res;
        res = "\n --Noeud " + Id + "--" + "\nAppartient au treillis : " + Treillis_Noeud.getId() + "\nRelie les barres : ";
        for (int i = 0; i < Barres_Noeud.size(); i++) {
            res = res + "\n-> " + Barres_Noeud.get(i).getId();

        }
        return res;
    }

    public Force getForceNoeud() {
        return ForceNoeud;
    }

    public int getId() {
        return Id;
    }

    public Treillis getTreillis_Noeud() {
        return Treillis_Noeud;
    }

    
    public abstract Point getPos();

    public double[] AnglesBarres() {
        double[] Angles = new double[Barres_Noeud.size()];
        double[][] Positions = new double[Barres_Noeud.size()][4]; //Dans ce tableau, on stocke d'abord la coordonée X de l'extremité 1, la position Y de l'extrémité 2, la position X de l'extremité 1, la position Y de l'extrémité 2
        Noeud Ex;
        Point P1, P2;
// Ce que l'on fait dans cette boucle, c'est que pour chaque barre qui est dans le tableau, on prend sa première extrémité, on prend sa deuxième extrémité, et ensuit on calcul l'angle avec atan
        for (int i = 0; i < Barres_Noeud.size(); i++) {
            //Ici, pour chaque barre, on prend chaque fois les deux extrémités, pour avoir leurs coordonées
            P1 = this.getPos();
            Positions[i][0] = P1.getAbscisse();
            Positions[i][1] = P1.getOrdonnee();
            Ex = Barres_Noeud.get(i).getNoeuds_Barre(0);//Ici, on stocke temporairement l'autre extremité
            if (Ex == this) {//On fait un test pour ne pas prendre deux fois la même extremité, car on n'est pas certain que la deuxième extrémité soit en postion 1 dans l'array de la barre et pas en position 0
                Ex = Barres_Noeud.get(i).getNoeuds_Barre(1);
            }
            P2 = Ex.getPos();
            Positions[i][2] = P2.getAbscisse(); //Ici on met les abscisses dans les colones 0 et 2 en fonction de quelles extremité pour laquelle on est
            Positions[i][3] = P2.getOrdonnee(); //Ici on met les ordonnées dans les colones 1 et 3 en fonction de quelles extremité pour laquelle on est
        }
        //Ici, on va calculer l'angle de chaque barres aves les coordonées que l'on a calulé avant
        //On va utiliser la commande Math.atan2(CO, CA) CO = coté opposé = Y Ex 2 - Y Ex 1, CA = coté opposé = X Ex 2 - X Ex 1
        for (int i = 0; i < Barres_Noeud.size(); i++) {
            double CO;
            double CA;
            CO = Positions[i][3] - Positions[i][1];
            CA = Positions[i][2] - Positions[i][0];
            Angles[i] = Math.atan2(CO, CA);
        }
        return Angles;
    }
    
    public double Angle(Point P){
        Point N = this.getPos();
        double Nx = N.getAbscisse();
        double Ny = N.getOrdonnee();
        double Px = P.getAbscisse();
        double Py = P.getOrdonnee();
        double CO = Py - Ny;
        double CA = Px - Nx;
        double Angle = Math.atan2(CO, CA);
        return Angle;
    }
    
    public abstract FormatDeRetourSystemNoeuds Generation_Syteme(int Colones, int Pos); //Cette classe permet de créer des petites matrices de 2 de haut et du nombre voulu de large pour avoir les equation selon X et Y de chaque noeud. Le pos ne sert que pour les appuis, pour savoir ou positionner les inconnus
}

///Pour faire arctan  Math.atan
/// Pour prendre en compte tous les problèmes, toutes les conditions : Math.atan2(CO, CA);  Cote opposé, coté adjacent
