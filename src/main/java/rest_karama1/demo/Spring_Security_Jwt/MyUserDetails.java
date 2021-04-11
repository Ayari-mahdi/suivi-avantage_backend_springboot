package rest_karama1.demo.Spring_Security_Jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {
    private String userName;
    private String password;
  //  private boolean active;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(CNSS_agents CNSS_AGENT) {
        this.userName = CNSS_AGENT.getUsername();
        this.password = CNSS_AGENT.getPassword();
        ///this.active = CNSS_AGENT.isActive();
        this.authorities = Arrays.stream(CNSS_AGENT.getRoles().split(","))
              .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
