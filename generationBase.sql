DROP DATABASE IF EXISTS MLR1;

CREATE DATABASE IF NOT EXISTS MLR1;
USE MLR1;
# -----------------------------------------------------------------------------
#       TABLE : CLIENTFOURNISSEUR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CLIENTFOURNISSEUR
 (
   IDENTIFIANT BIGINT(4) NOT NULL  
   , PRIMARY KEY (IDENTIFIANT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : COMMANDEFOURNISSEUR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COMMANDEFOURNISSEUR
 (
   IDCOMMANDE BIGINT(4) NOT NULL  ,
   IDFOURNISSEUR INTEGER(2) NOT NULL  ,
   IDENTIFIANT BIGINT(4) NULL  ,
   DATE DATE NOT NULL  ,
   MONTANTTOTAL REAL(5,2) NOT NULL  ,
   ESTREGLE BOOL NOT NULL  ,
   DATEDELIVRAISONESTIMEE DATE NOT NULL  ,
   DATEDELIVRAISONREELLE DATE NULL  ,
   DOSSIERARCHIVAGE CHAR(255) NULL  ,
   DATEARCHIVAGE DATETIME NULL  
   , PRIMARY KEY (IDCOMMANDE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE COMMANDEFOURNISSEUR
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_COMMANDEFOURNISSEUR_FOURNISSEUR
     ON COMMANDEFOURNISSEUR (IDFOURNISSEUR ASC);

CREATE  INDEX I_FK_COMMANDEFOURNISSEUR_CLIENTFOURNISSEUR
     ON COMMANDEFOURNISSEUR (IDENTIFIANT ASC);

# -----------------------------------------------------------------------------
#       TABLE : PERSONNE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PERSONNE
 (
   IDENTIFIANT BIGINT(4) NOT NULL  ,
   CODECOMMUNE INTEGER(10) NOT NULL  ,
   NOM VARCHAR(128) NOT NULL  ,
   PRENOM VARCHAR(128) NOT NULL  ,
   DATEDENAISSANCE DATE NULL  ,
   ADRESSE CHAR(255) NULL  ,
   MAIL VARCHAR(128) NULL  ,
   TELEPHONE VARCHAR(128) NULL  
   , PRIMARY KEY (IDENTIFIANT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE PERSONNE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_PERSONNE_VILLE
     ON PERSONNE (CODECOMMUNE ASC);

# -----------------------------------------------------------------------------
#       TABLE : REGLEFIDELISATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS REGLEFIDELISATION
 (
   IDREGLE BIGINT(4) NOT NULL  ,
   IDENTIFIANT BIGINT(4) NOT NULL  ,
   PARAMETRE VARCHAR(128) NOT NULL  ,
   BORNEINFERIEUR REAL(5,2) NOT NULL  ,
   BORNESUPERIEUR REAL(5,2) NOT NULL  ,
   AVANTAGE REAL(5,2) NOT NULL  
   , PRIMARY KEY (IDREGLE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE REGLEFIDELISATION
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_REGLEFIDELISATION_VETERINAIRE
     ON REGLEFIDELISATION (IDENTIFIANT ASC);

# -----------------------------------------------------------------------------
#       TABLE : VETERINAIRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS VETERINAIRE
 (
   IDENTIFIANT BIGINT(4) NOT NULL  ,
   SIGNATUREELECTRONIQUE LONGBLOB NULL  
   , PRIMARY KEY (IDENTIFIANT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ACHATCLIENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ACHATCLIENT
 (
   IDVENTE BIGINT(4) NOT NULL  ,
   IDENTIFIANT BIGINT(4) NOT NULL  ,
   IDENTIFIANT_1 BIGINT(4) NOT NULL  ,
   DATE DATE NOT NULL  ,
   MONTANTTOTAL REAL(5,2) NOT NULL  ,
   MONTANTREDUCTION REAL(5,2) NOT NULL  
   , PRIMARY KEY (IDVENTE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE ACHATCLIENT
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_ACHATCLIENT_EMPLOYE
     ON ACHATCLIENT (IDENTIFIANT_1 ASC);

CREATE  INDEX I_FK_ACHATCLIENT_CLIENT
     ON ACHATCLIENT (IDENTIFIANT ASC);

# -----------------------------------------------------------------------------
#       TABLE : FOURNISSEUR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS FOURNISSEUR
 (
   IDFOURNISSEUR INTEGER(2) NOT NULL  ,
   CODECOMMUNE INTEGER(10) NOT NULL  ,
   NOM CHAR(32) NOT NULL  ,
   ADRESSE CHAR(255) NOT NULL  ,
   NUMEROTELEPHONE BIGINT(14) NOT NULL  ,
   MAIL CHAR(32) NOT NULL  ,
   ACTIVITEE VARCHAR(128) NULL  ,
   DELAISLIVRAISON INTEGER(2) NULL  
   , PRIMARY KEY (IDFOURNISSEUR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE FOURNISSEUR
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_FOURNISSEUR_VILLE
     ON FOURNISSEUR (CODECOMMUNE ASC);

# -----------------------------------------------------------------------------
#       TABLE : PAYS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PAYS
 (
   IDPAYS BIGINT(4) NOT NULL  ,
   NOM VARCHAR(128) NOT NULL  
   , PRIMARY KEY (IDPAYS) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ESPECE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ESPECE
 (
   IDESPECE INTEGER(2) NOT NULL  ,
   NOM CHAR(32) NOT NULL  
   , PRIMARY KEY (IDESPECE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : LOG
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LOG
 (
   IDLOG BIGINT(4) NOT NULL  ,
   IDENTIFIANT BIGINT(4) NOT NULL  ,
   DATE DATETIME NOT NULL  ,
   ACTION CHAR(255) NOT NULL  
   , PRIMARY KEY (IDLOG) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE LOG
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_LOG_EMPLOYE
     ON LOG (IDENTIFIANT ASC);

# -----------------------------------------------------------------------------
#       TABLE : CONGE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CONGE
 (
   IDCONGE BIGINT(4) NOT NULL  ,
   IDENTIFIANT BIGINT(4) NOT NULL  ,
   IDENTIFIANT_1 BIGINT(4) NOT NULL  ,
   DATEDEBUT DATETIME NOT NULL  ,
   DATEFIN DATETIME NOT NULL  
   , PRIMARY KEY (IDCONGE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE CONGE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_CONGE_EMPLOYE
     ON CONGE (IDENTIFIANT ASC);

CREATE  INDEX I_FK_CONGE_VETERINAIRE
     ON CONGE (IDENTIFIANT_1 ASC);

# -----------------------------------------------------------------------------
#       TABLE : ORDONNANCE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ORDONNANCE
 (
   IDORDONNANCE CHAR(32) NOT NULL  ,
   IDANIMAL INTEGER(20) NOT NULL  ,
   IDENTIFIANT BIGINT(4) NOT NULL  ,
   DATE DATETIME NOT NULL  ,
   COMMENTAIRE CHAR(32) NULL  
   , PRIMARY KEY (IDORDONNANCE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE ORDONNANCE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_ORDONNANCE_VETERINAIRE
     ON ORDONNANCE (IDENTIFIANT ASC);

CREATE  INDEX I_FK_ORDONNANCE_ANIMAL
     ON ORDONNANCE (IDANIMAL ASC);

# -----------------------------------------------------------------------------
#       TABLE : VILLE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS VILLE
 (
   CODECOMMUNE INTEGER(10) NOT NULL  ,
   IDPAYS BIGINT(4) NOT NULL  ,
   NOM CHAR(32) NOT NULL  ,
   CODEPOSTAL BIGINT(10) NOT NULL  
   , PRIMARY KEY (CODECOMMUNE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE VILLE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_VILLE_PAYS
     ON VILLE (IDPAYS ASC);

# -----------------------------------------------------------------------------
#       TABLE : RACE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS RACE
 (
   IDRACE INTEGER(2) NOT NULL  ,
   IDESPECE INTEGER(2) NOT NULL  ,
   NOM CHAR(32) NOT NULL  
   , PRIMARY KEY (IDRACE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE RACE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_RACE_ESPECE
     ON RACE (IDESPECE ASC);

# -----------------------------------------------------------------------------
#       TABLE : ANIMAL
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ANIMAL
 (
   IDANIMAL INTEGER(20) NOT NULL  ,
   IDESPECE INTEGER(2) NOT NULL  ,
   IDENTIFIANT BIGINT(4) NOT NULL  ,
   NOM CHAR(32) NOT NULL  ,
   DATEDENAISSANCE DATE NOT NULL  
   , PRIMARY KEY (IDANIMAL) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE ANIMAL
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_ANIMAL_ESPECE
     ON ANIMAL (IDESPECE ASC);

CREATE  INDEX I_FK_ANIMAL_CLIENT
     ON ANIMAL (IDENTIFIANT ASC);

# -----------------------------------------------------------------------------
#       TABLE : CLIENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CLIENT
 (
   IDENTIFIANT BIGINT(4) NOT NULL  
   , PRIMARY KEY (IDENTIFIANT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PRODUIT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PRODUIT
 (
   IDPRODUIT SMALLINT(25) NOT NULL  ,
   NOM CHAR(255) NOT NULL  ,
   QUANTITEENSTOCK INTEGER(2) NOT NULL  ,
   QUANTITEMINIMUN INTEGER(2) NOT NULL  ,
   PRIXVENTEUNITAIRE REAL(25,2) NOT NULL  
   , PRIMARY KEY (IDPRODUIT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : TRAITEMENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS TRAITEMENT
 (
   IDTRAITEMENT INTEGER(4) NOT NULL  ,
   IDORDONNANCE CHAR(32) NOT NULL  ,
   DATEDEBUT DATE NOT NULL  ,
   DUREEJ INTEGER(2) NOT NULL  ,
   PRODUITPRESCRIT CHAR(32) NOT NULL  ,
   POSOLOGIE CHAR(32) NOT NULL  ,
   METHODEADMINISTRATION CHAR(32) NOT NULL  
   , PRIMARY KEY (IDTRAITEMENT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE TRAITEMENT
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_TRAITEMENT_ORDONNANCE
     ON TRAITEMENT (IDORDONNANCE ASC);

# -----------------------------------------------------------------------------
#       TABLE : EMPLOYE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EMPLOYE
 (
   IDENTIFIANT BIGINT(4) NOT NULL  ,
   IDENTIFIANTCONNEXION CHAR(32) NOT NULL  ,
   MOTDEPASSE CHAR(32) NOT NULL  
   , PRIMARY KEY (IDENTIFIANT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PROPOSER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PROPOSER
 (
   IDFOURNISSEUR INTEGER(2) NOT NULL  ,
   IDPRODUIT SMALLINT(25) NOT NULL  ,
   PRIXFOURNISSEURUNITAIRE REAL(5,2) NULL  
   , PRIMARY KEY (IDFOURNISSEUR,IDPRODUIT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE PROPOSER
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_PROPOSER_FOURNISSEUR
     ON PROPOSER (IDFOURNISSEUR ASC);

CREATE  INDEX I_FK_PROPOSER_PRODUIT
     ON PROPOSER (IDPRODUIT ASC);

# -----------------------------------------------------------------------------
#       TABLE : APPARTENIR1
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS APPARTENIR1
 (
   IDORDONNANCE CHAR(32) NOT NULL  ,
   IDPRODUIT SMALLINT(25) NOT NULL  
   , PRIMARY KEY (IDORDONNANCE,IDPRODUIT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE APPARTENIR1
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_APPARTENIR1_ORDONNANCE
     ON APPARTENIR1 (IDORDONNANCE ASC);

CREATE  INDEX I_FK_APPARTENIR1_PRODUIT
     ON APPARTENIR1 (IDPRODUIT ASC);

# -----------------------------------------------------------------------------
#       TABLE : CONCERNER2
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CONCERNER2
 (
   IDVENTE BIGINT(4) NOT NULL  ,
   IDPRODUIT SMALLINT(25) NOT NULL  ,
   QUANTITÉSORTIE INTEGER(2) NULL  ,
   PRIXVENTE REAL(5,2) NULL  
   , PRIMARY KEY (IDVENTE,IDPRODUIT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE CONCERNER2
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_CONCERNER2_ACHATCLIENT
     ON CONCERNER2 (IDVENTE ASC);

CREATE  INDEX I_FK_CONCERNER2_PRODUIT
     ON CONCERNER2 (IDPRODUIT ASC);

# -----------------------------------------------------------------------------
#       TABLE : CONCERNER3
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CONCERNER3
 (
   IDPRODUIT SMALLINT(25) NOT NULL  ,
   IDCOMMANDE BIGINT(4) NOT NULL  ,
   QUANTITIÉSORTIE INTEGER(2) NULL  ,
   PRIXACHATUNITAIRE REAL(5,2) NULL  
   , PRIMARY KEY (IDPRODUIT,IDCOMMANDE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE CONCERNER3
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_CONCERNER3_PRODUIT
     ON CONCERNER3 (IDPRODUIT ASC);

CREATE  INDEX I_FK_CONCERNER3_COMMANDEFOURNISSEUR
     ON CONCERNER3 (IDCOMMANDE ASC);

# -----------------------------------------------------------------------------
#       TABLE : AVOIRRENDEZVOUS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS AVOIRRENDEZVOUS
 (
   IDENTIFIANT BIGINT(4) NOT NULL  ,
   IDENTIFIANT_1 BIGINT(4) NOT NULL  ,
   DATEHEURE DATETIME NOT NULL  ,
   DUREEMINUTES INTEGER(4) NOT NULL  ,
   MESSAGE CHAR(255) NULL  
   , PRIMARY KEY (IDENTIFIANT,IDENTIFIANT_1) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE AVOIRRENDEZVOUS
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_AVOIRRENDEZVOUS_CLIENT
     ON AVOIRRENDEZVOUS (IDENTIFIANT ASC);

CREATE  INDEX I_FK_AVOIRRENDEZVOUS_VETERINAIRE
     ON AVOIRRENDEZVOUS (IDENTIFIANT_1 ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE CLIENTFOURNISSEUR 
  ADD FOREIGN KEY FK_CLIENTFOURNISSEUR_EMPLOYE (IDENTIFIANT)
      REFERENCES EMPLOYE (IDENTIFIANT) ;


ALTER TABLE COMMANDEFOURNISSEUR 
  ADD FOREIGN KEY FK_COMMANDEFOURNISSEUR_FOURNISSEUR (IDFOURNISSEUR)
      REFERENCES FOURNISSEUR (IDFOURNISSEUR) ;


ALTER TABLE COMMANDEFOURNISSEUR 
  ADD FOREIGN KEY FK_COMMANDEFOURNISSEUR_CLIENTFOURNISSEUR (IDENTIFIANT)
      REFERENCES CLIENTFOURNISSEUR (IDENTIFIANT) ;


ALTER TABLE PERSONNE 
  ADD FOREIGN KEY FK_PERSONNE_VILLE (CODECOMMUNE)
      REFERENCES VILLE (CODECOMMUNE) ;


ALTER TABLE REGLEFIDELISATION 
  ADD FOREIGN KEY FK_REGLEFIDELISATION_VETERINAIRE (IDENTIFIANT)
      REFERENCES VETERINAIRE (IDENTIFIANT) ;


ALTER TABLE VETERINAIRE 
  ADD FOREIGN KEY FK_VETERINAIRE_CLIENTFOURNISSEUR (IDENTIFIANT)
      REFERENCES CLIENTFOURNISSEUR (IDENTIFIANT) ;


ALTER TABLE ACHATCLIENT 
  ADD FOREIGN KEY FK_ACHATCLIENT_EMPLOYE (IDENTIFIANT_1)
      REFERENCES EMPLOYE (IDENTIFIANT) ;


ALTER TABLE ACHATCLIENT 
  ADD FOREIGN KEY FK_ACHATCLIENT_CLIENT (IDENTIFIANT)
      REFERENCES CLIENT (IDENTIFIANT) ;


ALTER TABLE FOURNISSEUR 
  ADD FOREIGN KEY FK_FOURNISSEUR_VILLE (CODECOMMUNE)
      REFERENCES VILLE (CODECOMMUNE) ;


ALTER TABLE LOG 
  ADD FOREIGN KEY FK_LOG_EMPLOYE (IDENTIFIANT)
      REFERENCES EMPLOYE (IDENTIFIANT) ;


ALTER TABLE CONGE 
  ADD FOREIGN KEY FK_CONGE_EMPLOYE (IDENTIFIANT)
      REFERENCES EMPLOYE (IDENTIFIANT) ;


ALTER TABLE CONGE 
  ADD FOREIGN KEY FK_CONGE_VETERINAIRE (IDENTIFIANT_1)
      REFERENCES VETERINAIRE (IDENTIFIANT) ;


ALTER TABLE ORDONNANCE 
  ADD FOREIGN KEY FK_ORDONNANCE_VETERINAIRE (IDENTIFIANT)
      REFERENCES VETERINAIRE (IDENTIFIANT) ;


ALTER TABLE ORDONNANCE 
  ADD FOREIGN KEY FK_ORDONNANCE_ANIMAL (IDANIMAL)
      REFERENCES ANIMAL (IDANIMAL) ;


ALTER TABLE VILLE 
  ADD FOREIGN KEY FK_VILLE_PAYS (IDPAYS)
      REFERENCES PAYS (IDPAYS) ;


ALTER TABLE RACE 
  ADD FOREIGN KEY FK_RACE_ESPECE (IDESPECE)
      REFERENCES ESPECE (IDESPECE) ;


ALTER TABLE ANIMAL 
  ADD FOREIGN KEY FK_ANIMAL_ESPECE (IDESPECE)
      REFERENCES ESPECE (IDESPECE) ;


ALTER TABLE ANIMAL 
  ADD FOREIGN KEY FK_ANIMAL_CLIENT (IDENTIFIANT)
      REFERENCES CLIENT (IDENTIFIANT) ;


ALTER TABLE CLIENT 
  ADD FOREIGN KEY FK_CLIENT_PERSONNE (IDENTIFIANT)
      REFERENCES PERSONNE (IDENTIFIANT) ;


ALTER TABLE TRAITEMENT 
  ADD FOREIGN KEY FK_TRAITEMENT_ORDONNANCE (IDORDONNANCE)
      REFERENCES ORDONNANCE (IDORDONNANCE) ;


ALTER TABLE EMPLOYE 
  ADD FOREIGN KEY FK_EMPLOYE_PERSONNE (IDENTIFIANT)
      REFERENCES PERSONNE (IDENTIFIANT) ;


ALTER TABLE PROPOSER 
  ADD FOREIGN KEY FK_PROPOSER_FOURNISSEUR (IDFOURNISSEUR)
      REFERENCES FOURNISSEUR (IDFOURNISSEUR) ;


ALTER TABLE PROPOSER 
  ADD FOREIGN KEY FK_PROPOSER_PRODUIT (IDPRODUIT)
      REFERENCES PRODUIT (IDPRODUIT) ;


ALTER TABLE APPARTENIR1 
  ADD FOREIGN KEY FK_APPARTENIR1_ORDONNANCE (IDORDONNANCE)
      REFERENCES ORDONNANCE (IDORDONNANCE) ;


ALTER TABLE APPARTENIR1 
  ADD FOREIGN KEY FK_APPARTENIR1_PRODUIT (IDPRODUIT)
      REFERENCES PRODUIT (IDPRODUIT) ;


ALTER TABLE CONCERNER2 
  ADD FOREIGN KEY FK_CONCERNER2_ACHATCLIENT (IDVENTE)
      REFERENCES ACHATCLIENT (IDVENTE) ;


ALTER TABLE CONCERNER2 
  ADD FOREIGN KEY FK_CONCERNER2_PRODUIT (IDPRODUIT)
      REFERENCES PRODUIT (IDPRODUIT) ;


ALTER TABLE CONCERNER3 
  ADD FOREIGN KEY FK_CONCERNER3_PRODUIT (IDPRODUIT)
      REFERENCES PRODUIT (IDPRODUIT) ;


ALTER TABLE CONCERNER3 
  ADD FOREIGN KEY FK_CONCERNER3_COMMANDEFOURNISSEUR (IDCOMMANDE)
      REFERENCES COMMANDEFOURNISSEUR (IDCOMMANDE) ;


ALTER TABLE AVOIRRENDEZVOUS 
  ADD FOREIGN KEY FK_AVOIRRENDEZVOUS_CLIENT (IDENTIFIANT)
      REFERENCES CLIENT (IDENTIFIANT) ;


ALTER TABLE AVOIRRENDEZVOUS 
  ADD FOREIGN KEY FK_AVOIRRENDEZVOUS_VETERINAIRE (IDENTIFIANT_1)
      REFERENCES VETERINAIRE (IDENTIFIANT) ;

