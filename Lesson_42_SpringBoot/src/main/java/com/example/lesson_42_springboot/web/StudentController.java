package com.example.lesson_42_springboot.web;

import com.example.lesson_42_springboot.domain.StudentDto;
import com.example.lesson_42_springboot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService StudentService;

    @GetMapping
    public ModelAndView home(@ModelAttribute(name = "student") StudentDto student) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("students", StudentService.getAll());
        return modelAndView;

    }

    @PostMapping
    public ModelAndView save(@ModelAttribute(name = "student") StudentDto student) {
        ModelAndView modelAndView = new ModelAndView("home");
        StudentService.save(student);
        modelAndView.addObject("students", StudentService.getAll());
        return modelAndView;
    }
}
