package com.ucoltis.bookshop.Services;

import com.ucoltis.bookshop.Models.Book;
import com.ucoltis.bookshop.Repositories.BookRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepo;

    @Override
    @Transactional
    public Book save(Book book) throws Exception {
        try {
            // Guardamos un libro.
            return bookRepo.save(book);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Book> getBooks(Pageable pageable) {
        // Obtiene una página de libros utilizando el repositorio.
        Page<Book> books = bookRepo.findAll(pageable);
        return books;
    }

    @Override
    public Optional<Book> getBookById(int id) {
        // Obtiene un libro por su identificador utilizando el repositorio.
        return bookRepo.findById(id);
    }

    @Override
    @Transactional
    public void delete(int id) throws Exception {
        try {
            // Eliminamos un libro por su identificador utilizando el repositorio.
            bookRepo.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Book> findByTitleContaining(String title) throws Exception {
        try {
            // Busca libros por título que contengan la cadena especificada utilizando el repositorio.
            List<Book> books = bookRepo.findByTitleContaining(title);
            return books;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Book> searchTitle(String title) throws Exception {
        try {
            // Realiza una búsqueda personalizada de libros por título utilizando el repositorio.
            List<Book> books = bookRepo.searchTitle(title);
            return books;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
