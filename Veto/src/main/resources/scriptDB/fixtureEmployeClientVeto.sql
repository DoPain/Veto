INSERT INTO Employe (idEmploye, idConnexion, motDePasse) VALUES 
((SELECT idPersonne FROM Personne WHERE Personne.nom = 'TestE1'), 'empTest1', 'test'),
((SELECT idPersonne FROM Personne WHERE Personne.nom = 'TestE2'), 'empTest2', 'test'),
((SELECT idPersonne FROM Personne WHERE Personne.nom = 'TestE3'), 'empTest3', 'test');

INSERT INTO Client ()