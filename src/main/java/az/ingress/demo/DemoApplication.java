package az.ingress.demo;


import az.ingress.demo.model.Account;
import az.ingress.demo.model.Phone;
import az.ingress.demo.model.Student;
import az.ingress.demo.repository.*;
import az.ingress.demo.service.TransferService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class DemoApplication implements CommandLineRunner {

	private final AccountRepository accountRepository;
	private final TransferService transferService;
	private final EntityManagerFactory emf;
	private final Map<Integer, Account> map = new HashMap<>();
	private final StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	@Transactional
	//@Transactional caches account when we search using findById referring to Primary Key
	public void run(String... args) throws Exception { // begin transaction



//		Account account = accountRepository.findByName("Ahmad").orElseThrow(RuntimeException::new);
//		log.info("account {}", account);
////		account.setName("Vugar");
//		accountRepository.save(account);
//		Account  account2 = accountRepository.findByName("Ahmad").orElseThrow(RuntimeException::new);
//		log.info("account {}", account);
//		log.info("method end");

//		Account account = getAccount(1);
//		//
//		//
//		Account account2 = getAccount(1);

		// Entity lifecycle modes
//		EntityManager em = emf.createEntityManager(); // persistence context - EM keeps all the entities in here
//		em.getTransaction().begin();
//
//		Account account = new Account();
//		account.setBalance(100.0);
//		account.setName("Miraga");
//		em.persist(account);
//		em.remove(account);
//		em.getTransaction().commit();
//		em.close();
//		// em.flush
//		// commit


//		Account from = accountRepository.findById(1).get();
//		Account to = accountRepository.findById(2).get();
//		transferService.transfer(from, to, 30.0);

//		List<Student> all = studentRepository.findAllBy();

//		all.forEach(student -> System.out.println(student));
//
//		studentRepository.findById(5).ifPresent(student -> System.out.println(student.getAge()));

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

//		Student student = new Student();
//		student.setName("Miraga");
//		student.setLastname("Mammadov");
//		student.setAge(29);
//
//		Phone phone = new Phone();
//		phone.setNumber("994558986598");
//		phone.setStudent(student);
//
//		Phone phone2 = new Phone();
//		phone2.setNumber("994778986598");
//		phone2.setStudent(student);
//
//		Phone phone3 = new Phone();
//		phone3.setNumber("994508986598");
//		phone3.setStudent(student);
//
//		student.setPhoneList(List.of(phone, phone2, phone3));
//
//		studentRepository.save(student);
//
//		////////////////////////////////////////
//		Student student2 = new Student();
//		student2.setName("Elsad");
//		student2.setLastname("Huseynov");
//		student2.setAge(32);
//
//		Phone phone4 = new Phone();
//		phone4.setNumber("994557826598");
//		phone4.setStudent(student2);
//
//		Phone phone5 = new Phone();
//		phone5.setNumber("994777836598");
//		phone5.setStudent(student2);
//
//		Phone phone6 = new Phone();
//		phone6.setNumber("994507846598");
//		phone6.setStudent(student2);
//
//		student2.setPhoneList(List.of(phone4, phone5, phone6));
//
//		studentRepository.save(student2);

//		Student student = studentRepository.findById(1).orElseThrow(RuntimeException::new);
//		log.info("Student is {}", student);
//		Student student2 = studentRepository.findById(1).orElseThrow(RuntimeException::new);
//		log.info("Student is {}", student2);

		List<Student> all = studentRepository.findAll();
		studentRepository.findById(1).orElseThrow(RuntimeException::new);
	}

	public Account getAccount(Integer id) {
		Account account = map.get(id);
		if (account == null) {
			account = accountRepository.findById(1).orElseThrow(RuntimeException::new);
			map.put(account.getId(), account);
			return account;
		} else {
			return account;
		}
	}
}
