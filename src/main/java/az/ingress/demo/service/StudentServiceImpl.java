package az.ingress.demo.service;

import az.ingress.demo.config.Config;
import az.ingress.demo.model.Student;
import az.ingress.demo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
//@Primary
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final Config config;

    public StudentServiceImpl(StudentRepository studentRepository, Config config) {
        this.studentRepository = studentRepository;
        this.config = config;
    }

    @Value("${student.balance}")
    private Integer balance;

    @Override
    public Student get(Integer id){
        System.out.println(config.getList());
        log.info("Student service get method is working.");
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new RuntimeException("Student not found");
        }
        return student.get();
    }

    @Override
    public Student create(Student student){
        log.info("Student service create method is working.");
//        student.setBalance(balance);
        Student studentInDb = studentRepository.save(student);
        return studentInDb;
    }

    @Override
    public Student update(Integer id, Student student){
        log.info("Student service update method is working.");
        Student entity = studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found"));
        if(student.getAge() != null){
            entity.setAge(student.getAge());
        }
        if(student.getName() != null){
            entity.setName(student.getName());
        }
        if(student.getSurName() != null){
            entity.setSurName(student.getSurName());
        }
        if(student.getPhone() != null){
            entity.setPhone(student.getPhone());
        }
        studentRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id){
        log.info("Student service delete method is working.");
        studentRepository.deleteById(id);
    }
}
