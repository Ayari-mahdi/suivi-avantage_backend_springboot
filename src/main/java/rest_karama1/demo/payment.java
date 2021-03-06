package rest_karama1.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@IdClass(paymentID.class)
@Table(name = "test_payment_table")
public class payment {
    @Id
     private long numemp;
    @Id
     private long cleemp;
    @Id
     private long numass;
    @Id
     private long cleass;
    @Id
     private char trim;
    @Id
     private String year;
     private String salaire;
     private String avg;
     private LocalDate dtsaisisalaire;
     private LocalDate dtpayement;

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public char getTrim() {
        return trim;
    }

    public void setTrim(char trim) {
        this.trim = trim;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
