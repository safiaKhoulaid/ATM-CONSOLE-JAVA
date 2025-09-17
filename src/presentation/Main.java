package presentation;

import java.util.Scanner;
import service.CompteService;
import service.OperationService;
import repository.CompteRepository;
import entities.Operation;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompteService compteService = new CompteService(new CompteRepository());
        OperationService operationService = new OperationService(new CompteRepository());
        String source = "" ;

        boolean quitter = false;

        while (!quitter) {
            afficherMenu();
            System.out.print("Choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // pour consommer le retour à la ligne

            switch (choix) {
                case 1:
                    creerCompte(scanner, compteService);
                    break;
                case 2:
                    effectuerVersement(scanner, operationService,source);
                    break;
                case 3:
                    effectuerRetrait(scanner, operationService);
                    break;
                case 4:
                    effectuerVirement(scanner, operationService);
                    break;
                case 5:
                    afficherSolde(scanner, compteService);
                    break;
                case 6:
                    afficherOperations(scanner, operationService);
                    break;
                case 0:
                    quitter = true;
                    System.out.println("✅ Au revoir !");
                    break;
                default:
                    System.out.println("⚠️ Choix invalide, réessayez.");
            }
        }

        scanner.close();
    }

    // ===== MENU =====
    public static void afficherMenu() {
        System.out.println("\n===== MENU BANQUE =====");
        System.out.println("1. Créer un compte");
        System.out.println("2. Effectuer un versement");
        System.out.println("3. Effectuer un retrait");
        System.out.println("4. Effectuer un virement");
        System.out.println("5. Consulter le solde d'un compte");
        System.out.println("6. Consulter les opérations d'un compte");
        System.out.println("0. Quitter");
    }

    // ===== CREATION DE COMPTE =====
    public static void creerCompte(Scanner scanner, CompteService compteService) {
        System.out.print("Type de compte (courant/epargne) : ");
        String type = scanner.nextLine();
        System.out.print("Code du compte : ");
        String code = scanner.nextLine();
        System.out.print("Montant initial : ");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        double decouvertOrTaux = 0;
        if(type.equalsIgnoreCase("courant")) {
            System.out.print("Découvert autorisé : ");
            decouvertOrTaux = scanner.nextDouble();
            scanner.nextLine();
        } else if(type.equalsIgnoreCase("epargne")) {
            System.out.print("Taux d'intérêt (%) : ");
            decouvertOrTaux = scanner.nextDouble();
            scanner.nextLine();
        }
        compteService.addCompte(type, code, montant, decouvertOrTaux);
    }

    // ===== VERSEMENT =====
    public static void effectuerVersement(Scanner scanner, OperationService operationService ,String source) {
        System.out.print("Code du compte : ");
        String code = scanner.nextLine();
        System.out.print("Montant à verser : ");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        operationService.virsement(code, montant,source);
    }

    // ===== RETRAIT =====
    public static void effectuerRetrait(Scanner scanner, OperationService operationService ) {
        System.out.print("Code du compte : ");
        String code = scanner.nextLine();
        System.out.print("Montant à retirer : ");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        operationService.retrait(code, montant);
    }

    // ===== VIREMENT =====
    public static void effectuerVirement(Scanner scanner, OperationService operationService) {
        System.out.print("Code du compte source : ");
        String codeSource = scanner.nextLine();
        System.out.print("Code du compte destination : ");
        String codeDestination = scanner.nextLine();
        System.out.print("Montant du virement : ");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        operationService.virement(codeSource, codeDestination, montant);
    }

 // ===== SOLDE =====
    public static void afficherSolde(Scanner scanner, CompteService compteService) {
        System.out.print("Code du compte : ");
        String code = scanner.nextLine();

        try {
            double solde = compteService.getSolde(code);
            System.out.println("💰 Solde du compte " + code + " : " + solde + " DH");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // ===== OPERATIONS =====
    public static void afficherOperations(Scanner scanner, OperationService operationService) {
        System.out.print("Code du compte : ");
        String code = scanner.nextLine();

        try {
                      operationService.afficherOperations(code);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

}
