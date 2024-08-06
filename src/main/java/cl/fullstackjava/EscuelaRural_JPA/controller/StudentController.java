package cl.fullstackjava.EscuelaRural_JPA.controller;

import cl.fullstackjava.EscuelaRural_JPA.entity.Student;
import cl.fullstackjava.EscuelaRural_JPA.service.CourseService;
import cl.fullstackjava.EscuelaRural_JPA.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;
    private CourseService courseService;

    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("students", studentService.findAllOrderedById());
        model.addAttribute("courses", courseService.findAll());
        return "students";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model) {
        model.addAttribute("students",studentService.findAllOrderedById());
        model.addAttribute("student", studentService.findById(id));
        model.addAttribute("courses", courseService.findAll());
        return "students";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student) {
        System.out.println("en save");
        if (Objects.equals(student.getId(), null) || student.getId() == 0) {
            System.out.println("creando...");
            studentService.create(student);
        } else {
            System.out.println("actualizando...");
            studentService.update(student);
        }
        return "redirect:/students";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        Student student = studentService.findById(id);
        if (student != null) {
            studentService.delete(id);
            model.addAttribute("success", "Student deleted successfully.");
        } else {
            model.addAttribute("error", "Cannot delete student with ID " + id + " as it does not exist.");
        }
        model.addAttribute("students", studentService.findAllOrderedById());
        model.addAttribute("courses", courseService.findAll());
        return "students";
    }
}