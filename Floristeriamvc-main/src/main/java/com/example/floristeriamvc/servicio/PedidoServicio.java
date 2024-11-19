package com.example.floristeriamvc.servicio;


import com.example.floristeriamvc.modelo.Pedido;

import java.util.List;

public interface PedidoServicio {
    List<Pedido> obtenerTodosLosPedidos();
    Pedido crearPedido(Pedido pedido);
    Pedido obtenerPedidoPorId(Long id);
    Pedido actualizarPedido(Long id, Pedido pedido);
    void eliminarPedido(Long id);
}
