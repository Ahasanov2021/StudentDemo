package az.ingress.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.HashCodeExclude;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    @ToString.Exclude
//    @HashCodeExclude
    Student student;


}
