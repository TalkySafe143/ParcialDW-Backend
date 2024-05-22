package com.parcial.parcialweb.entity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE book SET status = 1 WHERE id_book = ?")
@Where(clause = "status = 0")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    private String name;
    private String author;
    private String createdDate;
    private int editionNumber;
    private double price;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Enumerated(EnumType.ORDINAL)
    private BookType type;

    @Enumerated(EnumType.ORDINAL)
    private AuthorFame authorFame;

}
