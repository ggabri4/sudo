package sudoku;

/**
 * Implementation d'un élément de grille par un caractère.
 */
public class ElementDeGrilleImplAsChar implements ElementDeGrille {
    /**
    * Un caractere.
    */
    private char value;

    /**
     * Constructeur pour créer un nouvel élément
     * de grille avec un caractère spécifique.
     *
     * @param val le caractère pour représenter
     * cet élément de grille
     */
    public ElementDeGrilleImplAsChar(final char val) {
        this.value = val;
    }

    /**
     * Récupère le caractère représentant cet élément de grille.
     *
     * @return le caractère représentant cet élément de grille
     */
    public final char getValue() {
        return this.value;
    }

    /**
     * Définit le caractère représentant cet élément de grille.
     *
     * @param val le caractère pour représenter
     * cet élément de grille
     */
    public final void setValue(final char val) {
        this.value = val;
    }
}
