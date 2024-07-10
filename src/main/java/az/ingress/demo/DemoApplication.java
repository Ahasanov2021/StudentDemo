package az.ingress.demo;


import az.ingress.demo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

	private final EntityManagerFactory emf;

	@Value("${spring.profiles.active}")
	private String profile;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

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
		Session session = emf.unwrap(Session.class);

		session.beginTransaction();
		session.createNativeQuery("insert into student (name, lastname, age, phone, balance) values ('Namiq','Mammadov', 13, '5656569989', 0)")
				.executeUpdate();
		session.getTransaction().commit();
		session.close();




	}
}
