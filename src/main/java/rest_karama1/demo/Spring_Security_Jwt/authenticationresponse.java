package rest_karama1.demo.Spring_Security_Jwt;

public class authenticationresponse {
    private final String jwt;

    public authenticationresponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
