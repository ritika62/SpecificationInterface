package com.springboot.SpecificationInterface.Controller;

import com.springboot.SpecificationInterface.Dao.BookDao;
import com.springboot.SpecificationInterface.Entity.Book;
import com.springboot.SpecificationInterface.Service.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @PostMapping("/books/filter")
    public List<Book> filterBooks(@RequestBody RequestPojo requestPojo){
        return bookService.filterBooks(requestPojo);
    }



}




