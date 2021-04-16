package rest_karama1.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "test_payment_table")
public class payment {
    @Id
     private long id ;
     private long numemp;
     private long cleemp;
     private long numass;
     private long cleass;
     private String salaire;
     private LocalDate dtsaisisalaire;
     private LocalDate dtpayement;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumemp() {
        return numemp;
    }

    public void setNumemp(long numemp) {
        this.numemp = numemp;
    }

    public long getCleemp() {
        return cleemp;
    }

    public void setCleemp(long cleemp) {
        this.cleemp = cleemp;
    }

    public long getNumass() {
        return numass;
    }

    public void setNumass(long numass) {
        this.numass = numass;
    }

    public long getCleass() {
        return cleass;
    }

    public void setCleass(long cleass) {
        this.cleass = cleass;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public LocalDate getDtsaisisalaire() {
        return dtsaisisalaire;
    }

    public void setDtsaisisalaire(LocalDate dtsaisisalaire) {
        this.dtsaisisalaire = dtsaisisalaire;
    }

    public LocalDate getDtpayement() {
        return dtpayement;
    }

    public void setDtpayemennt(LocalDate dtpayement) {
        this.dtpayement = dtpayement;
    }
}
