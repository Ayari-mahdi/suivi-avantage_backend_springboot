package rest_karama1.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beneficiaire")
public class beneficiaire {
    @Id
    @Column(name = "ass_mat")
    private long ass_mat;
    @Column(name = "ass_cle")
    private long ass_cle;
    @Column(name = "ben_nom")
    private String ben_nom;
    @Column(name = "ben_prenom")
    private String ben_prenom;
    @Column(name = "ben_typid")
    private long ben_typid;
    @Column(name = "ben_numid")
    private String ben_numid;

    public beneficiaire(long ass_mat, long ass_cle, String ben_nom, String ben_prenom, long ben_typid, String ben_numid) {
        this.ass_mat = ass_mat;
        this.ass_cle = ass_cle;
        this.ben_nom = ben_nom;
        this.ben_prenom = ben_prenom;
        this.ben_typid = ben_typid;
        this.ben_numid = ben_numid;
    }

    public beneficiaire() {

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

    public String getBen_nom() {
        return ben_nom;
    }

    public void setBen_nom(String ben_nom) {
        this.ben_nom = ben_nom;
    }

    public String getBen_prenom() {
        return ben_prenom;
    }

    public void setBen_prenom(String ben_prenom) {
        this.ben_prenom = ben_prenom;
    }

    public long getBen_typid() {
        return ben_typid;
    }

    public void setBen_typid(long ben_typid) {
        this.ben_typid = ben_typid;
    }

    public String getBen_numid() {
        return ben_numid;
    }

    public void setBen_numid(String ben_numid) {
        this.ben_numid = ben_numid;
    }
}
