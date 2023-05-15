package interfaces;

public class HorsBornesException extends Exception {
    public HorsBornesException() {
        super("Les paramètres de positions sont hors des bornes de la grille.");
    }
}
