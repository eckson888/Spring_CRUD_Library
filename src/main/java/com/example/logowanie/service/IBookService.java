package com.example.logowanie.service;

import com.example.logowanie.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    void saveOrUpdate(Book book);
    Optional<Book> getById(int id);
    List<Book> getAll();
    void delete(int id);
}