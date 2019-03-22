package pt4p1ae1.veto.Entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Personne", schema = "PT_S4P1A_E1", catalog = "")
public class PersonneEntity {
    private long id;
    private long idVille;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String adresse;
    private String mail;
    private String telephone;
    private ClientEntity clientById;
    private EmployeEntity employeById;
    private VilleEntity villeByIdVille;
    private VeterinaireEntity veterinaireById;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idVille", nullable = false)
    public long getIdVille() {
        return idVille;
    }

    public void setIdVille(long idVille) {
        this.idVille = idVille;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 128)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = false, length = 128)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "dateNaissance", nullable = true)
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Basic
    @Column(name = "adresse", nullable = true, length = 255)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Email
    @Column(name = "mail", nullable = true, length = 128)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "telephone", nullable = true, length = 128)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonneEntity that = (PersonneEntity) o;
        return id == that.id &&
                idVille == that.idVille &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(dateNaissance, that.dateNaissance) &&
                Objects.equals(adresse, that.adresse) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(telephone, that.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idVille, nom, prenom, dateNaissance, adresse, mail, telephone);
    }

    @OneToOne(mappedBy = "personneById")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public ClientEntity getClientById() {
        return clientById;
    }

    public void setClientById(ClientEntity clientById) {
        this.clientById = clientById;
    }

    @OneToOne(mappedBy = "personneById")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public EmployeEntity getEmployeById() {
        return employeById;
    }

    public void setEmployeById(EmployeEntity employeById) {
        this.employeById = employeById;
    }

    @ManyToOne
    @JoinColumn(insertable =false, updatable=false,name = "idVille", referencedColumnName = "id", nullable = false)
    public VilleEntity getVilleByIdVille() {
        return villeByIdVille;
    }

    public void setVilleByIdVille(VilleEntity villeByIdVille) {
        this.villeByIdVille = villeByIdVille;
    }

    @OneToOne(mappedBy = "personneById")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    public VeterinaireEntity getVeterinaireById() {
        return veterinaireById;
    }

    public void setVeterinaireById(VeterinaireEntity veterinaireById) {
        this.veterinaireById = veterinaireById;
    }
}
