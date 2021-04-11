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
public class TriangleTerrain {
    
    private int Id;
    private Segment [] Seg = new Segment[3]; // On stocke ici les 3 segments qui forment notre triangle terrain
    
    public TriangleTerrain(int Iden, Segment[] S){ //On envoit les 3 segment à travers un tableau, c'est plus simple
        if (S.length !=3) {
            if (S.length < 3) {
                throw new Error ("Il n'y a pas assez de segment");
            }
            else if (S.length>3) {
                throw new Error ("Il y a trop de segment pour definir un TriangleTerrain");
            }
        }
        Id = Iden;
        for (int i = 0; i < 3; i++) {
            Seg[i] = S[i];
            
        }
    }

   
    public int getId() {
        return Id;
    }

    public Segment[] getSeg() { //Ici on retourne tout le tableau des segments
        return Seg;
    }
    
    public Segment getSeg(int i){ //Ici, on ne retourne que un seul segment précisé
        return Seg[i];
    }
    
    
    
}
