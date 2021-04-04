package rest_karama1.demo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "ws_aneti")
public class fake_karama {
    @Id
    @Column(name="number_Columns")
    private long numberColumns;
    @Column(name="number_Lines")
    private long numberLines;
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "ws_aneti_id",referencedColumnName = "number_Columns")
    List<data_karama> dataset2 = new ArrayList<>();
    //ArrayList<ArrayList<Object>> dataset2 = new ArrayList<>() ;

    public fake_karama() {

    }
    //private List<data_karama> dataset2 = new ArrayList<>();




    public long getNumberLines() {
        return numberLines;
    }

    public void setNumberLines(long numberLines) {
        this.numberLines = numberLines;
    }

    public long getNumberColumns() {
        return numberColumns;
    }

    public void setNumberColumns(long numberColumns) {
        this.numberColumns = numberColumns;
    }

    public List<data_karama> getDataset2() {
        return dataset2;
    }

    public void setDataset2(List<data_karama> dataset2) {
        this.dataset2 = dataset2;
    }

    @Override
    public String toString() {
        return "fake_karama{" +

                ", numberLines=" + numberLines +
                ", numberColumns=" + numberColumns +
                ", dataset2=" + dataset2 +
                '}';
    }

    public fake_karama(long numberColumns, long numberLines, List<data_karama> dataset2) {

        this.numberColumns = numberColumns;
        this.numberLines = numberLines;
        this.dataset2 = dataset2;
    }
}
