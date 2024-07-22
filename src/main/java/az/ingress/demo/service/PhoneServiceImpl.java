package az.ingress.demo.service;

import az.ingress.demo.dto.PhoneDto;
import az.ingress.demo.model.Phone;
import az.ingress.demo.model.Student;
import az.ingress.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final StudentRepository studentRepository;


    @Override
    public PhoneDto create(Integer studentId, PhoneDto phoneDto) {
        Student student = studentRepository.findById(studentId).orElseThrow(RuntimeException::new);
        Phone phone = Phone.builder()
                .number(phoneDto.getNumber())
                .student(student)
                .build();
        student.getPhoneList().add(phone);
        studentRepository.save(student);
        return null;
    }
}
