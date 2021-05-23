/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2.gui.GlobalPane;
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
        Contenu = new ArrayList<>();
        //Contenu = Figure.GenerationListFigure();
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

    public Point PointPlusProche(Point p, double distMax) {
        if (Contenu.isEmpty()) {
            return null;
        } else {
            ArrayList<Point> AP = Tri_Des_Point();
            Point Pmin = AP.get(0);
            double min = Pmin.getDistance(p);
            for (int i = 1; i < AP.size(); i++) {
                Point Pcur = AP.get(i);
                double cur = Pcur.getDistance(p);
                if (cur < min) {
                    min = cur;
                    Pmin = Pcur;
                }
            }
            if (min <= distMax) {
                return Pmin;
            } else {
                return null;
            }
        }
    }

    public Noeud NoeudPlusProche(Point p, double distMax) {
        if (Contenu.isEmpty()) {
            return null;
        } else {
            ArrayList<Noeud> AS = Tri_Des_Noeuds();
            Noeud Nmin = AS.get(0);
            double min = Nmin.getDistance(p);
            for (int i = 1; i < AS.size(); i++) {
                Noeud Ncur = AS.get(i);
                double cur = Ncur.getDistance(p);
                if (cur < min) {
                    min = cur;
                    Nmin = Ncur;
                }
            }
            if (min <= distMax) {
                return Nmin;
            } else {
                return null;
            }
        }
    }
    
    public String toString(){
        String res = "";
        for (Figure F : Contenu) {
            res = res + F.toString();
            
        }
        return res;
    }

    public Segment SegmentPlusProche(Point p, double distMax) {
        if (Contenu.isEmpty()) {
            return null;
        } else {
            ArrayList<Segment> AS = Tri_Des_Segment();
            Segment Smin = AS.get(0);
            double min = Smin.getDistance(p);
            for (int i = 1; i < AS.size(); i++) {
                Segment Scur = AS.get(i);
                double cur = Scur.getDistance(p);
                if (cur < min) {
                    min = cur;
                    Smin = Scur;
                }
            }
            if (min <= distMax) {
                return Smin;
            } else {
                return null;
            }
        }
    }

    public Treillis getTreillisCD() { //Cette classe permet de généré le treillis d'une ClasseDessin et de en même temps mettre le treillis de ses composants
        ArrayList<Noeud> AN = new ArrayList<>();
        ArrayList<Barre> AB = new ArrayList<>();
        //D'abord on établi le treillis
        for (Figure F : Contenu) {
            if (F instanceof Noeud) {
                AN.add((Noeud) F);
            } else if (F instanceof Barre) {
                AB.add((Barre) F);
            }
        }
        Treillis T = new Treillis(0, AN, AB);
        //Et maintenant on met bien la double relation en mettant tous les treillis des figure à T
        for (Barre B : T.getBarre_Treillis()) {
            B.setTreillisBarre(T);
        }
        for (Noeud N : T.getNoeuds_Treillis()) {
            N.setTreillisNoeud(T);
        }
        return T;
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

    public ArrayList<Force> Recup_Force(ArrayList<Noeud> AN) { //Cette classe rend la liste de toutes les force dans les noeuds
        ArrayList<Force> AF = new ArrayList<>();
        for (Noeud N : AN) { //On parcours la liste du nom
            Force F = N.getForceNoeud(); //On prend la force du noeud
            if (!AF.contains(F)) { //On test si la force est déjà dan sla liste ou pas
                AF.add(F); //Au cas ou, si la force n'est pas dans la liste, on l'ajoute
            }
        }
        return AF;
    }

    public ArrayList<TypeBarre> Recup_TypeBarre(ArrayList<Barre> AB) { //Cette classe rend la liste de tous les types de barres utilisés
        ArrayList<TypeBarre> ATB = new ArrayList<>();
        for (Barre B : AB) { //On parcours la liste de barre
            TypeBarre TB = B.getType_de_Barre(); //On prend le type de la barre
            if (!ATB.contains(TB)) { //On test si le type de barre est dans la liste
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
            if (AS.size() == 0) {
                throw new Error("Le fichier ne peut pas être sauvegardé, il faut au moins un segement");
            }
            bw.append(AS.get(0).getZoneConstructible().Enregistrement()); //La, on enregistre d'abord la zone constructible
            //bw.append(AN.get(0).getTreillis_Noeud().E)
            for (Force F : AF) {
                bw.append(F.Enregistrement());
            }
            for (TypeBarre TB : ATB) {
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
            //bw.append("Cout : ")
            bw.write("FIN");
            bw.close();
        }
    }
    
    public void Enregistrement(File file, GlobalPane GP) throws IOException {
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
            if (AS.size() == 0) {
                throw new Error("Le fichier ne peut pas être sauvegardé, il faut au moins un segement");
            }
            bw.append(AS.get(0).getZoneConstructible().Enregistrement()); //La, on enregistre d'abord la zone constructible
            //bw.append(AN.get(0).getTreillis_Noeud().E)
            for (Force F : AF) {
                bw.append(F.Enregistrement());
            }
            for (TypeBarre TB : ATB) {
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
            bw.append("Cout ; "+ GP.getCout() + "\n");
            bw.write("FIN");
            bw.close();
        }
    }

    public Remonte_Inversion Resolution_ClassDessin() { //Cette classe permet de resoudre entièrement le système et renvoie les solutions
        ArrayList<Noeud> AN = Tri_Des_Noeuds(); //On prend tous les noeuds qui sont parmis les figures
        ResolutionContrainteNoeuds RCN = new ResolutionContrainteNoeuds(AN);
        Remonte_Inversion RI = RCN.Resolution();
        return RI;
    }

    public static FormatRetourEnregistrement Lecture_Fichier(File file) throws IOException {
        try ( BufferedReader br = new BufferedReader(new FileReader(file))) {
            FormatRetourEnregistrement FRE = new FormatRetourEnregistrement();
            String Ligne;
            ArrayList<Figure> AF = new ArrayList<>();
            Map<Integer, Point> MP = new TreeMap<>();
            Map<Integer, Treillis> MT = new TreeMap<>();
            Map<Integer, Force> MF = new TreeMap<>();
            Map<Integer, TypeBarre> MTB = new TreeMap<>();
            Map<Integer, Noeud> MN = new TreeMap<>();
            Map<Integer, Segment> MS = new TreeMap<>();
            ZoneConstructible Zone_Construcible_Fichier = new ZoneConstructible(0, 0, 0, 0);
            while ((Ligne = br.readLine()) != null && !Ligne.equals("FIN")) {
                String[] Contient = Ligne.split(";");
                for (int i = 0; i < Contient.length; i++) {
                    System.out.println("Contient[" + i + "] " + Contient[i]);;

                }
//                for (int i = 1; i < Contient.length; i++) {
//                    System.out.println("Contient["+i+"] "+(int) Double.parseDouble(Contient[i]));
//                    
//                }
                switch (Contient[0]) {
                    case "ZoneConstructible ":
                        ZoneConstructible ZC = new ZoneConstructible((int) Double.parseDouble(Contient[1]), (int) Double.parseDouble(Contient[2]), (int) Double.parseDouble(Contient[3]), (int) Double.parseDouble(Contient[4]));
                        FRE.setZC(ZC);
                        Treillis T = new Treillis(0, ZC);
                        MT.put(T.getId(), T);
                        Zone_Construcible_Fichier = ZC;
                        FRE.setT(T);
                        break;
                    case "Point ":
                        Point P = new Point(Double.parseDouble(Contient[2]), Double.parseDouble(Contient[3]), (int) Double.parseDouble(Contient[1]), Double.parseDouble(Contient[4]), Double.parseDouble(Contient[5]), Double.parseDouble(Contient[6]));
                        MP.put(P.getId(), P); //On fait une nouvelle Map ou l'on ajoute le point en fonction de son identificateur
                        AF.add(P);
                        break;
                    case "Segment ":
                        Segment S = new Segment((int) Double.parseDouble(Contient[1]), Zone_Construcible_Fichier, MP.get((int) Double.parseDouble(Contient[2])), MP.get((int) Double.parseDouble(Contient[3])), Double.parseDouble(Contient[4]), Double.parseDouble(Contient[5]), Double.parseDouble(Contient[6]));
                        AF.add(S);
                        MS.put(S.getId(), S);
                        break;
                    case "NoeudSimple ":
                        Noeud_Simple NS = new Noeud_Simple(Double.parseDouble(Contient[3]), Double.parseDouble(Contient[4]), MT.get((int) Double.parseDouble(Contient[2])), (int) Double.parseDouble(Contient[1]), MF.get((int) Double.parseDouble(Contient[5])), Double.parseDouble(Contient[6]), Double.parseDouble(Contient[7]), Double.parseDouble(Contient[8]));
                        AF.add(NS);
                        MN.put(NS.getId(), NS);
                        break;
                    case "Force ":
                        Force F = new Force(Double.parseDouble(Contient[2]), Double.parseDouble(Contient[3]), (int) Double.parseDouble(Contient[1]));
                        MF.put(F.getId(), F);
                        break;
                    case "TypeBarre ":
                        TypeBarre TB = new TypeBarre((int) Double.parseDouble(Contient[1]), Contient[2], Double.parseDouble(Contient[3]), Double.parseDouble(Contient[4]), Double.parseDouble(Contient[5]), Contient[6], Double.parseDouble(Contient[7]));
                        MTB.put(TB.getId(), TB);
                        break;
                    case "Barre ":
                        Barre B = new Barre((int) Double.parseDouble(Contient[1]), MN.get((int) Double.parseDouble(Contient[4])), MN.get((int) Double.parseDouble(Contient[5])), MT.get((int) Double.parseDouble(Contient[2])), MTB.get((int) Double.parseDouble(Contient[3])), Double.parseDouble(Contient[6]), Double.parseDouble(Contient[7]), Double.parseDouble(Contient[8]));
                        AF.add(B);
                        break;
                    case "AppuiSimple ":
                        Appui_Simple AS = new Appui_Simple(MT.get((int) Double.parseDouble(Contient[2])), (int) Double.parseDouble(Contient[1]), Double.parseDouble(Contient[4]), MS.get((int) Double.parseDouble(Contient[3])), MF.get((int) Double.parseDouble(Contient[5])), Double.parseDouble(Contient[6]), Double.parseDouble(Contient[7]), Double.parseDouble(Contient[8]));
                        AF.add(AS);
                        MN.put(AS.getId(), AS);
                        break;
                    case "AppuiDouble ":
                        Appui_Double AD = new Appui_Double(MT.get((int) Double.parseDouble(Contient[2])), (int) Double.parseDouble(Contient[1]), Double.parseDouble(Contient[4]), MS.get((int) Double.parseDouble(Contient[3])), MF.get((int) Double.parseDouble(Contient[5])), Double.parseDouble(Contient[6]), Double.parseDouble(Contient[7]), Double.parseDouble(Contient[8]));
                        AF.add(AD);
                        MN.put(AD.getId(), AD);
                        break;
                    case "Cout ":
                        FRE.setCout(Double.parseDouble(Contient[1]));
                        break;
                    default:
                        throw new Error("Le fichier n'est pas pris en compte, cet element n'est pas réalisable");
                }

            }
            FRE.setAF(AF);

            return FRE;
        }
    }

    public void ColorationSimulation(Matrice M) { //Cette méthode permet de colorer les barres pour savoir si elles supportent ou pas l'éffort. Cette méthode prend en entier une matrice colone qui est en fait le vecteur de résolution du treillis
        Map<Integer, Barre> MB = new TreeMap<>();// Cette Map va permettre de trier dans l'ordre en fonction de leur identificateur, les barres
        for (Figure F : Contenu) { //On recupère toute les barres, comme une barre ne peut pas être créée s'il n'y a pas déjà deux neoud, alors on n'est qasiment certain d'avoir le même nombre de barres entre la liste que l'on va avoir là et le nombre de lignes de notre vecteur solution. De plus, on est presuqe sur de ne pas avoir deux fois la même barre car normalement, chaque barre a sont propre Id
            if (F instanceof Barre) {
                Barre B = (Barre) F;
                MB.put(B.getId(), B);
                System.out.println("Passe là CD");
            }
        }
        //Maintenant que l'on a la liste de toutes nos Barres, on va à chaque leur associer le boolean Correspondant de si elles sont cassées ou pas
        ArrayList<Boolean> AB = new ArrayList<>();
        for (int i = 0; i < MB.size(); i++) {
            System.out.println("Je passe dans la deuxième boucle");
            Barre B = MB.get(i); //On récuère la barre B qui a pour identificateur i
            double Val = M.get(i, 0); //On obteint la valeur de l'effort correspondant à la bonne barre
            AB.add(B.isBroken(Val));//On rentre dans la liste, la valeur obtenu avec la méthode isBroken
        }
        //return AB;
    }
    
    public void Remove(Figure F){
        Contenu.remove(F);
        /*
        if (F instanceof Barre){
            Barre B = (Barre) F;
            for(int i = 0; i < 2 ; i++){
                B.getNoeuds_Barre(i).removeBarre(B);
            }
        } else if (F instanceof Segment){
            Segment S = (Segment) F;
            for(int i = 0; i < 2; i++){
                S.getExtremite(i).removeSegment(S);
            }
        }
*/
        //TODO Il faut remove tous les elements qui sont en relation par exemple quand on elève une barre, il faut aussi l'elever des listes de barrs des ses extremités
    }
    
    public Remonte_Inversion Simulation(){
        Remonte_Inversion RI = new Remonte_Inversion();
        Remonte_Inversion RI1 = Resolution_ClassDessin(); //Si c'est faisable, on résoud
        RI.setPossible(RI1.getPossible());//J'aurais pu directement mettre true, mais je prefère faire ca come ca, on ne sait jamais, si jamais ca a réussi à rentre dans la boucle mais que ce n'est pas résolvable, c'est cohérant, sinon, on peut avoir true et en même temps, la matrice qui vaut null donc bon...
        if(this.isIsostatic() == false || RI.getPossible() == false){ //On teste si c'est isostatic ou pas
            return RI; //Note : on a pas besoin de le mettre à false parce que le constructeur vide met par defaut la matrice à null et le Possible à false
        } else {
            System.out.println("ICIIIIII");
            RI.setSolution(RI1.getSolution()); //On récupère a matrice solution
            Matrice M = RI.getSolution();
            this.ColorationSimulation(M); //On colore les barres
            return RI;
        }
    }


    public boolean isIsostatic() { //Cette classe permet de savoir si le calcul de treillis est possible ou pas
        boolean B;
        ArrayList<Barre> AB = this.Tri_Des_Barres(); //Cette liste permet de connaitre le nombre de barres
        ArrayList<Noeud> AN = this.Tri_Des_Noeuds(); //Cette liste permet de connaitre le nombre de Noued
        ArrayList<Appui_Double> AAD = new ArrayList<>();
        ArrayList<Appui_Simple> AAS = new ArrayList<>();
        ArrayList<Noeud_Simple> ANS = new ArrayList<>();
        for (Noeud N : AN) { //Dans cette boucle for, on parcour la liste de Noeud et on regarde de quels types sont t-ils pour pouvoir faire les listes des noeuds appui simples et des noeuds appui doubles
            if (N instanceof Appui_Double) { //On complète la liste des neouds appuis double
                AAD.add((Appui_Double) N);
            } else if (N instanceof Appui_Simple) { //On complète la liste des noeuds appui double
                AAS.add((Appui_Simple) N);
            }
        }
        if (2 * AN.size() == AB.size() + 2*AAS.size() + 1 * AAD.size()) { //On teste si cela répond à la formule du polycopié
            B = true;
        } else {
            B = false;
        }
        return B; //On renvoit si finalement, c'est isostatic ou pas
    }

    public void MAJ_Ids(Figure F, int Id) {

        if (F instanceof Barre) {
            ArrayList<Barre> AB = Tri_Des_Barres();
            for (Barre B : AB) {
                B.MAJ_Identifiacteurs(Id);
            }
        } else if (F instanceof Noeud) {
            ArrayList<Noeud> AN = Tri_Des_Noeuds();
            for (Noeud N : AN) {
                
                N.MAJ_Identifiacteurs(Id);
            }

        } else if (F instanceof Point) {
            ArrayList<Point> AP = Tri_Des_Point();
            for (Point P : AP) {
                
                P.MAJ_Identifiacteurs(Id);
            }
        } else if (F instanceof Segment) {
            ArrayList<Segment> AS = Tri_Des_Segment();
            for (Segment S : AS) {
                
                S.MAJ_Identifiacteurs(Id);
            }
        }

    }

}
