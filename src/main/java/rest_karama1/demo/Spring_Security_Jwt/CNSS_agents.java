package rest_karama1.demo.Spring_Security_Jwt;

import javax.persistence.*;

@Entity
@Table(name ="TEST_CNSS_agents")
public class CNSS_agents {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;
    private String userName;
    private String password;
    private String roles;
    private Long active;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Long isActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }
}
