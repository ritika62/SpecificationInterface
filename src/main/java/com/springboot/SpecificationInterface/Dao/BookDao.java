package com.springboot.SpecificationInterface.Dao;

import com.springboot.SpecificationInterface.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookDao extends JpaRepository<Book,Long>, JpaSpecificationExecutor<Book> {
}
