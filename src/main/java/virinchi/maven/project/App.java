package virinchi.maven.project;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Student;

public class App {
	static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	static Session session = sf.openSession();
	public static void main(String[] args) {
		
//		saveUser();
//		getAllData();
//		updateUser();
		deleteUser();
	}
	
	static void saveUser() {
		Student s = new Student();
		s.setFname("Meric");
		s.setLname("Sapkota");
		s.setEmail("meric5sapkota@gmail.com");
		
		session.save(s);
		session.beginTransaction().commit();
	}
	static void getAllData() {
		Criteria c = session.createCriteria(Student.class);
		List<Student> list = c.list();
		if(list.isEmpty()) {
			System.out.println("There is nothing here :) ");
		}
		else {
			for(Student s :list) {
				System.out.println(s.getId());
				System.out.println(s.getEmail());
				System.out.println(s.getFname());
				System.out.println(s.getLname());
			}
		}
	}
	static void updateUser() {
		Student s = (Student)session.get(Student.class, 1);
		s.setEmail("thuldai@gmail.com");
		s.setFname("Thulo");
		s.setLname("Dai");
		
		session.update(s);
		session.beginTransaction().commit();
		
		getAllData();
	}
	static void deleteUser() {
		Student s = (Student)session.get(Student.class, 3);
		session.delete(s);
		session.beginTransaction().commit();
		
		getAllData();
	}
}
