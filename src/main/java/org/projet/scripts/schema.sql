-- Créer la base de données si elle n'existe pas
CREATE DATABASE IF NOT EXISTS inventaire_ordinateurs;

-- Utiliser la base de données
USE inventaire_ordinateurs;

-- Créer la table 'ordinateurs'
CREATE TABLE IF NOT EXISTS ordinateurs (
                                           id INT AUTO_INCREMENT PRIMARY KEY,   -- Identifiant unique
                                           marque VARCHAR(100) NOT NULL,        -- Marque de l'ordinateur
    modele VARCHAR(100) NOT NULL,        -- Modèle de l'ordinateur
    processeur VARCHAR(100) NOT NULL,    -- Type de processeur
    ram INT NOT NULL,                    -- Quantité de RAM en Go
    stock INT NOT NULL,                  -- Quantité en stock
    prix DECIMAL(10,2) NOT NULL          -- Prix unitaire en devise
    );
