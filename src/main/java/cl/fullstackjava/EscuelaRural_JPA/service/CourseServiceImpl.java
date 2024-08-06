package cl.fullstackjava.EscuelaRural_JPA.service;

import cl.fullstackjava.EscuelaRural_JPA.entity.Course;
import cl.fullstackjava.EscuelaRural_JPA.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public boolean create(Course s) {
        try {
            courseRepository.save(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean update(Course s) {
        if (courseRepository.existsById(s.getId())) {
            courseRepository.save(s);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}