package sigs.api.model;



// import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "compte_fournisseur")
public class CompteFournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @NotBlank(message = "valeur obligatoire!")
    @Column
    private String nom;


    @Column
    // @JsonIgnore
    private Integer numero_compte;


    @NotBlank(message = "valeur obligatoire!")
    @Column
    private Date date;


    @NotNull
    @Column
    private Integer montant_acompte;



    public Integer getNumero_compte() {
        return numero_compte;
    }

    public void setNumero_compte(Integer numero_compte) {
        this.numero_compte = numero_compte;
    }

    public Integer getMontant_acompte() {
        return montant_acompte;
    }

    public void setMontant_acompte(Integer montant_acompte) {
        this.montant_acompte = montant_acompte;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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




}


