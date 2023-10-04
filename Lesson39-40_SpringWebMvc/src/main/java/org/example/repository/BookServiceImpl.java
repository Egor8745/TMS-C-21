package org.example.repository;

import org.example.domain.Books;
import org.example.exception.NameInBlackListException;
import org.example.service.BookSearchService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookSearchService {
    public List<Books> booksList = List.of(new Books("Book1", "Author1"), new Books("Book2", "Author2"), new Books("Book3", "Author3"), new Books("book4", "author4"));

    @Override
    public List<Books> searchBooks(String name) {
        if (name.startsWith("b")) {
            throw new NameInBlackListException();
        }
        if (name != null && !name.isEmpty()) {
            return booksList.stream()
                    .filter(book -> book.getName().equals(name))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }


}
