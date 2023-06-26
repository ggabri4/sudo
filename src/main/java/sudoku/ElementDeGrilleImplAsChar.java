package sudoku;

/**
 * Implementation d'un élément de grille par un caractère.
 */
public class ElementDeGrilleImplAsChar implements ElementDeGrille {
    
    private char value;

    /**
     * Constructeur pour créer un nouvel élément de grille avec un caractère spécifique.
     * 
     * @param value le caractère pour représenter cet élément de grille
     */
    public ElementDeGrilleImplAsChar(char value) {
        this.value = value;
    }

    /**
     * Récupère le caractère représentant cet élément de grille.
     * 
     * @return le caractère représentant cet élément de grille
     */
    public char getValue() {
        return this.value;
    }

    /**
     * Définit le caractère représentant cet élément de grille.
     * 
     * @param value le caractère pour représenter cet élément de grille
     */
    public void setValue(char value) {
        this.value = value;
    }
}
