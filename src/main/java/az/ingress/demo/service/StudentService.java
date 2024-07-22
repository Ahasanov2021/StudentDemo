package az.ingress.demo.service;

import az.ingress.demo.dto.StudentDto;
import az.ingress.demo.model.Student;

public interface StudentService {
    StudentDto get(Integer id);

    StudentDto create(StudentDto student);

    Student update(Integer id, Student student);

    void delete(Integer id);
}
