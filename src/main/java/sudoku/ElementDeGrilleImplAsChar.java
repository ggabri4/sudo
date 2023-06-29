/**
 * class element de grille si l'element est un caractère.
 */
package sudoku;

/**
 * Implementation si l'élement de grille est un caractère.
 *
 * @author Carlier Steven
 * @author Gruit Gabriel
 */

public class ElementDeGrilleImplAsChar implements ElementDeGrille {
    /**
     * @param element un caractère.
     */
    private final char element;

    /**
     * @param elem un caractère passé en paramètre.
     */
    public ElementDeGrilleImplAsChar(final char elem) {

        this.element = elem;
    }

}
