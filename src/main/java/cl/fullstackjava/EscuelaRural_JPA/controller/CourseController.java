package cl.fullstackjava.EscuelaRural_JPA.controller;

import cl.fullstackjava.EscuelaRural_JPA.entity.Course;
import cl.fullstackjava.EscuelaRural_JPA.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
@Controller
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "courses";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model) {
        model.addAttribute("courses", courseService.findAll());
        model.addAttribute("course", courseService.findById(id));
        return "courses";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Course course) {
        if (Objects.equals(course.getId(), null) || course.getId() == 0) {
            courseService.create(course);
        } else {
            courseService.update(course);
        }
        return "redirect:/courses";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        Course course = courseService.findById(id);
        if (course != null && course.getStudents().isEmpty()) {
            courseService.delete(id);
            model.addAttribute("success", "Course deleted successfully.");
        } else if (course == null) {
            model.addAttribute("error", "Course with ID " + id + " does not exist.");
        } else {
            model.addAttribute("error", "Cannot delete course with students enrolled.");
        }
        model.addAttribute("courses", courseService.findAll());
        return "courses";
    }
}