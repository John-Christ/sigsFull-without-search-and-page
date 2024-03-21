package sigs.api.model;


// import com.fasterxml.jackson.annotation.JsonIgnore;

import sigs.api.dao.DAOUser;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "demande")
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@NotBlank(message = "valeur obligatoire!")
    @Column
    private Date date;


    @Column
    //@JsonIgnore
    private String statut;


   // @Column
   // private String role;
   @NotBlank(message = "valeur obligatoire!")
    @Column
    private String nom;

    @NotBlank(message = "valeur obligatoire!")
    @Column
    // @JsonIgnore
    private String prenom;

    @Email(message = "Email incorrect!")
    @Column
    private String email;


    @Column
    private Integer tel;



    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(name = "demande_produit",
            joinColumns = @JoinColumn(name = "demande_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private Set<Produit> assignedProduits = new HashSet<>();





    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private DAOUser utilisateur;






    public Date getDate() {
        return date;
    }

        public void setDate(Date date) {
        this.date = date;
    }



    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }



   /* public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

*/



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
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




    public DAOUser getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(DAOUser utilisateur) {
        this.utilisateur = utilisateur;
    }





}

