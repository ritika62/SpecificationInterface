package com.springboot.SpecificationInterface.Service;
import com.springboot.SpecificationInterface.Controller.RequestPojo;
import com.springboot.SpecificationInterface.Dao.BookDao;
import com.springboot.SpecificationInterface.Entity.Book;
import com.springboot.SpecificationInterface.Specification.BookSpecification;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
 public class BookServiceTest {

@Mock
private BookDao bookDao;

@InjectMocks
private BookService bookService;

@Test
public void testFilterBooks_ReturnBooks() {
     RequestPojo requestPojo = new RequestPojo();
    List<Book> expectedBooks = Arrays.asList(new Book(1L,"Java","Ritika",1200L,"Advance"));
    when(bookDao.findAll(BookSpecification.filterBooks(requestPojo))).thenReturn(expectedBooks);
    assertEquals(expectedBooks, bookService.filterBooks(requestPojo));
}

    @Test
    public void testFilterBooks_ReturnOneBook() {
        RequestPojo requestPojo = new RequestPojo();
        List<Book> expectedBooks = Arrays.asList(new Book());
        when(bookDao.findAll(BookSpecification.filterBooks(requestPojo))).thenReturn(expectedBooks);

        assertEquals(expectedBooks, bookService.filterBooks(requestPojo));
    }

    @Test
    public void testFilterBooks_NullRequest() {
        assertThrows(NullPointerException.class, () ->
                bookService.filterBooks(null));
    }
}
