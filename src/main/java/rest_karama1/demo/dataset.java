package rest_karama1.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.processing.Generated;
import javax.persistence.*;
@JsonIgnoreProperties
@Entity
@Table(name = "list_reglement")
public class dataset {
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_ssequence")
    //@SequenceGenerator(name = "id_ssequence", sequenceName = "id_sseq")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dataset_seq")
    //@SequenceGenerator(name = "dataset_seq", sequenceName = "dataset_seq")
   @Id
    @Column (name = "id")
    private long id;

    @Column(name = "situation_reglement")
    private String situation_reglement;
    @Column(name = "mois_reglement")
    private String mois_reglement;
    @Column(name = "annee_reglement")
    private String annee_reglement;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "salaire")
    private String salaire;
    @Column(name = "montant_verse")
    private String montant_verse;

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }



    public String getSituation_reglement() {
        return situation_reglement;
    }

    public void setSituation_reglement(String situation_reglement) {
        this.situation_reglement = situation_reglement;
    }

    public String getMois_reglement() {
        return mois_reglement;
    }

    public void setMois_reglement(String mois_reglement) {
        this.mois_reglement = mois_reglement;
    }

    public String getAnnee_reglement() {
        return annee_reglement;
    }

    public void setAnnee_reglement(String annee_reglement) {
        this.annee_reglement = annee_reglement;
    }

    public String getMontant_verse() {
        return montant_verse;
    }

    public void setMontant_verse(String montant_verse) {
        this.montant_verse = montant_verse;
    }

    @Override
    public String toString() {
        return "dataset{" +
                ", situation_reglement='" + situation_reglement + '\'' +
                ", mois_reglement='" + mois_reglement + '\'' +
                ", annee_reglement='" + annee_reglement + '\'' +
                ", salaire='" + salaire + '\'' +
                ", montant_verse='" + montant_verse + '\'' +
                '}';
    }

    public dataset() {
    }
}
