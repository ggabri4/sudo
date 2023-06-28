package interfaces;

/**
 * Exception pour une valeur ...
 */
public class ValeurInitialeModificationException extends Exception {

    /**
     * Constructeur pour créer une nouvelle
     * exception avec un message spécifique.
     *
     * @param message le message détaillant la raison
     * pour laquelle l'exception a été levée.
     */
    public ValeurInitialeModificationException(final String message) {
        super(message);
    }
}
