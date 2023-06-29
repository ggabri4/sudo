import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.ElementInterditException;
import interfaces.HorsBornesException;
import interfaces.ValeurImpossibleException;
import interfaces.ValeurInitialeModificationException;
import sudoku.ElementDeGrille;
import sudoku.GrilleImpl;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private GrilleImpl grille;
    private ElementDeGrille elementMock;

    /**
     * 
     */
    @BeforeEach
    void setUp() {
        ElementDeGrille[] elementDeGrilles = new ElementDeGrille[9];
        grille = new GrilleImpl(elementDeGrilles);
        // elementMock = (ElementDeGrille) new ElementDeGrilleImplAsChar(9); // suppose
        // que nous avons une classe mock
        // ElementDeGrilleMock
        grille.setElements(elementDeGrilles);
    }

    @Test
    void getElements() {
        assertEquals(1, grille.getElements().size());
        assertTrue(grille.getElements().contains(elementMock));
    }

    @Test
    void getDimension() {
        assertEquals(9, grille.getDimension());
    }

    @Test
    void setValue() throws HorsBornesException, ValeurImpossibleException, ElementInterditException,
            ValeurInitialeModificationException {
        grille.setValue(0, 0, elementMock);
        assertEquals(elementMock, grille.getValue(0, 0));
    }

    @Test
    void setValueThrowsException() {
        assertThrows(HorsBornesException.class, () -> grille.setValue(10, 10, elementMock));
    }

    @Test
    void getValue() throws HorsBornesException, ValeurImpossibleException, ElementInterditException,
            ValeurInitialeModificationException {
        grille.setValue(0, 0, elementMock);
        assertEquals(elementMock, grille.getValue(0, 0));
    }

    @Test
    void getValueThrowsException() {
        assertThrows(HorsBornesException.class, () -> grille.getValue(10, 10));
    }

    @Test
    void isComplete() throws HorsBornesException, ValeurImpossibleException, ElementInterditException,
            ValeurInitialeModificationException {
        assertFalse(grille.isComplete());
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grille.setValue(i, j, elementMock);
            }
        }
        assertTrue(grille.isComplete());
    }

    @Test
    void isPossible() throws HorsBornesException, ElementInterditException {
        assertTrue(grille.isPossible(0, 0, elementMock));
    }

    @Test
    void isPossibleThrowsException() {
        assertThrows(HorsBornesException.class, () -> grille.isPossible(10, 10, elementMock));
    }
}
