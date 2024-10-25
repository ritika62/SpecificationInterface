package com.springboot.SpecificationInterface.Specification;

import com.springboot.SpecificationInterface.Controller.RequestPojo;
import com.springboot.SpecificationInterface.Entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<Book> hasBookName(String bookName) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("bookName"), bookName);
    }

    public static Specification<Book> hasAuthor(String author) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("author"), author);
    }

    public static Specification<Book> hasPriceGreaterThan(Long price) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.gt(root.get("price"), price);
    }

    public static Specification<Book> filterBooks(RequestPojo requestPojo) {

        if (requestPojo == null) {
            return Specification.where(null);
        }

        Specification<Book> specAnd = Specification.where(null);
        Specification<Book> specOr = Specification.where(null);


        if (requestPojo.getAndParameter1() != null) {
            if ("bookName".equals(requestPojo.getAndParameter1()) && requestPojo.getBookName() != null) {
                specAnd = specAnd.and(hasBookName(requestPojo.getBookName()));
            }
            if ("author".equals(requestPojo.getAndParameter1()) && requestPojo.getAuthor() != null) {
                specAnd = specAnd.and(hasAuthor(requestPojo.getAuthor()));
            }
            if ("priceGreaterThan".equals(requestPojo.getAndParameter1()) && requestPojo.getPriceGreaterThan() != null) {
                specAnd = specAnd.and(hasPriceGreaterThan(requestPojo.getPriceGreaterThan()));
            }
        }

        if (requestPojo.getAndParameter2() != null) {
            if ("bookName".equals(requestPojo.getAndParameter2()) && requestPojo.getBookName() != null) {
                specAnd = specAnd.and(hasBookName(requestPojo.getBookName()));
            }
            if ("author".equals(requestPojo.getAndParameter2()) && requestPojo.getAuthor() != null) {
                specAnd = specAnd.and(hasAuthor(requestPojo.getAuthor()));
            }
            if ("priceGreaterThan".equals(requestPojo.getAndParameter2()) && requestPojo.getPriceGreaterThan() != null) {
                specAnd = specAnd.and(hasPriceGreaterThan(requestPojo.getPriceGreaterThan()));
            }
        }


        if (requestPojo.getOrParameter1() != null) {
            if ("bookName".equals(requestPojo.getOrParameter1()) && requestPojo.getBookName() != null) {
                specOr = specOr.or(hasBookName(requestPojo.getBookName()));
            }
            if ("author".equals(requestPojo.getOrParameter1()) && requestPojo.getAuthor() != null) {
                specOr = specOr.or(hasAuthor(requestPojo.getAuthor()));
            }
            if ("priceGreaterThan".equals(requestPojo.getOrParameter1()) && requestPojo.getPriceGreaterThan() != null) {
                specOr = specOr.or(hasPriceGreaterThan(requestPojo.getPriceGreaterThan()));
            }
        }

        return specAnd.and(specOr);
    }
}
