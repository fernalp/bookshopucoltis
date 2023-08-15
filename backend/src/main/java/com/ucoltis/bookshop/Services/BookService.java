package com.ucoltis.bookshop.Services;

import com.ucoltis.bookshop.Models.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Book save(Book book) throws Exception;
    // Guarda un libro en la base de datos. Puede lanzar una excepción en caso de error.

    Page<Book> getBooks(Pageable pageable);
    // Obtiene una lista paginada de libros.

    Optional<Book> getBookById(int id);
    // Obtiene un libro por su identificador.

    void delete(int id) throws Exception;
    // Elimina un libro por su identificador. Puede lanzar una excepción en caso de error.

    List<Book> findByTitleContaining(String title) throws Exception;
    // Busca libros por título utilizando una coincidencia parcial. Puede lanzar una excepción en caso de error.

    List<Book> searchTitle(String title) throws Exception;
    // Busca libros por título utilizando una consulta personalizada. Puede lanzar una excepción en caso de error.
}
