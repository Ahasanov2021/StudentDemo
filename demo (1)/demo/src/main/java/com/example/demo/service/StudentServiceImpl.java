package com.example.demo.service;


import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        log.info("Student service create method is working");
        student.setBalance(500);
        Student studentInDb = studentRepository.save(student);
        return studentInDb;
    }

    @Override
    public Student update(Integer id, Student student){
        log.info("Student service update method is working");
        Student entity = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

        if(student.getAge() != null)
            entity.setAge(student.getAge());
        if(student.getName() != null)
            entity.setName(student.getName());
        if(student.getLastname() != null)
            entity.setLastname(student.getLastname());
        if(student.getPhone() != null)
            entity.setPhone(student.getPhone());
        entity = studentRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id){
        log.info("Student service delete method is working");
        studentRepository.deleteById(id);
    }

    @Override
    public Student get(Integer id) {
        log.info("Student service get method is working");
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new RuntimeException("Student not found");
        }
        return student.get();
    }
}
