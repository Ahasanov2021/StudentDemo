package az.ingress.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentGroupByDto {
    Integer age;
    Long count;
}

//public interface StudentGroupByDto {
//    Integer getAge();
//    Long getCount();
//}
