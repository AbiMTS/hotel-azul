package com.hotelazul.repository;
import com.hotelazul.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    List<Reserva> findByHuesped_NombresContainingIgnoreCase(String nombres);

    List<Reserva> findByHabitacion_NumeroContainingIgnoreCase(String numero);


}
