package sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import interfaces.ElementInterditException;
import interfaces.HorsBornesException;
import interfaces.ValeurImpossibleException;
import interfaces.ValeurInitialeModificationException;

public class GrilleImpl implements Grille {

    private int dimension;
    private ElementDeGrille[][] grille;
    private Set<ElementDeGrille> elements;

    public GrilleImpl(int dimension) {
        this.dimension = dimension;
        this.grille = new ElementDeGrille[dimension][dimension];
    }

    public GrilleImpl(ElementDeGrille[] initialElements) {

        if (initialElements == null || initialElements.length == 0) {
            throw new IllegalArgumentException("Le tableau d'éléments initiaux ne peut pas être vide.");
        }

        int dimension = (int) Math.sqrt(initialElements.length);
        if (dimension * dimension != initialElements.length) {
            throw new IllegalArgumentException("Le nombre d'éléments initiaux doit être un carré parfait.");
        }
        
        this.grille = new ElementDeGrille[dimension][dimension];

        this.elements = new HashSet<>(Arrays.asList(initialElements));
    }

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

    @Override
    public int getDimension() {
        return this.dimension;
    }

    @Override
    public void setValue(int x, int y, ElementDeGrille value) throws HorsBornesException, ValeurImpossibleException, ElementInterditException, ValeurInitialeModificationException {
        if (x < 0 || y < 0 || x >= dimension || y >= dimension) {
            throw new HorsBornesException("Position en dehors de la grille");
        }

        // Vérifier si la valeur existe déjà dans la même ligne
        for (int i = 0; i < dimension; i++) {
            if (grille[x][i] != null && grille[x][i].equals(value)) {
                throw new ValeurImpossibleException("Valeur déjà présente dans la ligne");
            }
        }

        // Vérifier si la valeur existe déjà dans la même colonne
        for (int i = 0; i < dimension; i++) {
            if (grille[i][y] != null && grille[i][y].equals(value)) {
                throw new ValeurImpossibleException("Valeur déjà présente dans la colonne");
            }
        }

        // Vérifier si la valeur existe déjà dans le même carré
        int squareSize = (int) Math.sqrt(dimension);
        int startX = (x / squareSize) * squareSize;
        int startY = (y / squareSize) * squareSize;

        for (int i = startX; i < startX + squareSize; i++) {
            for (int j = startY; j < startY + squareSize; j++) {
                if (grille[i][j] != null && grille[i][j].equals(value)) {
                    throw new ValeurImpossibleException("Valeur déjà présente dans le carré");
                }
            }
        }

        this.grille[x][y] = value;
    }


    @Override
    public ElementDeGrille getValue(int x, int y) throws HorsBornesException {
        if (x < 0 || y < 0 || x >= dimension || y >= dimension) {
            throw new HorsBornesException("Position en dehors de la grille");
        }
        return this.grille[x][y];
    }

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

    @Override
    public boolean isPossible(int x, int y, ElementDeGrille value) throws HorsBornesException, ElementInterditException {
        // Ici aussi, vous devrez implémenter la logique pour vérifier si l'opération est autorisée.
        // Pour l'instant, je vais simplement renvoyer vrai.
        return true;
    }

    @Override
    public boolean isValeurInitiale(int x, int y) {
        // Ici, vous auriez besoin d'une logique pour vérifier si la valeur à cette position est une valeur initiale.
        // Pour cet exemple, je vais simplement renvoyer faux.
        return false;
    }
}
