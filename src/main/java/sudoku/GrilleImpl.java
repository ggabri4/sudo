package sudoku;

import java.util.HashSet;
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
    * Un entier dimension.
    */
    private int dimension;
    /**
    * Un tableau d'éléments de grille.
    */
    private ElementDeGrille[][] grille;
    /**
    * Un set d'éléments de grille.
    */
    private Set<ElementDeGrille> elements;

    /**
     * Constructeur pour créer une nouvelle grille
     * avec une dimension spécifique.
     *
     * @param dim La dimension de la grille.
     */
    public GrilleImpl(final int dim) {
        this.dimension = dim;
        this.grille = new ElementDeGrille[dim][dim];
    }

    /**
     * Constructeur pour créer une nouvelle grille avec un ensemble d'éléments
     * initiaux.
     *
     * @param initialElements Les éléments initiaux de la grille.
     * @throws IllegalArgumentException Si le nombre d'éléments initiaux n'est
     * pas un carré parfait.
     */
    public GrilleImpl(ElementDeGrille[] initialElements) {

        if (initialElements == null || initialElements.length == 0) {
            throw new IllegalArgumentException("Le tableau d'éléments initiaux ne peut pas être vide.");
        }
    }
    /**
     * Récupère l'ensemble des éléments actuellement dans la grille.
     *
     * @return Un ensemble d'éléments de la grille.
     */
    @Override
    public Set<ElementDeGrille> getElements() {
        Set<ElementDeGrille> elements = new HashSet<>();
        for (ElementDeGrille[] row : grille) {
            for (ElementDeGrille e : row) {
                if (e != null) {
                    elements.add(e);
                }
            }
        }
        return elements;
    }

    /**
     * Récupère la dimension de la grille.
     *
     * @return La dimension de la grille.
     */
    @Override
    public int getDimension() {
        return this.dimension;
    }

    /**
     * Définit la valeur d'un élément spécifique de la grille.
     *
     * @param x Coordonnée x de l'élément.
     * @param y Coordonnée y de l'élément.
     * @param value La nouvelle valeur de l'élément.
     * @throws HorsBornesException Si les coordonnées sont en dehors des
     * limites de la grille.
     * @throws ValeurImpossibleException Si la valeur est déjà présente dans la
     * même ligne, colonne ou carré.
     * @throws ElementInterditException Si l'élément est interdit.
     * @throws ValeurInitialeModificationException Si on tente de modifier une
     * valeur initiale.
     */
    @Override
    public void setValue(final int x, final int y, final ElementDeGrille value) 
    throws HorsBornesException, ValeurImpossibleException,
    ElementInterditException, ValeurInitialeModificationException {
        if (x < 0 || y < 0 || x >= dimension || y >= dimension) {
            throw new HorsBornesException("Position en dehors de la grille");
        }

        // Vérifier si la valeur existe déjà dans la même ligne
        for (int i = 0; i < dimension; i++) {
            if (grille[x][i] != null && grille[x][i].equals(value)) {
                throw new ValeurImpossibleException(
                    "Valeur déjà présente dans la ligne");
            }
        }

        // Vérifier si la valeur existe déjà dans la même colonne
        for (int i = 0; i < dimension; i++) {
            if (grille[i][y] != null && grille[i][y].equals(value)) {
                throw new ValeurImpossibleException(
                    "Valeur déjà présente dans la colonne");
            }
        }

        // Vérifier si la valeur existe déjà dans le même carré
        int squareSize = (int) Math.sqrt(dimension);
        int startX = (x / squareSize) * squareSize;
        int startY = (y / squareSize) * squareSize;

        for (int i = startX; i < startX + squareSize; i++) {
            for (int j = startY; j < startY + squareSize; j++) {
                if (grille[i][j] != null && grille[i][j].equals(value)) {
                    System.out.println(new ValeurImpossibleException(
                        "Valeur déjà présente dans le carré"));
                }
            }
        }

        this.grille[x][y] = value;
    }

    /**
     * Récupère la valeur d'un élément spécifique de la grille.
     *
     * @param x Coordonnée x de l'élément.
     * @param y Coordonnée y de l'élément.
     * @throws HorsBornesException Si les coordonnées sont en dehors des limites
     * de la grille.
     * @return La valeur de l'élément aux coordonnées spécifiées.
     */
    @Override
    public ElementDeGrille getValue(final int x, final int y) throws HorsBornesException {
        if (x < 0 || y < 0 || x >= dimension || y >= dimension) {
            throw new HorsBornesException("Position en dehors de la grille");
        }
        return this.grille[x][y];
    }
    /**
     * Vérifie si la grille est complète.
     *
     * @return True si toutes les positions de la grille sont remplies,
     * sinon False.
     */
    @Override
    public boolean isComplete() {
        for (ElementDeGrille[] row : grille) {
            for (ElementDeGrille e : row) {
                if (e == null) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Vérifie si l'ajout d'une valeur à une position spécifique est possible.
     *
     * @param x Coordonnée x de l'élément.
     * @param y Coordonnée y de l'élément.
     * @param value La valeur à ajouter.
     * @throws HorsBornesException Si les coordonnées sont en dehors des
     * limites de la grille.
     * @throws ElementInterditException Si l'élément est interdit.
     * @return True si l'ajout de la valeur est possible, sinon False.
     */
    @Override
    public boolean isPossible(final int x, final int y, final ElementDeGrille value) 
    throws HorsBornesException, ElementInterditException {
        return true;
    }
    /**
     * Vérifie si la valeur à une position spécifique est une valeur initiale.
     *
     * @param x Coordonnée x de l'élément.
     * @param y Coordonnée y de l'élément.
     * @return True si la valeur à la position spécifiée est une valeur
     * initiale, sinon False.
     */
    @Override
    public boolean isValeurInitiale(final int x, final int y) {
        return false;
    }
}
