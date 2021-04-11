package rest_karama1.demo.Spring_Security_Jwt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CNSS_agents_repo extends JpaRepository<CNSS_agents,Long> {
     Optional<CNSS_agents> findByUserName(String userName);

    @Query(value="select e from CNSS_agents e where e.userName= ?1 ")
    Optional<CNSS_agents> findbyUserName(String userName);


}
