package cl.fullstackjava.EscuelaRural_JPA.repository;

import cl.fullstackjava.EscuelaRural_JPA.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
