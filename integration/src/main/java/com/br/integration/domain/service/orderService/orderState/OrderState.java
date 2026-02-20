package com.br.integration.domain.service.orderService.orderState;

import com.br.integration.domain.entites.Order;

public interface OrderState {
    void inPreparation(Order order);
    void forDelivery(Order order);
    void received(Order order);
}
