package com.example.floristeriamvc.controlador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/acerca")
public class acercaControlador {
    
    @GetMapping
    public String returnAcerca(Model model) {
        return "acerca";
    }
    
}
