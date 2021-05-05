package rest_karama1.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Complaintrepo extends JpaRepository<Complaints,String> {

    @Query(value = "select max(b.id) from test_compaints b" )
    long selectmaxid();
}
