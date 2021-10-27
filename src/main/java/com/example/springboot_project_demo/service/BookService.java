package com.example.springboot_project_demo.service;

import com.example.springboot_project_demo.model.Book;

import java.util.List;

public interface BookService {

    public List<Book> retrieveAllBooks();
    public Book retrieveBookById(int id);
    public String addBook(List<Book> book);
    public String updateBook(Book book);
    public String deleteBookById(int id);

}
