package com.example.lesson_42_springboot.web;

import com.example.lesson_42_springboot.domain.StudentDto;
import com.example.lesson_42_springboot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService StudentService;

    @GetMapping
    public ModelAndView home(@ModelAttribute(name = "student") StudentDto student) {
        ModelAndView modelAndView = new ModelAndView("home");

        modelAndView.addObject("students", StudentService.sortNumber());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView save(@ModelAttribute(name = "student") StudentDto student) {
        ModelAndView modelAndView = new ModelAndView("home");
        StudentService.save(student);
        modelAndView.addObject("students", StudentService.sortNumber());
        return modelAndView;
    }

    @PostMapping("/order")
    public ModelAndView order(@RequestParam(name = "id") UUID id, @RequestParam(name = "order") String order) {
        ModelAndView modelAndView = new ModelAndView("home");
        if (order.equals("up")) {
            StudentService.liftUp(id);
        }
        if (order.equals("down")) {
            StudentService.lowerDown(id);
        }
        modelAndView.addObject("students", StudentService.sortNumber());
        modelAndView.addObject("student", new StudentDto());
        return modelAndView;
    }
}
