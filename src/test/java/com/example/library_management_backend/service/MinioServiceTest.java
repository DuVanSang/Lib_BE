package com.example.library_management_backend.service;

import io.minio.MinioClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MinioServiceTest {
    @Mock
    private MinioClient minioClient;

    @InjectMocks
    private MinioService minioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUploadFile_NullFileName() throws Exception {
        MultipartFile file = mock(MultipartFile.class);
        when(file.getOriginalFilename()).thenReturn(null);
        when(file.getInputStream()).thenReturn(new ByteArrayInputStream(new byte[]{}));
        Exception exception = assertThrows(RuntimeException.class, () -> {
            minioService.uploadFile(file);
        });
        assertTrue(exception.getMessage().contains("Error uploading file"));
    }

    @Test
    void testDownloadFile_NotFound() throws Exception {
        String filename = "notfound.txt";
        // Giả lập lỗi khi gọi minioClient.getObject
        try {
            when(minioClient.getObject(any())).thenThrow(new RuntimeException("File not found"));
        } catch (Exception ignored) {}
        Exception exception = assertThrows(RuntimeException.class, () -> {
            minioService.downloadFile(filename);
        });
        assertTrue(exception.getMessage().contains("Error downloading file"));
    }
}
