package rest_karama1.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

public interface repository2 extends JpaRepository<dossieravantage, Serializable> {
    @Query(value ="select count(d) from dossieravantage d where d.emp_mat= :numaff1 and d.emp_cle= :numaff2 and d.avn_codav =:codavg")
    long countt(@Param("numaff1")Long numaff1,@Param("numaff2") Long numaff2,@Param("codavg") String codavg);

    @Query(value = "select SYSDATE from dual",nativeQuery = true)
    Date currentdate();

    @Query(value ="select count(d) from dossieravantage d where d.bur_cod= :cod ")
    long countByBur_cod(@Param("cod")long cod);

    @Query(value = "select  d.doa_refdoss from dossieravantage d where d.emp_mat=:numaf ")
    long geterfdoss(@Param("numaf") long numaf);

    @Query(value="select d from dossieravantage d where d.emp_mat=:x1 and d.emp_cle=:x2 ")
    Optional<dossieravantage> search(@Param("x1")long x1 , @Param("x2")long x2);




}
