package interfaces;

public class ElementInterditException extends Exception {
    public ElementInterditException() {
        super("L'élément ne fait pas partie des éléments autorisés.");
    }
}
