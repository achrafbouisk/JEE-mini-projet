package org.projet.serveur;

import org.projet.outils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOProduit {

    // Méthode pour ajouter un produit à la base de données
    public void ajouterProduit(Produit produit) throws SQLException {
        String sql = "INSERT INTO ordinateurs (marque, modele, processeur, ram, stock, prix) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produit.getMarque());
            stmt.setString(2, produit.getModele());
            stmt.setString(3, produit.getProcesseur());
            stmt.setInt(4, produit.getRam());
            stmt.setInt(5, produit.getStock());
            stmt.setDouble(6, produit.getPrix());

            stmt.executeUpdate();
        }
    }

    // Méthode pour lister tous les produits
    public List<Produit> listerProduits() throws SQLException {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT * FROM ordinateurs";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produit produit = new Produit(
                        rs.getString("marque"),
                        rs.getString("modele"),
                        rs.getString("processeur"),
                        rs.getInt("ram"),
                        rs.getInt("stock"),
                        rs.getDouble("prix")
                );
                produit.setId(rs.getInt("id"));
                produits.add(produit);
            }
        }

        return produits;
    }

    // Méthode pour mettre à jour un produit
    public void mettreAJourProduit(Produit produit) throws SQLException {
        String sql = "UPDATE ordinateurs SET marque = ?, modele = ?, processeur = ?, ram = ?, stock = ?, prix = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produit.getMarque());
            stmt.setString(2, produit.getModele());
            stmt.setString(3, produit.getProcesseur());
            stmt.setInt(4, produit.getRam());
            stmt.setInt(5, produit.getStock());
            stmt.setDouble(6, produit.getPrix());
            stmt.setInt(7, produit.getId());

            stmt.executeUpdate();
        }
    }

    // Méthode pour supprimer un produit
    public void supprimerProduit(int id) throws SQLException {
        String sql = "DELETE FROM ordinateurs WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
