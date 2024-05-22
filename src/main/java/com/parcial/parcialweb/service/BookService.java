package com.parcial.parcialweb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial.parcialweb.dto.BookDTO;
import com.parcial.parcialweb.entity.Book;
import com.parcial.parcialweb.repository.RepositoryBook;

@Service
public class BookService {
    
    @Autowired
    private RepositoryBook bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<BookDTO> getAll() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        return books.stream()
        .map(book -> modelMapper.map(book, BookDTO.class))
        .collect(Collectors.toList());
    }

    public BookDTO getByID(Long id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        BookDTO bookDTO = null;
        if (bookOptional.isPresent()){
            bookDTO = modelMapper.map(bookOptional.get(), BookDTO.class);
        }
        return bookDTO;
    }

    public BookDTO save(BookDTO book) {
        Book mappedBook = modelMapper.map(book, Book.class);
        Optional<Book> bookOptional = bookRepository.findById(book.getIdBook());

        if (bookOptional.isPresent()) return null;
        mappedBook = bookRepository.save(mappedBook);
        book.setIdBook(mappedBook.getIdBook());
        return book;
    }


    public BookDTO update(BookDTO bookDTO, Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (!optionalBook.isPresent()) return null;

        Book book = optionalBook.get();

        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setAuthorFame(bookDTO.getAuthorFame());
        book.setType(bookDTO.getType());
        book.setCreatedDate(bookDTO.getCreatedDate());
        book.setEditionNumber(bookDTO.getEditionNumber());
        book.setPrice(bookDTO.getPrice());

        bookDTO = modelMapper.map(book, BookDTO.class);
        return bookDTO;
    }


    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
