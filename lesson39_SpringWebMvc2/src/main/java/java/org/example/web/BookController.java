package java.org.example.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.org.example.domain.Books;
import java.org.example.service.BookSearchService;
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
    public String getSearchBook(@Valid String name, Model model) {
        List<Books> booksList = bookSearchService.searchBooks(name);
        model.addAttribute("books", booksList);
        return "ResultSearchBooks";
    }
}
