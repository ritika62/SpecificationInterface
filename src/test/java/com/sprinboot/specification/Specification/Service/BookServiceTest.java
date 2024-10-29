package com.sprinboot.specification.Specification.Service;
import com.springboot.SpecificationInterface.Controller.RequestPojo;
import com.springboot.SpecificationInterface.Dao.BookDao;
import com.springboot.SpecificationInterface.Entity.Book;
import com.springboot.SpecificationInterface.Service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    BookService bookService;

    private RequestPojo requestPojo;
    private Book book;

    @Mock
    BookDao bookDao;

   @BeforeEach
    public void setup() {
       requestPojo = new RequestPojo();
       book = new Book();
   }
   @Test
   public void testFilterBooks_NullRequestPojo() {
       List<Book> filteredBooks = bookService.filterBooks(null);
       assertNotNull(filteredBooks);
       assertEquals(0, filteredBooks.size());
   }
    @Test
    public void testFilterBooks_EmptyRequestPojo() {
        List<Book> filteredBooks = bookService.filterBooks(requestPojo);
        assertNotNull(filteredBooks);
        assertEquals(0, filteredBooks.size());
   }
    @Test
    public void testFilterBooks_BookNameAndAuthorOrPriceGreaterThan() {
        requestPojo.setBookName("Python");
        requestPojo.setAuthor("Rahul");
        requestPojo.setPriceGreaterThan(1200l);
        requestPojo.setAndParameter1("bookName");
        requestPojo.setAndParameter2("author");
        requestPojo.setOrParameter1("priceGreaterThan");
        List<Book> expectedBooks = List.of(book);
       when(bookDao.findAll(any(Specification.class))).thenReturn(expectedBooks);
        List<Book> filteredBooks = bookService.filterBooks(requestPojo);
        assertNotNull(filteredBooks);
     assertEquals(expectedBooks,filteredBooks);
    }

@Test
public void testFilterBooks_BookNameAndPriceGreaterThanOrAuthor() {
    requestPojo.setBookName("Java");
    requestPojo.setPriceGreaterThan(1000l);
    requestPojo.setAuthor("Rohan");
    requestPojo.setAndParameter1("bookName");
    requestPojo.setAndParameter2("priceGreaterThan");
    requestPojo.setOrParameter1("author");
    List<Book> expectedBooks = List.of(book);
    when(bookDao.findAll(any(Specification.class))).thenReturn(expectedBooks);
    List<Book> filteredBooks = bookService.filterBooks(requestPojo);
    assertNotNull(filteredBooks);
    assertEquals(expectedBooks,filteredBooks);
}

@Test
public void testFilterBooks_AuthorAndpriceGreaterThanOrBookName() {
       requestPojo.setAuthor("Harry");
    requestPojo.setPriceGreaterThan(1100l);
    requestPojo.setBookName("Spring");
    requestPojo.setAndParameter1("author");
    requestPojo.setAndParameter2("priceGreaterThan");
    requestPojo.setOrParameter1("bookName");
    List<Book> expectedBooks = List.of(book);
    when(bookDao.findAll(any(Specification.class))).thenReturn(expectedBooks);
    List<Book> filteredBooks = bookService.filterBooks(requestPojo);
    assertNotNull(filteredBooks);
    assertEquals(expectedBooks,filteredBooks);
}
}

