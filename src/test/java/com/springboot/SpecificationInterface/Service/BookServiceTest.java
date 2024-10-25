package com.springboot.SpecificationInterface.Service;
import com.springboot.SpecificationInterface.Controller.RequestPojo;
import com.springboot.SpecificationInterface.Dao.BookDao;
import com.springboot.SpecificationInterface.Entity.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookDao bookDao;

    @InjectMocks
    private BookService bookService;

   private RequestPojo requestPojo;
    private Book book;

    @Before
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
    public void testFilterBooks_BookNameAndCondition() {
        requestPojo.setAndParameter1("bookName");
        requestPojo.setBookName("Java");
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(book);
        when(bookDao.findAll(any(Specification.class))).thenReturn(expectedBooks);
        List<Book> filteredBooks = bookService.filterBooks(requestPojo);
        assertNotNull(filteredBooks);
        assertEquals(1, filteredBooks.size());
        assertEquals(book, filteredBooks.get(0));
    }

    @Test
    public void testFilterBooks_AuthorAndCondition() {
        requestPojo.setAndParameter1("author");
        requestPojo.setAuthor("Rohan");
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(book);
        when(bookDao.findAll(any(Specification.class))).thenReturn(expectedBooks);
        List<Book> filteredBooks = bookService.filterBooks(requestPojo);
        assertNotNull(filteredBooks);
        assertEquals(1, filteredBooks.size());
        assertEquals(book, filteredBooks.get(0));
    }

    @Test
    public void testFilterBooks_PriceGreaterThanAndCondition() {
        requestPojo.setAndParameter1("priceGreaterThan");
        requestPojo.setPriceGreaterThan(100L);
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(book);
        when(bookDao.findAll(any(Specification.class))).thenReturn(expectedBooks);
        List<Book> filteredBooks = bookService.filterBooks(requestPojo);
        assertNotNull(filteredBooks);
        assertEquals(1, filteredBooks.size());
        assertEquals(book, filteredBooks.get(0));
    }

    @Test
    public void testFilterBooks_BookNameOrCondition() {
        requestPojo.setOrParameter1("bookName");
        requestPojo.setBookName("Java");
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(book);
        when(bookDao.findAll(any(Specification.class))).thenReturn(expectedBooks);
        List<Book> filteredBooks = bookService.filterBooks(requestPojo);
        assertNotNull(filteredBooks);
        assertEquals(1, filteredBooks.size());
        assertEquals(book, filteredBooks.get(0));
    }

    @Test
    public void testFilterBooks_AuthorOrCondition() {
        requestPojo.setOrParameter1("author");
        requestPojo.setAuthor("Rohan");
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(book);
        when(bookDao.findAll(any(Specification.class))).thenReturn(expectedBooks);
        List<Book> filteredBooks = bookService.filterBooks(requestPojo);
        assertNotNull(filteredBooks);
        assertEquals(1, filteredBooks.size());
        assertEquals(book, filteredBooks.get(0));
    }

    @Test
    public void testFilterBooks_PriceGreaterThanOrCondition() {
        requestPojo.setOrParameter1("priceGreaterThan");
        requestPojo.setPriceGreaterThan(100L);
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(book);
        when(bookDao.findAll(any(Specification.class))).thenReturn(expectedBooks);
        List<Book> filteredBooks = bookService.filterBooks(requestPojo);
        assertNotNull(filteredBooks);
        assertEquals(1, filteredBooks.size());
        assertEquals(book, filteredBooks.get(0));
    }
}