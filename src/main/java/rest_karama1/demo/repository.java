package rest_karama1.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.Optional;

public interface repository extends JpaRepository<fake_karama, Serializable> {


}
