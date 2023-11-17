package com.bookshopping.bookshopping.Controller.admin;

import com.bookshopping.bookshopping.Model.Book;
import com.bookshopping.bookshopping.Model.Role;
import com.bookshopping.bookshopping.Request.BookRequest;
import com.bookshopping.bookshopping.Response.RegularResponse.APIResponse;
import com.bookshopping.bookshopping.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/admin/book")
@RolesAllowed(Role.ADMIN)
public class AdminBookController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllBooks() {
        List<Book> bookList = bookService.findall();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse> createBook(@RequestBody
                                                  BookRequest bookRequest) {
        List<Book> bookList = bookService.createbook(bookRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateBook(@RequestBody
                                                  BookRequest bookRequest) {
        List<Book> bookList = bookService.updatebook(bookRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteBook(@PathVariable Long id) {
        List<Book> bookList = bookService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}