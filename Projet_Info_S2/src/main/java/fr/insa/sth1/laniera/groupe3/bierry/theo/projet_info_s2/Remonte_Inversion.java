/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.sth1.laniera.groupe3.bierry.theo.projet_info_s2;

/**
 *
 * @author theob / Théo BIERRY
 */
public class Remonte_Inversion {
    
    private Matrice Solution;
    private boolean Possible;
    
    public Remonte_Inversion(){ //Soit ce n'est pas inversible est alors quand on la créer dans une classe anexe, on ne précise rien et donc c'est automatiquement pas inversible don cSolution est vide et Possible est false
        this.Possible = false;
    }
    
    public Remonte_Inversion(Matrice Solution){ // Soit c'est inversible et donc on ne demande que la matrice solution qui devient solution et possible devient true
        this.Solution = Solution;
        this.Possible = true;
    }

    /**
     * @return the Solution
     */
    public Matrice getSolution() {
        return Solution;
    }
    
    public boolean getPossible(){
        return Possible;
    }

    /**
     * @return the Possible
     */
    public boolean isPossible() {
        return Possible;
    }
    
    public String toString(){
        String res;
        res = "\nPossiblité : "+Possible;
        return res;
    }

    public void setSolution(Matrice Solution) {
        this.Solution = Solution;
    }

    public void setPossible(boolean Possible) {
        this.Possible = Possible;
    }
    
    
    
}
