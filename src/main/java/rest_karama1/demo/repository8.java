package rest_karama1.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface repository8 extends JpaRepository<aneti_avg,String> {
    @Query(value = "select a from aneti_avg a where a.code=:code " )
     aneti_avg codavn(@Param("code") String code);

}
