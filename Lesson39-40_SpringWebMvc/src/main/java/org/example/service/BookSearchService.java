package org.example.service;

import org.example.domain.Books;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookSearchService {
    List<Books> searchBooks(String name);
}
