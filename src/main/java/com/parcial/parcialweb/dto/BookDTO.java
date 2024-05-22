package com.parcial.parcialweb.dto;

import com.parcial.parcialweb.entity.AuthorFame;
import com.parcial.parcialweb.entity.BookType;
import com.parcial.parcialweb.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    
    private Long idBook;
    private String name;
    private String author;
    private String createdDate;
    private int editionNumber;
    private double price;
    private Status status;
    private BookType type;
    private AuthorFame authorFame;
}
