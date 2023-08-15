/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucoltis.bookshop.Controllers;

import com.ucoltis.bookshop.Services.AuthorServiceImpl;
import com.ucoltis.bookshop.Models.Author;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/author")
@CrossOrigin(origins = "*")
public class AuthorController {
    
    @Autowired
    AuthorServiceImpl authorServ;
    
    @PostMapping("/save")
    public ResponseEntity<Author> save(@RequestBody Author author) {
        // Guarda un autor utilizando el servicio de autor y devuelve una respuesta HTTP con el autor guardado en el cuerpo.
        Author authorSaved = authorServ.save(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(authorSaved);
    }
    
      
    @GetMapping("/list/{page}")
    public ResponseEntity<Page<Author>> getAuthors(Pageable pageable) {
        // Obtiene una página de autores utilizando el servicio de autor y devuelve una respuesta HTTP con los autores en el cuerpo.
        Page<Author> authors = authorServ.getAuthors(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(authors);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Integer id, @RequestBody Author author) {
            // Actualiza un autor existente utilizando el servicio de autor y devuelve una respuesta HTTP con el autor actualizado en el cuerpo.
        Optional<Author> authorFind = authorServ.getAuthorById(id);
        if (authorFind.isPresent()) {
            Author authorUpdated = authorFind.get();
            authorUpdated.setName(author.getName());
            authorUpdated.setLastname(author.getLastname());
            authorUpdated.setBiography(author.getBiography());
            authorServ.save(authorUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(authorUpdated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        // Elimina un autor utilizando el servicio de autor.
        authorServ.delete(id);
    }
    
    @GetMapping("/search/{name}")
    public ResponseEntity<?> search(@PathVariable String name) throws Exception {
        try {
            // Realiza una búsqueda de autores por nombre utilizando el servicio de autor y devuelve una respuesta HTTP con los autores encontrados en el cuerpo.
            List<Author> authors = authorServ.searchName(name);
            return ResponseEntity.status(HttpStatus.OK).body(authors);
        } catch (Exception e) {
            // Si ocurre un error, devuelve una respuesta HTTP con un mensaje de error en el cuerpo.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{'error':'" + e.getMessage() + "'}"));
        }
    }
}
