/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author theob
 */
public class ClassDessin { //Cette classe porte en fait mal son nom, de base, elle a été faite juste pour nous depanner de quelques problèmes, mais au fur et a mesure du temps, on s'est rendu compte qu'elle était essentielle dans la liaison entre l'interface graphique et les class de traitement de données pour calculer le treillis

    private ArrayList<Figure> Contenu;

    public ClassDessin(ArrayList<Figure> Fig) {
        Contenu = Fig;
    }

    public ClassDessin() {
        Contenu = Figure.GenerationListFigure();
    }

    public ArrayList<Figure> getContenu() {
        return Contenu;
    }

    public void addFigure(Figure F) {
        Contenu.add(F);
    }

    public void MaisDessineToutPuree(GraphicsContext Context) {
        for (Figure Fig : Contenu) {
            Fig.DessineToiNomDeDieu(Context);
        }
    }

    public double distancePoint(Point p) {
        if (Contenu.isEmpty()) {
            return new Point(0, 0).getDistance(p);
        } else {
            double dist = Contenu.get(0).getDistance(p);
            for (int i = 1; i < Contenu.size(); i++) {
                double cur = Contenu.get(i).getDistance(p);
                if (cur < dist) {
                    dist = cur;
                }
            }
            return dist;
        }
    }

    public Figure plusProche(Point p, double distMax) {
        if (Contenu.isEmpty()) {
            return null;
        } else {
            Figure fmin = Contenu.get(0);
            double min = fmin.getDistance(p);
            for (int i = 1; i < Contenu.size(); i++) {
                Figure fcur = Contenu.get(i);
                double cur = fcur.getDistance(p);
                if (cur < min) {
                    min = cur;
                    fmin = fcur;
                }
            }
            if (min <= distMax) {
                return fmin;
            } else {
                return null;
            }
        }
    }

    public void changeCouleur(Color value) {
        for (Figure f : Contenu) {
            f.setColor(value);
        }
    }

    public ArrayList<Noeud> Tri_Des_Noeuds() { //Cette méthode ermet de trier les noeuds dans une liste de figure pour que l'on puisse appliquer le calcul de treillis ensuite
        ArrayList<Noeud> AN = new ArrayList<Noeud>();
        for (int i = 0; i < Contenu.size(); i++) { //On parcours là toute la liste de figure
            if (Contenu.get(i) instanceof Noeud) { //On teste si la figure est un noeud
                AN.add((Noeud) Contenu.get(i)); //Et si c'est un noeud , on le Cast en Noeud et on l'ajoute à la liste 
            }

        }
        return AN;
    }

    public ArrayList<Barre> Tri_Des_Barres() {
        ArrayList<Barre> AB = new ArrayList<Barre>();
        for (int i = 0; i < Contenu.size(); i++) {
            if (Contenu.get(i) instanceof Barre) {
                AB.add((Barre) Contenu.get(i));
            }

        }
        return AB;
    }

    public ArrayList<Point> Tri_Des_Point() {
        ArrayList<Point> AP = new ArrayList<Point>();
        for (int i = 0; i < Contenu.size(); i++) {
            if (Contenu.get(i) instanceof Point) {
                AP.add((Point) Contenu.get(i));
            }

        }
        return AP;
    }

    public ArrayList<Segment> Tri_Des_Segment() {
        ArrayList<Segment> AS = new ArrayList<Segment>();
        for (int i = 0; i < Contenu.size(); i++) {
            if (Contenu.get(i) instanceof Segment) {
                AS.add((Segment) Contenu.get(i));
            }

        }
        return AS;
    }
    
    public ArrayList<Force> Recup_Force(ArrayList<Noeud> AN){ //Cette classe rend la liste de toutes les force dans les noeuds
        ArrayList<Force> AF = new ArrayList<>();
        for(Noeud N : AN){ //On parcours la liste du nom
            Force F = N.getForceNoeud(); //On prend la force du noeud
            if(!AF.contains(F)){ //On test si la force est déjà dan sla liste ou pas
                AF.add(F); //Au cas ou, si la force n'est pas dans la liste, on l'ajoute
            }
        }
        return AF;
    }
    
    public ArrayList<TypeBarre> Recup_TypeBarre(ArrayList<Barre> AB){ //Cette classe rend la liste de tous les types de barres utilisés
        ArrayList<TypeBarre> ATB = new ArrayList<>();
        for(Barre B : AB){ //On parcours la liste de barre
            TypeBarre TB = B.getType_de_Barre(); //On prend le type de la barre
            if(!ATB.contains(TB)){ //On test si le type de barre est dans la liste
                ATB.add(TB); //Au cas ou, s'il ne l'est pas, on l'ajoute
            }
        }
        return ATB;
    }

    public void Enregistrement(File file) throws IOException {
        //D'abord, on créer toutes les arraylistes des différentes figures
        ArrayList<Noeud> AN = Tri_Des_Noeuds();
        ArrayList<Point> AP = Tri_Des_Point();
        ArrayList<Barre> AB = Tri_Des_Barres();
        ArrayList<Segment> AS = Tri_Des_Segment();
        //Maintenant que toutes les figures sont triées, on va faire apparaitre tous ce qui ne sont pas des figures mais qui doivent etre enregistré
        ArrayList<Force> AF = Recup_Force(AN);
        ArrayList<TypeBarre> ATB = Recup_TypeBarre(AB);
        //Une fois que l'on a toutes les listes, on peut commencer l'enregistrement
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            if (AS.get(0) == null) {
                throw new Error("Le fichier ne peut pas être sauvegardé, il faut au moins un segement");
            }
            bw.append(AS.get(0).getTriangleTerrain().getZCTriangleTerrain().Enregistrement()); //La, on enregistre d'abord la zone constructible
            //TODO enregistrer aussi les type de barres
            for (Force F : AF) {
                bw.append(F.Enregistrement());
            }
            for(TypeBarre TB : ATB){
                bw.append(TB.Enregistrement());
            }
            for (Point P : AP) {
                bw.append(P.Enregistrement());
            }
            for (Segment S : AS) {
                bw.append(S.Enregistrement());
            }
            for (Noeud N : AN) {
                bw.append(N.Enregistrement());
            }
            for (Barre B : AB) {
                bw.append(B.Enregistrement());
            }
            bw.write("FIN");
            bw.close();
        }
    }

    public FormatRetourEnregistrement Lecture_Fichier(File file) throws IOException {
        try ( BufferedReader br = new BufferedReader(new FileReader(file))) {
            FormatRetourEnregistrement FRE = new FormatRetourEnregistrement();
            String Ligne;
            ArrayList<Figure> AF = new ArrayList<>();
            Map<Integer, Point> MP = new TreeMap<>();
            Map<Integer, Treillis> MT = new TreeMap<>();
            Map<Integer, Force> MF = new TreeMap<>(); 
            Map<Integer, TypeBarre> MTB = new TreeMap<>();
            while ((Ligne = br.readLine()) != null && !Ligne.equals("FIN")) {
                String[] Contient = Ligne.split(";");
                switch (Contient[0]) {
                    case "ZoneConstructible":
                        ZoneConstructible ZC = new ZoneConstructible(Integer.parseInt(Contient[1]), Integer.parseInt(Contient[2]), Integer.parseInt(Contient[3]), Integer.parseInt(Contient[4]));
                        FRE.setZC(ZC);
                        Treillis T = new Treillis(0, ZC);
                        MT.put(T.getId(), T);
                        FRE.setT(T);
                        break;
                    case "Point":
                        Point P = new Point(Double.parseDouble(Contient[2]), Double.parseDouble(Contient[3]), Integer.parseInt(Contient[1]), Double.parseDouble(Contient[4]), Double.parseDouble(Contient[5]), Double.parseDouble(Contient[6]));
                        MP.put(Integer.parseInt(Contient[1]), P); //On fait une nouvelle Map ou l'on ajoute le point en fonction de son identificateur
                        AF.add(P);
                        break;
                    case "Segment":
                        Segment S = new Segment(Integer.parseInt(Contient[1]), MP.get(Integer.parseInt(Contient[2])), MP.get(Integer.parseInt(Contient[3])), Double.parseDouble(Contient[4]), Double.parseDouble(Contient[5]), Double.parseDouble(Contient[6]));
                        AF.add(S);
                        break;
                    case "NoeudSimple":
                        Noeud_Simple NS = new Noeud_Simple(Double.parseDouble(Contient[3]), Double.parseDouble(Contient[4]), MT.get(Integer.parseInt(Contient[2])), Integer.parseInt(Contient[1]), MF.get(Integer.parseInt(Contient[5])),Double.parseDouble(Contient[6]) , Double.parseDouble(Contient[7]), Double.parseDouble(Contient[8]));
                        AF.add(NS);
                        break;
                        //TODO case APS, APD, Barre
                    case "Force":
                        Force F = new Force(Double.parseDouble(Contient[2]), Double.parseDouble(Contient[3]), Integer.parseInt(Contient[1]));
                        MF.put(F.getId(), F);
                        break;
                    case "TypeBarre" :
                        TypeBarre TB = new TypeBarre(Integer.parseInt(Contient[1]), Contient[2], Double.parseDouble(Contient[3]), Double.parseDouble(Contient[4]), Double.parseDouble(Contient[5]), Contient[6]);
                        MTB.put(TB.getId(), TB);
                        break;
                    case "Barre" : 
                        //Barre B = new Barre
                        break;
                    default:
                        throw new Error("Le fichier n'est pas pris en compte, cet element n'est pas réalisable");
                }

            }

            return FRE;
        }
    }
}
