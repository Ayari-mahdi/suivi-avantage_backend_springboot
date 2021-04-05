package rest_karama1.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="karama384")

public class facturation {
    @Column(name="kar_numemp")
    private long kar_numemp;
    @Column(name="kar_matfisc")
    private String kar_matfisc;
    @Column(name = "kar_raissos")
    private String Kar_raissos;
    @Column(name = "kar_adr")
    private String Kar_adr;
    @Column(name="kar_matass")
    private long kar_matass;
    @Column(name = "kar_cin")
    private String Kar_cin;
    @Column(name = "kar_nomsal")
    private String kar_nomsal;
    @Column(name = "kar_prenomsal")
    private String kar_prenomsal;
    @Column(name = "kar_anncontrat")
    private long kar_anncontrat;
    @Column(name = "kar_datdeb")
    private LocalDate kar_datdeb;
    @Column(name = "kar_datefin")
    private LocalDate kar_datfin;
    @Column(name = "kar_dtreelprscnss")
    private LocalDate kar_dtreelprscnss;
    @Column(name = "kar_ann")
    private long kar_ann;
    @Column(name = "kar_trim")
    private long kar_trim;
    @Column(name = "car_saldec")
    private long car_saldec;
    @Column(name = "kar_prsmntemp")
    private long kar_prsmntemp;
    @Column(name = "kar_prsmntsal")
    private long kar_prsmntsal;
    @Column(name = "kar_mnttotprs")
    private long kar_mnttotprs;
    @Column(name = "kar_situation")
    private String kar_situation;
    @Column(name = "kar_debittotemp")
    private long kar_debittotemp;
    @Column(name = "kar_codexp")
    private long kar_codexp;

    public long getKar_numemp() {
        return kar_numemp;
    }

    public void setKar_numemp(long kar_numemp) {
        this.kar_numemp = kar_numemp;
    }

    public String getKar_matfisc() {
        return kar_matfisc;
    }

    public void setKar_matfisc(String kar_matfisc) {
        this.kar_matfisc = kar_matfisc;
    }

    public String getKar_raissos() {
        return Kar_raissos;
    }

    public void setKar_raissos(String kar_raissos) {
        Kar_raissos = kar_raissos;
    }

    public String getKar_adr() {
        return Kar_adr;
    }

    public void setKar_adr(String kar_adr) {
        Kar_adr = kar_adr;
    }

    public long getKar_matass() {
        return kar_matass;
    }

    public void setKar_matass(long kar_matass) {
        this.kar_matass = kar_matass;
    }

    public String getKar_cin() {
        return Kar_cin;
    }

    public void setKar_cin(String kar_cin) {
        Kar_cin = kar_cin;
    }

    public String getKar_nomsal() {
        return kar_nomsal;
    }

    public void setKar_nomsal(String kar_nomsal) {
        this.kar_nomsal = kar_nomsal;
    }

    public String getKar_prenomsal() {
        return kar_prenomsal;
    }

    public void setKar_prenomsal(String kar_prenomsal) {
        this.kar_prenomsal = kar_prenomsal;
    }

    public long getKar_anncontrat() {
        return kar_anncontrat;
    }

    public void setKar_anncontrat(long kar_anncontrat) {
        this.kar_anncontrat = kar_anncontrat;
    }

    public LocalDate getKar_datdeb() {
        return kar_datdeb;
    }

    public void setKar_datdeb(LocalDate kar_datdeb) {
        this.kar_datdeb = kar_datdeb;
    }

    public LocalDate getKar_datfin() {
        return kar_datfin;
    }

    public void setKar_datfin(LocalDate kar_datfin) {
        this.kar_datfin = kar_datfin;
    }

    public LocalDate getKar_dtreelprscnss() {
        return kar_dtreelprscnss;
    }

    public void setKar_dtreelprscnss(LocalDate kar_dtreelprscnss) {
        this.kar_dtreelprscnss = kar_dtreelprscnss;
    }

    public long getKar_ann() {
        return kar_ann;
    }

    public void setKar_ann(long kar_ann) {
        this.kar_ann = kar_ann;
    }

    public long getKar_trim() {
        return kar_trim;
    }

    public void setKar_trim(long kar_trim) {
        this.kar_trim = kar_trim;
    }

    public long getCar_saldec() {
        return car_saldec;
    }

    public void setCar_saldec(long car_saldec) {
        this.car_saldec = car_saldec;
    }

    public long getKar_prsmntemp() {
        return kar_prsmntemp;
    }

    public void setKar_prsmntemp(long kar_prsmntemp) {
        this.kar_prsmntemp = kar_prsmntemp;
    }

    public long getKar_prsmntsal() {
        return kar_prsmntsal;
    }

    public void setKar_prsmntsal(long kar_prsmntsal) {
        this.kar_prsmntsal = kar_prsmntsal;
    }

    public long getKar_mnttotprs() {
        return kar_mnttotprs;
    }

    public void setKar_mnttotprs(long kar_mnttotprs) {
        this.kar_mnttotprs = kar_mnttotprs;
    }

    public String getKar_situation() {
        return kar_situation;
    }

    public void setKar_situation(String kar_situation) {
        this.kar_situation = kar_situation;
    }

    public long getKar_debittotemp() {
        return kar_debittotemp;
    }

    public void setKar_debittotemp(long kar_debittotemp) {
        this.kar_debittotemp = kar_debittotemp;
    }

    public long getKar_codexp() {
        return kar_codexp;
    }

    public void setKar_codexp(long kar_codexp) {
        this.kar_codexp = kar_codexp;
    }
}
