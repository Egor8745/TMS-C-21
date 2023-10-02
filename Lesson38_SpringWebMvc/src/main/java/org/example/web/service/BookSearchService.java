package org.example.web.service;

import org.example.web.domain.Books;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookSearchService {
    List<Books> searchBooks(String name);
}
