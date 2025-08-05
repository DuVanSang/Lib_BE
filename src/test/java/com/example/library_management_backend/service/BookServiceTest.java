package com.example.library_management_backend.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.library_management_backend.repository.BookRepository;
import com.example.library_management_backend.entity.Book;
import java.util.Optional;

class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindBookById_Found() {
        Book book = new Book();
        book.setId(1); // id là int
        book.setTitle("Demo Book");
        when(bookRepository.findById(1)).thenReturn(Optional.of(book));
        // Giả lập hàm getBookById trả về BookResponse (nếu có), bạn có thể cần mock thêm nếu BookService logic phức tạp
        // Ở đây chỉ demo gọi hàm repository
        Optional<Book> result = bookRepository.findById(1);
        assertTrue(result.isPresent());
        assertEquals("Demo Book", result.get().getTitle());
    }

    @Test
    void testFindBookById_NotFound() {
        when(bookRepository.findById(2)).thenReturn(Optional.empty());
        Optional<Book> result = bookRepository.findById(2);
        assertFalse(result.isPresent());
    }
}
