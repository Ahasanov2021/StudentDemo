package az.ingress.demo.repository;

import az.ingress.demo.model.Phone;
import az.ingress.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {




}
