package com.example.floristeriamvc.controlador;

import com.example.floristeriamvc.modelo.Flor;
import com.example.floristeriamvc.servicio.FlorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/flores")
public class FlorControlador {

    @Autowired
    private FlorServicio florServicio;

    // Listar flores
    @GetMapping
    public String listarFlores(Model model) {
        List<Flor> flores = florServicio.obtenerTodasLasFlores();
        model.addAttribute("flores", flores);
        return "flores";
    }

    // Mostrar formulario de nueva flor
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaFlor(Model model) {
        model.addAttribute("flor", new Flor());
        return "nuevaFlor";
    }

    // Crear nueva flor
    @PostMapping
    public String crearFlor(@ModelAttribute Flor flor) {
        florServicio.crearFlor(flor);
        return "redirect:/flores";
    }

    // Mostrar formulario para editar una flor existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarFlor(@PathVariable Long id, Model model) {
        Flor flor = florServicio.obtenerFlorPorId(id);
        if (flor != null) {
            model.addAttribute("flor", flor);
            return "editarFlor";
        } else {
            return "redirect:/flores";
        }
    }

    // Guardar cambios de edición
    @PostMapping("/editar/{id}")
    public String editarFlor(@PathVariable Long id, @ModelAttribute Flor florActualizada) {
        florServicio.actualizarFlor(id, florActualizada);
        return "redirect:/flores";
    }

    // Eliminar una flor
    @GetMapping("/eliminar/{id}")
    public String eliminarFlor(@PathVariable Long id) {
        florServicio.eliminarFlor(id);
        return "redirect:/flores";
    }
}

