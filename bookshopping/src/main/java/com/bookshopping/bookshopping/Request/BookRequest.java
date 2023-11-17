package com.bookshopping.bookshopping.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private Long id;
    private Long categoryId;
    private String title;
    private String description;
    private String author;
    private Double price;
    private byte[] photo;
}
