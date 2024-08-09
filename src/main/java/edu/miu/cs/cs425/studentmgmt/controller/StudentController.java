package edu.miu.cs.cs425.studentmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value = { "/eregistrar/register" })
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "public/register";
    }

    @PostMapping("")
    public String registerStudent(@Valid @ModelAttribute Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "public/register";
        }
        studentService.saveStudent(student);
        return "redirect:/eregistrar/home";
    }
}
