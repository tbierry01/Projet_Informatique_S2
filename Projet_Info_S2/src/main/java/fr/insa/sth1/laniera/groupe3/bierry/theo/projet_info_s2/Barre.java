/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author theob
 */
public class Barre extends Figure {

    private int Id;
    private Noeud[] Noeuds_Barre;
    private Treillis Treillis_Barre;
    private TypeBarre Type_de_Barre;
    private double Effort = 0;

    public Barre(int Iden, Noeud N1, Noeud N2, Treillis T, TypeBarre TB) {
        this(Iden, N1, N2, T, TB, Color.BLACK);
    }

    public Barre(int Iden, Noeud N1, Noeud N2, Treillis T, TypeBarre TB, Color C) {
        super(C);
        Id = Iden;
        Noeuds_Barre = new Noeud[2];
        Noeuds_Barre[0] = N1;
        Noeuds_Barre[1] = N2;
        Treillis_Barre = T;
        Type_de_Barre = TB;
        TB.addBarre_TypeBarre(this); // On complète les listes de chaque élements
        N1.addBarre(this);
        N2.addBarre(this);
        T.addBarre_Treillis(this);
    }

    public Barre(int Iden, Noeud N1, Noeud N2, Treillis T, TypeBarre TB, double r, double g, double b) {
        super(r, g, b);
        Id = Iden;
        Noeuds_Barre = new Noeud[2];
        Noeuds_Barre[0] = N1;
        Noeuds_Barre[1] = N2;
        Treillis_Barre = T;
        Type_de_Barre = TB;
        TB.addBarre_TypeBarre(this); // On complète les listes de chaque élements
        N1.addBarre(this);
        N2.addBarre(this);
        T.addBarre_Treillis(this);
    }
                                                                                // TO DO : FAIRE UN CONSTRUCTEUR AVEC ID, N1, N2 ET COULEUR
    public Barre(int Iden, Noeud N1, Noeud N2) {
        Id = Iden;
        Noeuds_Barre = new Noeud[2];
        Noeuds_Barre[0] = N1;
        Noeuds_Barre[1] = N2;
        N1.addBarre(this);
        N2.addBarre(this);
        Type_de_Barre = new TypeBarre(0);
    }
    
    public Barre(int Iden, Noeud N1, Noeud N2, Color C) {
        super(C);
        Id = Iden;
        Noeuds_Barre = new Noeud[2];
        Noeuds_Barre[0] = N1;
        Noeuds_Barre[1] = N2;
        N1.addBarre(this);
        N2.addBarre(this);
        Type_de_Barre = new TypeBarre(0);
    }
    
    public Barre(int Iden, Noeud N1, Noeud N2, TypeBarre TB, Color C) {
        super(C);
        Id = Iden;
        Noeuds_Barre = new Noeud[2];
        Noeuds_Barre[0] = N1;
        Noeuds_Barre[1] = N2;
        N1.addBarre(this);
        N2.addBarre(this);
        Type_de_Barre = TB;
    }

    public Barre(Noeud N1, Noeud N2) {
        Noeuds_Barre = new Noeud[2];
        Noeuds_Barre[0] = N1;
        Noeuds_Barre[1] = N2;
        N1.addBarre(this);
        N2.addBarre(this);
    }

    public String toString() {
        String res;
        res = "\n --Barre " + getId() + "--" + "\nExtremités : " + "\n-> " + Noeuds_Barre[0].getId() + "\n-> " + Noeuds_Barre[1].getId();// + "\nLa Barre est de type : " + Type_de_Barre.toString();
        return res;
    }

    /**
     * @return the Id
     */
    @Override
    public int getId() {
        return Id;
    }


    /**
     * @return the Noeuds_Barre
     */
    public Noeud[] getNoeuds_Barre() {
        return Noeuds_Barre;
    }
    
    public void setEffort(Matrice M){
        Effort = M.get(Id, 0);
    }

    public Noeud getNoeuds_Barre(int i) {
        return Noeuds_Barre[i];
    }

    /**
     * @return the Treillis_Barre
     */
    public Treillis getTreillis_Barre() {
        return Treillis_Barre;
    }

    /**
     * @return the Type_de_Barre
     */
    public TypeBarre getType_de_Barre() {
        return Type_de_Barre;
    }

    @Override
    public void DessineToiNomDeDieu(GraphicsContext Context) {
        Context.setLineWidth(5);
        Context.setStroke(super.getColor());
        Context.strokeLine(Noeuds_Barre[0].getPos().getAbscisse(), Noeuds_Barre[0].getPos().getOrdonnee(), Noeuds_Barre[1].getPos().getAbscisse(), Noeuds_Barre[1].getPos().getOrdonnee());
    }

    @Override
    public double getDistance(double x, double y) {
        double Distance;
        //On commence par faire comme pour les segements, à savoir calculer leur point médian
        double P0x = Noeuds_Barre[0].getPos().getAbscisse();
        double P0y = Noeuds_Barre[0].getPos().getOrdonnee();
        double P1x = Noeuds_Barre[1].getPos().getAbscisse();
        double P1y = Noeuds_Barre[1].getPos().getOrdonnee();
        double PMilieuX = (P0x + P1x) / 2;
        double PMilieuY = (P0y + P1y) / 2;
        Point P2 = new Point(PMilieuX, PMilieuY);
        Point P = new Point(x, y);//On fait un nouveau point ave les valeurs données en entré
        Distance = P2.Distance2Points(P);
        return Distance;
    }

    @Override
    public double getDistance(Point P) {
        double Distance;
        //On commence par faire comme pour les segements, à savoir calculer leur point médian
        double P0x = Noeuds_Barre[0].getPos().getAbscisse();
        double P0y = Noeuds_Barre[0].getPos().getOrdonnee();
        double P1x = Noeuds_Barre[1].getPos().getAbscisse();
        double P1y = Noeuds_Barre[1].getPos().getOrdonnee();
        double PMilieuX = (P0x + P1x) / 2;
        double PMilieuY = (P0y + P1y) / 2;
        Point P2 = new Point(PMilieuX, PMilieuY);
        Distance = P2.Distance2Points(P);
        return Distance;

    }

    @Override
    public String Enregistrement() {
        String S;
        double Coul[] = super.getColorTab();
        S = "Barre ; "+Id+ " ; " + Treillis_Barre.getId()+ " ; "+Type_de_Barre.getId()+" ; "+Noeuds_Barre[0].getId()+" ; "+Noeuds_Barre[1].getId()+" ; "+Coul[0]+" ; " + Coul[1] + " ; " +Coul[2] + "\n";
        return S;
    }

    public double getEffort(Matrice M){
        return M.get(Id, 0);
    }
    
    public double getEffort(){
        return Effort;
    }
    
    public boolean isBroken(Matrice M){
        if (Type_de_Barre.getRmC() > getEffort(M) || Type_de_Barre.getRmT() < getEffort(M)) {
            super.setColor(Color.RED);
            return true;
        } else {
            super.setColor(Color.GREEN);
            return false;
        }
    }
    
    public boolean isBroken(double val){
        System.out.println("Valeur " +val);
        System.out.println("Valeur RmT " +Type_de_Barre.getRmT());
        System.out.println("Valeur RmC " +Type_de_Barre.getRmC());
        if (Type_de_Barre.getRmT() < val || Type_de_Barre.getRmC() > val) {
            System.out.println("Okay, je passe par là");
            super.setColor(Color.RED);
            return true;
        } else {
            System.out.println("Okay, je passe par ci");
            super.setColor(Color.GREEN);
            return false;
        }
    }

    public void setTreillisBarre(Treillis T) {
        Treillis_Barre = T;
    }

    @Override
    public void setId(int Id) {
        this.Id = Id;
    }
    
    public double  getCout(){
        double C = 0;
        double dist = Noeuds_Barre[0].getDistance(Noeuds_Barre[1].getPos()); //Là on obtient la longeur de la barre
        C = dist*Type_de_Barre.getCout()+ ((int) dist)*Type_de_Barre.getCout_Supplementaire();
        return C;
    }
}
