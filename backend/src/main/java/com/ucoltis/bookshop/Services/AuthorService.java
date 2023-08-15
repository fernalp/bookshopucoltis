package com.ucoltis.bookshop.Services;

import com.ucoltis.bookshop.Models.Author;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface AuthorService {
    
    Author save(Author author);
    // Método para guardar un autor en la base de datos.
    
    Page<Author> getAuthors(Pageable pageable);
    // Método para obtener una lista paginada de autores.
    // Recibe un objeto Pageable que especifica los parámetros de paginación (número de página, tamaño de página, etc.).
    // Devuelve una página de autores.
    
    Optional<Author> getAuthorById(int id);
    // Método para obtener un autor por su identificador.
    // Recibe el id del autor como parámetro.
    // Devuelve un Optional que contiene el autor si existe, o un Optional vacío si no existe.
    
    void delete(int id);
    // Método para eliminar un autor por su identificador.
    // Recibe el id del autor como parámetro y elimina el autor correspondiente de la base de datos.
    
    List<Author> searchName(String name);
    // Método para buscar autores por nombre.
    // Recibe el nombre del autor como parámetro y devuelve una lista de autores que coinciden con el nombre proporcionado.
}
