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
public class Appui_Simple extends Appui {

    public Appui_Simple(Treillis T, int iden, double alpha, Segment S, Force FN) {
        super(T, iden, alpha, S, FN);
    }

    public Appui_Simple(Treillis T, int iden, double alpha, Segment S, Force FN, Color Couleur) {
        super(T, iden, alpha, S, FN, Couleur);
    }

    public Appui_Simple(Treillis T, int iden, double alpha, Segment S, Force FN, double r, double g, double b) {
        super(T, iden, alpha, S, FN, r, g, b);
    }

    public Appui_Simple(double alpha, Segment S) {
        super(alpha, S);
    }
    
    public Appui_Simple(int Id,double alpha, Segment S, Color C) {
        super(Id, alpha, S, C);
    }

    @Override
    public void addBarre(Barre B) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        super.Barres_Noeud.add(B);
    }

    public String toString() {
        String res;
        res = "\n --Appui Simple "+super.getId()+"--" + super.toString();

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
        Egalite.set(0, 0, -super.getForceNoeud().getNorme() * (Math.cos(super.getForceNoeud().getAngle())));
        Egalite.set(1, 0, -super.getForceNoeud().getNorme() * (Math.sin(super.getForceNoeud().getAngle())));

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
        double[] TableauAngle = this.AnglesBarres();
        for (int i = 0; i < Barres_Noeud.size(); i++) {
            SystemeNoeud.set(0, Barres_Noeud.get(i).getId(), Math.cos(TableauAngle[i]));// On met à la ligne 0, colone qui a pour valeur l'identifiacteur de la barre B, la valeur du cos de l'angle de la barre B
        }

        for (int i = 0; i < Barres_Noeud.size(); i++) {
            SystemeNoeud.set(1, Barres_Noeud.get(i).getId(), Math.sin(TableauAngle[i]));// On met à la ligne 0, colone qui a pour valeur l'identifiacteur de la barre B, la valeur du sin de l'angle de la barre B
        }

        //Dans les deux lignes qui suivent, on complete le system avec les inconnus en x et en y de la réaction de l'appui simple, respectivement dans les colones pos et pos + 1 
        SystemeNoeud.set(0, Pos, 1);
        SystemeNoeud.set(1, Pos + 1, 1);

        FormatDeRetourSystemNoeuds FR = new FormatDeRetourSystemNoeuds(SystemeNoeud, Egalite);
        return FR;
    }

    @Override
    public void DessineToiNomDeDieu(GraphicsContext Context) {
        Context.setFill(super.getColor());
        //Context.fillOval(this.getPos().getAbscisse() - 2.5*RAYON_POINT, this.getPos().getOrdonnee() - 2.5*RAYON_POINT, 5 * RAYON_POINT, 5 * RAYON_POINT);
        Context.fillRect(this.getPos().getAbscisse()-1.5*RAYON_POINT, this.getPos().getOrdonnee() - 1.5*RAYON_POINT, 3*RAYON_POINT, 3*RAYON_POINT);
    }

    @Override
    public String Enregistrement() {
        String S;
        double[] Coul = super.getColorTab();
        S = "AppuiSimple ; " + super.getId() + " ; " + super.getTreillis_Noeud().getId() + " ; " + super.getSegment().getId() + " ; " + super.getAlpha() + " ; " + super.getForceNoeud().getId() + " ; " + Coul[0] + " ; " + Coul[1] + " ; " + Coul[2] + "\n";
        return S;
    }

    public static Appui_Simple CreationAppuiPossibleOuPas(int Id, Segment S, Point P, Color C) { //Cette méthode permet de savoir si la création d'un appui est possible ou pas en focntion de ou l'utilisateur clique
        Point[] Ext = new Point[2]; //On met dans un tableau les deux extremités du segment
        Ext[0] = S.getExtremite(0);
        Ext[1] = S.getExtremite(1);
        //On va voir l'orientation du segment
        String Orientation;
        if (Ext[0].getAbscisse() < Ext[1].getAbscisse() && Ext[0].getOrdonnee() != Ext[1].getOrdonnee()) {
            Orientation = "Vers la droite"; //Ce que j'appelle vers la droite, c'est que le vecteur Ext[0] Ext[1] pointe vers la droite
        } else if (Ext[0].getAbscisse() > Ext[1].getAbscisse() && Ext[0].getOrdonnee() != Ext[1].getOrdonnee()) {
            Orientation = "Vers la gauche";//Ce que j'appelle vers la gauche, c'est que le vecteur Ext[0] Ext[1] pointe vers la gauche
        } else if (Ext[0].getAbscisse() == Ext[1].getAbscisse() && Ext[0].getOrdonnee() < Ext[1].getOrdonnee()) {
            Orientation = "VerticaleHaut";//Ce que j'appelle verrticalmentHaut, c'est que le vecteur Ext[0] Ext[1] pointe vers le haut et est vertical
        } else if (Ext[0].getAbscisse() == Ext[1].getAbscisse() && Ext[0].getOrdonnee() > Ext[1].getOrdonnee()) {
            Orientation = "VerticaleBas";//Ce que j'appelle verticalementBas, c'est que le vecteur Ext[0] Ext[1] pointe vers le bas et est verticale
        } else if (Ext[0].getOrdonnee() == Ext[1].getOrdonnee() && Ext[0].getAbscisse() < Ext[1].getAbscisse()) {
            Orientation = "HorizontaleDroite";//Ce que j'appelle HorizontalementDoite, c'est que le vecteur Ext[0] Ext[1] pointe vers la droite et est horizontale
        } else if (Ext[0].getOrdonnee() == Ext[1].getOrdonnee() && Ext[0].getAbscisse() > Ext[1].getAbscisse()) {
            Orientation = "HorizontaleGauche";//Ce que j'appelle HorizontalementGauche, c'est que le vecteur Ext[0] Ext[1] pointe vers la gauche et est horizontale
        } else {
            throw new Error("Ce n'est pas un segment");
        }

        Point P0 = new Point();
        double A;
        switch (Orientation) {
            case "Vers la droite":
                if (P.getAbscisse() < Ext[0].getAbscisse() || P.getAbscisse() > Ext[1].getAbscisse()) {
                    return null;
                } else {
                    EquationDroite ED = S.EquationSegment();
                    //Le but de la boucle if qui suit est juste une question de ressenti pour l'utilisateur, si le segment est vraiment incliné, cela est plus pratique de mettre l'appui sur la même horizontale que le clique de l'utilisateur, et si la droite est vraiment plate, cela est plus sympa de mettre l'appui sur la même verticale que le clique de l'utilisateur
                    if (Math.abs(ED.getCoefficient_directeur()) >= 1) { //On teste la valeur du coefficient directeur
                        P0.setOrdonnee(P.getOrdonnee());
                        //On determine ensuite la valeur de x grâce à l'équation de la droite avec la formuel y = mx + p ==> x = (y-p)/m
                        P0.setAbscisse((P.getOrdonnee() - ED.getReste()) / (ED.getCoefficient_directeur()));
                    } else {
                        P0.setAbscisse(P.getAbscisse());
                        //On determine ensuite la valeur de y grâce à la formule y = mx+p
                        P0.setOrdonnee(ED.getCoefficient_directeur() * P.getAbscisse() + ED.getReste());
                    }
                    //On a donc maintenant la position de P0, on va chercher la valeur correspondante pour alpha
                    //Pour ce, on va calculer la valeur de la distance entre l'extremité 0 et le point, puis on va faire le rapport de cette distance sur la longueur totale du segment
                    double Dist = Ext[0].getDistance(P0);
                    double Long = Ext[0].getDistance(Ext[1]);
                    A = Dist / Long;
                }
                break;
            case "Vers la gauche":
                if (P.getAbscisse() > Ext[0].getAbscisse() || P.getAbscisse() < Ext[1].getAbscisse()) {
                    return null;
                } else {
                    EquationDroite ED = S.EquationSegment();
                    //Le but de la boucle if qui suit est juste une question de ressenti pour l'utilisateur, si le segment est vraiment incliné, cela est plus pratique de mettre l'appui sur la même horizontale que le clique de l'utilisateur, et si la droite est vraiment plate, cela est plus sympa de mettre l'appui sur la même verticale que le clique de l'utilisateur
                    if (Math.abs(ED.getCoefficient_directeur()) >= 1) { //On teste la valeur du coefficient directeur
                        P0.setOrdonnee(P.getOrdonnee());
                        //On determine ensuite la valeur de x grâce à l'équation de la droite avec la formuel y = mx + p ==> x = (y-p)/m
                        P0.setAbscisse((P.getOrdonnee() - ED.getReste()) / (ED.getCoefficient_directeur()));
                    } else {
                        P0.setAbscisse(P.getAbscisse());
                        //On determine ensuite la valeur de y grâce à la formule y = mx+p
                        P0.setOrdonnee(ED.getCoefficient_directeur() * P.getAbscisse() + ED.getReste());
                    }
                    //On a donc maintenant la position de P0, on va chercher la valeur correspondante pour alpha
                    //Pour ce, on va calculer la valeur de la distance entre l'extremité 0 et le point, puis on va faire le rapport de cette distance sur la longueur totale du segment
                    double Dist = Ext[0].getDistance(P0);
                    double Long = Ext[0].getDistance(Ext[1]);
                    A = Dist / Long;
                }
                break;
            case "VerticaleHaut":
                if (P.getOrdonnee() < Ext[0].getOrdonnee() || P.getOrdonnee() > Ext[1].getOrdonnee()) {
                    return null;
                } else {
                    P0.setAbscisse(Ext[0].getAbscisse());//Comme c'est verticale, les abscisses des deux extremités sont égales
                    P0.setOrdonnee(P.getOrdonnee());//On place le point à l'ordonnée ou a été cliqué la souris
                    double Dist = Ext[0].getDistance(P0);
                    double Long = Ext[0].getDistance(Ext[1]);
                    A = Dist / Long;
                }
                break;
            case "VerticaleBas":
                if (P.getOrdonnee() > Ext[0].getOrdonnee() || P.getOrdonnee() < Ext[1].getOrdonnee()) {
                    return null;
                } else {
                    P0.setAbscisse(Ext[0].getAbscisse());//Comme c'est verticale, les abscisses des deux extremités sont égales
                    P0.setOrdonnee(P.getOrdonnee());//On place le point à l'ordonnée ou a été cliqué la souris
                    double Dist = Ext[0].getDistance(P0);
                    double Long = Ext[0].getDistance(Ext[1]);
                    A = Dist / Long;
                }
                break;
            case "HorizontaleDroite":
                if (P.getAbscisse() < Ext[0].getAbscisse() || P.getAbscisse() > Ext[1].getAbscisse()) {
                    return null;
                } else {
                    P0.setOrdonnee(Ext[0].getOrdonnee()); //Si les deux points sont horizontalement alignés, alors, l'ordonné du point sera la même que les extremité
                    P0.setAbscisse(P.getAbscisse());//On place l'appui à la même abcisse que le clic souris
                    double Dist = Ext[0].getDistance(P0);
                    double Long = Ext[0].getDistance(Ext[1]);
                    A = Dist / Long;
                }
                break;
            case "HorizontaleGauche":
                if (P.getAbscisse() > Ext[0].getAbscisse() || P.getAbscisse() < Ext[1].getAbscisse()) {
                    return null;
                } else {
                    P0.setOrdonnee(Ext[0].getOrdonnee()); //Si les deux points sont horizontalement alignés, alors, l'ordonné du point sera la même que les extremité
                    P0.setAbscisse(P.getAbscisse());//On place l'appui à la même abcisse que le clic souris
                    double Dist = Ext[0].getDistance(P0);
                    double Long = Ext[0].getDistance(Ext[1]);
                    A = Dist / Long;
                }
                break;
            default:
                throw new Error("Le segment a un problème");
        }
        //On a donc tout pour créer un appui
        Appui_Simple AS = new Appui_Simple(Id, A, S, C);
        return AS;
    }

}
