/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author theob
 */
public class Test_ensemble {

//    public static void Test_definition_classes() {
//        ArrayList<Point> AP = new ArrayList<>();
//        ArrayList<Segment[]> AS = new ArrayList<>();
//        ArrayList<Barre> AB = new ArrayList<>();
//        ArrayList<Noeud_Simple> ANS = new ArrayList<>();
//        ArrayList<Appui_Simple> AAS = new ArrayList<>();
//        ArrayList<Appui_Double> AAD = new ArrayList<>();
//        ArrayList<Treillis> AT = new ArrayList<>();
//        ArrayList<TriangleTerrain> ATT = new ArrayList<>();
//        System.out.println("Cette classe je m'en sert pour tester si mes autres calsses fonctionnent bien \nThéo");
//        ZoneConstructible ZC = new ZoneConstructible(0, 0, 200, 200);
//        System.out.println("-------------------------------------------------------------------\n");
//        Point P0 = new Point(0, 0, 0);
//        AP.add(P0);
//        Point P1 = new Point(1, 1, 1);
//        AP.add(P1);
//        Point P2 = new Point(1, 0, 2);
//        AP.add(P2);
//        Point P3 = new Point(0, 1, 3);
//        AP.add(P3);
//        Point P4 = new Point(-1, 1, 4);
//        AP.add(P4);
//        Point P5 = new Point(-1, 0, 5);
//        AP.add(P5);
//        Point P6 = new Point(-1, -1, 6);
//        AP.add(P6);
//        Point P7 = new Point(0, -1, 7);
//        AP.add(P7);
//        Point P8 = new Point(1, -1, 8);
//        AP.add(P8);
//        Point P9 = new Point(0, 0, 9);
//        AP.add(P9);
//        Segment S0 = new Segment(0, P0, P1);
//        Segment S1 = new Segment(1, P1, P2);
//        Segment S2 = new Segment(2, P2, P0);
//        Segment[] S = new Segment[3];
//        S[0] = S0;
//        S[1] = S1;
//        S[2] = S2;
//        AS.add(S);
//        TriangleTerrain TT1 = new TriangleTerrain(0, S, ZC);
//        ATT.add(TT1);
//        Treillis T0 = new Treillis(0, ZC);
//        AT.add(T0);
//        Noeud_Simple N0 = new Noeud_Simple(P0, T0, 0);
//        ANS.add(N0);
//        Noeud_Simple N1 = new Noeud_Simple(P1, T0, 1);
//        ANS.add(N1);
//         Noeud_Simple N2 = new Noeud_Simple(P2, T0, 0);
//        ANS.add(N2);
//        Noeud_Simple N3 = new Noeud_Simple(P3, T0, 1);
//        ANS.add(N3);
//        Noeud_Simple N4 = new Noeud_Simple(P4, T0, 1);
//        ANS.add(N4);
//        Noeud_Simple N5 = new Noeud_Simple(P5, T0, 1);
//        ANS.add(N5);
//        Noeud_Simple N6 = new Noeud_Simple(P6, T0, 1);
//        ANS.add(N6);
//         Noeud_Simple N7 = new Noeud_Simple(P7, T0, 0);
//        ANS.add(N7);
//        Noeud_Simple N8 = new Noeud_Simple(P8, T0, 1);
//        ANS.add(N8);
//        Noeud_Simple N9 = new Noeud_Simple(P9, T0, 1);
//        ANS.add(N9);
//        TypeBarre TB = new TypeBarre(0);
//        Barre B0 = new Barre(0, N0, N1, T0, TB);
//        AB.add(B0);
//        Barre B1 = new Barre(1, N0, N2, T0, TB);
//        AB.add(B1);
//        Barre B2 = new Barre(2, N0, N3, T0, TB);
//        AB.add(B2);
//        Barre B3 = new Barre(3, N0, N4, T0, TB);
//        AB.add(B3);
//        Barre B4 = new Barre(4, N0, N5, T0, TB);
//        AB.add(B4);
//        Barre B5 = new Barre(5, N0, N6, T0, TB);
//        AB.add(B5);
//        Barre B6 = new Barre(6, N0, N7, T0, TB);
//        AB.add(B6);
//        Barre B7 = new Barre(7, N0, N8, T0, TB);
//        AB.add(B7);
//        Appui_Simple AS0 = new Appui_Simple(T0, 2, 0.5, S2);
//        AAS.add(AS0);
//        Appui_Double AD0 = new Appui_Double(T0, 3, 0, S2);
//        AAD.add(AD0);
////        Barre B5 = new Barre(5, AD0, AS0, T0, TB);
////        AB.add(B5);
//        //Ce qui suit est la partie de l'affichage
//        Affichage(AP, AS, ATT, AB, ANS, AAS, AAD, AT, ZC);
//        double [] Angle = N0.AnglesBarres();
//        System.out.println("N0 ");
//        for (int i = 0; i < Angle.length; i++) {
//            System.out.println("\n" + Angle[i]);
//            
//        }
//    }
//    
    public static void Affichage(ArrayList<Point> AP, ArrayList<Segment[]> AS, ArrayList<TriangleTerrain> ATT, ArrayList<Barre> AB, ArrayList<Noeud_Simple> ANS, ArrayList<Appui_Simple> AAS, ArrayList<Appui_Double> AAD, ArrayList<Treillis> AT, ZoneConstructible ZC){
        System.out.println("\n=====Points=====");
        for (int i = 0; i < AP.size(); i++) {
            System.out.println(AP.get(i));
        }
        System.out.println("\n=====Segments=====");
        for (int i = 0; i < AS.size(); i++) {
            for (int j = 0; j < AS.get(i).length; j++) {
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
        
        System.out.println("\n=====Treillis=====");
        for (int i = 0; i < AT.size(); i++) {
            System.out.println(AT.get(i));
        }

        System.out.println("-------------------------------------------------------------------\n" + ZC);
    }
    
    public static void  Test_Classe_Point(){
        Point P0 = new Point(0,1, 0);
        Point P1 = new Point(1,0, 1);
        Segment S0 = new Segment(0, P0, P1);
        System.out.println("Points\n"+P0+P1+S0);
        System.out.println("Longueur "+ S0.LongueurSegment());
        System.out.println("Angle verticale P0 par rapport à P1 "+P0.AngleVertical_DeuxPoints(P1));
        System.out.println("Angle horizontale P0 par rapport à P1 "+P0.AngleHorizontal_DeuxPoints(P1));
        System.out.println("Angle verticale P1 par rapport à P0 "+P1.AngleVertical_DeuxPoints(P0));
        System.out.println("Angle horizontale P1 par rapport à P0 "+P1.AngleHorizontal_DeuxPoints(P0));

    }
    
    public static void Test_Position_Appui(){
        Point P0 = new Point(1,1, 0);
        Point P1 = new Point(0,0, 1);
        Segment S0 = new Segment(0, P0, P1);
        Appui A0 = new Appui_Double(1, S0);
        System.out.println("Position appui "+A0.getPos());
    }
    
    public static void Test_CompteurId_Points(){
        Point P0 = new Point(1,1);
        Point P1 = new Point(0,0);
        Point P2 = new Point(1,1);
        Point P3 = new Point(0,0);
        System.out.println("Points : ");
        System.out.println("P0 : "+ P0.getId());
        System.out.println("P1 : "+ P1.getId());
        System.out.println("P2 : "+ P2.getId());
        System.out.println("P3 : "+ P3.getId());
        
    }
    
    public static void Test_Angles(){
        ArrayList <Barre> ARB = new ArrayList<>();
        Point P0 = new Point(0,0);
        Point P1 = new Point(1,0);
        Point P2 = new Point(1,1);
        Point P3 = new Point(-1,0);
        Point P4 = new Point(-1,1);
        System.out.println("P0 : "+ P0);
        System.out.println("P1 : "+ P1);
        System.out.println("P2 : "+ P2);
        System.out.println("P3 : "+ P3);
        System.out.println("P4 : "+ P4);
        Noeud_Simple N0 = new Noeud_Simple(P0);
        Noeud_Simple N2 = new Noeud_Simple(P2);
        Noeud_Simple N4 = new Noeud_Simple(P2);
        Segment S0 = new Segment(0, P0, P2);
        Segment S1 = new Segment(1, P0, P2);
        Appui_Simple A0 = new Appui_Simple(0.0, S0);
        Appui_Simple A1 = new Appui_Simple(1, S0);
        Appui_Double AD0 = new Appui_Double(0.0, S0);
        Appui_Double AD1 = new Appui_Double(1, S0);
        Barre B0 = new Barre(N0, N2);
        ARB.add(B0);
        Barre B1 = new Barre(A0, A1);
        ARB.add(B1);
        Barre B2 = new Barre(AD0, AD1);
        ARB.add(B2);
        Barre B3 = new Barre(N2, N4);
        ARB.add(B3);
        Barre B4 = new Barre(N0, N4);
        ARB.add(B4);
        Barre B5 = new Barre(N4, N0);
        ARB.add(B5);
        ResolutionContraintes RC = new ResolutionContraintes(ARB);
        double [] Angle = RC.Calcul_Angle();
        for (int i = 0; i < Angle.length; i++) {
            System.out.println("Angle "+i+" "+ Angle[i]);
            
        }
    }
    
    public static void TestAngle2(){
        Point P = new Point(0, 0);
        Noeud_Simple N = new Noeud_Simple(P);
        Point P1 = new Point(0, 1);
        Point P2 = new Point(1, 0);
        Point P3 = new Point(0, -1);
        Point P4 = new Point(1, -1);
        Point P5 = new Point(-1, -1);
        System.out.println("Angle : ");
        System.out.println("P : " + N.Angle(P));
        System.out.println("P1 : " + N.Angle(P1));
        System.out.println("P2 : " + N.Angle(P2));
        System.out.println("P3 : " + N.Angle(P3));
        System.out.println("P4 : " + N.Angle(P4));
        System.out.println("P5 : " + N.Angle(P5));
        
        
    }
    
    public static void TestAngleNormal(){
        Point P0 = new Point(1,-10);
        Point P1 = new Point(1, 0);
        Segment S = new Segment(0, P1, P0);
        Appui_Simple AS0 = new Appui_Simple(0.25, S);
        System.out.println("Position appui "+AS0.getPos());
        System.out.println("Angle horizontale "+ AS0.Angle(P1));
        //System.out.println("Angle "+ AS0.getAngleNormal());
    }
    
    public static void TestResolutionContrainte(){
        ZoneConstructible ZC = new ZoneConstructible(-5, 5, -5, 5);
        Point P0 = new Point(0, -2, 0);
        Point P1 = new Point(0, 2, 1);
        Point P2 = new Point(-1, 0, 2);
        Point P3 = new Point(1, 1, 3);
        Segment S0 = new Segment(0, P0, P1);
        Segment S1 = new Segment(1, P1, P2);
        Segment S2 = new Segment(2, P2, P0);
        Segment [] S = new Segment [3];
        S[0] = S0;
        S[1] = S1;
        S[2] = S2;
        Treillis T = new Treillis(0, ZC);
        Force F0 = new Force(0, 0);
        Force F1 = new Force(-1000, Math.PI/2);
        Appui_Double AD = new Appui_Double(T, 0 , 0.5, S0, F0);
        Appui_Simple AS = new Appui_Simple(T, 1, 1, S0, F0);
        Noeud_Simple NS = new Noeud_Simple(P3, T, 2, F1);
        TypeBarre TB = new TypeBarre(0);
        Barre B1 = new Barre(0, AS, NS, T, TB);
        Barre B2 = new Barre(1, AD, NS, T, TB);
        Barre B3 = new Barre(2, AD, AS, T, TB);
        //TriangleTerrain TT = new TriangleTerrain(0, S, ZC);
        ArrayList<Noeud> ARN = new ArrayList<>();
        ARN.add(AD);
        ARN.add(AS);
        ARN.add(NS);
        ResolutionContrainteNoeuds RCN = new ResolutionContrainteNoeuds(ARN);
        Remonte_Inversion RI = RCN.Resolution();
        Matrice M = RI.getSolution();
        System.out.println("Matrice : \n"+M);
    }
    
    public static void TestClassDessin(){
        ClassDessin CD = new ClassDessin();
        System.out.println("Contenu : "+CD.getContenu());
    }
    
    private static ClassDessin Generation_Liste_Figure (){
        ZoneConstructible ZC = new ZoneConstructible(10, 0, 100, 100);
        Treillis T  = new Treillis(0, ZC);
        TypeBarre TB = new TypeBarre(0);
        Force FN = new Force(50, 0);
        ArrayList<Figure> AF = new ArrayList<>();
        Point P0 = new Point(0, 0, 0);
        AF.add(P0);
        Point P1 = new Point(1, 1, 1);
        AF.add(P1);
        Segment S0 = new Segment(0, ZC, P0, P1, 0, 1, 1);
        
        AF.add(S0);
        Point P2 = new Point(2, 0, 0);
        AF.add(P2);
        Point P3 = new Point(3, 1, 1);
        AF.add(P3);
        Segment S1 = new Segment(1, ZC, P2, P3, 1, 1, 0);
        AF.add(S1);
        Point P4 = new Point(4, 0, 0);
        AF.add(P4);
        Point P5 = new Point(5, 1, 1);
        AF.add(P5);
        Segment S2 = new Segment(2, ZC, P0, P1, 0, 0, 0);
        AF.add(S2);
        Segment[] S = new Segment[3];
        S[0] = S0;
        S[1] = S1;
        S[2] = S2;
        //TriangleTerrain TT = new TriangleTerrain(0, S, ZC);
        Noeud_Simple NS0 = new Noeud_Simple(P0, T, 0, FN);
        AF.add(NS0);
        Appui_Simple AS0 = new Appui_Simple(T, 0, 0.5, S0, FN);
        AF.add(AS0);
        Barre B0 = new Barre(0, NS0, AS0, T, TB);
        AF.add(B0);
        ClassDessin CD = new ClassDessin(AF);
        return CD;
    }
    
    public static void Test_Tri_Figure(){
        ClassDessin CD = Generation_Liste_Figure();
        ArrayList<Noeud> AN = CD.Tri_Des_Noeuds();
        System.out.println("Liste : " + AN);
    }
    
    private static void Test_Enregistrement() throws IOException{
        ClassDessin CD = Generation_Liste_Figure();
        File F = new File ("Test.txt");
        CD.Enregistrement(F);
    }
   
    private static void Test_Letcure() throws IOException{
        ClassDessin CD = Generation_Liste_Figure();
        File F = new File ("Test.txt");
        FormatRetourEnregistrement FRE = CD.Lecture_Fichier(F);
        System.out.println(FRE);
        
    }
    
    private  static ArrayList<Figure> Generation_AF(){
        ArrayList<Figure> AF = new ArrayList<>();
        ZoneConstructible ZC = new ZoneConstructible(-5, 5, -5, 5);
        Point P0 = new Point(0, -2, 0);
        AF.add(P0);
        Point P1 = new Point(0, 2, 1);
        AF.add(P1);
        Point P2 = new Point(-1, 0, 2);
        AF.add(P2);
        Point P3 = new Point(1, 1, 3);
        AF.add(P3);
        Segment S0 = new Segment(0, ZC, P0, P1, 0, 0, 1);
        AF.add(S0);
        Segment S1 = new Segment(1, ZC, P1, P2, 1, 0, 0);
        AF.add(S1);
        Segment S2 = new Segment(2, ZC, P2, P0, 0, 1, 0);
        AF.add(S2);
        Segment [] S = new Segment [3];
        S[0] = S0;
        S[1] = S1;
        S[2] = S2;
        Treillis T = new Treillis(0, ZC);
        Force F0 = new Force(0, 0, 0);
        Force F1 = new Force(-1000, Math.PI/2, 1);
        Appui_Double AD = new Appui_Double(T, 0 , 0.5, S0, F0);
        AF.add(AD);
        Appui_Simple AS = new Appui_Simple(T, 1, 1, S0, F0);
        AF.add(AS);
        Noeud_Simple NS = new Noeud_Simple(P3, T, 2, F1);
        AF.add(NS);
        TypeBarre TB = new TypeBarre(0);
        Barre B1 = new Barre(0, AS, NS, T, TB);
        AF.add(B1);
        Barre B2 = new Barre(1, AD, NS, T, TB);
        AF.add(B2);
        Barre B3 = new Barre(2, AD, AS, T, TB);
        AF.add(B3);
        return AF;
    }
    
    public static void TestEnrLecRes() throws IOException{
        ArrayList<Figure> AF = Generation_AF();
        ClassDessin CD = new ClassDessin(AF);
        File file = new File("Test1.txt");
        CD.Enregistrement(file);
        FormatRetourEnregistrement FRE = CD.Lecture_Fichier(file);
        ClassDessin CD1 = new ClassDessin(FRE.getAF());
        ArrayList<Noeud> AN = CD1.Tri_Des_Noeuds();
        ResolutionContrainteNoeuds RCN = new ResolutionContrainteNoeuds(AN);
        Remonte_Inversion RI = RCN.Resolution();
        Matrice M = RI.getSolution();
        System.out.println("Matrice : \n"+M);
        
    }
    
    public static void main(String[] args) throws IOException{
        //Test_definition_classes();
        //Test_Classe_Point();
        //Test_Position_Appui();
        //Test_CompteurId_Points();
        //Test_Angles();
        //TestAngle2();
        //TestAngleNormal();
        TestResolutionContrainte();        
        //TestClassDessin();
        //Test_Tri_Figure();
        //Test_Enregistrement();
        //Test_Letcure();
        //TestEnrLecRes();
        
       
        
    }

    
}



