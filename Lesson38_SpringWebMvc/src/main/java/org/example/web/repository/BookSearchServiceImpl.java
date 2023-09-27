package org.example.web.repository;

import org.example.web.domain.Books;
import org.example.web.service.BookSearchService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookSearchServiceImpl implements BookSearchService {
    public List<Books> booksList = List.of(new Books("book1", "author1"), new Books("book2", "author2"), new Books("book3", "author3"));

    @Override
    public List<Books> searchBooks(String name) {
        if (name != null && !name.isEmpty()) {
            return booksList.stream()
                    .filter(book -> book.getName().equals(name))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }
}
