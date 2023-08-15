/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucoltis.bookshop.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "author")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // Identificador único generado automáticamente para cada autor
    
    @NotNull
    @NotBlank
    private String name;
    // Nombre del autor. No puede ser nulo ni estar en blanco.
    
    private String lastname;
    // Apellido del autor.
    
    private String biography;
    // Biografía del autor.
    
    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Book> books = new ArrayList<Book>();
    // Lista de libros escritos por el autor.
    // La anotación @OneToMany indica una relación de uno a muchos entre el autor y los libros.
    // El atributo "mappedBy" indica que el mapeo de la relación se realiza mediante el atributo "author" en la clase Book.
    // El atributo "fetch = FetchType.EAGER" indica que los libros se cargarán inmediatamente al cargar el autor.
    // La anotación @JsonBackReference se utiliza para evitar una referencia circular al serializar el autor y los libros.
}
