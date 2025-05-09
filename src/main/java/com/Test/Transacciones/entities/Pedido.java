package com.Test.Transacciones.entities;

import jakarta.persistence.*;

@Entity
public class Pedido {
    @Id
    @GeneratedValue
    private Long id;
    private String estado;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pago pago;

    public Pedido() {
    }

    public Pedido(Long id, Pago pago, String estado) {
        this.id = id;
        this.pago = pago;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", pago=" + pago +
                '}';
    }
}
