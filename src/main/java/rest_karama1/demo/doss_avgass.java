package rest_karama1.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "test_doss_avgass")
public class doss_avgass {
    @Id
    @Column(name = "ass_mat")
    private long ass_mat;
    @Column(name = "ass_cle")
    private long ass_cle;
    @Column(name = "emp_mat")
    private long emp_mat;
    @Column(name = "emp_cle")
    private long emp_cle;
    @Column(name ="bur_cod")
    private long bur_cod;
    @Column(name = "doa_refdos")
    private long doa_refdos;
    @Column(name = "daa_dtdeb")
    private Date daa_dtdeb;
    @Column(name = "daa_dtfin")
    private Date daa_dtfin;
    @Column(name = "daa_cin")
    private long daa_cin;
    @Column(name = "daa_dtsais")
    private LocalDate daa_dtsais;
    @Column(name = "daa_numref")
    private String daa_numref;
    @Column(name = "daa_nom")
    private String daa_nom;
    @Column(name = "daa_prenom")
    private String daa_prenom;
    @Column(name = "daa_inforef")
    private String daa_inforef;
    @Column(name = "daa_agent")
    private Long daa_agent;
    @Column(name = "daa_salaire")
    private long daa_salaire;
    @Column(name = "daa_dtrec")
    private Date daa_dtrec;
    @Column(name = "daa_flgper")
    private long daa_flgper;
    @Column(name = "daa_dtdep")
    private Date daa_dtdep;

    public doss_avgass() {
    }

    public long getAss_mat() {
        return ass_mat;
    }

    public void setAss_mat(long ass_mat) {
        this.ass_mat = ass_mat;
    }

    public long getAss_cle() {
        return ass_cle;
    }

    public void setAss_cle(long ass_cle) {
        this.ass_cle = ass_cle;
    }

    public long getEmp_mat() {
        return emp_mat;
    }

    public void setEmp_mat(long emp_mat) {
        this.emp_mat = emp_mat;
    }

    public long getEmp_cle() {
        return emp_cle;
    }

    public void setEmp_cle(long emp_cle) {
        this.emp_cle = emp_cle;
    }

    public long getBur_cod() {
        return bur_cod;
    }

    public void setBur_cod(long bur_cod) {
        this.bur_cod = bur_cod;
    }

    public long getDoa_refdos() {
        return doa_refdos;
    }

    public void setDoa_refdos(long doa_refdos) {
        this.doa_refdos = doa_refdos;
    }

    public Date getDaa_dtdeb() {
        return daa_dtdeb;
    }

    public void setDaa_dtdeb(Date daa_dtdeb) {
        this.daa_dtdeb = daa_dtdeb;
    }

    public Date getDaa_dtfin() {
        return daa_dtfin;
    }

    public void setDaa_dtfin(Date daa_dtfin) {
        this.daa_dtfin = daa_dtfin;
    }

    public long getDaa_cin() {
        return daa_cin;
    }

    public void setDaa_cin(long daa_cin) {
        this.daa_cin = daa_cin;
    }

    public LocalDate getDaa_dtsais() {
        return daa_dtsais;
    }

    public void setDaa_dtsais(LocalDate daa_dtsais) {
        this.daa_dtsais = daa_dtsais;
    }

    public String getDaa_numref() {
        return daa_numref;
    }

    public void setDaa_numref(String daa_numref) {
        this.daa_numref = daa_numref;
    }

    public String getDaa_nom() {
        return daa_nom;
    }

    public void setDaa_nom(String daa_nom) {
        this.daa_nom = daa_nom;
    }

    public String getDaa_prenom() {
        return daa_prenom;
    }

    public void setDaa_prenom(String daa_prenom) {
        this.daa_prenom = daa_prenom;
    }

    public String getDaa_inforef() {
        return daa_inforef;
    }

    public void setDaa_inforef(String daa_inforef) {
        this.daa_inforef = daa_inforef;
    }

    public Long getDaa_agent() {
        return daa_agent;
    }

    public void setDaa_agent(Long daa_agent) {
        this.daa_agent = daa_agent;
    }

    public long getDaa_salaire() {
        return daa_salaire;
    }

    public void setDaa_salaire(long daa_salaire) {
        this.daa_salaire = daa_salaire;
    }

    public Date getDaa_dtrec() {
        return daa_dtrec;
    }

    public void setDaa_dtrec(Date daa_dtrec) {
        this.daa_dtrec = daa_dtrec;
    }

    public long getDaa_flgper() {
        return daa_flgper;
    }

    public void setDaa_flgper(long daa_flgper) {
        this.daa_flgper = daa_flgper;
    }

    public Date getDaa_dtdep() {
        return daa_dtdep;
    }

    public void setDaa_dtdep(Date daa_dtdep) {
        this.daa_dtdep = daa_dtdep;
    }
}
