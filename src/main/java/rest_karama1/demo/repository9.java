package rest_karama1.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface repository9 extends JpaRepository<ws_aneti_historique,String> {

    @Query(value = "select b from ws_aneti_historique b where b.id=:id" )
   ws_aneti_historique search_histo_id(@Param("id") long id);

    @Query(value = "select max(b.id) from ws_aneti_historique b " )
     long selectmaxid();

    @Query(value = "select b from ws_aneti_historique b where b.id=(select max(b.id) from ws_aneti_historique b where b.type_contrat=:avg) ")
    ws_aneti_historique selectfirst(@Param("avg")String avg);

    @Query(value = "select b from ws_aneti_historique b where b.id=(select max(b.id) from ws_aneti_historique b where b.type_contrat=:avg and b.id<:val) ")
     Optional<ws_aneti_historique> selectrest(@Param("avg")String avg,@Param("val") long val);



     List<ws_aneti_historique> findAllByOrderByIdAsc();


}
