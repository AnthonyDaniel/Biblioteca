package com.biblioteca.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class LibroEntidad {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name="titulo", nullable = true)
    private String titulo;
        
    @Column(nullable = true)
    private String descripcion;

    @Column(nullable = true)
    private String autor;
    
    @Column(nullable = true)
    private String editorial;
    
    @Column(nullable = true)
    private String categoria;

    public LibroEntidad () {
    }
    
    public LibroEntidad (Long _id,String _titulo, String _descripcion, 
    		String _autor, String _editorial, String _categoria ) {
    	this.id=_id;
    	this.titulo=_titulo;
    	this.descripcion=_descripcion;
    	this.autor=_autor;
    	this.editorial=_editorial;
    	this.categoria=_categoria;
    }
    
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getAutor() {
		return autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public String getCategoria() {
		return categoria;
	}
  
}
