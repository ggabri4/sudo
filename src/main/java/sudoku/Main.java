package sudoku;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import interfaces.ElementInterditException;
import interfaces.ValeurInitialeModificationException;
import interfaces.ValeurImpossibleException;
import interfaces.HorsBornesException;

/**
 * Lance le solveur de sudoku.
 */
public final class Main {

    /**
     * Constructeur privé pour empêcher.
     * l'instanciation de la classe utilitaire
     *
     * Aucun code n'est nécessaire ici car la classe
     * utilitaire ne nécessite pas de constructeur spécifique
     *
     */
    private Main() {
    }

    /**
     * Affiche la grille dans le terminal de commande.
     *
     * @param grille une grille de sudoku
     */
    private static void afficherGrille(final Grille grille) {
        int dimension = grille.getDimension();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                ElementDeGrille valeur;
                try {
                    valeur = grille.getValue(i, j);
                    if (valeur != null) {
                        System.out.print(valeur.toString() + " ");
                    } else {
                        System.out.print("- ");
                    }

                } catch (HorsBornesException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }

    /**
     * Main du solveur.
     *
     * @param args le nom du fichier pour la grille
     */
    public static void main(final String[] args) {
        File grillesFolder = new File("grilles");

        if (grillesFolder.exists() && grillesFolder.isDirectory()) {
            File[] grilleFiles = grillesFolder.listFiles();

            if (grilleFiles != null) {
                for (File grilleFile : grilleFiles) {
                    if (grilleFile.isFile()) {
                        System.out.println(
                                "Résolution de la grille : "
                                        + grilleFile.getName());

                        try (FileInputStream inputStream = new FileInputStream(
                                grilleFile)) {
                            Grille grille = GrilleParser.parse(inputStream);

                            System.out.println("Grille initiale :");
                            afficherGrille(grille);

                            Solveur solveur = new SolveurImpl();
                            boolean isSolved = solveur.solve(grille);

                            if (isSolved) {
                                System.out.println("Grille résolue :");
                                afficherGrille(grille);
                            } else {
                                System.out.println(
                                        "La grille ne peut pas être résolue.");
                            }
                        } catch (IOException
                                | ElementInterditException
                                | ValeurInitialeModificationException
                                | HorsBornesException
                                | ValeurImpossibleException e) {
                            e.printStackTrace();
                        }

                        System.out.println();
                    }
                }
            }
        }
    }
}
