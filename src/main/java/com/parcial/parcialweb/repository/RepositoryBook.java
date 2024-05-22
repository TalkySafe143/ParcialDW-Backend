package com.parcial.parcialweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.parcial.parcialweb.entity.Book;

public interface RepositoryBook extends CrudRepository<Book, Long> {
    
}
