package com.example.floristeriamvc.controlador;

import com.example.floristeriamvc.modelo.Pedido;
import com.example.floristeriamvc.servicio.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoControlador {

    @Autowired
    private PedidoServicio pedidoServicio;

    // Listar pedidos
    @GetMapping
    public String listarPedidos(Model model) {
        List<Pedido> pedidos = pedidoServicio.obtenerTodosLosPedidos();
        model.addAttribute("pedidos", pedidos);
        return "pedidos"; // Nombre de la plantilla para listar pedidos
    }

    // Mostrar formulario para crear un nuevo pedido
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoPedido(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "nuevoPedido"; // Nombre de la plantilla para crear un nuevo pedido
    }

    // Crear un nuevo pedido
    @PostMapping
    public String crearPedido(@ModelAttribute Pedido pedido) {
        pedidoServicio.crearPedido(pedido);
        return "redirect:/pedidos"; // Redirigir a la lista de pedidos después de crear
    }

    // Mostrar formulario para editar un pedido existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoServicio.obtenerPedidoPorId(id);
        if (pedido != null) {
            model.addAttribute("pedido", pedido);
            return "editarPedido"; // Nombre de la plantilla para editar un pedido
        } else {
            return "redirect:/pedidos"; // Redirigir si no se encuentra el pedido
        }
    }

    // Guardar cambios de edición
    @PostMapping("/editar/{id}")
    public String editarPedido(@PathVariable Long id, @ModelAttribute Pedido pedidoActualizado) {
        pedidoServicio.actualizarPedido(id, pedidoActualizado);
        return "redirect:/pedidos"; // Redirigir a la lista de pedidos después de editar
    }

    // Eliminar un pedido
    @GetMapping("/eliminar/{id}")
    public String eliminarPedido(@PathVariable Long id) {
        pedidoServicio.eliminarPedido(id);
        return "redirect:/pedidos"; // Redirigir a la lista de pedidos después de eliminar
    }

    @GetMapping("/{id}")
public String consultarPedido(@PathVariable Long id, Model model) {
    Pedido pedido = pedidoServicio.obtenerPedidoPorId(id);
    if (pedido != null) {
        model.addAttribute("pedido", pedido);
        return "detallePedido"; // nombre de la plantilla que muestra los detalles del pedido
    } else {
        return "redirect:/pedidos"; // redirigir si no se encuentra el pedido
    }
}
}