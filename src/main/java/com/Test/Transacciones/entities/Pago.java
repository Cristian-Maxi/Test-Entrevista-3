package com.Test.Transacciones.entities;

import jakarta.persistence.*;

@Entity
public class Pago {
    @Id
    @GeneratedValue
    private Long id;
    private Double monto;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Pago() {
    }

    public Pago(Long id, Double monto, Pedido pedido) {
        this.id = id;
        this.monto = monto;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", monto=" + monto +
                ", pedido=" + pedido +
                '}';
    }
}