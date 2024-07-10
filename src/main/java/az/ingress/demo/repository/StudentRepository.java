package az.ingress.demo.repository;

import az.ingress.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "select * from student where age > :age", nativeQuery = true)
    Optional<Student> getByAge(Integer age);

    List<Student> findAllByAgeGreaterThan(Integer age);

    List<Student> findAllByLastname(String lastname);

    List<Student> findAllByPhoneEndingWith(String phone);

    Optional<Student> findById(Integer id);

    List<Student> findAllByLastnameAndAgeGreaterThan(String lastname, Integer age);

    @Query(value = "update student set age = :age where lastname = :lastname", nativeQuery = true)
    @Modifying
    int updateByAge(Integer age, String lastname);


}
