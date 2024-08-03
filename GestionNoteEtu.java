import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionNoteEtu {

    // Liste des classes et des matières
    private List<Classe> classes;
    private List<Matiere> matieres;

    // Méthode principale, le point d'entrée
    public static void main(String[] args) {

        GestionNoteEtu gestionnaire = new GestionNoteEtu();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu principal");
            System.out.println("1. Ajouter une classe");
            System.out.println("2. Ajouter un étudiant");
            System.out.println("3. Ajouter une matière");
            System.out.println("4. Enregistrer une note");
            System.out.println("5. Calculer les moyennes");
            System.out.println("6. Afficher le classement");
            System.out.println("7. Quitter");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine();  // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    // Appel de la méthode ajouter une classe
                    System.out.print("Entrez le nom de la nouvelle classe: ");
                    String nomClasse = scanner.nextLine();
                    Classe nouvelleClasse = new Classe(nomClasse);
                    gestionnaire.ajouterClasse(nouvelleClasse);
                    System.out.println("Classe ajoutée avec succès!");
                    break;

                case 2:
                    // Appel de la méthode ajouter un étudiant
                    System.out.print("Entrez le nom de l'étudiant: ");
                    String nomEtudiant = scanner.nextLine();
                    System.out.print("Entrez l'ID de l'étudiant: ");
                    String idEtudiant = scanner.nextLine();
                    Etudiant nouvelEtudiant = new Etudiant(nomEtudiant, idEtudiant);

                    System.out.print("Entrez le nom de la classe de l'étudiant: ");
                    String nomClasseEtudiant = scanner.nextLine();
                    Classe classeEtudiant = gestionnaire.getClasse(nomClasseEtudiant);
                    if (classeEtudiant != null) {
                        gestionnaire.ajouterEtudiant(nouvelEtudiant, classeEtudiant);
                        System.out.println("Étudiant ajouté avec succès!");
                    } else {
                        System.out.println("Classe non trouvée.");
                    }
                    break;

                case 3:
                    // Appel de la méthode ajouter une matière
                    System.out.print("Entrez le nom de la matière: ");
                    String nomMatiere = scanner.nextLine();
                    Matiere nouvelleMatiere = new Matiere(nomMatiere);
                    gestionnaire.ajouterMatiere(nouvelleMatiere);
                    System.out.println("Matière ajoutée avec succès!");
                    break;

                case 4:
                    // Appel méthode enregistrer une note
                    System.out.print("Entrez le nom de la classe: ");
                    String classeNom = scanner.nextLine();
                    Classe classe = gestionnaire.getClasse(classeNom);

                    if (classe != null) {
                        System.out.print("Entrez le nom de la matière: ");
                        String matiereNom = scanner.nextLine();
                        Matiere matiere = gestionnaire.getMatiere(matiereNom);

                        if (matiere != null) {
                            System.out.print("Entrez l'ID de l'étudiant: ");
                            String etudiantId = scanner.nextLine();
                            System.out.print("Entrez la note: ");
                            double valeurNote = scanner.nextDouble();
                            gestionnaire.enregistrerNote(classe, matiere, etudiantId, valeurNote);
                            System.out.println("Note enregistrée avec succès!");
                        } else {
                            System.out.println("Matière non trouvée.");
                        }
                    } else {
                        System.out.println("Classe non trouvée.");
                    }
                    break;

                case 5:
                    // Appel méthode calculer les moyennes
                    System.out.print("Entrez le nom de la classe: ");
                    String nomClasseMoyenne = scanner.nextLine();
                    Classe classeMoyenne = gestionnaire.getClasse(nomClasseMoyenne);
                    if (classeMoyenne != null) {
                        gestionnaire.calculerMoyennes(classeMoyenne);
                    } else {
                        System.out.println("Classe non trouvée.");
                    }
                    break;

                case 6:
                    // Appel méthode afficher le classement
                    System.out.print("Entrez le nom de la classe: ");
                    String nomClasseClassement = scanner.nextLine();
                    Classe classeClassement = gestionnaire.getClasse(nomClasseClassement);
                    if (classeClassement != null) {
                        System.out.print("Entrez le nom de la matière: ");
                        String nomMatiereClassement = scanner.nextLine();
                        Matiere matiereClassement = gestionnaire.getMatiere(nomMatiereClassement);
                        if (matiereClassement != null) {
                            gestionnaire.afficherClassement(classeClassement, matiereClassement);
                        } else {
                            System.out.println("Matière non trouvée.");
                        }
                    } else {
                        System.out.println("Classe non trouvée.");
                    }
                    break;

                case 7:
                    exit = true;
                    break;

                default:
                    System.out.println("Option invalide.");
            }
        }
        scanner.close();
    }

    // Constructeur
    public GestionNoteEtu() {
        this.classes = new ArrayList<>();
        this.matieres = new ArrayList<>();
    }

    // Méthode pour ajouter des classes
    public void ajouterClasse(Classe classe) {
        classes.add(classe);
    }

    // Méthode pour ajouter des étudiants
    public void ajouterEtudiant(Etudiant etudiant, Classe classe) {
        classe.ajouterEtudiant(etudiant);
    }

    // Méthode pour ajouter des matières
    public void ajouterMatiere(Matiere matiere) {
        matieres.add(matiere);
    }

    // Méthode pour obtenir une classe par son nom
    public Classe getClasse(String nomClasse) {
        for (Classe classe : classes) {
            if (classe.getNom().equals(nomClasse)) {
                return classe;
            }
        }
        return null;
    }

    // Méthode pour obtenir une matière par son nom
    public Matiere getMatiere(String nomMatiere) {
        for (Matiere matiere : matieres) {
            if (matiere.getNom().equals(nomMatiere)) {
                return matiere;
            }
        }
        return null;
    }

    // Méthode pour enregistrer une note
    public void enregistrerNote(Classe classe, Matiere matiere, String etudiantId, double valeur) {
        for (Etudiant etudiant : classe.getEtudiants()) {
            if (etudiant.getId().equals(etudiantId)) {
                etudiant.ajouterNote(matiere, new Note(valeur));
            }
        }
    }

    // Méthode pour calculer les moyennes
    public void calculerMoyennes(Classe classe) {
        for (Etudiant etudiant : classe.getEtudiants()) {
            System.out.println("Moyenne de " + etudiant.getNom() + " : " + etudiant.calculerMoyenne());
        }
    }

    // Méthode pour afficher le classement
    public void afficherClassement(Classe classe, Matiere matiere) {
        classe.getEtudiants().stream()
                .sorted((e1, e2) -> Double.compare(e2.getNotes().get(matiere).getValeur(), e1.getNotes().get(matiere).getValeur()))
                .forEach(e -> System.out.println(e.getNom() + ": " + e.getNotes().get(matiere).getValeur()));
    }
}
