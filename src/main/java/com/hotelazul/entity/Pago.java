package com.hotelazul.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(nullable = false)
    private BigDecimal monto;

    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    public Pago() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
