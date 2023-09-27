package org.example.web;

import org.example.web.domain.Books;
import org.example.web.service.BookSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class BookController {
    private BookSearchService bookSearchService;

    public BookController(BookSearchService bookSearchService) {
        this.bookSearchService = bookSearchService;
    }

    @GetMapping("/books")
    public String getBook() {
        return "SearchBooks";
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String getSearchBook(@RequestParam(value = "name") String name, Model model) {
        List<Books> booksList = bookSearchService.searchBooks(name);
        model.addAttribute("books", booksList);
        return "ResultSearchBooks";
    }
}
