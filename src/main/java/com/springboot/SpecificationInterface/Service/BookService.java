package com.springboot.SpecificationInterface.Service;

import com.springboot.SpecificationInterface.Controller.RequestPojo;
import com.springboot.SpecificationInterface.Dao.BookDao;
import com.springboot.SpecificationInterface.Entity.Book;
import com.springboot.SpecificationInterface.Specification.BookSpecification;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class BookService {

    private BookDao bookDao;


    public List<Book> filterBooks(RequestPojo requestPojo) {
        Specification<Book> spec = Specification.where(null);

        if (requestPojo.getBookName() != null) {
            spec = spec.and(BookSpecification.hasBookName(requestPojo.getBookName()));
        }

        if (requestPojo.getAuthor() != null) {
            spec = spec.and(BookSpecification.hasAuthor(requestPojo.getAuthor()));
        }

        if (requestPojo.getPriceGreaterThan() != null) {
            spec = spec.and(BookSpecification.hasPriceGreaterThan(requestPojo.getPriceGreaterThan()));
        }

    return bookDao.findAll(spec);
    }}
