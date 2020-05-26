package com.biblioteca.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.modelo.LibroEntidad;
import com.biblioteca.servicios.LibroServicio;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/libro")
public class LibroControlador {
	 @Autowired
	 private LibroServicio libroS;
	 
	@GetMapping("")
	public List<LibroEntidad> obtenerLibros() {
		return libroS.obtenerLibros();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<LibroEntidad>> obtenerLibroPorID(@PathVariable(value = "id") Long id){
	
		Optional<LibroEntidad> libro = libroS.buscarLibroPorID(id);
		
		if(libro != null) {
			return ResponseEntity.ok().body(libro);
		}
		
		return ResponseEntity.noContent().build();
	}

	@PostMapping("")
	public boolean agregarLibro(@RequestBody LibroEntidad libro) {
		return libroS.agregarLibro(libro);
	}

	@PutMapping("")
	public boolean modificarLibro( @RequestBody LibroEntidad libro) {
		return libroS.modificarLibro(libro);
	}

	@DeleteMapping("/{id}")
	public boolean eliminarLibro(@PathVariable(value = "id") Long id){
		return libroS.eliminarLibro(id);
	}
}


