import org.projet.serveur.InventaireInterface;
import org.projet.serveur.Produit;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class ClientTest {
    public static void main(String[] args) {
        try {
            // Connexion au serveur RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            InventaireInterface inventaire = (InventaireInterface) registry.lookup("InventaireService");

            // Ajout d'un nouveau produit
            Produit produit = new Produit("Apple", "MacBook Pro", "M1", 16, 10, 2500.00);
            inventaire.ajouterProduit(produit);
            System.out.println("Produit ajouté : " + produit);

            // Lister les produits
            System.out.println("Liste des produits après ajout :");
            List<Produit> produits = inventaire.listerProduits();
            produits.forEach(p -> System.out.println(p));

            // Mise à jour du produit
            produit.setPrix(2300.00);  // Modifier le prix
            inventaire.mettreAJourProduit(produit);
            System.out.println("Produit mis à jour : " + produit);

            // Vérification après la mise à jour
            System.out.println("Liste des produits après mise à jour :");
            produits = inventaire.listerProduits();
            produits.forEach(p -> System.out.println(p));

            // Suppression d'un produit
            int idProduitASupprimer = produit.getId();  // Utilisez l'ID du produit créé
            inventaire.supprimerProduit(idProduitASupprimer);
            System.out.println("Produit supprimé avec l'ID : " + idProduitASupprimer);

            // Vérification après suppression
            System.out.println("Liste des produits après suppression :");
            produits = inventaire.listerProduits();
            produits.forEach(p -> System.out.println(p));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
