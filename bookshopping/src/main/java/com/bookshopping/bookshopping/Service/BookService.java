package com.bookshopping.bookshopping.Service;

import com.bookshopping.bookshopping.Dto.BookDto;
import com.bookshopping.bookshopping.Exception.ResourceNotFoundException;
import com.bookshopping.bookshopping.Model.AppUser;
import com.bookshopping.bookshopping.Model.Book;
import com.bookshopping.bookshopping.Model.Category;
import com.bookshopping.bookshopping.Repository.BookRepository;
import com.bookshopping.bookshopping.Repository.CategoryRepository;
import com.bookshopping.bookshopping.Request.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

@Autowired
    private BookRepository bookRepository;
@Autowired
    private CategoryRepository categoryRepository;
@Autowired
    private BookDto bookDto;
public List<Book>findall(){return  bookRepository.findAll();}
    @Transactional
public List<Book>createbook(BookRequest bookRequest){
Book book=bookDto.mapToBook(bookRequest);
    Category category=categoryRepository.findById(bookRequest.getCategoryId()).orElseThrow(()->new ResourceNotFoundException("CategoryId","CategoryId",bookRequest.getCategoryId()));
    book.setCategory(category);
    bookRepository.save(book);
    return findall();
}
@Transactional
    public List<Book>updatebook(BookRequest bookRequest){
        Book book=bookDto.mapToBook(bookRequest);
        Category category=categoryRepository.findById(bookRequest.getCategoryId()).orElseThrow(()->new ResourceNotFoundException("CategoryId","CategoryId",bookRequest.getCategoryId()));
        book.setCategory(category);
        bookRepository.save(book);
        return findall();
    }
    public List<Book> deleteById(Long id) {
        bookRepository.deleteById(id);
        return findall();
    }


}
