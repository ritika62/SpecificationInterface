package com.springboot.SpecificationInterface.Service;

import com.springboot.SpecificationInterface.Controller.RequestPojo;
import com.springboot.SpecificationInterface.Dao.BookDao;
import com.springboot.SpecificationInterface.Entity.Book;
import com.springboot.SpecificationInterface.Specification.BookSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class BookService {

    private BookDao bookDao;

    public List<Book> searchBooks(RequestPojo requestPojo) {
        Specification<Book> spec = BookSpecification.searchBooks(requestPojo);

    return bookDao.findAll(spec);
    }}
