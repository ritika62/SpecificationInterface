package com.springboot.SpecificationInterface.Service;

import com.springboot.SpecificationInterface.Dao.BookDao;
import com.springboot.SpecificationInterface.Entity.Book;
import com.springboot.SpecificationInterface.Specification.BookSpecification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

    @Service
    @AllArgsConstructor
    public class BookServiceImpl implements  BookService{
        BookDao bookDao;
        @Override
        public List<Book> findBooksByAuthor(String author) {
            return bookDao.findAll(BookSpecification.hasAuthor(author));
        }

        @Override
        public List<Book> findBooksByBookName(String bookName) {
            return bookDao.findAll(BookSpecification.hasBookName(bookName));
        }

        @Override
        public List<Book> findBooksByBookNameAndAuthor(String bookName, String author) {
            return bookDao.findAll(BookSpecification.hasBookNameAndAuthor(bookName,author));
        }

        @Override
        public List<Book> findBooksByPriceGreaterThan(long price) {
            return bookDao.findAll(BookSpecification.hasPriceGreaterThan(price));
        }
    }



