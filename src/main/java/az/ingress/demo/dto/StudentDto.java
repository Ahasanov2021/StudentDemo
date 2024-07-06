package az.ingress.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    Integer id;

    String name;

    String surname;

    Integer age;

    String phone;

    Double balance;

//    Address address;
}
