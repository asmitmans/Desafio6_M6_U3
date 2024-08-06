package cl.fullstackjava.EscuelaRural_JPA.service;

import cl.fullstackjava.EscuelaRural_JPA.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    List<Student> findAllOrderedById();
    Student findById(int id);
    boolean create(Student s);
    boolean update(Student s);
    boolean delete(int id);
}
