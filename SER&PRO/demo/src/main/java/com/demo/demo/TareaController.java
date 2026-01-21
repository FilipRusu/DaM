package com.demo.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
// Simulación de Base de Datos en Memoria RAM
	private static List<Tarea> baseDatosSimulada = new ArrayList<>();
// Contador manual para asignar IDs
	private static long contadorId = 1;

// 1. LEER (GET)
	@GetMapping
	public List<Tarea> listar() {
		return baseDatosSimulada;
	}

// 2. CREAR (POST)
	@PostMapping
	public Tarea guardar(@RequestBody Tarea nueva) {
		nueva.setId(contadorId++); // Asignamos ID y sumamos 1
		baseDatosSimulada.add(nueva);
		return nueva;
	}

// 3. ACTUALIZAR (PUT)
	@PutMapping("/{id}")
	public Tarea actualizar(@PathVariable Long id, @RequestBody Tarea datos) {
// Buscamos la tarea por ID usando un bucle clásico
		for (Tarea t : baseDatosSimulada) {
			if (t.getId().equals(id)) {
// Solo actualizamos el estado 'hecha'
				t.setHecha(datos.isHecha());
				return t;
			}
		}
		return null; // Si no existe
	}

// 4. BORRAR (DELETE)
	@DeleteMapping("/{id}")
	public String borrar(@PathVariable Long id) {
// Usamos for con índice 'i' para evitar ConcurrentModificationException
		for (int i = 0; i < baseDatosSimulada.size(); i++) {
			if (baseDatosSimulada.get(i).getId().equals(id)) {
				baseDatosSimulada.remove(i);
				return "Tarea borrada correctamente";
			}
		}
		return "No se encontró la tarea con ID: " + id;
	}
}