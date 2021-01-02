package commande.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Categorie implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, unique = true)
    private String libelle;

    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;

    @OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
    private List<Marque> marques;

    public Categorie(){
        produits = new ArrayList<>();
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
     * @return List<Produit> return the produits
     */
    public List<Produit> getProduits() {
        return produits;
    }

    /**
     * @param produits the produits to set
     */
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }


    @Override
    public String toString() {
        return getLibelle();
    }
    

    /**
     * @return List<Marque> return the marques
     */
    public List<Marque> getMarques() {
        return marques;
    }

    /**
     * @param marques the marques to set
     */
    public void setMarques(List<Marque> marques) {
        this.marques = marques;
    }

}