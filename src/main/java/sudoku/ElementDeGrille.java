package sudoku;


/**
 * @author Sébastien Choplin <sebastien.choplin@u-picardie.fr>
 */
public interface ElementDeGrille {
    
    /**
     * Récupère le caractère représentant cet élément de grille.
     * 
     * @return le caractère représentant cet élément de grille
     */
    char getValue();

    /**
     * Définit le caractère représentant cet élément de grille.
     * 
     * @param value le caractère pour représenter cet élément de grille
     */
    void setValue(char value);
}
