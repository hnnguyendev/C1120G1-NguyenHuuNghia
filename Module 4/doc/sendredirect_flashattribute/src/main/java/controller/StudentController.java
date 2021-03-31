package controller;

import models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import services.StudentService;
import services.impl.StudentServiceImpl;

@Controller
public class StudentController {

    StudentService studentService = new StudentServiceImpl();

    @GetMapping("/students")
    public String getStudentPage(Model model){
        model.addAttribute("listStudent", studentService.findAll());
        return "student/list";
    }

    @GetMapping("/student/create")
    public String createStudentPage(){
        return "student/create";
    }

    @PostMapping("/student/create")
    public String saveStudent(@RequestParam int id,
                              @RequestParam String name,
                              @RequestParam int age,
                              RedirectAttributes redirectAttributes
                              ){
        studentService.save(new Student(id, name, age));
        redirectAttributes.addFlashAttribute("message", "Them moi thanh cong");
        return "redirect:/students";
    }
}
