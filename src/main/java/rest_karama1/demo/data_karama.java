package rest_karama1.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@JsonIgnoreProperties
@Entity
@Table(name = "data_karama")
public class data_karama {
   // @Id
    //@Column(name = "id")
    //private long id;
    @Id
    @Column(name = "cin")
    private String cin;
    @Column(name="nom_prenom")
    private String nom_prenom;
    @Column(name="genre")
    private String genre;
    @Column(name = "type_contrat")
    private String type_contrat;
    @Column(name = "date_debut")
    private String date_debut;
    @Column(name = "date_finprevesionnelle")
    private String date_finprevesionnelle;
    @Column(name = "date_fin_reelle")
    private String date_fin_reelle;
    @Column(name = "situation")
    private String situation;
    @Column(name = "date_situation")
    private String date_situation;
    @Column(name = "matricule")
    private String matricule;
    @Column(name = "numero_affiliation")
    private String numero_affiliation;
    @Column(name="reference_accord")
    private String reference_accord;
    @Column(name = "date_accord")
    private String date_accord;
    @Column(name = "raison_sociale_entreprise")
    private String raison_sociale_entreprise;
    @Column(name = "nom_etablissement")
    private String nom_etablissement;

    @Column(name = "ass_exist")
    private Long ass_exist;
    @Column(name = "emp_exist")
    private Long emp_exist;
    @Column(name = "bur_cod")
    private Long bur_cod;
    @Column(name = "local_date")
    private LocalDate local_date;

    @Column(name = "from_date")
    private String from_date;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "data_karama_id",referencedColumnName = "cin")
    private List<dataset> liste_reglements=new ArrayList<>();
    //private  ArrayList<ArrayList<String>> liste_reglements =new ArrayList<>();




    @Override
    public String toString() {
        return "data_karama{" +
                "cin='" + cin + '\'' +
                ", nom_prenom='" + nom_prenom + '\'' +
                ", genre='" + genre + '\'' +
                ", type_contrat='" + type_contrat + '\'' +
                ", date_debut='" + date_debut + '\'' +
                ", date_finprevesionnelle='" + date_finprevesionnelle + '\'' +
                ", date_fin_reelle='" + date_fin_reelle + '\'' +
                ", situation='" + situation + '\'' +
                ", date_situation='" + date_situation + '\'' +
                ", matricule='" + matricule + '\'' +
                ", numero_affiliation='" + numero_affiliation + '\'' +
                ", reference_accord='" + reference_accord + '\'' +
                ", date_accord='" + date_accord + '\'' +
                ", raison_sociale_entreprise='" + raison_sociale_entreprise + '\'' +
                ", nom_etablissement='" + nom_etablissement + '\'' +
                ", liste_reglements=" + liste_reglements +

                '}';
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }



    public LocalDate getDate() {
        return local_date;
    }



    public void setDate(LocalDate local_date) {
        this.local_date = local_date;
    }

    public Long getBur_cod() {
        return bur_cod;
    }

    public void setBur_cod(Long bur_cod) {
        this.bur_cod = bur_cod;
    }

    public Long getAss_exist() {
        return ass_exist;
    }

    public void setAss_exist(Long ass_exist) {
        this.ass_exist = ass_exist;
    }

    public Long getEmp_exist() {
        return emp_exist;
    }

    public void setEmp_exist(Long emp_exist) {
        this.emp_exist = emp_exist;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_finprevesionnelle() {
        return date_finprevesionnelle;
    }

    public void setDate_finprevesionnelle(String date_finprevesionnelle) {
        this.date_finprevesionnelle = date_finprevesionnelle;
    }

    public String getDate_fin_reelle() {
        return date_fin_reelle;
    }

    public void setDate_fin_reelle(String date_fin_reelle) {
        this.date_fin_reelle = date_fin_reelle;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getDate_situation() {
        return date_situation;
    }

    public void setDate_situation(String date_situation) {
        this.date_situation = date_situation;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNumero_affiliation() {
        return numero_affiliation;
    }

    public void setNumero_affiliation(String numero_affiliation) {
        this.numero_affiliation = numero_affiliation;
    }

    public String getReference_accord() {
        return reference_accord;
    }

    public void setReference_accord(String reference_accord) {
        this.reference_accord = reference_accord;
    }

    public String getDate_accord() {
        return date_accord;
    }

    public void setDate_accord(String date_accord) {
        this.date_accord = date_accord;
    }

    public String getRaison_sociale_entreprise() {
        return raison_sociale_entreprise;
    }

    public void setRaison_sociale_entreprise(String raison_sociale_entreprise) {
        this.raison_sociale_entreprise = raison_sociale_entreprise;
    }

    public String getNom_etablissement() {
        return nom_etablissement;
    }

    public void setNom_etablissement(String nom_etablissement) {
        this.nom_etablissement = nom_etablissement;
    }


    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getType_contrat() {
        return type_contrat;
    }

    public void setType_contrat(String type_contrat) {
        this.type_contrat = type_contrat;
    }

    public List<dataset> getListe_reglements() {
        return liste_reglements;
    }

    public void setListe_reglements( List<dataset> liste_reglements) {
        this.liste_reglements = liste_reglements;
    }


    public data_karama(String cin, String nom_prenom, String genre, String type_contrat, String date_debut, String date_finprevesionnelle, String date_fin_reelle, String situation, String date_situation, String matricule, String numero_affiliation, String reference_accord, String date_accord, String raison_sociale_entreprise, String nom_etablissement, List<dataset> liste_reglements) {
        this.cin = cin;
        this.nom_prenom = nom_prenom;
        this.genre = genre;
        this.type_contrat = type_contrat;
        this.date_debut = date_debut;
        this.date_finprevesionnelle = date_finprevesionnelle;
        this.date_fin_reelle = date_fin_reelle;
        this.situation = situation;
        this.date_situation = date_situation;
        this.matricule = matricule;
        this.numero_affiliation = numero_affiliation;
        this.reference_accord = reference_accord;
        this.date_accord = date_accord;
        this.raison_sociale_entreprise = raison_sociale_entreprise;
        this.nom_etablissement = nom_etablissement;
        this.liste_reglements = liste_reglements;
    }

    public data_karama() {
    }
}
