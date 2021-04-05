package rest_karama1.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface repository10 extends JpaRepository<facturation,Long> {
    @Query(value="select d from facturation d where d.kar_numemp=:numemp ")
    Optional<facturation> search(@Param("x1")long numemp );
}
