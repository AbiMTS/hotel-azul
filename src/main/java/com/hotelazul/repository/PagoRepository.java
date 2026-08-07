package com.hotelazul.repository;

import com.hotelazul.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long>{
    List<Pago> findByMetodoPagoContainingIgnoreCase(String metodoPago);

    List<Pago> findByReserva_Id(Long id);

}
