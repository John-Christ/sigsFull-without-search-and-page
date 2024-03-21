package sigs.api.model;


// import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "valeur obligatoire!")
    @Column
    private Date date;


    @Column
    private Date date_livraison;


    @Column
   // @JsonIgnore
    private String ref_cmd;

    @NotNull
    @Column
    private Integer mnt_ttc;

    @Column
    private Integer duree;


    @NotBlank(message = "valeur obligatoire!")
    @Column
    // @JsonIgnore
    private String nom;




    @Column
    private String description;


    @Column
    private Integer solde;




    @Column
    private String statut;


    @NotNull
    @Column
    private Integer qte;


    @NotNull
    @Column
    private Integer prix_unitaire;




    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(name = "commande_produit",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private Set<Produit> assignedProduits = new HashSet<>();





    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;






    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Date getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(Date date_livraison) {
        this.date_livraison = date_livraison;
    }



    public String getRef_cmd() {
        return ref_cmd;
    }

    public void setRef_cmd(String ref_cmd) {
        this.ref_cmd = ref_cmd;
    }



    public Integer getMnt_ttc() {
        return mnt_ttc;
    }

    public void setMnt_ttc(Integer mnt_ttc) {
        this.mnt_ttc = mnt_ttc;
    }





    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }




    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getStatut() {
        return statut;
    }

        public void setStatut(String statut) {
        this.statut = statut;
    }



    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }



    public Integer getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Integer prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }





    public Set<Produit> getAssignedProduits() {
        return assignedProduits;
    }

    public void setAssignedProduits(Set<Produit> assignedProduits) {
        this.assignedProduits = assignedProduits;
    }





    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }




}

