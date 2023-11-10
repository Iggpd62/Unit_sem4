import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testGetAllBooks() {
     
        List<Book> expectedBooks = Arrays.asList(
                new Book("1234567890", "Book 1", "Author 1"),
                new Book("0987654321", "Book 2", "Author 2")
        );
    
        Mockito.when(bookRepository.getAllBooks()).thenReturn(expectedBooks);
  
        List<Book> actualBooks = bookService.getAllBooks();
  
        Assertions.assertEquals(expectedBooks, actualBooks);
    
        Mockito.verify(bookRepository).getAllBooks();
    }

    @Test
    public void testGetBookByISBN() {
        String isbn = "1234567890";
        Book expectedBook = new Book(isbn, "Book 1", "Author 1");

        Mockito.when(bookRepository.getBookByISBN(isbn)).thenReturn(expectedBook);

        Book actualBook = bookService.getBookByISBN(isbn);

        Assertions.assertEquals(expectedBook, actualBook);

        Mockito.verify(bookRepository).getBookByISBN(isbn);
    }
}
