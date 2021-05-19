package rest_karama1.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface repository4 extends JpaRepository<data_karama, Serializable> {
    @Query(value = "select distinct j from data_karama j where j.numero_affiliation =:numaf and j.cin =:cin and j.type_contrat=:typavg")
    data_karama findbynumaff(@Param("numaf") String numaf, @Param("cin") String cin,@Param("cin") String typavg);

    @Query(value = "select  j from data_karama j where j.ass_exist=1 and j.emp_exist=1 ")
    List<data_karama> findbyavg();

    @Query(value = "select  j from data_karama j where j.bur_cod=:burcod and j.numero_affiliation=:numero_affiliation and j.cin =:cin")
    List<data_karama> findByall(@Param("burcod") long burcod,  @Param("cin") String cin,@Param("numero_affiliation") String numero_affiliation);
    //@Query(value = "select  j from data_karama j where j.bur_cod= ?1 and j.numero_affiliation =?2 and j.cin = ?3")
    //List<data_karama> findByall(long burcod,String numero_affiliation, String cin);

    @Query(value = "select  j from data_karama j where j.type_contrat=:typavg and j.bur_cod=:burcod ")
    List<data_karama> findBy_burcod(@Param("typavg") String typavg,@Param("burcod") long burcod);

    @Query(value = "select  j from data_karama j where j.type_contrat=:typavg and j.bur_cod=:burcod and j.cin =:cin  or j.numero_affiliation=:cin" )
    List<data_karama> findBy_burcod_cin(@Param("typavg") String typavg,@Param("burcod") long burcod, @Param("cin") String cin);

    @Query(value = "select  j from data_karama j where j.bur_cod=:burcod and (j.numero_affiliation =:numero_affiliation or j.cin=:cin)")
    List<data_karama> findBy_burcod_numaff(@Param("burcod") long burcod, @Param("numero_affiliation")String numero_affiliation, @Param("cin") String cin);

    //@Query(value = "select  j from data_karama j where j.bur_cod= ?1 and j.numero_affiliation =?2 ")
   // List<data_karama> findBy_burcod_numaff(long burcod, String numero_affiliation);

    @Query(value = "select distinct j from data_karama j where j.numero_affiliation =:numaf and j.cin =:cin and j.type_contrat=:code")
    Optional<data_karama> findbycin(@Param("numaf") String numaf, @Param("cin") String cin,@Param("code") String code);

    @Query(value = "select distinct j from data_karama j where j.emp_exist=2 or j.ass_exist=2")
    List<data_karama> findfaulty();

    @Query(value = "select distinct j from data_karama j where j.ass_exist is null and j.type_contrat='STARTUP-ACT'")
    List<data_karama> findnotyetregistered();

    @Query(value = " select count(j) from data_karama j where j.type_contrat =:avg ")
    long count1(@Param("avg") String avg);

    @Query(value = " select count(j) from data_karama j where  j.ass_exist=1 ")
    long count2();
    @Query(value = " select count(j) from data_karama j where j.ass_exist is null ")
    long count21();
    @Query(value = " select count(j) from data_karama j where j.emp_exist=2 or j.ass_exist=2 ")
    long count22();

    @Query(value = " select count(j) from data_karama j where j.type_contrat =:avg and j.genre=:genre")
    long countsex(@Param("avg") String avg,@Param("genre") String genre);
    @Query(value = "select count(b) from data_karama b where b.local_date=:dat" )
    long countbydate(@Param("dat") LocalDate dat);

    @Query(value = "select count(b) from data_karama b where b.type_contrat=:avg and b.local_date<=:dat2" )
    long countbetweendate(@Param("avg") String avg,@Param("dat2") LocalDate dat2);


}