package com.example.springboot_project_demo.controller;



import com.example.springboot_project_demo.model.Book;
import com.example.springboot_project_demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping("books/all")
    public List<Book> getAllBooks() {
        return bookService.retrieveAllBooks();
    }

    @GetMapping("books/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.retrieveBookById(id);
    }

    @PostMapping("/books")
    public String addBook(@RequestBody List<Book> book) {
        return bookService.addBook(book);
    }

    @PutMapping("/books")
    public String updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("books/{id}")
    public String deleteBook(@PathVariable int id) {
        return bookService.deleteBookById(id);
    }

}
