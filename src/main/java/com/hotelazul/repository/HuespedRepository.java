package com.hotelazul.repository;
import com.hotelazul.entity.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, Long>{
    List<Huesped> findByDniContaining(String dni);

    List<Huesped> findByNombresContainingIgnoreCase(String nombres);

    List<Huesped> findByApellidosContainingIgnoreCase(String apellidos);

}
