package commande.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
public class Produit implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, unique = true, nullable = false)
    private String numSerie;

    @Column(length = 100)
    private String libelle;

    private int prixUnitaire;

    private int marge;

    private int quantite;

    private int seuil;

    @Column(columnDefinition = "int default 0")
    private int etat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marque_id")
    private Marque marque;

    @OneToMany(mappedBy = "produit")
    private List<Detail> details;

    @OneToMany(mappedBy = "produit")
    private List<Stock> entrees;

    public Produit() {
    }

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
     * @return String return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * @return float return the prixUnitaire
     */
    public int getPrixUnitaire() {
        return prixUnitaire;
    }

    /**
     * @param prixUnitaire the prixUnitaire to set
     */
    public void setPrixUnitaire(int prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    
    /**
     * @return int return the quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * @return int return the seuil
     */
    public int getSeuil() {
        return seuil;
    }

    /**
     * @param seuil the seuil to set
     */
    public void setSeuil(int seuil) {
        this.seuil = seuil;
    }

    /**
     * @return List<Detail> return the details
     */
    public List<Detail> getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(List<Detail> details) {
        this.details = details;
    }


    /**
     * @return int return the marge
     */
    public int getMarge() {
        return marge;
    }

    /**
     * @param marge the marge to set
     */
    public void setMarge(int marge) {
        this.marge = marge;
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
     * @return List<Stock> return the entrees
     */
    public List<Stock> getEntrees() {
        return entrees;
    }

    /**
     * @param entrees the entrees to set
     */
    public void setEntrees(List<Stock> entrees) {
        this.entrees = entrees;
    }


    @Override
    public String toString() {
        return  getLibelle();
    }


    /**
     * @return Categorie return the categorie
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /**
     * @return Marque return the marque
     */
    public Marque getMarque() {
        return marque;
    }

    /**
     * @param marque the marque to set
     */
    public void setMarque(Marque marque) {
        this.marque = marque;
    }


    /**
     * @return String return the numSerie
     */
    public String getNumSerie() {
        return numSerie;
    }

    /**
     * @param numSerie the numSerie to set
     */
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

}
