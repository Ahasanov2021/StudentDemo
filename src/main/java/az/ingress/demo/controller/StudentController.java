package az.ingress.demo.controller;

import az.ingress.demo.model.Student;
import az.ingress.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/v1")
public class StudentController {

//    @Autowired
//    @Qualifier("studentServiceImpl")
//    private StudentService studentService;

    private final StudentService studentService;

    public StudentController(@Qualifier("studentServiceImpl") StudentService studentService) {
        this.studentService = studentService;
    }

//    public StudentController(StudentService studentServiceImplv2) {
//        this.studentService = studentServiceImplv2;
//    }

    @GetMapping("/{id}")
    public Student get(@PathVariable Integer id){
        return studentService.get(id);
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Integer id, @RequestBody Student student){
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        studentService.delete(id);
    }
}
