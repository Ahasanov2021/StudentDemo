package az.ingress.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity//(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

//    @Column(name = "surname")
    String lastname;

    Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "balance_id")
    Balance balance;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<Phone> phoneList;


//    @JoinTable(
//            name = "new_table_name",
//            joinColumns = @JoinColumn(name = "student"),
//            inverseJoinColumns = @JoinColumn(name = "role")
//    )
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_authorities",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")}
    )
    List<Role> roles;

}
