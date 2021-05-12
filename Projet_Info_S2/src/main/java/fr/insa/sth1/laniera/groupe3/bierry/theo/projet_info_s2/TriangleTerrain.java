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
    /*
    private int Id;
    private Segment [] Seg; // On stocke ici les 3 segments qui forment notre triangle terrain
    private ZoneConstructible ZCTriangleTerrain;
    
    public TriangleTerrain(int Iden, Segment[] S, ZoneConstructible ZC){ //On envoit les 3 segment à travers un tableau, c'est plus simple
        if (S.length !=3) {
            if (S.length < 3) {
                throw new Error ("Il n'y a pas assez de segment");
            }
            else if (S.length>3) {
                throw new Error ("Il y a trop de segment pour definir un TriangleTerrain");
            }
        }
        Id = Iden;
        Seg = new Segment[3];
        for (int i = 0; i < 3; i++) {
            Seg[i] = S[i];
            S[i].setTriangleTerrain(this);
        }
        
        ZCTriangleTerrain = ZC;
        ZC.addTriangleTerrain(this); //On fait ca pour respecter la multiplicité de notre diagrmame UML, dès que l'on crer un nouveua TringalTerrain dans la zone constructible ZC, on l'ajoute à la liste des triangles terrains de ZC
        
    }
    
    public String toString(){
        String res;
        res = "\n -- Triangle Terrain "+Id+"--"+"\nA pour segment : "+"\n -> "+Seg[0].getId()+"\n -> "+Seg[1].getId()+"\n -> "+Seg[2].getId()+"\nAppartient à la zone constructible";
        return res;
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

    public ZoneConstructible getZCTriangleTerrain() {
        return ZCTriangleTerrain;
    }
    */
    
    
}
