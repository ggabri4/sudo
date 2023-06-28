import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.ElementInterditException;
import interfaces.HorsBornesException;
import interfaces.ValeurImpossibleException;
import interfaces.ValeurInitialeModificationException;
import sudoku.ElementDeGrille;
import sudoku.ElementDeGrilleImplAsChar;
import sudoku.Grille;
import sudoku.GrilleImpl;
import org.mockito.Mockito;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
 
    // Supposons que vous ayez une méthode pour créer des éléments de grille dans votre interface
    // ElementDeGrille (par exemple, newElement).
    ElementDeGrille elementDeGrille = Mockito.mock(ElementDeGrille.class);
    Grille grille = new GrilleImpl(9);

    @Test
    public void testSetValue() {
        try {
            if(grille.getValue(0, 0) == null) {
                grille.setValue(0, 0, elementDeGrille);
                assertEquals(elementDeGrille, grille.getValue(0, 0));
            }
        } catch (Exception e) {
            fail("Exception was thrown: " + e.getMessage());
        }
    }

    @Test
    public void testOutOfBounds() {
        assertThrows(HorsBornesException.class, () -> {
            grille.setValue(-1, 0, elementDeGrille);
        });
    }

    @Test
    public void testValueNotPossible() {
        assertThrows(ValeurImpossibleException.class, () -> {
            grille.setValue(0, 0, elementDeGrille);
            grille.setValue(0, 1, elementDeGrille);
        });
    }
}
