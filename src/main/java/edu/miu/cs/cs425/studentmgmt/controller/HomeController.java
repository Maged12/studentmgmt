package edu.miu.cs.cs425.studentmgmt.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs.cs425.studentmgmt.service.StudentService;

@Controller
@RequestMapping(value = { "", "/", "/eregistrar/home" })
public class HomeController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = { "" })
    public ModelAndView displayHomePage() {
        var modelAndView = new ModelAndView();
        var students = studentService.getAllStudents();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("public/index");
        return modelAndView;
    }

}
