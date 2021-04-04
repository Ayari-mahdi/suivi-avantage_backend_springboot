package rest_karama1.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="test_dossieravantage")
public class dossieravantage {
    @Id
    @Column(name = "emp_mat")
    private long emp_mat;
    @Column(name = "emp_cle")
    private long emp_cle;
    @Column(name = "bur_cod")
    private long bur_cod;
    @Column(name = "doa_refdoss")
    private long doa_refdoss;
    @Column(name = "avn_codav" ,length = 13)
    private String avn_codav;
    @Column(name = "doa_dtedep")
    private LocalDate doa_dtedep;
    @Column(name = "doa_dtedeb")
    private Date doa_dtedeb;
    @Column(name = "doa_dtefin")
    private Date doa_dtefin;
    @Column(name = "doa_obs")
    private String doa_obs;
    @Column(name = "doa_dtedition")
    private Date doa_dtedition;
    @Column(name = "doa_agent")
    private Long doa_agent;
    @Column(name = "doa_reference")
    private String doa_reference;
    @Column(name = "doa_libreference")
    private String doa_libreference;
    @Column(name = "doa_dersit")
    private Long doa_dersit;
    @Column(name = "doa_dtdersit")
    private LocalDate doa_dtdresit;
    @Column(name = "doa_dtrapp")
    private Date doa_dtrapp;
    @Column(name = "doa_dtaccdoss")
    private Date doa_dtaccdoss;
    @Column(name = "doa_reffisc")
    private String doa_reffisc;
    @Column(name = "doa_dtreffisc")
    private Date doa_dtreffisc;


    public dossieravantage() {
    }

    public Long getDoa_agent() {
        return doa_agent;
    }

    public void setDoa_agent(Long doa_agent) {
        this.doa_agent = doa_agent;
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

    public long getDoa_refdoss() {
        return doa_refdoss;
    }

    public void setDoa_refdoss(long doa_refdoss) {
        this.doa_refdoss = doa_refdoss;
    }

    public String getAvn_codav() {
        return avn_codav;
    }

    public void setAvn_codav(String avn_codav) {
        this.avn_codav = avn_codav;
    }

    public LocalDate getDoa_dtedep() {
        return doa_dtedep;
    }

    public void setDoa_dtedep(LocalDate doa_dtedep) {
        this.doa_dtedep = doa_dtedep;
    }

    public Date getDoa_dtedeb() {
        return doa_dtedeb;
    }

    public void setDoa_dtedeb(Date doa_dtedeb) {
        this.doa_dtedeb = doa_dtedeb;
    }

    public Date getDoa_dtefin() {
        return doa_dtefin;
    }

    public void setDoa_dtefin(Date doa_dtefin) {
        this.doa_dtefin = doa_dtefin;
    }

    public String getDoa_obs() {
        return doa_obs;
    }

    public void setDoa_obs(String doa_obs) {
        this.doa_obs = doa_obs;
    }

    public Date getDoa_dtedition() {
        return doa_dtedition;
    }

    public void setDoa_dtedition(Date doa_dtedition) {
        this.doa_dtedition = doa_dtedition;
    }



    public String getDoa_reference() {
        return doa_reference;
    }

    public void setDoa_reference(String doa_reference) {
        this.doa_reference = doa_reference;
    }

    public String getDoa_libreference() {
        return doa_libreference;
    }

    public void setDoa_libreference(String doa_libreference) {
        this.doa_libreference = doa_libreference;
    }

    public Long getDoa_dersit() {
        return doa_dersit;
    }

    public void setDoa_dersit(Long doa_dersit) {
        this.doa_dersit = doa_dersit;
    }

    public LocalDate getDoa_dtdresit() {
        return doa_dtdresit;
    }

    public void setDoa_dtdresit(LocalDate doa_dtdresit) {
        this.doa_dtdresit = doa_dtdresit;
    }

    public Date getDoa_dtrapp() {
        return doa_dtrapp;
    }

    public void setDoa_dtrapp(Date doa_dtrapp) {
        this.doa_dtrapp = doa_dtrapp;
    }

    public Date getDoa_dtaccdoss() {
        return doa_dtaccdoss;
    }

    public void setDoa_dtaccdoss(Date doa_dtaccdoss) {
        this.doa_dtaccdoss = doa_dtaccdoss;
    }

    public String getDoa_reffisc() {
        return doa_reffisc;
    }

    public void setDoa_reffisc(String doa_reffisc) {
        this.doa_reffisc = doa_reffisc;
    }

    public Date getDoa_dtreffisc() {
        return doa_dtreffisc;
    }

    public void setDoa_dtreffisc(Date doa_dtreffisc) {
        this.doa_dtreffisc = doa_dtreffisc;
    }


}
