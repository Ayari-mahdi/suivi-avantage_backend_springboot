package rest_karama1.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface repository3 extends JpaRepository<employeur,Long> {
    @Query(value ="select e.bur_cod from employeur e where e.emp_mat=:numaf")
    Optional<Long> brcod(@Param("numaf")long numaf);




}
