package commande.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Client implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 60, unique = true)
    private String identification;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Column(length = 200)
    private String adresse;

    @Column(length = 50, unique = true)
    private String email;

    @Column(length = 60, nullable = true)
    private String password;
    
    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeClient type;

    @OneToMany(mappedBy = "client")
    private List<Facture> factures;

    
    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the identification
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * @param identification the identification to set
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return String return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return Date return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * @return String return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return List<Commande> return the commandes
     */
    public List<Commande> getCommandes() {
        return commandes;
    }

    /**
     * @param commandes the commandes to set
     */
    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    /**
     * @return TypeClient return the type
     */
    public TypeClient getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TypeClient type) {
        this.type = type;
    }

    /**
     * @return List<Facture> return the factures
     */
    public List<Facture> getFactures() {
        return factures;
    }

    /**
     * @param factures the factures to set
     */
    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }


    @Override
    public String toString() {
        return getPrenom() + " " + getNom() ;
    }

}