package sudoku;

import interfaces.*;
import java.util.HashSet;
import java.util.Set;

public class ElementDeGrilleImplAsChar implements Grille {
    private int dimension;
    private ElementDeGrille[][] grille;
    private Set<ElementDeGrille> elements;

    public ElementDeGrilleImplAsChar(int dimension) {
        this.dimension = dimension;
        this.grille = new ElementDeGrille[dimension][dimension];
        this.elements = new HashSet<>();
    }

    @Override
    public Set<ElementDeGrille> getElements() {
        return this.elements;
    }

    @Override
    public int getDimension() {
        return this.dimension;
    }

    @Override
    public void setValue(int x, int y, ElementDeGrille value) throws HorsBornesException, ValeurImpossibleException, ElementInterditException, ValeurInitialeModificationException {
        if (x < 0 || x >= dimension || y < 0 || y >= dimension) {
            throw new HorsBornesException();
        }

        if (value != null && !elements.contains(value)) {
            throw new ElementInterditException();
        }

        if (isValeurInitiale(x, y)) {
            throw new ValeurInitialeModificationException();
        }

        grille[x][y] = value;
    }

    @Override
    public ElementDeGrille getValue(int x, int y) throws HorsBornesException {
        if (x < 0 || x >= dimension || y < 0 || y >= dimension) {
            throw new HorsBornesException();
        }

        return grille[x][y];
    }

    @Override
    public boolean isComplete() {
        for (ElementDeGrille[] row : grille) {
            for (ElementDeGrille element : row) {
                if (element == null) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean isPossible(int x, int y, ElementDeGrille value) throws HorsBornesException, ElementInterditException {
        if (x < 0 || x >= dimension || y < 0 || y >= dimension) {
            throw new HorsBornesException();
        }

        if (value != null && !elements.contains(value)) {
            throw new ElementInterditException();
        }

        return grille[x][y] == null || !isValeurInitiale(x, y);
    }

    @Override
    public boolean isValeurInitiale(int x, int y) {
        // Ici vous devrez mettre en place une logique pour déterminer si une valeur est initiale ou non
        // Je vais juste retourner false pour l'instant, car je n'ai pas les détails de l'implémentation
        return false;
    }
}
