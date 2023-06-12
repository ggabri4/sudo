package sudoku;

import java.util.Set;

import interfaces.ElementInterditException;
import interfaces.HorsBornesException;
import interfaces.ValeurImpossibleException;
import interfaces.ValeurInitialeModificationException;

public class GrilleImpl implements Grille {

    private ElementDeGrille[] elementDeGrilles;

    public GrilleImpl(ElementDeGrille[] elementDeGrilles){
        this.elementDeGrilles = elementDeGrilles;
    }

    @Override
    public Set<ElementDeGrille> getElements() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getElements'");
    }

    @Override
    public int getDimension() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getDimension'");
    }

    @Override
    public void setValue(int x, int y, ElementDeGrille value) throws HorsBornesException, ValeurImpossibleException,
            ElementInterditException, ValeurInitialeModificationException {
        
    }

    @Override
    public ElementDeGrille getValue(int x, int y) throws HorsBornesException {
        
        throw new UnsupportedOperationException("Unimplemented method 'getValue'");
    }

    @Override
    public boolean isComplete() {
        
        throw new UnsupportedOperationException("Unimplemented method 'isComplete'");
    }

    @Override
    public boolean isPossible(int x, int y, ElementDeGrille value)
            throws HorsBornesException, ElementInterditException {
        
        throw new UnsupportedOperationException("Unimplemented method 'isPossible'");
    }

    @Override
    public boolean isValeurInitiale(int x, int y) {
        
        throw new UnsupportedOperationException("Unimplemented method 'isValeurInitiale'");
    }

    public void setElements(ElementDeGrille[] elements) {
        this.elementDeGrilles = elements;
    }
    
}
