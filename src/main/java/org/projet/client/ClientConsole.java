package org.projet.client;

import org.projet.serveur.InventaireInterface;
import org.projet.serveur.Produit;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;
public class ClientConsole {

    public static void main(String[] args) {
        try {
            // Connexion au serveur RMI
            Registry registry = LocateRegistry.getRegistry("192.168.11.103", 1099);
            InventaireInterface inventaire = (InventaireInterface) registry.lookup("InventaireService");
            // Menu interactif
            Scanner scanner = new Scanner(System.in);
            int choix;

            do {
                System.out.println("\nSystème de Gestion d'Inventaire d'Ordinateurs");
                System.out.println("1. Ajouter un produit");
                System.out.println("2. Lister les produits");
                System.out.println("3. Mettre à jour un produit");
                System.out.println("4. Supprimer un produit");
                System.out.println("5. Quitter");
                System.out.print("Entrez votre choix : ");
                choix = scanner.nextInt();
                scanner.nextLine(); // Consomme la ligne restante

                switch (choix) {
                    case 1:
                        ajouterProduit(inventaire, scanner);
                        break;
                    case 2:
                        listerProduits(inventaire);
                        break;
                    case 3:
                        mettreAJourProduit(inventaire, scanner);
                        break;
                    case 4:
                        supprimerProduit(inventaire, scanner);
                        break;
                    case 5:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } while (choix != 5);

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Méthode pour ajouter un produit
    private static void ajouterProduit(InventaireInterface inventaire, Scanner scanner) {
        try {
            System.out.print("Entrez la marque : ");
            String marque = scanner.nextLine();
            System.out.print("Entrez le modèle : ");
            String modele = scanner.nextLine();
            System.out.print("Entrez le processeur : ");
            String processeur = scanner.nextLine();
            System.out.print("Entrez la RAM (Go) : ");
            int ram = scanner.nextInt();
            System.out.print("Entrez le stock : ");
            int stock = scanner.nextInt();
            System.out.print("Entrez le prix : ");
            double prix = scanner.nextDouble();
            scanner.nextLine(); // Consomme la ligne restante

            Produit produit = new Produit(marque, modele, processeur, ram, stock, prix);
            inventaire.ajouterProduit(produit);
            System.out.println("Produit ajouté avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout du produit : " + e.getMessage());
        }
    }

    // Méthode pour lister les produits
    private static void listerProduits(InventaireInterface inventaire) {
        try {
            List<Produit> produits = inventaire.listerProduits();
            System.out.println("\nListe des produits :");
            produits.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des produits : " + e.getMessage());
        }
    }

    // Méthode pour mettre à jour un produit
    private static void mettreAJourProduit(InventaireInterface inventaire, Scanner scanner) {
        try {
            System.out.print("Entrez l'ID du produit à mettre à jour : ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consomme la ligne restante

            System.out.print("Entrez la nouvelle marque : ");
            String marque = scanner.nextLine();
            System.out.print("Entrez le nouveau modèle : ");
            String modele = scanner.nextLine();
            System.out.print("Entrez le nouveau processeur : ");
            String processeur = scanner.nextLine();
            System.out.print("Entrez la nouvelle RAM (Go) : ");
            int ram = scanner.nextInt();
            System.out.print("Entrez le nouveau stock : ");
            int stock = scanner.nextInt();
            System.out.print("Entrez le nouveau prix : ");
            double prix = scanner.nextDouble();
            scanner.nextLine(); // Consomme la ligne restante

            Produit produit = new Produit(marque, modele, processeur, ram, stock, prix);
            produit.setId(id);

            inventaire.mettreAJourProduit(produit);
            System.out.println("Produit mis à jour avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur lors de la mise à jour du produit : " + e.getMessage());
        }
    }

    // Méthode pour supprimer un produit
    private static void supprimerProduit(InventaireInterface inventaire, Scanner scanner) {
        try {
            System.out.print("Entrez l'ID du produit à supprimer : ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consomme la ligne restante

            inventaire.supprimerProduit(id);
            System.out.println("Produit supprimé avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression du produit : " + e.getMessage());
        }
    }
}
