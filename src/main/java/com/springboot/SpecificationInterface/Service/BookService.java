package com.springboot.SpecificationInterface.Service;

import com.springboot.SpecificationInterface.Entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> findBooksByBookName(String bookName);
    public List<Book> findBooksByAuthor(String author);
    public List<Book> findBooksByBookNameAndAuthor(String bookName, String author);
    public List<Book> findBooksByPriceGreaterThan(long price);

}
