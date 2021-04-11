package rest_karama1.demo;

import javax.persistence.Column;
import java.io.Serializable;

public class facturationID implements Serializable {
    @Column(name="kar_numemp")
    private Long kar_numemp;
    @Column(name="kar_matass")
    private Long kar_matass;
    @Column(name = "kar_cin")
    private String Kar_cin;
    @Column(name = "kar_nomsal")
    private String kar_nomsal;
    @Column(name = "kar_prenomsal")
    private String kar_prenomsal;
    @Column(name = "kar_ann")
    private Long kar_ann;
    @Column(name = "kar_trim")
    private Long kar_trim;

    public facturationID(Long kar_numemp, Long kar_matass, String kar_cin, String kar_nomsal, String kar_prenomsal, Long kar_ann, Long kar_trim) {
        this.kar_numemp = kar_numemp;
        this.kar_matass = kar_matass;
        Kar_cin = kar_cin;
        this.kar_nomsal = kar_nomsal;
        this.kar_prenomsal = kar_prenomsal;
        this.kar_ann = kar_ann;
        this.kar_trim = kar_trim;
    }

    public facturationID(){
    }
}
