package rest_karama1.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface repository9 extends JpaRepository<ws_aneti_historique,String> {

    @Query(value = "select b from ws_aneti_historique b where b.id=:id" )
   ws_aneti_historique search_histo_id(@Param("id") long id);

    public List<ws_aneti_historique> findAllByOrderByIdAsc();
}
