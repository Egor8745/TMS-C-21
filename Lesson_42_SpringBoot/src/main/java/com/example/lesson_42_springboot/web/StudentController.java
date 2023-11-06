package com.example.lesson_42_springboot.web;

import com.example.lesson_42_springboot.domain.StudentDto;
import com.example.lesson_42_springboot.domain.StudentSearchDto;
import com.example.lesson_42_springboot.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService StudentService;

    @GetMapping
    public ModelAndView home(@ModelAttribute(name = "student") StudentDto student, @ModelAttribute(name = "studentSearch") StudentSearchDto searchDto) {
        ModelAndView modelAndView = new ModelAndView("home");

        modelAndView.addObject("students", StudentService.sortNumber());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView save(@ModelAttribute(name = "student") @Valid StudentDto studentDto, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("home");
        int errorCount = result.getErrorCount();
        if (errorCount == 0) {
            StudentService.save(studentDto);
        }
        modelAndView.addObject("students", StudentService.sortNumber());
        modelAndView.addObject("studentSearch", new StudentSearchDto());
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
        modelAndView.addObject("studentSearch", new StudentSearchDto());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(@ModelAttribute(name = "studentSearch") @Valid StudentSearchDto searchDto, BindingResult result) {
        List<StudentDto> studentSearch = StudentService.search(searchDto);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("studentList", studentSearch);
        modelAndView.addObject("student", new StudentDto());
        return modelAndView;
    }
}
