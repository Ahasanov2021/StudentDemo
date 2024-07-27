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
//@NamedQueries({
//        @NamedQuery(name = "Student_AGE_EQUALS", query = "from Student where age = :age"),
//        @NamedQuery(name = "Student_AGE_GREATER_THAN", query = "from Student where age > :age")
//})
//@NamedEntityGraph(name = "students_with_phone_list", attributeNodes = @NamedAttributeNode("phoneList"))
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

//    @Column(name = "surname")
    String lastname;

    Integer age;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "balance_id")
    Balance balance;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Phone> phoneList;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "user_authorities",
//            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")}
//    )
//    List<Role> roles;


    @Override
    public String toString(){
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", phoneList=" + phoneList +
                '}';

    }

}
