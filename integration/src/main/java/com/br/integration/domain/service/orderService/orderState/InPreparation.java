package com.br.integration.domain.service.orderService.orderState;

import com.br.integration.domain.entites.Order;

public class InPreparation implements OrderState {

    @Override
    public void inPreparation(Order order) {
        throw new IllegalStateException("Pedido já está em preparação.");
    }

    @Override
    public void forDelivery(Order order) {
        order.setStatus("FORDELIVERY");
        order.setState(new ForDelivery());
        System.out.println("Pedido #" + order.getId() + " está em entrega.");
    }

    @Override
    public void received(Order order) {
        throw new IllegalStateException("Pedido não pode ser recebido enquanto estiver em preparação.");
    }
}
