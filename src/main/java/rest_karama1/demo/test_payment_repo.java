package rest_karama1.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Optional;

public interface test_payment_repo extends JpaRepository<payment,Long> {
    @Query(value="select d from payment d where d.numemp=:x1 and d.cleemp=:x2 and d.trim=:trim and d.year=:year and d.avg=:avg ")
    Optional<List<payment>> searchemp(@Param("x1")long x1 , @Param("x2")long x2, @Param("trim") char trim, @Param("year")String year, @Param("avg")String avg);
}
