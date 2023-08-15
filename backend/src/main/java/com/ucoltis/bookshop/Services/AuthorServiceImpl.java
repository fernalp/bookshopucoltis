package com.ucoltis.bookshop.Services;

import com.ucoltis.bookshop.Models.Author;
import com.ucoltis.bookshop.Repositories.AuthorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepo;
    // Inyecta una instancia de AuthorRepository para interactuar con la base de datos.

    @Override
    public Author save(Author author) {
        return authorRepo.save(author);
        // Guarda el autor en la base de datos utilizando el AuthorRepository.
    }

    @Override
    public Page<Author> getAuthors(Pageable pageable) {
        return authorRepo.findAll(pageable);
        // Obtiene una lista paginada de autores utilizando el AuthorRepository.
    }

    @Override
    public Optional<Author> getAuthorById(int id) {
        return authorRepo.findById(id);
        // Obtiene un autor por su identificador utilizando el AuthorRepository.
    }

    @Override
    public void delete(int id) {
        authorRepo.deleteById(id);
        // Elimina un autor por su identificador utilizando el AuthorRepository.
    }

    @Override
    public List<Author> searchName(String name) {
        return authorRepo.searchName(name);
        // Busca autores por nombre utilizando el método searchName definido en AuthorRepository.
    }
}
