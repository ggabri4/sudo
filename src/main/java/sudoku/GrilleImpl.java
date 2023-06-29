package sudoku;

import java.util.Set;

import interfaces.ElementInterditException;
import interfaces.HorsBornesException;
import interfaces.ValeurImpossibleException;
import interfaces.ValeurInitialeModificationException;

/**
 * Implémentation de l'interface Grille pour représenter une grille de sudoku.
 */
public class GrilleImpl implements Grille {
    /**
     * @param dimension un entier.
     */
    private int dimension;

    /**
     * @param grille tableau d'éléments de grille.
     */
    private ElementDeGrille[][] grille;

    /**
     * @param elements Un set d'éléments de grille.
     */
    private Set<ElementDeGrille> elements;

    /**
     * @param elements tableau d'éléments de grille.
     */
    private ElementDeGrille[] elementDeGrilles;

    /**
     * Constructeur pour créser une nouvelle grille avec un ensemble d'éléments
     * initiaux.
     *
     * @param initialElements Les éléments initiaux de la grille.
     * @throws IllegalArgumentException Si le nombre d'éléments initiaux n'est
     *                                  pas un carré parfait.
     */
    public GrilleImpl(final ElementDeGrille[] initialElements) {

        if (initialElements == null || initialElements.length == 0) {
            throw new IllegalArgumentException(
                    "Le tableau d'éléments initiaux ne peut pas être vide.");
        }
    }

    /**
     * Récupère l'ensemble des éléments actuellement dans la grille.
     *
     * @return Un ensemble d'éléments de la grille.
     */
    @Override
    public Set<ElementDeGrille> getElements() {

        throw new UnsupportedOperationException(
                "Unimplemented method 'getElements'");
    }

    /**
     * Récupère la dimension de la grille.
     *
     * @return La dimension de la grille.
     */
    @Override
    public final int getDimension() {

        throw new UnsupportedOperationException(
                "Unimplemented method 'getDimension'");
    }

    /**
     * Définit la valeur d'un élément spécifique de la grille.
     *
     * @param x     Coordonnée x de l'élément.
     * @param y     Coordonnée y de l'élément.
     * @param value La nouvelle valeur de l'élément.
     * @throws HorsBornesException                 Si les coordonnées
     *                                             sont en dehors
     *                                             des limites
     *                                             de la grille.
     * @throws ValeurImpossibleException           Si la valeur est déjà
     *                                             présente
     *                                             dans la même ligne,
     *                                             colonne ou
     *                                             carré.
     * @throws ElementInterditException            Si l'élément est interdit.
     * @throws ValeurInitialeModificationException Si on tente de modifier une
     *                                             valeur initiale.
     */
    @Override
    public void setValue(final int x, final int y, final ElementDeGrille value)
            throws HorsBornesException, ValeurImpossibleException,
            ElementInterditException, ValeurInitialeModificationException {

    }

    /**
     * Récupère la valeur d'un élément spécifique de la grille.
     *
     * @param x Coordonnée x de l'élément.
     * @param y Coordonnée y de l'élément.
     * @throws HorsBornesException Si les coordonnées sont en dehors des limites
     *                             de la grille.
     * @return La valeur de l'élément aux coordonnées spécifiées.
     */
    @Override
    public final ElementDeGrille getValue(final int x,
            final int y) throws HorsBornesException {
        throw new UnsupportedOperationException(
                "Unimplemented method 'getValue'");
    }

    /**
     * Vérifie si la grille est complète.
     *
     * @return True si toutes les positions de la grille sont remplies,
     *         sinon False.
     */
    @Override
    public final boolean isComplete() {

        throw new UnsupportedOperationException(
                "Unimplemented method 'isComplete'");
    }

    /**
     * Vérifie si l'ajout d'une valeur à une position spécifique est possible.
     *
     * @param x     Coordonnée x de l'élément.
     * @param y     Coordonnée y de l'élément.
     * @param value La valeur à ajouter.
     * @throws HorsBornesException      Si les coordonnées sont en dehors des
     *                                  limites de la grille.
     * @throws ElementInterditException Si l'élément est interdit.
     * @return True si l'ajout de la valeur est possible, sinon False.
     */
    @Override
    public final boolean isPossible(final int x,
            final int y, final ElementDeGrille value)
            throws HorsBornesException, ElementInterditException {

        throw new UnsupportedOperationException(
                "Unimplemented method 'isPossible'");
    }

    /**
     * Vérifie si la valeur à une position spécifique est une valeur initiale.
     *
     * @param x Coordonnée x de l'élément.
     * @param y Coordonnée y de l'élément.
     * @return True si la valeur à la position spécifiée est une valeur
     *         initiale, sinon False.
     */
    @Override
    public final boolean isValeurInitiale(final int x, final int y) {

        throw new UnsupportedOperationException(
                "Unimplemented method 'isValeurInitiale'");
    }

    /**
     * initialise la grille.
     *
     * @param elements la grille d'éléments.
     */
    public final void setElements(final ElementDeGrille[] elements) {
        this.elementDeGrilles = elements;
    }

}
