package rest_karama1.demo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface repository5 extends JpaRepository<beneficiaire, Long> {
    @Query(value = "select b from beneficiaire b where b.ben_numid=:cin and b.ben_typid=0" )
    List<Optional<beneficiaire>> search_ben(@Param("cin") String cin);

}
