package rest_karama1.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "test_compaints")
public class Complaints {
    @Id
    private long id;
    private String name;
    private String email;
    private String typeofproblem;
    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeofproblem() {
        return typeofproblem;
    }

    public void setTypeofproblem(String typeofproblem) {
        this.typeofproblem = typeofproblem;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
