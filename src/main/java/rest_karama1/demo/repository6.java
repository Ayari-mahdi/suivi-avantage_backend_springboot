package rest_karama1.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

public interface repository6 extends JpaRepository<doss_avgass, Serializable> {
    @Query(value = "select count(d) from doss_avgass d where d.ass_mat=:mat" )
    long search_dossavgass(@Param("mat") long mat);

    @Query(value="select d from doss_avgass d where d.emp_mat=:x1 and d.emp_cle=:x2 ")
    List<doss_avgass> search2(@Param("x1")long x1 , @Param("x2")long x2);
}
