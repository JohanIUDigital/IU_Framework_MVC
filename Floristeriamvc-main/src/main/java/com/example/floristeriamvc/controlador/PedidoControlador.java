package com.example.floristeriamvc.controlador;

import com.example.floristeriamvc.modelo.Pedido;
import com.example.floristeriamvc.servicio.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/index")
public class PedidoControlador {

    @Autowired
    private PedidoServicio pedidoServicio;

    // Listar pedidos
    @GetMapping
    public String listarPedidos(Model model) {
        List<Pedido> pedidos = pedidoServicio.obtenerTodosLosPedidos();
        model.addAttribute("index", pedidos);
        return "index"; // Nombre de la plantilla para listar pedidos
    }
}