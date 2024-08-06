package cl.fullstackjava.EscuelaRural_JPA.service;

import cl.fullstackjava.EscuelaRural_JPA.entity.Student;
import cl.fullstackjava.EscuelaRural_JPA.repository.StudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAllOrderedById() {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public boolean create(Student s) {
        try {
            studentRepository.save(s);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean update(Student s) {
        if (studentRepository.existsById(s.getId())) {
            studentRepository.save(s);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}