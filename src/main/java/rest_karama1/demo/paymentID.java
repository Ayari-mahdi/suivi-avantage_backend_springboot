package rest_karama1.demo;


import java.io.Serializable;

public class paymentID implements Serializable {
    private long numemp;
    private long cleemp;
    private long numass;
    private long cleass;
    private char trim;

    public paymentID(long numemp, long cleemp, long numass, long cleass, char trim) {
        this.numemp = numemp;
        this.cleemp = cleemp;
        this.numass = numass;
        this.cleass = cleass;
        this.trim = trim;
    }
}
