package az.ingress.demo.repository;

import az.ingress.demo.dto.StudentGroupByDto;
import az.ingress.demo.model.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

//    @Query(value = "select * from student where age = :age", nativeQuery = true)
//    List<Student> findStudentWithAgeEquals(Integer age);

    //JPQL Java persistence query language
    @Query(value = "from Student s where s.age = :age")
    List<Student> findStudentWithAgeEquals(Integer age);

//    @Query(value = "select * from student s left join phone p on s.id = p.student_id", nativeQuery = true)
    @Query(value = "from Student s join fetch s.phoneList")
    List<Student> findStudents();

    // nativequery only works with an interface
    // jpql works both with a class and interface

//    @Query(value = "select age, count(*) as count from student group by age", nativeQuery = true)
//    List<StudentGroupByDto> groupByAge();

    @Query(value = "select new az.ingress.demo.dto.StudentGroupByDto(s.age, count(*)) as count from Student s group by s.age")
    List<StudentGroupByDto> groupByAgeJpql();

//    @Query(value = "select * from student where age > :age", nativeQuery = true)
//    Optional<Student> getByAge(Integer age);


//    @Query("select s from Student s left join fetch s.phoneList")   // 1. JPQL
//    @EntityGraph(value = "students_with_phone_list", type = EntityGraph.EntityGraphType.FETCH)  //2. Entity Graph
    @EntityGraph(attributePaths = {"phoneList"}, type = EntityGraph.EntityGraphType.FETCH)  // 3.
    List<Student> findAllBy();

//
//    List<Student> findAllByAgeGreaterThan(Integer age);
//
//    List<Student> findAllByLastname(String lastname);
//
//    List<Student> findAllByPhoneEndingWith(String phone);
//
//    Optional<Student> findById(Integer id);
//
//    List<Student> findAllByLastnameAndAgeGreaterThan(String lastname, Integer age);
//
//    @Query(value = "update student set age = :age where lastname = :lastname", nativeQuery = true)
//    @Modifying
//    int updateByAge(Integer age, String lastname);


}
