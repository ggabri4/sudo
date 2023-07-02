package sudoku;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import interfaces.ElementInterditException;
import interfaces.ValeurInitialeModificationException;
import interfaces.ValeurImpossibleException;
import interfaces.HorsBornesException;

public class Main {
    private static void afficherGrille(Grille grille) {
        int dimension = grille.getDimension();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                ElementDeGrille valeur;
                try {
                    valeur = grille.getValue(i, j);
                    System.out.print(valeur != null ? valeur.toString() + " " : "- ");

                } catch (HorsBornesException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        File grillesFolder = new File("grilles");

        if (grillesFolder.exists() && grillesFolder.isDirectory()) {
            File[] grilleFiles = grillesFolder.listFiles();

            if (grilleFiles != null) {
                for (File grilleFile : grilleFiles) {
                    if (grilleFile.isFile()) {
                        System.out.println("Résolution de la grille : " + grilleFile.getName());

                        try (FileInputStream inputStream = new FileInputStream(grilleFile)) {
                            Grille grille = GrilleParser.parse(inputStream);

                            System.out.println("Grille initiale :");
                            afficherGrille(grille);

                            Solveur solveur = new SolveurImpl();
                            boolean isSolved = solveur.solve(grille);

                            if (isSolved) {
                                System.out.println("Grille résolue :");
                                afficherGrille(grille);
                            } else {
                                System.out.println("La grille ne peut pas être résolue.");
                            }
                        } catch (IOException | ElementInterditException |
                                ValeurInitialeModificationException |
                                HorsBornesException | ValeurImpossibleException e) {
                            e.printStackTrace();
                        }

                        System.out.println();
                    }
                }
            }
        }
    }
}