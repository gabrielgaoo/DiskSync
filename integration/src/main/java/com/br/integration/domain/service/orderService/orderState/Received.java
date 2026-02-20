package com.br.integration.domain.service.orderService.orderState;

import com.br.integration.domain.entites.Order;

public class Received implements OrderState {

    @Override
    public void inPreparation(Order order) {
        throw new IllegalStateException("Pedido já foi finalizado.");
    }

    @Override
    public void forDelivery(Order order) {
        throw new IllegalStateException("Pedido não pode ser enviado novamente, já foi recebido.");
    }

    @Override
    public void received(Order order) {
        throw new IllegalStateException("Pedido já está marcado como recebido.");
    }
}
