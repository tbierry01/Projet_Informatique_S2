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
public class Test_ensemble {

    public static void Test_definition_classes() {
        ArrayList<Point> AP = new ArrayList<>();
        ArrayList<Segment[]> AS = new ArrayList<>();
        ArrayList<Barre> AB = new ArrayList<>();
        ArrayList<Noeud_Simple> ANS = new ArrayList<>();
        ArrayList<Appui_Simple> AAS = new ArrayList<>();
        ArrayList<Appui_Double> AAD = new ArrayList<>();
        ArrayList<Treillis> AT = new ArrayList<>();
        ArrayList<TriangleTerrain> ATT = new ArrayList<>();
        System.out.println("Cette classe je m'en sert pour tester si mes autres calsses fonctionnent bien \nThéo");
        ZoneConstructible ZC = new ZoneConstructible(0, 0, 200, 200);
        System.out.println("-------------------------------------------------------------------\n");
        Point P0 = new Point(0, 0, 0);
        AP.add(P0);
        Point P1 = new Point(50, 50, 1);
        AP.add(P1);
        Point P2 = new Point(10, 10, 2);
        AP.add(P2);
        Point P3 = new Point(30, 30, 3);
        AP.add(P3);
        Point P4 = new Point(100, 100, 4);
        AP.add(P4);
        Point P5 = new Point(70, 70, 5);
        AP.add(P5);
        Segment S0 = new Segment(0, P0, P1);
        Segment S1 = new Segment(1, P1, P2);
        Segment S2 = new Segment(2, P1, P3);
        Segment[] S = new Segment[3];
        S[0] = S0;
        S[1] = S1;
        S[2] = S2;
        AS.add(S);
        TriangleTerrain TT1 = new TriangleTerrain(0, S, ZC);
        ATT.add(TT1);
        System.out.println("\n=====Points=====");
        for (int i = 0; i < AP.size(); i++) {
            System.out.println(AP.get(i));
        }
        System.out.println("\n=====Segments=====");
        for (int i = 0; i < AS.size(); i++) {
            for (int j = 0; j < S.length; j++) {
                System.out.println(AS.get(i)[j]);

            }

        }
        System.out.println("\n=====TrianglesTerrain=====");
        for (int i = 0; i < ATT.size(); i++) {
            System.out.println(ATT.get(i));
        }
        System.out.println("\n=====Barres=====");
        for (int i = 0; i < AB.size(); i++) {
            System.out.println(AB.get(i));
        }
        System.out.println("\n=====Noeuds Simples=====");
        for (int i = 0; i < ANS.size(); i++) {
            System.out.println(ANS.get(i));
        }
        System.out.println("\n=====Appui Simples=====");
        for (int i = 0; i < AAS.size(); i++) {
            System.out.println(AAS.get(i));
        }
        System.out.println("\n=====Appui Double=====");
        for (int i = 0; i < AAD.size(); i++) {
            System.out.println(AAD.get(i));
        }

        System.out.println("-------------------------------------------------------------------\n" + ZC);
    }

    public static void main(String[] args) {
        Test_definition_classes();
    }
}
