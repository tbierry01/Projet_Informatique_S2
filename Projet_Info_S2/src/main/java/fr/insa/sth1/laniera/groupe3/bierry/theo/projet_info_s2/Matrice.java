/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// ATTENTION, en JAVA, les types prédéfinis int, double, ...) ne peuvent pas être modifié dans des méthodes, MAIS les Classes et les tabaleaux eux peuvent être modifié dans des méthodes
// ATTENTION, on n'a pas le droit, DANS UNE AUTRE CLASSE de faire Matrice§.nbrCol car nbrCol est private !!! Par contre, on peut faire Mtrice.getnbrCol()
// Convention JAVA, pour recuperer la valeur d'un boolean, on ne fait pas get mais if
// Pour les booleans, au lieu de faire == false, on peut faire not(truc boolean)
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

//import fr.insa.sth1.laniera.groupe3.bierry.theo.td1_3v1.Lire;
//Synthaxe pour demander des méthode statics dans d'autres classe NomClasse.Methode(elements1, elements2);
/**
 *
 * @author theob / Théo BIERRY
 */
//1.1 def classe 
/**
 * Pour les commentaires
 *
 * @param = commenter les paramètres;
 * @return = commenter le retour;
 */
public class Matrice {

    private int nbrLig;

    private int nbrCol;

    private double[][] coeffs;

//1.2 constructeur 
    public Matrice(int nlig, int ncol) {

        this.nbrLig = nlig;

        this.nbrCol = ncol;

        this.coeffs = new double[nlig][ncol];

    }

    public Matrice() {

        this.nbrLig = 0;

        this.nbrCol = 0;

        this.coeffs = new double[0][0];

    }

    // Encapsulation
    public int getCol() {

        return this.nbrCol;
    }

    public int getLig() {

        return this.nbrLig;
    }

    public double get(int i, int j) {

        return this.coeffs[i][j];
    }

    public void set(int i, int j, double a) {

        this.coeffs[i][j] = a;
    }

//1.3 toString 
    public String toString() {

        String res = "      ";
        for (int j = 0; j < this.nbrCol; j++) {
            res = res + "    ("+j+")     ";
            
        }
        res = res +"\n";
        for (int i = 0; i < this.nbrLig; i++) {

            res = res + "("+i+")"+"[";

            for (int j = 0; j < this.nbrCol; j++) {

                res = res + "   " + String.format("%+4.2E", this.coeffs[i][j]);

            }

            res = res + "]\n";

        }

        return res;

    }

    public static void testToString() {

        Matrice m = new Matrice(4, 5);

        m.coeffs[0][0] = Math.PI;

        System.out.println("m = \n" + m);

    }

    

    public Matrice Remplissage_Matrice_Predefini() { //Cela permet de remplir une matrice déjà existante, dont on connait le nombre de ligne et de cologne

        for (int i = 0; i < this.nbrLig; i++) {
            for (int j = 0; j < this.nbrCol; j++) {
                System.out.println("Donner la valeur de la case [" + (i + 1) + "][" + (j + 1) + "] \n");
                this.coeffs[i][j] = Lire.i();
            }

        }
        return this;
    }

    public static Matrice identite(int taille) {
        Matrice m;
        m = new Matrice(taille, taille);
        for (int i = 0; i < taille; i++) {
            m.coeffs[i][i] = 1;

        }
        return m;
    }

    public static void testId() {

        Matrice mat = identite(3);
        System.out.println("id 3" + mat);
    }

    public static Matrice matTest1() {
        Matrice m = new Matrice(3, 3);
        int l = 0;
        int c = 0;

        for (int i = 0; i < 9; i++) {
            m.coeffs[l][c] = i;
            c = c + 1;
            if (c >= 3) {
                c = 0;
                l = l + 1;
            }
        }
        return m;
    }

    public static Matrice matTest2() {
        Matrice m = new Matrice(3, 3);
        int l = 0;
        int c = 0;
        for (int i = 0; i < 9; i++) {
            m.coeffs[l][c] = i;
            if (l == c && m.coeffs[l][l] != 0) {
                m.coeffs[l][l] = -m.coeffs[l][l];
            }
            c = c + 1;
            if (c >= 3) {
                c = 0;
                l = l + 1;
            }
        }
        return m;
    }

    public static int aleaUnOuDeux() {
        if (Math.random() < 0.5) {
            return 1;
        } else {
            return 2;
        }
    }

    public static void Test_aleaUnOuDeux(Matrice m) {

        int NbCol, NbLig;
        NbCol = m.nbrCol;
        NbLig = m.nbrLig;
        for (int i = 0; i < NbLig; i++) {
            for (int j = 0; j < NbCol; j++) {
                m.coeffs[i][j] = aleaUnOuDeux();

            }

        }
    }

    public static int aleaZeroOuUnOuDeux(double pz) {

        int res;

        if (Math.random() < pz) {
            res = 0;
        } else {
            res = aleaUnOuDeux();
        }

        return res;
    }

    public static void Test_aleaZeroOuUnOuDeux(Matrice m, double pz) {

        int NbCol, NbLig;
        NbCol = m.nbrCol;
        NbLig = m.nbrLig;
        for (int i = 0; i < NbLig; i++) {
            for (int j = 0; j < NbCol; j++) {
                m.coeffs[i][j] = aleaZeroOuUnOuDeux(pz);

            }

        }
    }

    public static Matrice vecteur(double[] tab) {
        Matrice m = new Matrice(tab.length, 1);
        for (int i = 0; i < tab.length; i++) {
            m.coeffs[i][0] = tab[i];

        }
        return m;
    }

    public Matrice concatLig(Matrice m2) {

        if (this.nbrCol != m2.nbrCol) {
            throw new Error("Nb de cologne n'est pas identique \n");
        }

        Matrice res = new Matrice(this.nbrLig + m2.nbrLig, this.nbrCol);

        for (int j = 0; j < this.nbrCol; j++) {

            for (int i = 0; i < this.nbrLig; i++) {
                res.coeffs[i][j] = this.coeffs[i][j];

            }

            for (int i = 0; i < m2.nbrLig; i++) {
                res.coeffs[i + this.nbrLig][j] = m2.coeffs[i][j];

            }
        }

        return res;

    }

    public Matrice concatCol(Matrice m2) {

        if (this.nbrLig != m2.nbrLig) {
            throw new Error("Nb de ligne n'est pas identique \n");
        }

        Matrice res = new Matrice(this.nbrLig, this.nbrCol + m2.nbrCol);

        for (int j = 0; j < this.nbrLig; j++) {

            for (int i = 0; i < this.nbrCol; i++) {
                res.coeffs[j][i] = this.coeffs[j][i];

            }

            for (int i = 0; i < m2.nbrCol; i++) {
                res.coeffs[j][i + this.nbrCol] = m2.coeffs[j][i];

            }
        }

        return res;

    }

    public Matrice subLines(int NbLigneDebut, int NbLigneFin) {

        int Dim = Math.abs(NbLigneFin - NbLigneDebut + 1);
        Matrice res = new Matrice(Dim, this.nbrCol);
        for (int i = 0; i < Dim; i++) {
            for (int j = 0; j < this.nbrCol; j++) {
                res.coeffs[i][j] = this.coeffs[i + NbLigneDebut][j];

            }

        }

        return res;
    }

    public Matrice subCols(int NbColDebut, int NbColFin) {

        int Dim = Math.abs(NbColFin - NbColDebut + 1);
        Matrice res = new Matrice(this.nbrLig, Dim);
        for (int i = 0; i < this.nbrLig; i++) {
            for (int j = 0; j < Dim; j++) {
                res.coeffs[i][j] = this.coeffs[i][j + NbColDebut];

            }

        }

        return res;
    }

    public Matrice transposition() {

        Matrice res = new Matrice(this.nbrCol, this.nbrLig);
        for (int i = 0; i < this.nbrLig; i++) {
            for (int j = 0; j < this.nbrCol; j++) {
                res.coeffs[j][i] = this.coeffs[i][j];

            }

        }

        return res;
    }

    public static int intAlea(int bmin, int bmax) {
        int res;
        res = (int) (Math.random() * (bmax - bmin + 1) + bmin);
        return res;
    }

    public Matrice MiseAuCarre() {
        Matrice mi_taille_n = identite(this.nbrLig);
        Matrice mi_taille_c = identite(this.nbrCol);
        Matrice Partie_gauche_res = this.concatLig(mi_taille_c);
        Matrice Partie_droite_res = mi_taille_n.concatLig(this.transposition());
        Matrice res = Partie_gauche_res.concatCol(Partie_droite_res);
        return res;
    }

    public static void Test_Test_Partie_2(Matrice m) {
        Matrice m4;
        m4 = m.MiseAuCarre();
        System.out.println("Test partie 2, Matrcie Carré \n" + m4);
    }

    public static void Test_Transposition(Matrice m) {

        Matrice m4;
        m4 = m.transposition();
        System.out.println("Transposition \n" + m4);
    }

    public void Test_SubLines() {
        Matrice m4;
        m4 = this.subLines(2, 3);
        System.out.println("subLines \n" + m4);
    }

    public static void Test_SubCols(Matrice m) {
        Matrice m4;
        m4 = m.subCols(2, 3);
        System.out.println("subCols \n" + m4);
    }

    public static void Test_ConcatCol(Matrice m1, Matrice m2) {
        Matrice m4;
        m4 = m1.concatCol(m2);
        System.out.println("ConcatCol \n" + m4);

    }

    public static void Test_ConcatLig(Matrice m1, Matrice m2) {
        Matrice m4;
        m4 = m1.concatLig(m2);
        System.out.println("ConcatLig \n" + m4);

    }

    public static void test2() {

        int nl = intAlea(1, 4);
        int nc = intAlea(1, 4);
        Matrice m = new Matrice(nl, nc);
        for (int i = 0; i < nl; i++) {
            for (int j = 0; j < nc; j++) {
                m.coeffs[i][j] = aleaZeroOuUnOuDeux(0.33);

            }
        }
        Matrice MC = m.MiseAuCarre();
        Matrice MbisLi = m.subLines(0, nl - 1);
        Matrice Mbis = MbisLi.subCols(0, nc - 1);

        System.out.println("m = \n" + m);
        System.out.println("");
        System.out.println("MC = \n" + MC);
        System.out.println("");
        System.out.println("Mbis = \n" + Mbis);
    }

    public Matrice addition(Matrice m) {

        if (this.nbrCol != m.nbrCol || this.nbrLig != m.nbrLig) {
            throw new Error("Dimensions pas identiques \n");
        }

        Matrice res = new Matrice(this.nbrLig, this.nbrCol);

        for (int i = 0; i < this.nbrLig; i++) {
            for (int j = 0; j < this.nbrCol; j++) {
                res.coeffs[i][j] = this.coeffs[i][j] + m.coeffs[i][j];

            }

        }
        return res;
    }

    public Matrice soustraction(Matrice m) {

        if (this.nbrCol != m.nbrCol || this.nbrLig != m.nbrLig) {
            throw new Error("Dimensions pas identiques \n");
        }

        Matrice res = new Matrice(this.nbrLig, this.nbrCol);

        for (int i = 0; i < this.nbrLig; i++) {
            for (int j = 0; j < this.nbrCol; j++) {
                res.coeffs[i][j] = this.coeffs[i][j] - m.coeffs[i][j];

            }

        }
        return res;
    }

    public void Opposee() {

        for (int i = 0; i < this.nbrLig; i++) {
            for (int j = 0; j < this.nbrCol; j++) {
                this.coeffs[i][j] = -this.coeffs[i][j];

            }

        }

    }

    public Matrice multiplication(Matrice m) {
        if (this.nbrCol != m.nbrLig) {
            throw new Error("Le nombre de colone de la première matrice n'est pas égal au nombre de ligne de la deuxième matrice");
        }
        double Somme;
        Matrice res = new Matrice(this.nbrLig, m.nbrCol); //Pourquoi quand je clique uen fois sur le premeier Matrice, cela me surligne tous les Matrices de a méthode sauf le deuxième, et quand je clique sur le deuxième cela ne surligne que le deuxième? Sont-ils différents.
        for (int j = 0; j < this.nbrLig; j++) {
            for (int k = 0; k < m.nbrCol; k++) {
                Somme = 0;
                for (int i = 0; i < this.nbrCol; i++) {
                    Somme = Somme + (this.coeffs[j][i] * m.coeffs[i][k]);

                }
                res.coeffs[j][k] = Somme;

            }

        }
        return res;
    }

    public void Test_3() {
        Matrice m;
        m = this.multiplication(this);
        m = this.addition(m);
        System.out.println("Test 3 " + m);
    }

    public int permutLigne(int Ldebut, int Lfin) {
        Matrice m = new Matrice(1, this.nbrCol);
        int Valeur = 1;
        for (int i = 0; i < this.nbrCol; i++) {
            m.coeffs[0][i] = this.coeffs[Lfin][i]; //On place tous les coeffs de la ligne de Fin de la matrice que l'on entre dans une matrice tampon 
        }
        for (int i = 0; i < this.nbrCol; i++) {
            if (this.coeffs[Lfin][i] != this.coeffs[Ldebut][i]) {
                Valeur = -1;
            }
            this.coeffs[Lfin][i] = this.coeffs[Ldebut][i]; //On remplace toutes les valeurs de la ligne de fin par celles de la ligne du début
        }
        for (int i = 0; i < this.nbrCol; i++) {
            this.coeffs[Ldebut][i] = m.coeffs[0][i];
        }
        return Valeur;
    }

    public void transvection(int l1, int l2) { //Cette méthode permet d'appliquer le pivot en l1 sur la ligne l2
        if (this.coeffs[l1][l1] == 0) {
            throw new Error("La valeur [" + l1 + "][" + l2 + "] est nulle \n");
        }
        double p = (this.coeffs[l2][l1]) / (this.coeffs[l1][l1]);
        //System.out.println("p " + p);
        for (int j = 0; j < this.nbrCol; j++) {
            if (j == l1) {
                this.coeffs[l2][j] = 0;
                //System.out.println("Matrice (ligne 497) changement du coeff ligne " + l2 + " colone " + j + " par 0 \n" + this);
            } else {
                this.coeffs[l2][j] = this.coeffs[l2][j] - p * this.coeffs[l1][j];
                //System.out.println("Matrice (ligne 500) changement du coeff ligne " + l2 + " colone " + j + " par coeff [" + l2 + "][" + j + "] - " + p + " * coeff [" + l1 + "][" + j + "]\n" + this);
            }

        }
    }

//    public int lignePlusGrandPivot(int nc) {
//        int nl = 0; // La valeur de la ligne du plus grand pivot
//        double EPSILON_PIVOT = Math.pow(10, -8);
//        for (int i = nc; i < this.nbrLig; i++) {
//            if (Math.abs(this.coeffs[i][nc]) > nl) { //J'ai elenvé la valeur absolue car je trouve ca mieux Math.abs(this.coeffs[i][nc]) > nl
//                nl = i;
//                System.out.println("Nl "+nl);
//            }
//        }
//        if (nl <= EPSILON_PIVOT) {
//            nl = -1;
//        }
//        return nl;
//    }
    
     public int lignePlusGrandPivot(int nc) {
        int nl = nc; // nl est la valeur de la ligne du plus grand pivot, on l'initialise à la valeur de la ligne de départ qui est en l'occurence égale à la valeur de la colone de départ
        double EPSILON_PIVOT = Math.pow(10, -8);
        double Tampon = Math.abs(this.coeffs[nl][nc]); //Ici, on stocke une valeur temporaire qui va nous permettre de savoir si le plus grand pivot est nul ou pas
        for (int i = nc; i < this.nbrLig; i++) { //On parcours toutes les lignes pour trouver le plus grand pivot en valeur absolue
            //System.out.println("Tampon dans boucle for : "+Tampon);
            //System.out.println("Math.abs(this.coeffs[i][nc]) "+Math.abs(this.coeffs[i][nc]));
            if (Math.abs(this.coeffs[i][nc]) > Math.abs(this.coeffs[nl][nc])) { //On compare cahque case à celle ou il y a le plus grand pivot actuel pour voir si elle n'est pas plus grande
                nl = i; //Si la case de la ligne en cours à une valeur plus grande que la case de pivot actuel, alors on chage la ligne du pivot
                //System.out.println("Nl "+nl);
                //System.out.println("Math.abs(this.coeffs[i][nc]) dans boulce if  "+Math.abs(this.coeffs[i][nc]));
                Tampon = Math.abs(this.coeffs[i][nc]); //On change aussi la valeur du tampon, ce n'est pas utile à chauqe fois mais il faut au moins le faire une fois pour qu'il soit plus grand que EPSILLON_PIVOT et ne pas rentrer dans la boucle if finale
                //System.out.println("Tampon dans boulce if : "+Tampon);
            }
        }
        //System.out.println("Tampon : "+Tampon);
        if (Tampon <= EPSILON_PIVOT) { //Si toutes les cases de la ligne sont nulles, alors on renvoit -1 pour la valeur de la ligne
            nl = -1;
        }
        return nl;
    }

    public ResGauss DescenteGauss() { //Heu en fait ou sont les différentes signatures que l'on a? On en a une pour la permutation, une si la igne du pivott est -1, et c'est tout non?
        int Signature = 1;
        int ne = 0;
        int Ligne_pivot;

        for (int j = 0; j < this.nbrLig; j++) { //On travail là sur les colones mais on met nbrLig car on veut une matrice carré
            System.out.println("-----------Travail sur la colone " + j + "----------- ");
            Ligne_pivot = this.lignePlusGrandPivot(j); //On cherche la ligne du plus grand pivot de la colone j
            System.out.println("Ligne pivot " + Ligne_pivot);
            if (Ligne_pivot == -1) {
                Signature = -1 * Signature;
                //System.out.println("Signature dans la boucle if : "+ Signature);
            } else {
                ne = ne + 1;
                if (j != Ligne_pivot) {
                    Signature = Signature * this.permutLigne(j, Ligne_pivot); //on permute la ligne du plus grand pivot avec la ligne égale  la colone actuelle car  chaque fois, le plus grand pivot doit être sur le même numéro de ligne que celui de la colone ou l'on est actuellement
                    //System.out.println("Signature  " + Signature);
                    System.out.println("Matrice après permutation ligne " + j + " avec ligne " + Ligne_pivot + "\n" + this);
                } 
                for (int i = j + 1; i < this.nbrLig; i++) {
                    if (this.coeffs[i][j] != 0) {
                        this.transvection(j, i); //On fait la transvection de la ligne j qui est maintenant la ligne du pivot avec la ligne i
                        System.out.println("Matrice transvection ligne " + i + " avec ligne " + j + "\n" + this);
                    }
                }
            }

        }
        ResGauss Resultat = new ResGauss(ne, Signature);
        return Resultat;
    }

    public void MultiplicationLigne(int ligne, int mult) {
        for (int j = 0; j < this.nbrCol; j++) {
            this.coeffs[ligne][j] = mult * this.coeffs[ligne][j];

        }
    }

    public void Remplacement_Ligne(int Ligne_a_remplacer, int Ligne_annexe, double coeff) { // Cette procédure permet de faire des opérations du type L2 <- L2 - 3*L3  ou L2 est la ligne à remplacer, 3 le coeff et L3 la ligne qui participe au remplacement, ligne annexe (La ligne qui contient le pivot)
        for (int j = Ligne_a_remplacer; j < this.nbrCol; j++) { //En fait, dans cette boucle, on fait varier les colones et les lignes sont fixes, et le but c'est d'à la fin, de n'avoir que le pivot avec sa valeur. Si l'on commence à ligne_a_remplacer, c'est parce que comme la matrice est presque carré, alors on a pas besoin de travailler avec les coefficient de la même ligne mais du nombre de colone inférieur car ceux-ci sont déjà nu, donc l'oppération ne changera rien mais occupe la mémoire (Faire un shéma pour comprendre cette histoire de matrice presque carré)
            this.coeffs[Ligne_a_remplacer][j] = this.coeffs[Ligne_a_remplacer][j] - coeff * this.coeffs[Ligne_annexe][j];
            //System.out.println("\nLigne à remmplacer : "+Ligne_a_remplacer+" Colone : "+j+ " Coeff : "+coeff+" Ligne Pivot : " + Ligne_annexe + "\n" + this);
        }
    }

    public Matrice RemonteGauss(ResGauss Resultat_Descente) { //Tester si remonte Gauss à les bon attributs
        if (Resultat_Descente.rang != this.nbrLig) {
            throw new Error("La matrice n'a pas de solution !");
        }
        Matrice Stockage = new Matrice(this.nbrLig, 1);
        for (int i = 0; i < this.nbrLig; i++) { //A l'interieur de ces deux boucles, ce que l'on fait c'est que l'on met tous les pivots égaux à 1
            double Facteur_Division_pour_obtenir_pivot = this.coeffs[i][i]; //Ici, on stocke la valeur du pivot avant qu'il ne soit égale à 1
            for (int j = 0; j < this.nbrCol; j++) {
                if (this.coeffs[i][j] != 0) { //Cela permet juste d'optimiser le programme
                    this.coeffs[i][j] = (this.coeffs[i][j]) / Facteur_Division_pour_obtenir_pivot; //Ici on divise chaque coeff par la valuer du pivot de la même ligne avant qu'il ne soit égale à 1
                }
            }
        }
        //System.out.println("\nM1 coeff pivot 1 \n" + this);

        //Faire une procédure qui prend une ligne, un coeff et une autre ligne te qui utilise Remplacement_Ligne pour remonter la matrice triangulaire de facon à avoir la valeur de chaque pivot
        for (int k = this.nbrLig - 1; k > 0; k--) {// La on fait varier la ligne annexe et >0 car on a pas besoin de faire ceci avec la ligne tout en haut 
            //for (int j = this.nbrCol - 2; j >= 0; j--) { // - 2 car -1 de déalage habituelle et -1 car on ne prend pas la dernière colone puisaue c4est le vecteur solution
            int j = k;    //En fait, la ligne du pivot et la colone sur laquelle on travil sont intimement liée et c'est donc pour cela qu'il sont identiques
            for (int i = j - 1; i >= 0; i--) { // k-1 car on ne travaill que avec l'emesemble des ligne strictement au dessus de la ligne annexe
                System.out.println("\n Remplacement avant procédure Ligne : "+i+ " Colone : "+j+" Ligne pivot : "+k+ " Coeff : "+this.coeffs[i][j]+"\n"+this);
                Remplacement_Ligne(i, k, this.coeffs[i][j]);
                System.out.println("\n Remplacement Ligne : "+i+ " Colone : "+j+" Ligne pivot : "+k+"\n"+this);
            }

            //}
        }

        System.out.println("Descente de gauss 1 \n"+this);
        for (int i = 0; i < Stockage.nbrLig; i++) { //Cette boucle permet de remplir le tableau "Stockage" de tous les coeffs de la dernières colone, cad les valeur des pivots
            Stockage.coeffs[i][0] = this.coeffs[i][this.nbrCol - 1]; //-1 car décalage de 1 case

        }

        return Stockage;
        //System.out.println("\nLe vecteur solution est : \n" + Stockage);

    }

    public double Determinant(int signature) { //Methode à tester
        double det = 1;
        for (int i = 0; i < this.nbrLig; i++) {
            det = det * this.coeffs[i][i];
        }
        det = det * signature;

        return det;
    }

    public Remonte_Inversion Resolution_complete(Matrice Vect) { //Ici on résoud un systeme entier avec la matrice carré du système en paramètre implicite et la matrice vecteur qui est le vecteur des égalités
        Matrice Matrice_rectangle = this.concatCol(Vect); // On assemble les deux pour que cela soit plus facile a travailler
        
        if( Matrice_rectangle.getLig() + 1 != Matrice_rectangle.getCol()){
            Remonte_Inversion Sol = new Remonte_Inversion(); // S'il l'est, alors on créer un objet de la classe Remonte_Inversion qui est vide de la matrice solution puisqu'elle n'existe pas et qui possède comme attribut Possible, false 
            return Sol; 
        } else{
            ResGauss Resultat_descente = Matrice_rectangle.DescenteGauss();
        //On rend la matrice triangulaire supérieur
            double EPSILON_PIVOT = Math.pow(10, -8);
            System.out.println(" +++++++++++++++++++++++++++++ Determinant : "+Matrice_rectangle.Determinant(Resultat_descente.signature) );
            if (Math.abs(Matrice_rectangle.Determinant(Resultat_descente.signature)) <= EPSILON_PIVOT ) { //Ici on fait une condition qui demande si la matrice est inversible ou non,  à savoir, si son déterminant est différnet de 0 ou non
                Remonte_Inversion Sol = new Remonte_Inversion(); // S'il l'est, alors on créer un objet de la classe Remonte_Inversion qui est vide de la matrice solution puisqu'elle n'existe pas et qui possède comme attribut Possible, false 
            return Sol; 
            //throw new Error ("Le système ne possède pas de solution ou du moins, pas de solution unique");
            } else { //Si la matrice est inversible, alors on entre dans cette boucle
                Remonte_Inversion Sol = new Remonte_Inversion(Matrice_rectangle.RemonteGauss(Resultat_descente));
                return Sol;
            }
        }
    }


    public static void Test_Resol(){
        Matrice m1 = matTest2();
        Matrice Vecteur = new Matrice(3, 1);
        System.out.println("\nRemplissage Vecteur \n");
        Vecteur.Remplissage_Matrice_Predefini();
        Remonte_Inversion Sol = m1.Resolution_complete(Vecteur);
        if(Sol.isPossible() == false){
            throw new Error ("Le systeme ne possede pas une unique solution");
        }
        System.out.println("\nLa solution est : \n" + Sol.getSolution());
    }
    
    public static void TestGene() {
         System.out.println("Donner le nombre de ligne de la matrice :");
        int L = Lire.i();
        System.out.println("Donner le nombre de colone de la matrice :");
        int C = Lire.i();

        Matrice m1 = new Matrice(L, C);
        m1.Remplissage_Matrice_Predefini();

        System.out.println("M1 \n" + m1);
        Matrice m2 = new Matrice(L, 1);
        System.out.println("Remplissage du vecteur colone : \n");
        m2.Remplissage_Matrice_Predefini();
        System.out.println("Vecteur colone : \n" + m2);
        m1 = m1.concatCol(m2);
        ResGauss Resultat = m1.DescenteGauss();
        System.out.println("M1 descente gauss \n" + m1);
        System.out.println("\nResultat descente gauss \n" + Resultat);
        Matrice m3 = m1.RemonteGauss(Resultat);
        System.out.println("\nRemonté Gauss \n" + m1);
        System.out.println("\nLe vecteur solution est : \n" + m3);
    }
    
    public static void main(String[] args) {
        
        Test_Resol();

//        Matrice m1 = new Matrice(3,3);
//        System.out.println("1 \n");
//        Matrice m2 = new Matrice(3,3);
//        Matrice m6;
//        double[] Tab = {1, 2, 3};
//        double pz = 0.5;
//        Matrice m5 = matTest2();
//        System.out.println("M5 " +m5);
//        Test_aleaZeroOuUnOuDeux(m1, pz);
//        System.out.println("2 \n");
//        System.out.println("m1 \n"+m1);
//        Test_aleaZeroOuUnOuDeux(m2, pz);
//        System.out.println("m2 \n"+m2);
//        Test_ConcatLig(m1 , m2);
//        Test_ConcatCol(m1 , m2);
//        m2.Test_SubLines();
//        Test_SubCols(m1);
//        Test_Transposition(m1);
//        Test_Test_Partie_2(m1);
//        Matrice m6 = vecteur(Tab);
//        System.out.println("M6 " + m6);
//        System.out.println("M 6 \n" +m6);
//        test2();
//        System.out.println("Addition \n" + m1.addition(m2));
//        System.out.println("Soustraction \n" + m1.soustraction(m2));
//        m1.Opposee();
//        System.out.println("M1 opposé \n" + m1);
//        Matrice m = new Matrice(5,3);
//        System.out.println("Multiplication \n" + m1.multiplication(m2));
//        matTest1().Test_3();
//        Matrice m1 = new Matrice(3, 3);
////        m1 = m1.Remplissage_Matrice_Predefini();
////        System.out.println("Matrice m \n"+m);
////        int i = m.permutLigne(0, 2);
////        System.out.println("Matrice m permut \n"+m);
////        System.out.println("Parite = "+i);
////        Matrice m1 = matTest1();
//        System.out.println("Donner le nombre de ligne de la matrice :");
//        int L = Lire.i();
//        System.out.println("Donner le nombre de colone de la matrice :");
//        int C = Lire.i();
//
//        Matrice m1 = new Matrice(L, C);
//        m1.Remplissage_Matrice_Predefini();
//
//        System.out.println("M1 \n" + m1);
//        Matrice m2 = new Matrice(L, 1);
//        System.out.println("Remplissage du vecteur colone : \n");
//        m2.Remplissage_Matrice_Predefini();
//        System.out.println("Vecteur colone : \n" + m2);
//        m1 = m1.concatCol(m2);
////        m1.permutLigne(0, 1);
////        System.out.println("M1 permut \n"+m1);
////        m1.transvection(0, 2);
////        System.out.println("M1 transvection \n"+m1);
////        int j = -1;
////        do {
////            System.out.println("Donner la valeur de la colone \n");
////            int i = Lire.i();
////            System.out.println("Ligne du plus grand pivot = " + m1.lignePlusGrandPivot(i));
////            System.out.println("\n");
////            System.out.println("Encore? (Ecrire -1 pour continuer)");
////            j = Lire.i();
////
////        } while (j == -1);
//        ResGauss Resultat = m1.DescenteGauss();
//        System.out.println("M1 descente gauss \n" + m1);
//        System.out.println("\nResultat descente gauss \n" + Resultat);
//        Matrice m3 = m1.RemonteGauss(Resultat);
//        System.out.println("\nRemonté Gauss \n" + m1);
//        System.out.println("\nLe vecteur solution est : \n" + m3);

    }

}
