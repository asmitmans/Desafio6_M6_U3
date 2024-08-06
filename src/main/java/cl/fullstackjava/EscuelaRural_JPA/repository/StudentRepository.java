package cl.fullstackjava.EscuelaRural_JPA.repository;

import cl.fullstackjava.EscuelaRural_JPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
