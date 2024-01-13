package com.example.demo.service;

import com.example.demo.model.Student;

public interface StudentService {


    Student create(Student student);

    Student update(Integer id, Student student);

    void delete(Integer id);

     Student get(Integer id);
}
