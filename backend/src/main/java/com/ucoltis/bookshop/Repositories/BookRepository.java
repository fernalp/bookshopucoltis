package com.ucoltis.bookshop.Repositories;

import com.ucoltis.bookshop.Models.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {
    
    List<Book> findByTitleContaining(String title);
    // Método predefinido para buscar libros por título
    // El método findByTitleContaining utiliza una convención de nombres de Spring Data JPA para generar automáticamente
    // la consulta en función del nombre del método.
    // En este caso, la consulta buscará libros cuyo título contenga el título proporcionado como parámetro.
    // El resultado es una lista de libros.
    
    @Query(value = "SELECT b FROM Book b WHERE b.title like %?1%")
    List<Book> searchTitle(String title);
    // Método personalizado para buscar libros por título utilizando una consulta personalizada en JPQL.
    // La anotación @Query se utiliza para definir consultas personalizadas en JPQL.
    // En este caso, la consulta buscará libros cuyo título coincida parcialmente con el título proporcionado como parámetro.
    // El símbolo "%" se utiliza para representar cualquier conjunto de caracteres.
    // El parámetro "?1" hace referencia al primer parámetro del método, que es el título que se va a buscar.
    // El resultado de la consulta es una lista de libros.
}
