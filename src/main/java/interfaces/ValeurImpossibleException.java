package interfaces;
/**
 * Exception pour une valeur impossible pour la case.
 */
public class ValeurImpossibleException extends Exception {

    /**
     * Constructeur pour créer une nouvelle
     * exception avec un message spécifique.
     *
     * @param message le message détaillant la raison
     * pour laquelle l'exception a été levée.
     */
    public ValeurImpossibleException(final String message) {
        super(message);
    }
}
