package rest_karama1.demo;

import javax.persistence.*;

@Entity
@Table(name = "test_aneti_avg")
public class aneti_avg {
    @Id
    @Column(name = "code")
    private  String code;
    @Column(name = "lib")
    private String lib;
    @Column(name = "avn_codav")
    private String avn_codav;

    public aneti_avg() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public String getAvn_codav() {
        return avn_codav;
    }

    public void setAvn_codav(String avn_codav) {
        this.avn_codav = avn_codav;
    }
}
