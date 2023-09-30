package java.org.example.service;

import org.springframework.stereotype.Service;

import java.org.example.domain.Books;
import java.util.List;

@Service
public interface BookSearchService {
    List<Books> searchBooks(String name);
}
