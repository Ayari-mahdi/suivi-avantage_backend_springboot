package rest_karama1.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface repository4 extends JpaRepository<data_karama, Serializable> {
    @Query(value = "select distinct j from data_karama j where j.numero_affiliation =:numaf and j.cin =:cin")
    data_karama findbynumaff(@Param("numaf") String numaf, @Param("cin") String cin);


    @Query(value = "select  j from data_karama j where j.bur_cod=:burcod and j.numero_affiliation=:numero_affiliation and j.cin =:cin")
    List<data_karama> findByall(@Param("burcod") long burcod,  @Param("cin") String cin,@Param("numero_affiliation") String numero_affiliation);
    //@Query(value = "select  j from data_karama j where j.bur_cod= ?1 and j.numero_affiliation =?2 and j.cin = ?3")
    //List<data_karama> findByall(long burcod,String numero_affiliation, String cin);

    @Query(value = "select  j from data_karama j where j.bur_cod=:burcod ")
    List<data_karama> findBy_burcod(@Param("burcod") long burcod);

    @Query(value = "select  j from data_karama j where j.bur_cod=:burcod and j.cin =:cin")
    List<data_karama> findBy_burcod_cin(@Param("burcod") long burcod, @Param("cin") String cin);

    @Query(value = "select  j from data_karama j where j.bur_cod=:burcod and (j.numero_affiliation =:numero_affiliation or j.cin=:cin)")
    List<data_karama> findBy_burcod_numaff(@Param("burcod") long burcod, @Param("numero_affiliation")String numero_affiliation, @Param("cin") String cin);

    //@Query(value = "select  j from data_karama j where j.bur_cod= ?1 and j.numero_affiliation =?2 ")
   // List<data_karama> findBy_burcod_numaff(long burcod, String numero_affiliation);

    @Query(value = "select distinct j from data_karama j where j.numero_affiliation =:numaf and j.cin =:cin and j.type_contrat=:code")
    Optional<data_karama> findbycin(@Param("numaf") String numaf, @Param("cin") String cin,@Param("code") String code);


}