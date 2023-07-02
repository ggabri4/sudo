package sudoku;

/**
 * Interface de résolveur de Grille.
 *
 * @author Steven Carlier
 * @author Gabriel GRUIT
 */
public interface Solveur {
    /**
     * Résoud une Grille.
     *
     * @param grille Grille à résoudre.
     * @return true si la grille a été résolue.
     */
    boolean solve(Grille grille);
}
