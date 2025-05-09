package com.Test.Transacciones.services;

import com.Test.Transacciones.Repositories.PagoRepository;
import com.Test.Transacciones.Repositories.PedidoRepository;
import com.Test.Transacciones.entities.Pago;
import com.Test.Transacciones.entities.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagoRepository pagoRepository;

    @Transactional
    public void confirmarPedido(Long pedidoId, Double monto) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        if (!"PENDIENTE".equals(pedido.getEstado())) {
            throw new RuntimeException("El pedido ya fue procesado");
        }

        pedido.setEstado("CONFIRMADO");
        Pago pago = new Pago();
        pago.setMonto(monto);
        pago.setPedido(pedido);

        pedidoRepository.save(pedido);
        pagoRepository.save(pago);
    }
}
