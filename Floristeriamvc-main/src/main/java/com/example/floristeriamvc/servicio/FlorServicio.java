package com.example.floristeriamvc.servicio;

import com.example.floristeriamvc.modelo.Flor;

import java.util.List;

public interface FlorServicio {
    List<Flor> obtenerTodasLasFlores(); // Para listar todas las flores
    Flor crearFlor(Flor flor);          // Para crear una nueva flor
    Flor obtenerFlorPorId(Long id);     // Para obtener una flor por su ID
    Flor actualizarFlor(Long id, Flor florActualizada); // Para actualizar una flor
    void eliminarFlor(Long id);         // Para eliminar una flor por su ID
}
