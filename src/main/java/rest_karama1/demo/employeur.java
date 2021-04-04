package rest_karama1.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "employeur")
public class employeur {
    @Id
    @Column(name = "emp_mat")
    private long emp_mat;
    @Column(name = "emp_cle")
    private long emp_cle;
    @Column(name = "bur_cod")
    private long bur_cod;

    public employeur() {
    }

    public long getEmp_mat() {
        return emp_mat;
    }

    public long getEmp_cle() {
        return emp_cle;
    }

    public long getBur_cod() {
        return bur_cod;
    }


}
