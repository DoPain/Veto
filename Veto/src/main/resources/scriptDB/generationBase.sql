USE PT_S4P1A_E1;

# -----------------------------------------------------------------------------
#       TABLE : Personne
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Personne
(
  id            BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idVille       BIGINT(4)             NOT NULL,
  nom           VARCHAR(128)          NOT NULL,
  prenom        VARCHAR(128)          NOT NULL,
  dateNaissance DATE                  NULL,
  adresse       CHAR(255)             NULL,
  mail          VARCHAR(128)          NULL,
  telephone     VARCHAR(128)          NULL
);

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Personne
# -----------------------------------------------------------------------------


CREATE INDEX I_FK_Personne_Ville
  ON Personne (id ASC);

# -----------------------------------------------------------------------------
#       TABLE : Veterinaire
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Veterinaire
(
  id        BIGINT(4) PRIMARY KEY NOT NULL,
  signature LONGBLOB              NULL
);

# -----------------------------------------------------------------------------
#       TABLE : Panier
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Panier
(
  id           BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idClient     BIGINT(4)             NOT NULL,
  idEmploye    BIGINT(4)             NOT NULL,
  DATE         DATE                  NOT NULL,
  montantTotal REAL(5, 2)            NOT NULL
);

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Panier
# -----------------------------------------------------------------------------


CREATE INDEX I_FK_Panier_Employe
  ON Panier (id ASC);

CREATE INDEX I_FK_Panier_Client
  ON Panier (id ASC);

# -----------------------------------------------------------------------------
#       TABLE : Espece
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Espece
(
  id  BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nom CHAR(32)              NOT NULL
);

# -----------------------------------------------------------------------------
#       TABLE : Log
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Log
(
  id        BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idEmploye BIGINT(4)             NOT NULL,
  temps     TIMESTAMP             NOT NULL DEFAULT CURRENT_TIMESTAMP,
  action    CHAR(255)             NOT NULL
);

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Log
# -----------------------------------------------------------------------------


CREATE INDEX I_FK_Log_Employe
  ON Log (id ASC);

# -----------------------------------------------------------------------------
#       TABLE : Conge
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Conge
(
  id        BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idEmploye BIGINT(4)             NOT NULL,
  dateDebut DATETIME              NOT NULL,
  dateFin   DATETIME              NOT NULL
);

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Conge
# -----------------------------------------------------------------------------


CREATE INDEX I_FK_Conge_Employe
  ON Conge (idEmploye ASC);

CREATE INDEX I_Conge
  ON Conge (id ASC);

# -----------------------------------------------------------------------------
#       TABLE : Ordonnance
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Ordonnance
(
  id             BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idAnimal       BIGINT(4)             NOT NULL,
  idVeterinaire  BIGINT(4)             NOT NULL,
  dateOrdonnance DATETIME              NOT NULL,
  commentaire    CHAR(32)              NULL
);

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Ordonnance
# -----------------------------------------------------------------------------


CREATE INDEX I_FK_Ordonnance_Veterinaire
  ON Ordonnance (idVeterinaire ASC);

CREATE INDEX I_FK_Ordonnance_Animal
  ON Ordonnance (idAnimal ASC);

# -----------------------------------------------------------------------------
#       TABLE : Ville
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Ville
(
  id                    BIGINT(4)  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ville_departement     VARCHAR(3)           DEFAULT NULL,
  ville_slug            VARCHAR(150)         DEFAULT NULL,
  ville_nom             VARCHAR(45)          DEFAULT NULL,
  ville_nom_simple      VARCHAR(45)          DEFAULT NULL,
  ville_nom_reel        VARCHAR(45)          DEFAULT NULL,
  ville_nom_soundex     VARCHAR(20)          DEFAULT NULL,
  ville_nom_metaphone   VARCHAR(22)          DEFAULT NULL,
  ville_code_postal     VARCHAR(150)         DEFAULT NULL,
  ville_commune         VARCHAR(3)           DEFAULT NULL,
  ville_code_commune    VARCHAR(5) NOT NULL,
  ville_arrondissement  SMALLINT(3) unsigned DEFAULT NULL,
  ville_canton          VARCHAR(4)           DEFAULT NULL,
  ville_amdi            SMALLINT(5) unsigned DEFAULT NULL,
  ville_population_2010 INTEGER(11)          DEFAULT NULL,
  ville_population_1999 INTEGER(11)          DEFAULT NULL,
  ville_population_2012 INTEGER(10)          DEFAULT NULL COMMENT 'approximatif',
  ville_densite_2010    INTEGER(11)          DEFAULT NULL,
  ville_surface         float                DEFAULT NULL,
  ville_longitude_deg   float                DEFAULT NULL,
  ville_latitude_deg    float                DEFAULT NULL,
  ville_longitude_grd   VARCHAR(9)           DEFAULT NULL,
  ville_latitude_grd    VARCHAR(8)           DEFAULT NULL,
  ville_longitude_dms   VARCHAR(9)           DEFAULT NULL,
  ville_latitude_dms    VARCHAR(8)           DEFAULT NULL,
  ville_zmin            INTEGER(4)           DEFAULT NULL,
  ville_zmax            INTEGER(4)           DEFAULT NULL,
  UNIQUE KEY ville_code_commune_2 (ville_code_commune),
  UNIQUE KEY ville_slug (ville_slug),
  KEY ville_departement (ville_departement),
  KEY ville_nom (ville_nom),
  KEY ville_nom_reel (ville_nom_reel),
  KEY ville_code_commune (ville_code_commune),
  KEY ville_code_postal (ville_code_postal),
  KEY ville_longitude_latitude_deg (ville_longitude_deg, ville_latitude_deg),
  KEY ville_nom_soundex (ville_nom_soundex),
  KEY ville_nom_metaphone (ville_nom_metaphone),
  KEY ville_population_2010 (ville_population_2010),
  KEY ville_nom_simple (ville_nom_simple)
);

# -----------------------------------------------------------------------------
#       TABLE : Race
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Race
(
  id       BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idEspece BIGINT(4)             NOT NULL,
  nom      CHAR(32)              NOT NULL
);

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Race
# -----------------------------------------------------------------------------


CREATE INDEX I_FK_Race_Espece
  ON Race (idEspece ASC);

# -----------------------------------------------------------------------------
#       TABLE : Animal
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Animal
(
  id                BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idRace            BIGINT(4)             NOT NULL,
  idClient          BIGINT(4)             NOT NULL,
  nom               CHAR(32)              NOT NULL,
  sexe              CHAR(1),
  poids             REAL(4, 2),
  autreInformations LONGTEXT,
  dateNaissance     DATETIME
);

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Animal
# -----------------------------------------------------------------------------


CREATE INDEX I_FK_Animal_Race
  ON Animal (idRace ASC);

CREATE INDEX I_FK_Animal_Client
  ON Animal (idClient ASC);

# -----------------------------------------------------------------------------
#       TABLE : Client
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Client
(
  id BIGINT(4) PRIMARY KEY NOT NULL
);

# -----------------------------------------------------------------------------
#       TABLE : Produit
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Produit
(
  id              BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nom             CHAR(255)             NOT NULL,
  quantiteEnStock INTEGER(2)            NOT NULL,
  quantiteMinimum INTEGER(2)            NOT NULL,
  prix            REAL(25, 2)           NOT NULL
);

# -----------------------------------------------------------------------------
#       TABLE : Traitement
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Traitement
(
  id        BIGINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idAnimal  BIGINT(4)             NOT NULL,
  maladie   CHAR(255)             NOT NULL,
  soin      CHAR(255),
  dateDebut DATE                  NOT NULL,
  dateFin   DATE

);

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Traitement
# -----------------------------------------------------------------------------


CREATE INDEX I_FK_Traitement_Ordonnance
  ON Traitement (id ASC);

# -----------------------------------------------------------------------------
#       TABLE : Employe
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Employe
(
  id               BIGINT(4) PRIMARY KEY NOT NULL,
  login            CHAR(32)              NOT NULL UNIQUE,
  motDePasse       CHAR(32)              NOT NULL,
  salaire          REAL(10, 2),
  dateDebutContrat DATE                  NOT NULL

);

# -----------------------------------------------------------------------------
#       TABLE : Appartenir
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Appartenir
(
  id           BIGINT(4)  NOT NULL AUTO_INCREMENT,
  idOrdonnance BIGINT(4)  NOT NULL,
  idProduit    BIGINT(4)  NOT NULL,
  quantite     INTEGER(2) NOT NULL,
  PRIMARY KEY (id)
);

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Appartenir
# -----------------------------------------------------------------------------


CREATE INDEX I_FK_Appartenir_Ordonnance
  ON Appartenir (idOrdonnance ASC);

CREATE INDEX I_FK_Appartenir_Produit
  ON Appartenir (idProduit ASC);

# -----------------------------------------------------------------------------
#       TABLE : Commander
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS Commander
(
  id        BIGINT(4)  NOT NULL PRIMARY KEY,
  idProduit BIGINT(4)  NOT NULL,
  quantite  INTEGER(2) NULL,
  prix      REAL(5, 2) NULL
);

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE Commander
# -----------------------------------------------------------------------------


CREATE INDEX I_FK_Commander_Panier
  ON Commander (id ASC);

CREATE INDEX I_FK_Commander_Produit
  ON Commander (idProduit ASC);

# -----------------------------------------------------------------------------
#       TABLE : AvoirRendezVous
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS AvoirRendezVous
(
  id            BIGINT(4)  NOT NULL AUTO_INCREMENT,
  idClient      BIGINT(4)  NOT NULL,
  idVeterinaire BIGINT(4)  NOT NULL,
  dateHeure     DATETIME   NOT NULL,
  dureeMinutes  INTEGER(4) NOT NULL,
  message       CHAR(255)  NULL,
  PRIMARY KEY (id)
);

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE AvoirRendezVous
# -----------------------------------------------------------------------------

CREATE INDEX I_FK_AvoirRendezVous
  ON AvoirRendezVous (id ASC);

CREATE INDEX I_FK_AvoirRendezVous_Client
  ON AvoirRendezVous (idClient ASC);

CREATE INDEX I_FK_AvoirRendezVous_Veterinaire
  ON AvoirRendezVous (idVeterinaire ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------

ALTER TABLE Panier
  ADD FOREIGN KEY FK_Panier_Employe (idEmploye)
    REFERENCES Employe (id);


ALTER TABLE Panier
  ADD FOREIGN KEY FK_Panier_Client (idClient)
    REFERENCES Client (id);


ALTER TABLE Log
  ADD FOREIGN KEY FK_Log_Employe (idEmploye)
    REFERENCES Employe (id);


ALTER TABLE Conge
  ADD FOREIGN KEY FK_Conge_Employe (idEmploye)
    REFERENCES Employe (id);


ALTER TABLE Ordonnance
  ADD FOREIGN KEY FK_Ordonnance_Veterinaire (idVeterinaire)
    REFERENCES Veterinaire (id);


ALTER TABLE Ordonnance
  ADD FOREIGN KEY FK_Ordonnance_Animal (idAnimal)
    REFERENCES Animal (id);


ALTER TABLE Race
  ADD FOREIGN KEY FK_Race_Espece (idEspece)
    REFERENCES Espece (id);


ALTER TABLE Animal
  ADD FOREIGN KEY FK_Animal_Race (idRace)
    REFERENCES Race (id);


ALTER TABLE Animal
  ADD FOREIGN KEY FK_Animal_Client (idClient)
    REFERENCES Client (id);


ALTER TABLE Client
  ADD FOREIGN KEY FK_Client_Personne (id)
    REFERENCES Personne (id);

ALTER TABLE Veterinaire
  ADD FOREIGN KEY FK_Veterinaire_Personne (id)
    REFERENCES Personne (id);


ALTER TABLE Employe
  ADD FOREIGN KEY FK_Employe_Personne (id)
    REFERENCES Personne (id);


ALTER TABLE Appartenir
  ADD FOREIGN KEY FK_Appartenir_Produit (idProduit)
    REFERENCES Produit (id);


ALTER TABLE Commander
  ADD FOREIGN KEY FK_Commander_Panier (id)
    REFERENCES Panier (id);


ALTER TABLE Commander
  ADD FOREIGN KEY FK_Commander_Produit (idProduit)
    REFERENCES Produit (id);

ALTER TABLE AvoirRendezVous
  ADD FOREIGN KEY FK_AvoirRendezVous_Client (idClient)
    REFERENCES Client (id);

ALTER TABLE AvoirRendezVous
  ADD FOREIGN KEY FK_AvoirRendezVous_Veterinaire (idVeterinaire)
    REFERENCES Veterinaire (id);

ALTER TABLE Traitement
  ADD FOREIGN KEY FK_Traitement_Animal (idAnimal)
    REFERENCES Animal (id);


ALTER TABLE Appartenir
  ADD FOREIGN KEY FK_Appartenir_Ordonnance (idOrdonnance)
    REFERENCES Ordonnance (id);

ALTER TABLE Personne
  ADD FOREIGN KEY FK_Personne_Ville (idVille)
    REFERENCES Ville (id);
