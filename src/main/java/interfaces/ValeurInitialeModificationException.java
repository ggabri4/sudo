package interfaces;

public class ValeurInitialeModificationException extends Exception {
    public ValeurInitialeModificationException() {
        super("La tentative de modification d'une valeur initiale de la grille est interdite.");
    }
}
