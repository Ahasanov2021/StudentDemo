package az.ingress.demo;


import az.ingress.demo.model.Student;
import az.ingress.demo.repository.BalanceRepository;
import az.ingress.demo.repository.PhoneRepository;
import az.ingress.demo.repository.RoleRepository;
import az.ingress.demo.repository.StudentRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@Transactional
public class DemoApplication implements CommandLineRunner {


	private final EntityManagerFactory emf;

	@Value("${spring.profiles.active}")
	private String profile;

	private final StudentRepository studentRepository;
	private final PhoneRepository phoneRepository;
	private final BalanceRepository balanceRepository;
	private final RoleRepository roleRepository;
	private final EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		List<Student> all = studentRepository.findAllBy();

		all.forEach(student -> System.out.println(student));

		studentRepository.findById(5).ifPresent(student -> System.out.println(student.getAge()));

//		studentRepository.findAll();


//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.createNamedQuery("Student_AGE_EQUALS", Student.class).getResultList();

//		var studentGroupByDto = studentRepository.groupByAgeJpql();
//		studentGroupByDto.forEach(dto -> {
//			System.out.println("Age " + dto.getAge());
//			System.out.println("Count " + dto.getCount());
//
//		});

//		============================JDBC=========================================================
//		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5888/postgres", "postgres", "mysecretpassword");
//		Statement statement = con.createStatement();
//		ResultSet resultSet = statement.executeQuery("select * from student");
//		while (resultSet.next()) {
//			System.out.println(resultSet.getInt(1));
//			System.out.println(resultSet.getString(2));
//			System.out.println(resultSet.getString(3));
//			System.out.println(resultSet.getInt(4));
//			System.out.println(resultSet.getString(5));
//			System.out.println(resultSet.getInt(6));
//		}


		// ========== EntityManager class in JPA ========================
//		EntityManager entityManager = emf.createEntityManager();
//		List<Student> resultList = entityManager.createNativeQuery("select * from student where age > :age", Student.class)
//				.setParameter("age", 20)
//				.getResultList();
//		System.out.println(resultList);
//
//		Student entity = (Student) entityManager.createNativeQuery("select * from student where id = :id", Student.class)
//				.setParameter("id", 2)
//				.getSingleResult();
//		System.out.println(entity);

//		entityManager.getTransaction().begin();
//		int i = entityManager.createNativeQuery("insert into student (name, lastname, age, phone, balance) values ('Mahmud','Ahmadov', 33, '3658464889', 3000)")
//				.executeUpdate();
//		entityManager.getTransaction().commit();
//		entityManager.close();

		// ========== Session class in Hibernate ========================
//		Session session = emf.unwrap(Session.class);
//
//		session.beginTransaction();
//		session.createNativeQuery("insert into student (name, lastname, age, phone, balance) values ('Namiq','Mammadov', 13, '5656569989', 0)")
//				.executeUpdate();
//		session.getTransaction().commit();
//		session.close();

//		Phone phone1 = Phone.builder()
//				.number("9942455454454")
//				.build();
//
//		Phone phone2 = Phone.builder()
//				.number("9948454986683")
//				.build();
//
//		Phone phone3 = Phone.builder()
//				.number("99445487979975")
//				.build();
//
//		Student student = Student.builder()
//				.name("Ali")
//				.age(15)
//				.lastname("Hasanov")
//				.build();
//
//		phone1.setStudent(student);
//		phone2.setStudent(student);
//		phone3.setStudent(student);
//
//		phoneRepository.saveAll(List.of(phone1, phone2, phone3));
//		studentRepository.save(student);


//		Student student = studentRepository.findById(2).get();
//		Phone build = Phone.builder()
//				.number("4648497987987")
//				.student(student)
//				.build();
//
//		student.getPhoneList().add(build);
//
//		studentRepository.save(student);

//		Role user = Role.builder()
//				.role("user")
//				.build();
//
//		Role admin = Role.builder()
//				.role("admin")
//				.build();
//
//		roleRepository.save(user);
//		roleRepository.save(admin);

//		Role user = roleRepository.findByRole("user").get();
////		Role admin = roleRepository.findByRole("admin").get();
////
//		Student student = Student.builder()
//				.name("Hasan")
//				.age(25)
//				.lastname("Hasanov")
//				.roles(List.of(user))
//				.build();
//		studentRepository.save(student);

//		studentRepository.deleteById(1);


//		System.out.println(student);

//		Phone phone = phoneRepository.findById(1).get();
//		System.out.println(phone);
//		System.out.println(phone.getStudent());



	}
}
