package rest_karama1.demo.Spring_Security_Jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class myUserDetailsService implements UserDetailsService {

    @Autowired
    CNSS_agents_repo cnss_agents_repo;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
     //  return new User("foo","foo",new ArrayList<>());
       Optional<CNSS_agents> CNSS_agent = cnss_agents_repo.findByUserName(userName);

       CNSS_agent.orElseThrow(()-> new UsernameNotFoundException("Not found" + userName));
//return new User("foo","foo",new ArrayList<>());
       return CNSS_agent.map(MyUserDetails::new).get();
    }
}
