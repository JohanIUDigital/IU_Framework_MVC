package com.example.floristeriamvc.servicio;

import com.example.floristeriamvc.modelo.Flor;
import com.example.floristeriamvc.repositorio.FlorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlorServicioImpl implements FlorServicio {

    @Autowired
    private FlorRepositorio florRepositorio;

    // Obtener todas las flores
    @Override
    public List<Flor> obtenerTodasLasFlores() {
        return florRepositorio.findAll(); // Devuelve una lista de todas las flores en la BD
    }

    // Crear una nueva flor
    @Override
    public Flor crearFlor(Flor flor) {
        return florRepositorio.save(flor); // Guarda la nueva flor en la base de datos
    }

    // Obtener una flor por su ID
    @Override
    public Flor obtenerFlorPorId(Long id) {
        return florRepositorio.findById(id).orElse(null); // Busca por ID o devuelve null si no la encuentra
    }

    // Actualizar una flor existente
    @Override
    public Flor actualizarFlor(Long id, Flor florActualizada) {
        Flor florExistente = obtenerFlorPorId(id);
        if (florExistente != null) {
            // Actualiza los campos de la flor existente
            florExistente.setTipo(florActualizada.getTipo());
            florExistente.setColor(florActualizada.getColor());
            florExistente.setVariedad(florActualizada.getVariedad());
            florExistente.setCantidadDisponible(florActualizada.getCantidadDisponible());
            florExistente.setPrecioCompra(florActualizada.getPrecioCompra());
            florExistente.setPrecioVenta(florActualizada.getPrecioVenta());
            return florRepositorio.save(florExistente); // Guarda los cambios
        }
        return null; // Devuelve null si la flor no existe
    }

    // Eliminar una flor por su ID
    @Override
    public void eliminarFlor(Long id) {
        florRepositorio.deleteById(id); // Elimina la flor por su ID
    }
}
