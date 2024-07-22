package az.ingress.demo.controller;

import az.ingress.demo.dto.PhoneDto;
import az.ingress.demo.dto.StudentDto;
import az.ingress.demo.model.Student;
import az.ingress.demo.service.PhoneService;
import az.ingress.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/v1")
@RequiredArgsConstructor
public class PhoneController {


    private final PhoneService phoneService;

    @PostMapping("/{studentId}/phone")
    public PhoneDto create(@PathVariable Integer studentId, @RequestBody PhoneDto phoneDto){
        return phoneService.create(studentId, phoneDto);
    }

    @DeleteMapping("/{studentId}/phone")
    public PhoneDto delete(@PathVariable Integer studentId, @RequestBody PhoneDto phoneDto){
        return phoneService.create(studentId, phoneDto);
    }

}
