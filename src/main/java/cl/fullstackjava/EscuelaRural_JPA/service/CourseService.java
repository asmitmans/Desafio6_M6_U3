package cl.fullstackjava.EscuelaRural_JPA.service;

import cl.fullstackjava.EscuelaRural_JPA.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(int id);
    boolean create(Course s);
    boolean update(Course s);
    boolean delete(int id);
}
