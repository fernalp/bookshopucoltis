package com.ucoltis.bookshop.Controllers;

import com.ucoltis.bookshop.Models.Book;
import com.ucoltis.bookshop.Services.BookServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/book")
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    BookServiceImpl bookServ;
    
    @PostMapping("/save")
    public ResponseEntity<Book> save(@RequestBody Book book) throws Exception {
        // Guarda un libro utilizando el servicio de libro y devuelve una respuesta HTTP con el libro guardado en el cuerpo.
        Book bookSaved = bookServ.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookSaved);
    }
    
    @GetMapping("/list/{page}")
    public ResponseEntity<Page<Book>> list(Pageable pageable) {
        // Obtiene una página de libros utilizando el servicio de libro y devuelve una respuesta HTTP con los libros en el cuerpo.
        Page<Book> books = bookServ.getBooks(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) throws Exception {
        // Actualiza un libro existente utilizando el servicio de libro y devuelve una respuesta HTTP con el libro actualizado en el cuerpo.
        Optional<Book> bookFind = bookServ.getBookById(book.getId());
        if (bookFind.isPresent()) {
            bookServ.save(book);
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        // Elimina un libro utilizando el servicio de libro.
        bookServ.delete(id);
    }
    
    @GetMapping("/search/{title}")
    public ResponseEntity<?> search(@PathVariable String title) throws Exception {
        try {
            // Realiza una búsqueda de libros por título utilizando el servicio de libro y devuelve una respuesta HTTP con los libros encontrados en el cuerpo.
            List<Book> books = bookServ.searchTitle(title);
            return ResponseEntity.status(HttpStatus.OK).body(books);
        } catch (Exception e) {
            // Si ocurre un error, devuelve una respuesta HTTP con un mensaje de error en el cuerpo.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{'error':'" + e.getMessage() + "'}"));
        }
    }
}
