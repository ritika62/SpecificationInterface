package com.springboot.SpecificationInterface.Controller;
import com.springboot.SpecificationInterface.Entity.Book;
import com.springboot.SpecificationInterface.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @PostMapping("/books/filter")
    public List<Book> filterBooks(@RequestBody RequestPojo requestPojo) {
        return bookService.filterBooks(requestPojo);
    }
}




