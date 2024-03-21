package sigs.api.model;


// import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pret")
public class Pret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "valeur obligatoire!")
    @Column
    private String nom;


    @Column
    // @JsonIgnore
    private String description;


    @NotBlank(message = "valeur obligatoire!")
    @Column
    private Date date_sortie;


    @NotBlank(message = "valeur obligatoire!")
    @Column
    private Date date_retour;



    @Column
    private String statut;


    @NotNull
    @Column
    // @JsonIgnore
    private Integer qte;


    @NotBlank(message = "valeur obligatoire!")
    @Column
    private String direction;



    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(name = "pret_produit",
            joinColumns = @JoinColumn(name = "pret_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private Set<Produit> assignedProduits = new HashSet<>();





    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
    }



    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }



    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }


    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }




    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
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




}


