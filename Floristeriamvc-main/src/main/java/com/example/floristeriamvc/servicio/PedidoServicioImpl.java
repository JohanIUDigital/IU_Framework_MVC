package com.example.floristeriamvc.servicio;



import com.example.floristeriamvc.modelo.Pedido;
import com.example.floristeriamvc.repositorio.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServicioImpl implements PedidoServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepositorio.findAll();
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepositorio.save(pedido);
    }

    @Override
    public Pedido obtenerPedidoPorId(Long id) {
        return pedidoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Pedido actualizarPedido(Long id, Pedido pedido) {
        Pedido pedidoExistente = obtenerPedidoPorId(id);
        if (pedidoExistente != null) {
            pedidoExistente.setClienteNombre(pedido.getClienteNombre());
            pedidoExistente.setClienteDireccion(pedido.getClienteDireccion());
            pedidoExistente.setClienteContacto(pedido.getClienteContacto());
            pedidoExistente.setTipoArreglo(pedido.getTipoArreglo());
            pedidoExistente.setOcasion(pedido.getOcasion());
            pedidoExistente.setFechaEntrega(pedido.getFechaEntrega());
            pedidoExistente.setPresupuesto(pedido.getPresupuesto());
            pedidoExistente.setEstado(pedido.getEstado());
            return pedidoRepositorio.save(pedidoExistente);
        }
        return null;
    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoRepositorio.deleteById(id);
    }
}
