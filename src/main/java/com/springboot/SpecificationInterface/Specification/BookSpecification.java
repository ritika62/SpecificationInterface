package com.springboot.SpecificationInterface.Specification;

import com.springboot.SpecificationInterface.Controller.RequestPojo;
import com.springboot.SpecificationInterface.Entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<Book> hasBookName(String bookName) {
        return((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("bookName"),bookName));
    }

    public static Specification<Book> hasAuthor(String author) {
        return (root, query, criteriabuilder) ->
                criteriabuilder.equal(root.get("author"), author);
    }

    public static Specification<Book> hasPriceGreaterThan(Long price) {
        return (root, query, criteriabuilder) ->
                criteriabuilder.gt(root.get("price"), price);
    }

    public static Specification<Book> filterBooks(RequestPojo requestPojo) {
        Specification<Book> spec = Specification.where(null);
        if(requestPojo.getBookName()!=null) {
            spec = spec.and(hasBookName(requestPojo.getBookName()));
        }
        if(requestPojo.getAuthor()!=null) {
            spec = spec.and(hasAuthor(requestPojo.getAuthor()));
        }
        if(requestPojo.getPriceGreaterThan()!=null) {
            spec = spec.and(hasPriceGreaterThan(requestPojo.getPriceGreaterThan()));
        }
        return spec;
    }

    }




