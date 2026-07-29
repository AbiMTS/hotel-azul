package com.hotelazul.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "habitaciones")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(nullable = false)
    private Integer piso;

    @Column(nullable = false)
    private BigDecimal precio;

    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "tipo_habitacion_id")
    private TipoHabitacion tipoHabitacion;

    public Habitacion() {
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public Integer getPiso() {
        return piso;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
}
