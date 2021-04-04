package rest_karama1.demo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="bureau")
public class bureau {
    @Id
    @Column(name="bur_cod")
    private long bur_cod;
    @Column(name = "bur_intit")
    private String bur_intit;

    public String getBur_intit() {
        return bur_intit;
    }

    public void setBur_intit(String bur_intit) {
        this.bur_intit = bur_intit;
    }

    public long getBur_cod() {
        return bur_cod;
    }

    public void setBur_cod(long bur_cod) {
        this.bur_cod = bur_cod;
    }
}

