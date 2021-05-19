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
public class ResolutionContrainteNoeuds {

    private ArrayList<Noeud> Noeuds_Systeme;
    private int NbInconnus;
    private int NbBarres;

    public ResolutionContrainteNoeuds(ArrayList<Noeud> NS) {
        Noeuds_Systeme = NS;
        int Compteur = Noeuds_Systeme.get(0).getTreillis_Noeud().getBarre_Treillis().size(); //Comme tous les noeuds appartiennent au même treillis, alors un seul suffit pour connaitre le nombre de barre dans le treillis, en l'occurence, le premier
        NbBarres = Compteur; //Ici, on stocke le nombre de barres ce qui va nous être utile pour la suite
        //Dans ce qui suit, jusqu'à la fin de la boucle for, on calcul combien de colones doit on rajouter à notre systeme en fonction des appuis simples et appuis doubles
        for (int i = 0; i < Noeuds_Systeme.size(); i++) {
            if (Noeuds_Systeme.get(i) instanceof Appui_Double) { //Si le noeud est un appui double on a 2 inconnues en plus, Rx et Ry
                Compteur = Compteur + 1;
            } else if (Noeuds_Systeme.get(i) instanceof Appui_Simple) { //Si le noeud est un appui simple, on a que 1 inconnue en plus qui est la reaction normale
                Compteur = Compteur + 2;
            }
        }
        NbInconnus = Compteur;
    }

    public FormatDeRetourSystemNoeuds CreationSystemeEnsembleTreillis() { //On créer les 2 matrices de notre système, celle qui posède le système et celle qui contient le vecteur de l'équivalence
        int Compteur = NbBarres;
        Matrice SystemeEquation = new Matrice(0, NbInconnus);
        Matrice Equivalence = new Matrice(0, 1);
        FormatDeRetourSystemNoeuds FR;
        for (int i = 0; i < Noeuds_Systeme.size(); i++) {
            FR = Noeuds_Systeme.get(i).Generation_Syteme(NbInconnus, Compteur); //On reupère le FormatDeRetour du Noeud en position i
            SystemeEquation = SystemeEquation.concatLig(FR.getSysteme()); //On concatène toutes les lignes des systemes de chauque Noeuds pour en faire un système
            Equivalence = Equivalence.concatLig(FR.getEgalite()); //On concatène toutes les lignes des equivalences de chaque Noeuds pour en faire une grandde colone
            
            System.out.println("Matrices au noeud "+i+"\n--Systeme equation--\n"+SystemeEquation+"\n--Equivalence--\n"+Equivalence);
            System.out.println("Compteur : "+Compteur);
            //Dans les boucles de conditions qui suivent, on ajuste le compteur en fonction du type de noeud auquel on fait face
            if (Noeuds_Systeme.get(i) instanceof Appui_Double) {
                Compteur = Compteur + 1; //Plus 1 car 1 inconnus donc 2 colones en plus
            } else if (Noeuds_Systeme.get(i) instanceof Appui_Simple) {
                Compteur = Compteur + 2; //Plus 2 car 2 inconnu donc 1 colone en plus
            }
            
        }
        FormatDeRetourSystemNoeuds FRreturn = new FormatDeRetourSystemNoeuds(SystemeEquation, Equivalence);
        System.out.println("Matrice avant travail : "+FRreturn);
        return FRreturn;
    }
    
    public Remonte_Inversion Resolution(){ //Cette classe permet de renvoyer une instance di type Remonte_Inversion avec la possibilité ou pas et la matrice si c'est bon
        FormatDeRetourSystemNoeuds FR = CreationSystemeEnsembleTreillis(); //On fait la méthode CreationSystemEnsembleTreillis
        System.out.println("Format de retour : "+FR);
        Remonte_Inversion RI = FR.getSysteme().Resolution_complete(FR.getEgalite()); //On résoud le système composé de la matrice principale et de l'équivalence
        //System.out.println("FR Sytem : "+ FR.getSysteme());
        System.out.println("Remonte Inversion: "+ RI);
        return RI;
    }
    
    //ATTENTION, on n'a un problème de résolution lorsque l'on inverse l'ordre

}
