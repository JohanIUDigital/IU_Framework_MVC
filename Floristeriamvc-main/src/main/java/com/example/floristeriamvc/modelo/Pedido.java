package com.example.floristeriamvc.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Table_PEDIDO")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clienteNombre;
    private String clienteDireccion;
    private String clienteContacto;
    private String tipoArreglo;
    private String ocasion;
    private String fechaEntrega;
    private double presupuesto;
    private String estado; // en curso, completado, entregado

    @ManyToMany
    @JoinTable(
        name = "pedido_flor", // Nombre de la tabla de unión
        joinColumns = @JoinColumn(name = "pedido_id"), // Columna de clave foránea para Pedido
        inverseJoinColumns = @JoinColumn(name = "flor_id") // Columna de clave foránea para Flor
    )
    private Set<Flor> flores = new HashSet<>(); // Usamos un Set para evitar duplicados
}
