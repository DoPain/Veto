USE PT_S4P1A_E1;

# -----------------------------------------------------------------------------
#       TABLE : Personne
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Personne
 (
   idPersonne BIGINT(4) PRIMARY KEY AUTO_INCREMENT NOT NULL  ,
   codeCommune INTEGER(10) NOT NULL  ,
   nom VARCHAR(128) NOT NULL  ,
   prenom VARCHAR(128) NOT NULL  ,
   dateNaissance DATE NULL  ,
   adresse CHAR(255) NULL  ,
   mail VARCHAR(128) NULL  ,
   telephone VARCHAR(128) NULL
 )
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Personne
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_Personne_Ville
     ON Personne (codeCommune ASC);

# -----------------------------------------------------------------------------
#       TABLE : Veterinaire
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Veterinaire
 (
   idVeterinaire BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
   signature LONGBLOB NULL
 )
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : Panier
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Panier
 (
   idVente BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT  ,
   idClient BIGINT(4) NOT NULL  ,
   idEmploye BIGINT(4) NOT NULL  ,
   DATE DATE NOT NULL  ,
   montantTotal REAL(5,2) NOT NULL
 )
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Panier
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_Panier_Employe
     ON Panier (idEmploye ASC);

CREATE  INDEX I_FK_Panier_Client
     ON Panier (idClient ASC);

# -----------------------------------------------------------------------------
#       TABLE : Pays
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Pays
 (
   idPays BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT  ,
   nom VARCHAR(128) NOT NULL
 )
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : Espece
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Espece
 (
   idEspece INTEGER(2) PRIMARY KEY NOT NULL AUTO_INCREMENT  ,
   nom CHAR(32) NOT NULL
 )
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : Log
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Log
 (
   idLog BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT  ,
   idEmployee BIGINT(4) NOT NULL  ,
   DATE DATETIME NOT NULL  ,
   action CHAR(255) NOT NULL
 )
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Log
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_Log_Employe
     ON Log (idEmploye ASC);

# -----------------------------------------------------------------------------
#       TABLE : Conge
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Conge
 (
   idConge BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
   idEmploye BIGINT(4) NOT NULL  ,
   idVeterinaire BIGINT(4) NOT NULL  ,
   dateDebut DATETIME NOT NULL  ,
   DATEFIN DATETIME NOT NULL
 )
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Conge
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_Conge_Employe
     ON Conge (idEmploye ASC);

CREATE  INDEX I_FK_Conge_Veterinaire
     ON Conge (idVeterinaire ASC);

# -----------------------------------------------------------------------------
#       TABLE : Ordonnance
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Ordonnance
 (
   idOrdonnance BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
   idAnimal INTEGER(20) NOT NULL  ,
   idVeterinaire BIGINT(4) NOT NULL  ,
   DATE DATETIME NOT NULL  ,
   commentaire CHAR(32) NULL
 )
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Ordonnance
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_Ordonnance_Veterinaire
     ON Ordonnance (idVeterinaire ASC);

CREATE  INDEX I_FK_Ordonnance_Animal
     ON Ordonnance (idAnimal ASC);

# -----------------------------------------------------------------------------
#       TABLE : Ville
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Ville
 (
   codeCommune INTEGER(10) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
   idPays BIGINT(4) NOT NULL  ,
   nom CHAR(32) NOT NULL  ,
   codePostal BIGINT(10) NOT NULL
 )
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Ville
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_Ville_Pays
     ON Ville (idPays ASC);

# -----------------------------------------------------------------------------
#       TABLE : Race
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Race
 (
   idRace INTEGER(2) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
   idEspece INTEGER(2) NOT NULL  ,
   nom CHAR(32) NOT NULL
 )
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Race
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_Race_Espece
     ON Race (idEspece ASC);

# -----------------------------------------------------------------------------
#       TABLE : Animal
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Animal
 (
   idAnimal INTEGER(20) PRIMARY KEY NOT NULL AUTO_INCREMENT  ,
   idEspece INTEGER(2) NOT NULL  ,
   idClient BIGINT(4) NOT NULL  ,
   nom CHAR(32) NOT NULL  ,
   dateNaissance DATE NOT NULL
 )
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Animal
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_Animal_Espece
     ON Animal (idEspece ASC);

CREATE  INDEX I_FK_Animal_Client
     ON Animal (idClient ASC);

# -----------------------------------------------------------------------------
#       TABLE : Client
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Client
 (
   idClient BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT
 )
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : Produit
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Produit
 (
   idProduit SMALLINT(25) PRIMARY KEY NOT NULL AUTO_INCREMENT  ,
   nom CHAR(255) NOT NULL  ,
   QuantiteEnStock INTEGER(2) NOT NULL  ,
   QuantiteMinimum INTEGER(2) NOT NULL  ,
   prix REAL(25,2) NOT NULL
 )
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : Traitement
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Traitement
 (
   idTraitement INTEGER(4) PRIMARY KEY NOT NULL AUTO_INCREMENT ,
   idOrdonnance CHAR(32) NOT NULL  ,
   dateDebut DATE NOT NULL  ,
   dureeJour INTEGER(2) NOT NULL  ,
   produitPrescrit CHAR(32) NOT NULL  ,
   posologie CHAR(32) NOT NULL  ,
   methodeAdministration CHAR(32) NOT NULL
 )
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Traitement
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_Traitement_Ordonnance
     ON Traitement (idOrdonnance ASC);

# -----------------------------------------------------------------------------
#       TABLE : Employe
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Employe
 (
   idEmploye BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT  ,
   idConnexion CHAR(32) NOT NULL  ,
   motDePasse CHAR(32) NOT NULL
 )
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : Appartenir
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Appartenir
 (
   idOrdonnance CHAR(32) NOT NULL  ,
   idProduit SMALLINT(25) NOT NULL
   , PRIMARY KEY (idOrdonnance,idProduit)
 )
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Appartenir
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_Appartenir_Ordonnance
     ON Appartenir (idOrdonnance ASC);

CREATE  INDEX I_FK_Appartenir_Produit
     ON Appartenir (idProduit ASC);

# -----------------------------------------------------------------------------
#       TABLE : Commander
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Commander
 (
   idVente BIGINT(4) NOT NULL  ,
   idProduit SMALLINT(25) NOT NULL  ,
   QUANTITESORTIE INTEGER(2) NULL  ,
   PRIXVENTE REAL(5,2) NULL
   , PRIMARY KEY (idVente,idProduit)
 )
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Commander
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_Commander_Panier
     ON Commander (idVente ASC);

CREATE  INDEX I_FK_Commander_Produit
     ON Commander (idProduit ASC);

# -----------------------------------------------------------------------------
#       TABLE : AvoirRendezVous
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS AvoirRendezVous
 (
   idClient BIGINT(4) NOT NULL  ,
   idVeterinaire BIGINT(4) NOT NULL  ,
   dateHeure DATETIME NOT NULL  ,
   dureeMinutes INTEGER(4) NOT NULL  ,
   message CHAR(255) NULL
   , PRIMARY KEY (idClient,idVeterinaire)
 )
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE AvoirRendezVous
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_AvoirRendezVous_Client
     ON AvoirRendezVous (idClient ASC);

CREATE  INDEX I_FK_AvoirRendezVous_Veterinaire
     ON AvoirRendezVous (idVeterinaire ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------

ALTER TABLE Personne
  ADD FOREIGN KEY FK_Personne_Ville (codeCommune)
      REFERENCES Ville (codeCommune) ;


ALTER TABLE Veterinaire
  ADD FOREIGN KEY FK_Veterinaire_ClientFournisseur (id)
      REFERENCES ClientFournisseur (id) ;


ALTER TABLE Panier
  ADD FOREIGN KEY FK_Panier_Employe (idEmploye)
      REFERENCES Employe (idEmploye) ;


ALTER TABLE Panier
  ADD FOREIGN KEY FK_Panier_Client (idClient)
      REFERENCES Client (idClient) ;


ALTER TABLE Fournisseur
  ADD FOREIGN KEY FK_Fournisseur_Ville (codeCommune)
      REFERENCES Ville (codeCommune) ;


ALTER TABLE Log
  ADD FOREIGN KEY FK_Log_Employe (idEmploye)
      REFERENCES Employe (idEmploye) ;


ALTER TABLE Conge
  ADD FOREIGN KEY FK_Conge_Employe (idEmploye)
      REFERENCES Employe (idEmploye) ;


ALTER TABLE Conge
  ADD FOREIGN KEY FK_Conge_Veterinaire (idVeterinaire)
      REFERENCES Veterinaire (idVeterinaire) ;


ALTER TABLE Ordonnance
  ADD FOREIGN KEY FK_Ordonnance_Veterinaire (idVeterinaire)
      REFERENCES Veterinaire (idVeterinaire) ;


ALTER TABLE Ordonnance
  ADD FOREIGN KEY FK_Ordonnance_Animal (idAnimal)
      REFERENCES Animal (idAnimal) ;


ALTER TABLE Ville
  ADD FOREIGN KEY FK_Ville_Pays (idPays)
      REFERENCES Pays (idPays) ;


ALTER TABLE Race
  ADD FOREIGN KEY FK_Race_Espece (idEspece)
      REFERENCES Espece (idEspece) ;


ALTER TABLE Animal
  ADD FOREIGN KEY FK_Animal_Espece (idEspece)
      REFERENCES Espece (idEspece) ;


ALTER TABLE Animal
  ADD FOREIGN KEY FK_Animal_Client (idClient)
      REFERENCES Client (idClient) ;


ALTER TABLE Client
  ADD FOREIGN KEY FK_Client_Personne (idPersonne)
      REFERENCES Personne (idPersonne) ;


ALTER TABLE Traitement
  ADD FOREIGN KEY FK_Traitement_Ordonnance (idOrdonnance)
      REFERENCES Ordonnance (idOrdonnance) ;


ALTER TABLE Employe
  ADD FOREIGN KEY FK_Employe_Personne (idPersonne)
      REFERENCES Personne (idPersonne) ;

ALTER TABLE Appartenir
  ADD FOREIGN KEY FK_Appartenir_Ordonnance (idOrdonnance)
      REFERENCES Ordonnance (idOrdonnance) ;


ALTER TABLE Appartenir
  ADD FOREIGN KEY FK_Appartenir_Produit (idProduit)
      REFERENCES Produit (idProduit) ;


ALTER TABLE Commander
  ADD FOREIGN KEY FK_Commander_Panier (idVente)
      REFERENCES Panier (idVente) ;


ALTER TABLE Commander
  ADD FOREIGN KEY FK_Commander_Produit (idProduit)
      REFERENCES Produit (idProduit) ;

ALTER TABLE AvoirRendezVous
  ADD FOREIGN KEY FK_AvoirRendezVous_Client (idClient)
      REFERENCES Client (idClient) ;


ALTER TABLE AvoirRendezVous
  ADD FOREIGN KEY FK_AvoirRendezVous_Veterinaire (idVeterinaire)
      REFERENCES Veterinaire (idVeterinaire) ;
