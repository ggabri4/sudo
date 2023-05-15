package interfaces;

public class CaractereInterditException extends Exception {
    public CaractereInterditException() {
        super("La valeur ne fait pas partie du jeu de valeurs autorisées par la grille.");
    }
}
