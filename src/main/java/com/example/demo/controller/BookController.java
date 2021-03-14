package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.domain.Request.BookRequestAuthor;
import com.example.demo.domain.Request.BookRequestGenre;
import com.example.demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/book")
public class BookController extends BaseController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Book book) {
        return buildResponse(bookService.add(book), HttpStatus.OK);
    }

    @PostMapping("/add/genre")
    public ResponseEntity<?> addGenre(@RequestBody BookRequestGenre bookRequestGenre) {
        return buildResponse(bookService.addGenre(bookRequestGenre), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        return buildResponse(bookService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findByAuthor")
    public ResponseEntity<?> findByAuthor(@RequestParam String author) {
        return buildResponse(bookService.findByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/findByGenre")
    public ResponseEntity<?> findByGenre(@RequestParam String genre) {
        return buildResponse(bookService.findByGenre(genre), HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> findByName(@RequestParam String name) {
        return buildResponse(bookService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/findByPrice")
    public ResponseEntity<?> findByPrice(@RequestParam int price) {
        return buildResponse(bookService.findByPrice(price), HttpStatus.OK);
    }

    @PostMapping("/updateGenre")
    public ResponseEntity<?> updateGenre(@RequestParam Long id, String genre) {
        return buildResponse(bookService.updateGenre(id, genre), HttpStatus.OK);
    }

    @PostMapping("/updatePrice")
    public ResponseEntity<?> updatePrice(@RequestParam Long id, int price) {
        return buildResponse(bookService.updatePrice(id, price), HttpStatus.OK);
    }

    @PostMapping("/updateAll")
    public ResponseEntity<?> updateAll(@RequestParam Long id, String author, String genre, String name, int price) {
        return buildResponse(bookService.updateAll(id, author, genre, name, price), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        return buildResponse(bookService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return buildResponse(bookService.findAll(), HttpStatus.OK);
    }
//
//    @PostMapping("/add/author")
//    public ResponseEntity<?> addAuthor(@RequestBody BookRequestAuthor bookRequestAuthor) {
//        return buildResponse(bookService.addAuthor(bookRequestAuthor), HttpStatus.OK);
//    }
    @GetMapping("/findAllByLibrary")
    public ResponseEntity<?> findAllByLibrary(@RequestParam Long id) {
        return buildResponse(bookService.findAllByLibrary(id), HttpStatus.OK);
    }
}
