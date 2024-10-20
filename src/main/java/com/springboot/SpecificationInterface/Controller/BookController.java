package com.springboot.SpecificationInterface.Controller;

import com.springboot.SpecificationInterface.Entity.Book;
import com.springboot.SpecificationInterface.Service.BookService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
public class BookController {

    BookService bookService;

    @GetMapping("/findBooksByAuthor/{author}")
    public List<Book> findBooksByAuthor(String author) {
        return bookService.findBooksByAuthor(author);
    }

    @GetMapping("/findBooksByBookName/{bookName}")
    public List<Book> findBooksByBookName(String bookName) {
        return bookService.findBooksByBookName(bookName);
    }

    @GetMapping("/findBooksByBookNameAndAuthor/{bookName}/{author}")
    public List<Book> findBooksByBookNameAndAuthor(String bookName, String author) {
        return bookService.findBooksByBookNameAndAuthor(bookName,author);
    }

    @GetMapping("/findBooksByPriceGreaterThan/{price}")
    public List<Book> findBooksByPriceGreaterThan(long price) {
        return bookService.findBooksByPriceGreaterThan(price);
    }


    }




