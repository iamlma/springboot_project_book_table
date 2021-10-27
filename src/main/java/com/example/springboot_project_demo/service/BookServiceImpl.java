package com.example.springboot_project_demo.service;

import com.example.springboot_project_demo.model.Book;
import com.example.springboot_project_demo.reporsitory.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> retrieveAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book retrieveBookById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    @Transactional
    public String addBook(List<Book> book) {
        bookRepository.saveAll(book);
        String message = "Saving failed.";
        if (retrieveAllBooks() !=null) {
            message = "Successfully saved in the database";
        }
        return message;
    }

    @Override
    @Transactional
    public String updateBook(Book updatedBook) {
        Book book = retrieveBookById(updatedBook.getId());
        String message = "Update failed.";
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setYearPublished(updatedBook.getYearPublished());
            bookRepository.save(book);
            message = "Updated record";
        }
        return message;
    }

    @Override
    @Transactional
    public String deleteBookById(int id) {
        String message = "No record found";
        if (retrieveBookById(id) !=null) {
            bookRepository.deleteById(id);
            message = "Delete successful";
        }
        return message;
    }
}