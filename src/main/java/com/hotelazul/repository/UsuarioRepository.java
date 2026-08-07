package com.hotelazul.repository;

import com.hotelazul.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Optional<Usuario> findByCorreo(String correo);
    List<Usuario> findByNombresContainingIgnoreCase(String nombres);

    List<Usuario> findByCorreoContainingIgnoreCase(String correo);
}
