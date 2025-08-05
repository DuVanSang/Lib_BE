package com.example.library_management_backend.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.library_management_backend.repository.BookRepository;
import com.example.library_management_backend.model.Book;
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
        book.setId(1L);
        book.setTitle("Demo Book");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        Optional<Book> result = bookService.findBookById(1L);
        assertTrue(result.isPresent());
        assertEquals("Demo Book", result.get().getTitle());
    }

    @Test
    void testFindBookById_NotFound() {
        when(bookRepository.findById(2L)).thenReturn(Optional.empty());
        Optional<Book> result = bookService.findBookById(2L);
        assertFalse(result.isPresent());
    }
}
