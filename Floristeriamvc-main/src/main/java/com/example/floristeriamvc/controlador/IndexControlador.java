package com.example.floristeriamvc.controlador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/index")
public class IndexControlador {
    
    @GetMapping
    public String returnIndex(Model model) {
        return "index";
    }
}