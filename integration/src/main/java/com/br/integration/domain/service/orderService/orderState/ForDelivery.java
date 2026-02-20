package com.br.integration.domain.service.orderService.orderState;

import com.br.integration.domain.entites.Order;

public class ForDelivery implements OrderState {

    @Override
    public void inPreparation(Order order) {
        throw new IllegalStateException("Pedido não pode voltar para preparação.");
    }

    @Override
    public void forDelivery(Order order) {
        throw new IllegalStateException("Pedido já está em entrega.");
    }

    @Override
    public void received(Order order) {
        order.setStatus("RECEIVED");
        order.setState(new Received());
        System.out.println("Pedido #" + order.getId() + " foi entregue.");
    }
}
