package sigs.api.model;



// import com.fasterxml.jackson.annotation.JsonIgnore;

import sigs.api.dao.DAOUser;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank(message = "valeur obligatoire!")
    @Column
    private String nom;



    @Column
    // @JsonIgnore
    private String statut;


    @NotNull
    @Column
    private Integer qte;

    @Column
    private Integer seuil;




    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "stock_produit",
            joinColumns = @JoinColumn(name = "stock_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private Set<Produit> assignedProduits = new HashSet<>();





    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mouvementStock_id")
    private MouvementStock mouvementStock;





    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }




    public Integer getSeuil() {
        return seuil;
    }

    public void setSeuil(Integer seuil) {
        this.seuil = seuil;
    }



    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }





    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }







    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Set<Produit> getAssignedProduits() {
        return assignedProduits;
    }

    public void setAssignedProduits(Set<Produit> assignedProduits) {
        this.assignedProduits = assignedProduits;
    }





    public MouvementStock getMouvementStock() {
        return mouvementStock;
    }

    public void setMouvementStock(MouvementStock mouvementStock) {
        this.mouvementStock = mouvementStock;
    }





}


