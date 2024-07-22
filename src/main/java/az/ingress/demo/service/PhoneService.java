package az.ingress.demo.service;

import az.ingress.demo.dto.PhoneDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface PhoneService {

    PhoneDto create(Integer studentId, PhoneDto phoneDto);

}
