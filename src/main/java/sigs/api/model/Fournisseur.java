package sigs.api.model;


// import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fournisseur")
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotBlank(message = "valeur obligatoire!")
    @Column
    private String nom;

    @Email(message = "Email incorrect!")
    @Column
    private String email;


    @Column
    private Integer tel;

    @Column
    private String adresse;
    @Column
    // @JsonIgnore
    private String ville;


    @Column
    private String pays;




    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "compteFournisseur_id")
    private CompteFournisseur compteFournisseur;




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



    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }





    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }





    public CompteFournisseur getCompteFournisseur() {
        return compteFournisseur;
    }

    public void setCompteFournisseur(CompteFournisseur compteFournisseur) {
        this.compteFournisseur = compteFournisseur;
    }



}


