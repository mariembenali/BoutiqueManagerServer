package commande.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
public class User implements Serializable{

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

    @Column(length = 200)
    private String adresse;

    @Column(length = 50, unique = true)
    private String email;

    @Column(length = 255)
    private String password;

    @Column(columnDefinition = "int default 0")
    private int etat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profil_id")
    private Profil profil;

    @OneToMany(mappedBy = "user")
    private List<Commande> commandes;

    @OneToMany(mappedBy = "user")
    private List<Facture> factures;

    @OneToMany(mappedBy = "user")
    private List<Stock> stocks;

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
     * @return int return the etat
     */
    public int getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(int etat) {
        this.etat = etat;
    }

    /**
     * @return Profil return the profil
     */
    public Profil getProfil() {
        return profil;
    }

    /**
     * @param profil the profil to set
     */
    public void setProfil(Profil profil) {
        this.profil = profil;
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

    /**
     * @return List<Stock> return the stocks
     */
    public List<Stock> getStocks() {
        return stocks;
    }

    /**
     * @param stocks the stocks to set
     */
    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

}