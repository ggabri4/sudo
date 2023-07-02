package sudoku;

import interfaces.ElementInterditException;
import interfaces.HorsBornesException;
import interfaces.ValeurImpossibleException;
import interfaces.ValeurInitialeModificationException;

/**
 * Implémentation de l'interface Solveur.
 * Résout une grille de sudoku en utilisant l'algorithme de backtracking.
 *
 * @author Gabriel GRUIT
 * @author Steven CARLIER
 */
public class SolveurImpl implements Solveur {
    /**
     * Instance de GrilleImpl pour stocker la grille de sudoku à résoudre.
     */
    private GrilleImpl grille;

    /**
     * Tente de résoudre la grille de sudoku fournie.
     *
     * @param grille La grille de sudoku à résoudre.
     * @return true si la grille de sudoku a pu être résolue, sinon false.
     */
    @Override
    public boolean solve(Grille grille) {
        this.grille = (GrilleImpl) grille;
        return solve();
    }

    /**
     * Implémentation de l'algorithme de backtracking
     * pour résoudre la grille de sudoku.
     * Parcourt chaque cellule de la grille
     * et essaie de placer un nombre valide.
     * Si un nombre valide est placé, il passe
     * à la cellule suivante par un appel récursif.
     * Si aucun nombre valide ne peut être placé,
     * il revient en arrière et change le nombre de la cellule précédente.
     *
     * @return true si la grille de sudoku a pu être résolue, sinon false.
     */
    public boolean solve() {
        for (int row = 0; row < grille.getDimension(); row++) {
            for (int col = 0; col < grille.getDimension(); col++) {
                try {
                    if (grille.getValue(row, col) == null) {
                        for (int num = 1; num <= grille.getDimension(); num++) {
                            ElementDeGrille value = new ElementDeGrilleImplAsChar((char) num);

                            if (grille.isPossible(row, col, value)) {
                                grille.setValue(row, col, value);
                                if (solve()) {
                                    return true;
                                } else {
                                    grille.setValue(row, col, null);
                                }
                            }

                        }
                        return false;
                    }
                } catch (HorsBornesException
                        | ValeurImpossibleException
                        | ElementInterditException
                        | ValeurInitialeModificationException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
