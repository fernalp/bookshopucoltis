package com.ucoltis.bookshop.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // Identificador único generado automáticamente para cada libro

    private String title;
    // Título del libro

    private String description;
    // Descripción del libro

    private String category;
    // Categoría del libro

    private Double price;
    // Precio del libro

    private String isbn;
    // ISBN del libro

    private int pages;
    // Número de páginas del libro

    private LocalDate publication_date;
    // Fecha de publicación del libro

    private String image;
    // Ruta de la imagen de portada del libro

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_author")
    private Author author;
    // Autor del libro
    // La anotación @ManyToOne indica una relación de muchos a uno entre el libro y
    // el autor.
    // El atributo "fetch = FetchType.EAGER" indica que el autor se cargará
    // inmediatamente al cargar el libro.
    // La anotación @JoinColumn se utiliza para especificar la columna de la tabla
    // de libros que hace referencia al autor.
    // En este caso, la columna se llama "id_author".
}
