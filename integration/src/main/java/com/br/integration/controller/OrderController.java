package com.br.integration.controller;

import com.br.integration.domain.service.orderService.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Pedido", description = "Consultar pedidos, status e atualizar entrega")
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Listar meus pedidos", description = "Retorna todos os pedidos do usuário autenticado")
    @GetMapping
    public ResponseEntity<?> getMyOrders() {
        return ResponseEntity.ok(orderService.getMyOrders());
    }

    @Operation(summary = "Status do pedido", description = "Retorna o status de um pedido pelo ID")
    @GetMapping("/{id}/status")
    public ResponseEntity<?> getStatus(@Parameter(description = "ID do pedido") @PathVariable Long id) {
        return ResponseEntity.ok(orderService.getStatus(id));
    }

    @Operation(summary = "Marcar em entrega", description = "Atualiza o pedido para status 'em entrega'")
    @PutMapping("/{id}/delivery")
    public ResponseEntity<?> updateToDelivery(@Parameter(description = "ID do pedido") @PathVariable Long id) {
        orderService.updateToDelivery(id);
        return ResponseEntity.ok("O pedido de numero " + id + " já está a caminho para entrega.");
    }

    @Operation(summary = "Marcar como entregue", description = "Atualiza o pedido para status 'entregue'")
    @PutMapping("/{id}/received")
    public ResponseEntity<?> updateToReceived(@Parameter(description = "ID do pedido") @PathVariable Long id) {
        orderService.updateToReceived(id);
        return ResponseEntity.ok("O pedido de numero " + id + " foi entregue.");
    }
}
