package com.ucoltis.bookshop.Repositories;

import com.ucoltis.bookshop.Models.Author;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    
    @Query(value = "select a from Author a where a.name like %?1%")
    List<Author> searchName(String name);
    // Método personalizado para buscar autores por nombre
    // La anotación @Query se utiliza para definir consultas personalizadas en JPQL (Java Persistence Query Language).
    // En este caso, la consulta busca autores cuyo nombre coincida parcialmente con el parámetro proporcionado.
    // El símbolo "%" se utiliza para representar cualquier conjunto de caracteres.
    // El parámetro "?1" hace referencia al primer parámetro del método, que es el nombre que se va a buscar.
    // El resultado de la consulta es una lista de autores.
}
