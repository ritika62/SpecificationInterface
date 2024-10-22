package com.springboot.SpecificationInterface.Specification;

import com.springboot.SpecificationInterface.Entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {


    public static Specification<Book> hasBookName(String bookName) {
        return (root, query, builder) ->
                builder.equal(root.get("bookName"), bookName);
    }

    public static Specification<Book> hasAuthor(String author) {
        return (root, query, builder) ->
                builder.equal(root.get("author"), author);
    }
/*
    public static Specification<Book> hasBookNameAndAuthor(String bookName, String author) {
        return (root, query, builder) ->
                builder.and(
                        builder.equal(root.get("bookName"), bookName),
                        builder.equal(root.get("author"), author)
                );}*/


    public static Specification<Book> hasPriceGreaterThan(Long price) {
        return (root, query, builder) ->
                builder.gt(root.get("price"), price);
    }


    }




