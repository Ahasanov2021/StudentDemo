package az.ingress.demo.service;

import az.ingress.demo.model.Student;

public interface StudentService {
    Student get(Integer id);

    Student create(Student student);

    Student update(Integer id, Student student);

    void delete(Integer id);
}
