package rest_karama1.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="testcomplaints")
public class Complaints {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "empname")
    private String name;
    @Column(name = "empemail")
    private String email;
    @Column(name = "typeofproblem")
    private String typeofproblem;
    @Column(name = "commentproblem")
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
