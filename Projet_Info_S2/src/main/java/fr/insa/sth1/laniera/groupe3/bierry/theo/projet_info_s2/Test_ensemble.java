/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

/**
 *
 * @author theob
 */
public class Test_ensemble {
    
    public static void Test_definition_classes(){
        System.out.println("Cette classe je m'en sert pour tester si mes autres calsses fonctionnent bien \nThéo");
        ZoneConstructible ZC = new ZoneConstructible(0, 0, 200, 200);
        Point P0 = new Point(0, 0, 0);
        Point P1 = new Point(50, 50, 1);
        Point P2 = new Point(10, 10, 2);
        Point P3 = new Point(30, 30, 3);
        Point P4 = new Point(100, 100, 4);
        Point P5 = new Point(70, 70, 5);
        Segment S0 = new Segment(0, P0, P1);
        Segment S1 = new Segment(1, P1, P2);
        Segment S2 = new Segment(2, P1, P3);
        Segment[] S = new Segment[3];
        S[0] = S0;
        S[1] = S1;
        S[2] = S2;
        TriangleTerrain TT1 = new TriangleTerrain(0, S, ZC);
        System.out.println("-------------------------------------------------------------------\n"+ZC);
    }
    
    public static void main(String[] args) {
        Test_definition_classes();
    }
}
