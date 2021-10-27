package com.example.springboot_project_demo.reporsitory;

import com.example.springboot_project_demo.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository <Book, Integer> {
}
