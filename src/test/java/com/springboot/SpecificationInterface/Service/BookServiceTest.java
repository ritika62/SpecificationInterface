package com.springboot.SpecificationInterface.Service;

import com.springboot.SpecificationInterface.Controller.RequestPojo;
import com.springboot.SpecificationInterface.Dao.BookDao;
import com.springboot.SpecificationInterface.Entity.Book;
import com.springboot.SpecificationInterface.Specification.BookSpecification;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookDao bookDao;

    @Mock
    private BookSpecification bookSpecification;

    @InjectMocks
    private BookService bookService;
    private Book book;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearchBooks_shouldReturnBooks() {
        RequestPojo requestPojo = new RequestPojo();
        Specification<Book> specification = BookSpecification.searchBooks(requestPojo);

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        List<Book> expectedBooks = Arrays.asList(book1, book2, book3);

        when(bookDao.findAll(specification)).thenReturn(expectedBooks);

        List<Book> actualBooks = bookService.searchBooks(requestPojo);

        assertEquals(expectedBooks, actualBooks);
        verify(bookDao, times(1)).findAll(specification);
    }
}


